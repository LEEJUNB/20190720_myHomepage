package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "header", urlPatterns = { "/header" })
public class headerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public headerServlet() {
		super();

	}

	// 요청정보가 들어왔을 떄 헤더정보가 무엇이 있을지를 출력하고자 한다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");// 응답 보내기 전에 컨텐츠타입에 대해 미리 알려줘야 한다.
		PrintWriter out = response.getWriter(); // 요청객체(response)로 부터 응답 보낼 통로를 알아온다. cli와의 연결통로 알아오기
		// 응답 보낼 HTML 태그들
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		// 알아보고픈 헤더에 대한 정보들을 작성해보자
		// 요청이 들어올 때 모든 정보들은 WAS가 HttpServletRequest라는 객체에 담아뒀다.
		// 근데 이를 doGet()의 파라미터로 가지고 들어왔다.고로 request에게 물어보면 요청시의 모든 정보들을 알 수 있다.
		Enumeration<String> headerNames = request.getHeaderNames();// request가 가진 메서드 중 getHeaderNames()메서드는 모든 헤더 이름을
																	// 문자열(Enumeration)로 반환해준다.
		while (headerNames.hasMoreElements()) {// Enumeration으로 반환받았기에 그 부분을 while문 통해 알아보면 headerName을 알 수 있고
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);// headerName을 통해 getHeader()통해 헤더값을 알 수 있다.
			out.println(headerName + " : " + headerValue + " <br> ");// 이를 응답 결과에 담아 브라우저에 출력한다.
		}
		out.println("<h1>test</h1>");
		out.println("<//body>");
		out.println("<//html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); // doPost()또한 doGet()을 호출하도록 되어있기에 doGET()에 구현한 것과 동일하게 실행된다.
	}
}
