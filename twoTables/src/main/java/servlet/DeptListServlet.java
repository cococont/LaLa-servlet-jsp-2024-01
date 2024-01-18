package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dept.Dept;
import model.dept.GetDeptListLogic;

@WebServlet("/deptlist")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dept> deptList = new ArrayList<>();

		GetDeptListLogic logic = new GetDeptListLogic();
		deptList = logic.execute();
		
		request.setAttribute("deptList", deptList);
		String url = "WEB-INF/jsp/deptList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
