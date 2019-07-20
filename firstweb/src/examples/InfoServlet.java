package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "info", urlPatterns = { "/info" })
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>info</title></head>");
		out.println("<body>");

		String uri = request.getRequestURI(); // domain, port num 이후 정보
		StringBuffer url = request.getRequestURL();
		String contentPath = request.getContextPath(); // WAS에는 여러웹앱이 존재할 수 있는데 특정 웹앱을 찾아가는 root이름
		String remoteAddr = request.getRemoteAddr(); // cli의 주소값

		out.println("uri : " + uri + "<br>");
		out.println("url : " + url + "<br>");
		out.println("contentpath : " + contentPath + "<br>");
		out.println("remoteAddr : " + remoteAddr + "<br>");

		out.println("</body>");
		out.println("</html>");
	}

}
