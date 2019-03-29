package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import application.UpdateCourse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;

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
	private Button btnAtualizar;

	@FXML
	private Button btnCancelar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initCourse();
		
		btnAtualizar.setOnMouseClicked((MouseEvent e) -> {
			updateCourse();
		});
		
		btnCancelar.setOnMouseClicked((MouseEvent e) -> {
			closeUpdate();
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
}
