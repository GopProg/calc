import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorEngine implements ActionListener {
	Calculator parent;
	char selectedAction = ' ';
	double currentResult = 0;

	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent a) {

		JButton clickedButton = (JButton) a.getSource();
		String dispFieldText = parent.displayField.getText();
		double displayValue = 0;

		if (!"".equals(dispFieldText)) {
			
			displayValue = Double.parseDouble(dispFieldText);
			
		}

		Object src = a.getSource();

		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonDivide) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMultiply) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonEqual) {

			if (selectedAction == '+') {
				currentResult += displayValue;

				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '/') {
				if (currentResult == 0 || displayValue == 0) {
					JOptionPane.showConfirmDialog(null, "На ноль делить нельзя!", "Ошибка!", JOptionPane.PLAIN_MESSAGE);
				} else {
					currentResult /= displayValue;
					parent.displayField.setText("" + currentResult);
				}
			} else if (selectedAction == '*') {

				currentResult *= displayValue;
				parent.displayField.setText("" + currentResult);
			}
		} else {

			String clickedButtonLabel = clickedButton.getText();
			parent.displayField.setText(dispFieldText + clickedButtonLabel);
		}
	}
}