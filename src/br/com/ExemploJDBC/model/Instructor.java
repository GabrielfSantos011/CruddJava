package br.com.ExemploJDBC.model;

public class Instructor {

  private int idInstructor;
	private String nameInstructor;
	private String dept_nameInstructor;
	private double salaryInstructor;
	
	public int getIdInstructor() {
		return this.idInstructor;
	}
	
	public void setIdDepartment(int idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getNameInstructor() {
		return nameInstructor;
	}

	public void setNameInstructor(String nameInstructor) {
		this.nameInstructor = nameInstructor;
	}

	public String getDept_NameInstructor() {
		return dept_nameInstructor;
	}

	public void setDept_NameInstructor(String dept_nameInstructor) {
		this.dept_nameInstructor = dept_nameInstructor;
  }

	public double getSalaryInstructor(){
		return salaryInstructor;
	}

	public void setSalaryInstructor(double salaryInstructor) {
		this.salaryInstructor = salaryInstructor;
	}
	
}
  

