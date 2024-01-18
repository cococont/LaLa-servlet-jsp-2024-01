package servlet.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.dept.Dept;
import model.dept.GetDeptNameByIdLogic;
import util.MayValidator;
import util.Tools;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		String dept_id = request.getParameter("dept_id");
		GetDeptNameByIdLogic getDeptName = new GetDeptNameByIdLogic();
		String dept_name = getDeptName.execute(dept_id);
		Dept dept = new Dept(dept_id, dept_name);
		Employee emp = new Employee(id, name, age, dept);
//		emp の入力値チェックが必要
		MayValidator validator = new MayValidator();
		List<String> errors = validator.check(emp);
		String url = null;
		if (errors.size() > 0) {
//			エラーがあれば createEmp へ
			request.setAttribute("errors", errors);
			url = "WEB-INF/jsp/create/createEmp.jsp";
		} else {
			url = "WEB-INF/jsp/create/createConfirm.jsp";
		}
//		エラーがあれば createEmp.jsp に戻る
//		エラーメッセージを送る
		request.setAttribute("emp", emp);

		request.getRequestDispatcher(url).forward(request, response);
	}
}
