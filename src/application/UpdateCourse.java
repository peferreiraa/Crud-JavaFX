package application;

import controller.UpdateCourseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.Course;

public class UpdateCourse  extends Application{
	
	private static Stage stageUpdateCourse;
	
	public UpdateCourse(Course course) {
		UpdateCourseController.setCourse2(course);
	}
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UpdateCourse.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
			setStageUpdateCourse(stage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStageUpdateCourse() {
		return stageUpdateCourse;
	}

	public static void setStageUpdateCourse(Stage stageUpdateCourse) {
		UpdateCourse.stageUpdateCourse = stageUpdateCourse;
	}

	



}
