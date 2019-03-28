package application;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;

public class TestDB {

	public static void main(String[] args) {
		
		CourseDao dao = DaoFactory.createCourseDao();
		dao.delete(3);
	}

}
