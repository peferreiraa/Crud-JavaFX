package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import util.OpenMainView;

public class LoginController implements Initializable {
	
	@FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label lblimg;
    
    @FXML
    private Label lblClose;
    
    @FXML
    private Label lblMinimize;
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		lblClose.setOnMouseClicked((MouseEvent e) -> {
			closeLogin();
		});
		
		lblMinimize.setOnMouseClicked((MouseEvent e) -> {
			Login.getStageLogin().setIconified(true);
		});
		
		btnEntrar.setOnMouseClicked((MouseEvent e) -> {
			if(txtUsuario.getText().equals("root") && txtSenha.getText().equals("teste")) {
				OpenMainView.openMainView();
				closeLogin();
			}else {
				System.out.println("Error!");
			}
		});
		
	}
	
	public void closeLogin() {
		Login.getStageLogin().close();
	}
}
