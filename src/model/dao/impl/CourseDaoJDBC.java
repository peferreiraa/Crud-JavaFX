package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.CourseDao;
import model.entities.Course;

public class CourseDaoJDBC implements CourseDao {
	
	private Connection conn;

	public CourseDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Course obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO cursos (nome, descricao, carga_horaria, total_de_aulas) VALUES (?, ?, ?, ?)");
			st.setString(1, obj.getNome());
			st.setString(2, obj.getDescricao());
			st.setInt(3, obj.getCargaHoraria());
			st.setInt(4, obj.getTotalAulas());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void update(Course obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE cursos SET nome = ?,  descricao = ?, carga_horaria = ?, total_de_aulas = ? WHERE id = ?");
			st.setString(1, obj.getNome());
			st.setString(2, obj.getDescricao());
			st.setInt(3, obj.getCargaHoraria());
			st.setInt(4, obj.getTotalAulas());
			st.setInt(5, obj.getId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public void delete(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM cursos WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public List<Course> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM cursos");
			rs = st.executeQuery();
			while(rs.next()) {
				Course obj = new Course();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setDescricao(rs.getString("descricao"));
				obj.setCargaHoraria(rs.getInt("carga_horaria"));
				obj.setTotalAulas(rs.getInt("total_de_aulas"));
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	
	
}
