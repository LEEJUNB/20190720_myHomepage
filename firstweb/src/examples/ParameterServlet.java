package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet(name = "param", urlPatterns = { "/param" })
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParameterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>parameter</title></head>");
		out.println("<body>");

		String nameVal = request.getParameter("name"); // getParameter("parameter name")
		String ageVal = request.getParameter("age"); // getParameter("parameter value") 숫자가 아닌 전부 문자열로 넘어오기에 String사용

		out.println("name : " + nameVal + "<br>");
		out.println("age : " + ageVal + "<br>");

		out.println("</body>");
		out.println("</html>");
	}
}