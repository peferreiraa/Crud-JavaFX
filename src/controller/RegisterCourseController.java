package controller;

import java.net.URL;
import java.util.ResourceBundle;


import application.RegisterCourse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;
import util.Constraints;
import util.OpenMainView;

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
    private Label lblClose;

    @FXML
    private Label lblMinimize;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnCancelar;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		constraints();
		
		lblMinimize.setOnMouseClicked((MouseEvent e) -> {
			RegisterCourse.getStageRegisterCourse().setIconified(true);
		});
		
		lblClose.setOnMouseClicked((MouseEvent e) -> {
			closeRegister();
		});
		
		btnCadastrar.setOnMouseClicked((MouseEvent e) -> {
			register();
			closeRegister();
			OpenMainView.openMainView();
			
		});
		
		btnCancelar.setOnMouseClicked((MouseEvent e) -> {
			closeRegister();
			OpenMainView.openMainView();
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
	
	public void constraints() {
		Constraints.setTexFieldMaxLength(txtNome, 20);
		Constraints.setTexFieldMaxLength(txtDescricao, 20);
		Constraints.setTexFieldInteger(txtTotalAulas);
		Constraints.setTexFieldInteger(txtCargaHoraria);
	}
}
