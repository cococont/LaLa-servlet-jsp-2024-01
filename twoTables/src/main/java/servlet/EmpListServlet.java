package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmpListLogic;

@WebServlet("/list")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> empList = new ArrayList<>();

		GetEmpListLogic logic = new GetEmpListLogic();
		empList = logic.execute();
		
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
