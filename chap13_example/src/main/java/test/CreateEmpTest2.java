package test;

import model.Employee;
import model.RegisterEmpLogic;
public class CreateEmpTest2 {
  public static void main(String[] args) {
	  RegisterEmpLogic logic = new RegisterEmpLogic();
	  Employee emp = new Employee("EMP005", "菅原 aa", 38);
	  if (logic.execute(emp)) {
		  System.out.println("登録成功");
	  } else {
		  System.out.println("登録失敗");
	  }
//	  dao.create(emp);
//	  System.out.println(emp);
  }
}
