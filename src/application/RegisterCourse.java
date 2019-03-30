package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegisterCourse extends Application {
	
	private static Stage stageRegisterCourse;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RegisterCourse.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Register");
			stage.setScene(scene);
			stage.show();
			setStageRegisterCourse(stage);
			parent.getStylesheets().addAll("/css/RegisterCourse.css");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStageRegisterCourse() {
		return stageRegisterCourse;
	}

	public static void setStageRegisterCourse(Stage stageRegisterCourse) {
		RegisterCourse.stageRegisterCourse = stageRegisterCourse;
	}

	
}
