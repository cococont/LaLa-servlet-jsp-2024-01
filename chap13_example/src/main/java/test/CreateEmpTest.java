package test;

import dao.EmployeesDAO;
import model.Employee;
public class CreateEmpTest {
  public static void main(String[] args) {
	  EmployeesDAO dao = new EmployeesDAO();
	  Employee emp = new Employee("EMP004", "菅原 aa", 38);
	  if (dao.create(emp)) {
		  System.out.println("登録成功");
	  } else {
		  System.out.println("登録失敗");
	  }
//	  dao.create(emp);
//	  System.out.println(emp);
  }
}
