package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.ListCourse;
import application.MainView;
import application.RegisterCourse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainViewController implements Initializable {
	
    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnListarCursos;
    
    @FXML
    private Label lblClose;

    @FXML
    private Label lblMinimize;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		lblClose.setOnMouseClicked((MouseEvent e) -> {
			closeMain();
		});
		
		lblMinimize.setOnMouseClicked((MouseEvent e) -> {
			MainView.getStageMainView().setIconified(true);
		});
		
		btnCadastrar.setOnMouseClicked((MouseEvent e) -> {
			closeMain();
			openRegister();
		});
		
		btnListarCursos.setOnMouseClicked((MouseEvent e) -> {
			closeMain();
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
