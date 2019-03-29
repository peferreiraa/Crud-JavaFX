package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainView;
import application.RegisterCourse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;
import util.Alerts;
import util.Constraints;

public class RegisterCourseController implements Initializable {

	@FXML
	private TextField txtNome;;

	@FXML
	private TextField txtDescricao;

	@FXML
	private TextField txtCargaHoraria;

	@FXML
	private TextField txtTotalAulas;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnCancelar;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		constraints();
		
		btnCadastrar.setOnMouseClicked((MouseEvent e) -> {
			register();
			closeRegister();
			openMain();
			
		});
		
		btnCancelar.setOnMouseClicked((MouseEvent e) -> {
			closeRegister();
			openMain();
		});
		
		
	}
	
	public void register() {
		Course obj = new Course();
		CourseDao dao = DaoFactory.createCourseDao();
		obj.setNome(txtNome.getText());
		obj.setDescricao(txtDescricao.getText());
		obj.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
		obj.setTotalAulas(Integer.parseInt(txtTotalAulas.getText()));
		dao.insert(obj);
	}
	
	public void closeRegister() {
		RegisterCourse.getStageRegisterCourse().close();
	}
	
	public void openMain() {
		MainView main = new MainView();
		main.start(new Stage());
	}
	
	public void constraints() {
		Constraints.setTexFieldMaxLength(txtNome, 20);
		Constraints.setTexFieldMaxLength(txtDescricao, 20);
		Constraints.setTexFieldInteger(txtTotalAulas);
		Constraints.setTexFieldInteger(txtCargaHoraria);
	}
}
