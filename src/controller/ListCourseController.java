package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;

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
	private TableColumn<Course, Date> columnAno;

    @FXML
    private Button btnDeletar;
    
    private Course selectedCourse;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initTable();
		
		btnDeletar.setOnMouseClicked((MouseEvent e) -> {
			delete();
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
		columnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		tblCourse.setItems(updateTable());
	}
	
	public ObservableList<Course> updateTable(){
		CourseDao dao = DaoFactory.createCourseDao();
		return FXCollections.observableArrayList(dao.findAll());
	}
	
	public void delete() {
		if(selectedCourse != null) {
			CourseDao dao = DaoFactory.createCourseDao();
			dao.delete(selectedCourse.getId());
			tblCourse.setItems(updateTable());
		}
		else {
			System.out.println("Error!");
		}
	}
}
