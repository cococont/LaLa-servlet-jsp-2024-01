package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import util.Tools;

@WebServlet("/create")
public class CreateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
//		emp の入力値チェックが必要
//		エラーがあれば createEmp.jsp に戻る
//		エラーメッセージを送る
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/create/createConfirm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
