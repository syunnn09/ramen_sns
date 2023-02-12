package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import definition.Const;
import model.UserBean;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("prefs", Const.prefs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/createNewUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int prefecture = Integer.parseInt(request.getParameter("prefecture"));
		String imagePath = "";
		String bio = "";

		UserBean user = new UserBean(userName, password, email, imagePath, bio, prefecture);
		UserDao userDao = new UserDao();
		boolean isCreatedUser = userDao.insert(user);
		System.out.println(isCreatedUser);

		response.sendRedirect("mypage");
	}

}
