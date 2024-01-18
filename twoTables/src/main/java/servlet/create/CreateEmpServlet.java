package servlet.create;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.dept.Dept;
import util.Tools;

//import model.dept.Dept;
//import model.dept.GetDeptListLogic;

@WebServlet("/create")
public class CreateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		以下を filter で実装
//		GetDeptListLogic logic = new GetDeptListLogic();
//		List<Dept> deptList = logic.execute();
//		request.setAttribute("deptList", deptList);
		String url = "WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		String did = request.getParameter("dept_id");
		Dept dept = new Dept(did, null);
		Employee emp = new Employee(id, name, age, dept);
		
//		emp の入力値チェックが必要
//		エラーがあれば createEmp.jsp に戻る
//		エラーメッセージを送る
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
