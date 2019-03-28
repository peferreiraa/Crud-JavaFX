package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Login extends Application {
	
	private static Stage stageLogin;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
			setStageLogin(stage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStageLogin() {
		return stageLogin;
	}

	public static void setStageLogin(Stage stageLogin) {
		Login.stageLogin = stageLogin;
	}
	
	
}
