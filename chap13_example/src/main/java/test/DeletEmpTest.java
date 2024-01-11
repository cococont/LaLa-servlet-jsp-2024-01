package test;

import dao.EmployeesDAO;
import model.Employee;
public class DeletEmpTest {
  public static void main(String[] args) {
	  EmployeesDAO dao = new EmployeesDAO();
	  Employee emp = new Employee("EMP004", "菅原 aa", 38);
	  dao.remove("EMP004");
  }
}
