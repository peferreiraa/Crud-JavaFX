package util;

import application.MainView;
import javafx.stage.Stage;

public class OpenMainView {
	
	public static void openMainView() {
		MainView main = new MainView();
		main.start(new Stage());
	}
}
