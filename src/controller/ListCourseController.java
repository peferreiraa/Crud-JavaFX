package controller;

import java.net.URL;

import java.util.ResourceBundle;

import application.ListCourse;
import application.UpdateCourse;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;
import util.Alerts;
import util.OpenMainView;

public class ListCourseController implements Initializable{

	@FXML
	private TableView<Course> tblCourse;

	@FXML
	private TableColumn<Course, Integer> columnId;

	@FXML
	private TableColumn<Course, String> columnNome;

	@FXML
	private TableColumn<Course, String> columnDescricao;

	@FXML
	private TableColumn<Course, Integer> columnCargaHoraria;

	@FXML
	private TableColumn<Course, Integer> columnTotalAulas;

    @FXML
    private Button btnDeletar;
    
    @FXML
    private Button btnPesquisar;

    @FXML
    private TextField txtPesquisar;
    
    @FXML
    private Label lblClose;

    @FXML
    private Label lblMinimize;

    @FXML
    private Button btnUpdateCurso;
    
    @FXML
    private Button btnAtualizarTabela;
    
    private Course selectedCourse;
    
    private ObservableList<Course> courses = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initTable();
		
		lblClose.setOnMouseClicked((MouseEvent e) -> {
			closeListCourse();
			OpenMainView.openMainView();
		});
		
		lblMinimize.setOnMouseClicked((MouseEvent e) -> {
			ListCourse.getStageListCourse().setIconified(true);
		});
		
		btnAtualizarTabela.setOnMouseClicked((MouseEvent e) -> {
			tblCourse.setItems(updateTable());
		});
		
		btnDeletar.setOnMouseClicked((MouseEvent e) -> {
			delete();	
		});
		
		btnPesquisar.setOnMouseClicked((MouseEvent e) -> {
			tblCourse.setItems(searchCourse());
		});
		
		btnUpdateCurso.setOnMouseClicked((MouseEvent e) -> {
			if(selectedCourse != null) {
				UpdateCourse update = new UpdateCourse(selectedCourse);
				update.start(new Stage());
				closeListCourse();
			}
			else {
				Alerts.showAlert("Error", "Selecione um curso!", null, AlertType.ERROR);
			}
		});
		
		tblCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {

			@Override
			public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
				selectedCourse = newValue;
				
			}
		});
	}
	
	public void initTable() {
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		columnCargaHoraria.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
		columnTotalAulas.setCellValueFactory(new PropertyValueFactory<>("totalAulas"));
		tblCourse.setItems(updateTable());
	}
	
	public ObservableList<Course> updateTable(){
		CourseDao dao = DaoFactory.createCourseDao();
		courses = FXCollections.observableArrayList(dao.findAll());
		return courses;
	}
	
	public void delete() {
		if(selectedCourse != null) {
			CourseDao dao = DaoFactory.createCourseDao();
			dao.delete(selectedCourse.getId());
			tblCourse.setItems(updateTable());
		}else {
			Alerts.showAlert("Error", "Selecione um curso!", null, AlertType.ERROR);
		}
	}
	
	public ObservableList<Course> searchCourse(){
		ObservableList<Course> courseSearch = FXCollections.observableArrayList();
		for(Course course : courses) {
			if(course.getNome().toLowerCase().contains(txtPesquisar.getText().toLowerCase()) || 
					course.getId().toString().contains(txtPesquisar.getText())) {
				courseSearch.add(course);
			}
		}
		return courseSearch;
	}
	
	public void closeListCourse() {
		ListCourse.getStageListCourse().close();
	}
	
}
