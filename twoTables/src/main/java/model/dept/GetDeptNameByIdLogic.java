package model.dept;

import dao.DeptDAO;

public class GetDeptNameByIdLogic {
	public String execute(String dept_id) {
		DeptDAO dao = new DeptDAO();
		return dao.findNameById(dept_id);
	}
}
