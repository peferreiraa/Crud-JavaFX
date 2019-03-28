package application;

import java.sql.Connection;

import db.DB;

public class TestDB {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();

	}

}
