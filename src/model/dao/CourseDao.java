package model.dao;

import java.util.List;

import model.entities.Course;

public interface CourseDao {
	
	void insert(Course obj);
	void update(Course obj);
	void delete(Integer id);
	List<Course> findAll();
}
