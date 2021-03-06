package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView extends Application {
	
	private static Stage stageMainView;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Main View");
			stage.setScene(scene);
			stage.show();
			setStageMainView(stage);
			parent.getStylesheets().addAll("/css/MainView.css");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStageMainView() {
		return stageMainView;
	}

	public static void setStageMainView(Stage stageMainView) {
		MainView.stageMainView = stageMainView;
	}

	

}
