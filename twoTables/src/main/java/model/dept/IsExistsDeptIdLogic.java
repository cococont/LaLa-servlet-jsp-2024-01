package model.dept;

import dao.DeptDAO;

public class IsExistsDeptIdLogic {
	public boolean execute(String id) {
		DeptDAO dao = new DeptDAO();
		return dao.isExistsId(id);
	}
}
