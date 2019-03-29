package application;

import java.util.List;

import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;

public class TestDB {

	public static void main(String[] args)  {
		
		Course course = new Course("Java", "Intermediário", 90, 270);
		CourseDao dao = DaoFactory.createCourseDao();
		dao.insert(course);
		
	}

}
