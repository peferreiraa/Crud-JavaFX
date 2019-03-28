package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Login;
import application.MainView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	@FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnEntrar.setOnMouseClicked((MouseEvent e) -> {
			if(txtUsuario.getText().equals("root") && txtSenha.getText().equals("teste")) {
				MainView main = new MainView();
				main.start(new Stage());
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
