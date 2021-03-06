package application;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ListCourse extends Application {
	
	private static Stage stageListCourse;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ListCourse.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
			setStageListCourse(stage);
			parent.getStylesheets().addAll("/css/ListCourse.css");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStageListCourse() {
		return stageListCourse;
	}

	public static void setStageListCourse(Stage stageListCourse) {
		ListCourse.stageListCourse = stageListCourse;
	}



}
