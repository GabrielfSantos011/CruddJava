package br.com.ExemploJDBC.model;

public class Student {
  
private int idStudent;
private String nameStudent;
private String dept_name;
private int tot_cred;


public int getIdStudent(){
  return this.idStudent;
}

public void setIdStudent(int idStudent){
  this.idStudent = idStudent;

}

public String getNameStudent(){
  return this.nameStudent;
}

public void setName(String nameStudent){
  this.nameStudent = nameStudent;
}

public String getDept_Name(){
  return this.dept_name;
}

public void setDept_Name(String dept_name){
  this.dept_name = dept_name;
}

public int getTot_Cred(){
  return this.tot_cred;
}

public void setTot_Cred(int tot_cred){
  this.tot_cred = tot_cred;
}


}
