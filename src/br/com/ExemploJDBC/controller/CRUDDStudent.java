package br.com.ExemploJDBC.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Student;


public class CRUDDStudent <T> extends AbstractCRUD<T> {

  @Override
    public boolean create(T o) throws SQLException {
      Student stu = (Student) o;
      String query = 
              "INSERT INTO department (name, dept_name, tot_cred) "
              + "VALUES (?, ?, ?)";
      PreparedStatement stmt = super.connection.prepareStatement(query);
      stmt.setString(1, stu.getNameStudent());
      stmt.setString(2, stu.getDept_Name());
      stmt.setDouble(3, stu.getTot_Cred());
      int rows = stmt.executeUpdate();
      if(rows > 0) {
          return true;
      }
      return false;
}

@Override
public boolean delete(int id) throws SQLException {
  // TODO Auto-generated method stub
  String query = "DELETE FROM student WHERE id = ?";
  PreparedStatement stmt = super.connection.prepareStatement(query);
  stmt.setInt(1, id);
  int rows = stmt.executeUpdate();
  return rows > 0;
}

@Override
public boolean update(T o) throws SQLException {
  Student stu = (Student) o;
  String query = "UPDATE student "
      + "SET name = ?, dept_name = ?, tot_cred = ? "
      + "WHERE id = ?";
  PreparedStatement stmt = super.connection.prepareStatement(query);
  stmt.setString(1, stu.getNameStudent());
  stmt.setString(2, stu.getDept_Name());
  stmt.setDouble(3, stu.getTot_Cred());
  stmt.setInt(4, stu.getIdStudent());
  int rows = stmt.executeUpdate();
  return rows > 0;
  
}

@Override
public T getById(int id) throws SQLException {
  
  String query = "SELECT * FROM student WHERE id = ?";
  PreparedStatement stmt = super.connection.prepareStatement(query);
  stmt.setInt(1, id);
  ResultSet result = stmt.executeQuery();
  result.next();
  Student stu = new Student();
  stu.setIdStudent(result.getInt(1));
  stu.setName(result.getString(2));
  stu.setDept_Name(result.getString(3));
  stu.setTot_Cred(result.getInt(4));
  return (T) stu;
}

@Override
public ArrayList<T> listAll() throws SQLException {
  String query = "SELECT * FROM student";
  PreparedStatement stmt = super.connection.prepareStatement(query);
  ResultSet result = stmt.executeQuery();
  ArrayList<Student> student = new ArrayList<Student>();
  while(result.next()) {
    Student stu = new Student();
    stu.setIdStudent(result.getInt(1));
    stu.setName(result.getString(2));
    stu.setDept_Name(result.getString(3));
    stu.setTot_Cred(result.getInt(4));
    student.add(stu);
  }
  return (ArrayList<T>) student;
}


}

