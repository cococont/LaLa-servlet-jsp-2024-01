package test;

import java.util.List;

import model.Employee;
import model.GetEmpListLogic;

public class SelectEmployees2 {
  public static void main(String[] args) {
	  GetEmpListLogic logic = new GetEmpListLogic();
	  List<Employee> empList = logic.execute();
	  
	  for (Employee emp : empList) {
		  System.out.println("ID:" + emp.getId());
		  System.out.println("名前:" + emp.getName());
		  System.out.println("年齢:" + emp.getAge() + "\n");
	}
  }
}
