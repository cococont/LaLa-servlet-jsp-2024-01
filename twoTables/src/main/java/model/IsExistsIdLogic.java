package model;

import dao.EmployeesDAO;

public class IsExistsIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.isExistsId(id);
	}
}
