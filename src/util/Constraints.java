package util;

import javafx.scene.control.TextField;

public class Constraints {
	
	public static void setTexFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if(newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}
	
	public static void setTexFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if(newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
}
