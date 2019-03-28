package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.ListCourse;
import application.MainView;
import application.RegisterCourse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainViewController implements Initializable {
	
    @FXML
    private Button btnCadastrar;
    

    @FXML
    private Button btnListarCursos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnCadastrar.setOnMouseClicked((MouseEvent e) -> {
			closeMain();
			openRegister();
		});
		
		btnListarCursos.setOnMouseClicked((MouseEvent e) -> {
			openListCourse();
		});
		
	}
	
	public void openRegister() {
		RegisterCourse register = new RegisterCourse();
		register.start(new Stage());
	}
	
	public void closeMain() {
		MainView.getStageMainView().close();
	}
	
	public void openListCourse() {
		ListCourse listCourse = new ListCourse();
		listCourse.start(new Stage());
	}
}
