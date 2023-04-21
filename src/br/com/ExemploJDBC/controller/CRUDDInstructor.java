package br.com.ExemploJDBC.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Instructor;

public class CRUDDInstructor<T> extends AbstractCRUD<T> {
	
	@Override
	public boolean create(T o) throws SQLException {
		Instructor Instr = (Instructor) o;
		String query = 
				"INSERT INTO instructor (name, dept_name, salary) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, Instr.getNameInstructor());
		stmt.setString(2, Instr.getDept_NameInstructor());
		stmt.setDouble(3, Instr.getSalaryInstructor());
		int rows = stmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
	
		String query = "DELETE FROM instructor WHERE id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public boolean update(T o) throws SQLException {
		Instructor Instr = (Instructor) o;
		String query = "UPDATE instructor "
				+ "SET name = ?, dept_name = ?, salary = ? "
				+ "WHERE id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, Instr.getNameInstructor());
		stmt.setString(2, Instr.getDept_NameInstructor());
		stmt.setDouble(3, Instr.getSalaryInstructor());
		stmt.setInt(4, Instr. getIdInstructor());
		int rows = stmt.executeUpdate();
		return rows > 0;
		
	}

	@Override
	public T getById(int id) throws SQLException {
		
		String query = "SELECT * FROM instructor WHERE id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		Instructor Instr = new Instructor();
		Instr.setIdDepartment(result.getInt(1));
		Instr.setNameInstructor(result.getString(2));
		Instr.setDept_NameInstructor(result.getString(3));
		Instr.setSalaryInstructor(result.getDouble(4));
		return (T) Instr;
	}

	@Override
	public ArrayList<T> listAll() throws SQLException {
		String query = "SELECT * FROM instructor";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<Instructor> instructor = new ArrayList<Instructor>();
		while(result.next()) {
			Instructor instr = new Instructor();
			instr.setIdDepartment(result.getInt(1));
			instr.setNameInstructor(result.getString(2));
			instr.setDept_NameInstructor(result.getString(3));
			instr.setSalaryInstructor(result.getDouble(4));
			instructor.add(instr);
		}
		return (ArrayList<T>) instructor;
	}

}