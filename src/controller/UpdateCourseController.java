package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.ListCourse;
import application.UpdateCourse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;
import util.Constraints;

public class UpdateCourseController implements Initializable {

	private static Course course2;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtDescricao;

	@FXML
	private TextField txtCargaHoraria;

	@FXML
	private TextField txtTotalAulas;

	@FXML
	private TextField txtAno;

	@FXML
	private TextField txtId;
	
    @FXML
    private Label lblClose;

    @FXML
    private Label lblMinimize;

	@FXML
	private Button btnAtualizar;

	@FXML
	private Button btnCancelar;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initCourse();
		constraints();
		
		lblMinimize.setOnMouseClicked((MouseEvent e) -> {
			UpdateCourse.getStageUpdateCourse().setIconified(true);
		});
		
		lblClose.setOnMouseClicked((MouseEvent e) -> {
			closeUpdate();
		});
		
		btnAtualizar.setOnMouseClicked((MouseEvent e) -> {
			updateCourse();
			openListCourse();
		});
		
		btnCancelar.setOnMouseClicked((MouseEvent e) -> {
			closeUpdate();
			openListCourse();
		});
	}

	
	
	public static void setCourse2(Course course2) {
		UpdateCourseController.course2 = course2;
	}

	public static Course getCourse2() {
		return course2;
	}

	public void updateCourse() {
		Course course = new Course();
		CourseDao dao = DaoFactory.createCourseDao();
		course.setId(Integer.parseInt(txtId.getText()));
		course.setNome(txtNome.getText());
		course.setDescricao(txtDescricao.getText());
		course.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
		course.setTotalAulas(Integer.parseInt(txtTotalAulas.getText()));
		dao.update(course);
		closeUpdate();
		
	}
	
	public void initCourse() {
		txtId.setText(course2.getId().toString());
		txtNome.setText(course2.getNome());
		txtDescricao.setText(course2.getDescricao());
		txtCargaHoraria.setText(course2.getCargaHoraria().toString());
		txtTotalAulas.setText(course2.getTotalAulas().toString());
	}
	
	public void closeUpdate() {
		UpdateCourse.getStageUpdateCourse().close();
	}
	
	public void constraints() {
		Constraints.setTexFieldMaxLength(txtNome, 20);
		Constraints.setTexFieldMaxLength(txtDescricao, 20);
		Constraints.setTexFieldInteger(txtTotalAulas);
		Constraints.setTexFieldInteger(txtCargaHoraria);
	}
	
	public void openListCourse() {
		ListCourse lc = new ListCourse();
		lc.start(new Stage());
	}
}
