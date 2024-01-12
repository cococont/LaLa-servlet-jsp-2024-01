package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.RegisterEmpLogic;
import util.Tools;

@WebServlet("/register")
public class RegisterEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Tools.myParseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
//		System.out.println(emp);
//		emp の入力値チェックが必要
//		エラーがあれば createEmp.jsp に戻る
//		エラーメッセージを送る
		request.setAttribute("emp", emp);
		RegisterEmpLogic registerEmpLogic = new RegisterEmpLogic();
		String msg = "";
		if (registerEmpLogic.execute(emp)) {
			msg = "登録成功";
		} else {
			msg = "登録失敗";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/create/createDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
