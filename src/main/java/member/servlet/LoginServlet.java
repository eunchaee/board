package member.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.service.BoardServiceInf;
import board.vo.BoardVO;
import member.service.MemberService;
import member.service.MemberServiceInf;
import member.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet2")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		MemberServiceInf service =new MemberService();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("mem_pass", mem_pass);
		MemberVO member =service.getMember(map);
		
//		String StringCategory_seq = request.getParameter("category_seq");
//		int category_seq = Integer.parseInt(StringCategory_seq);
		BoardServiceInf bservice =BoardService.getInstance();
		
		HttpSession session=request.getSession();
		session.setAttribute("mem_id", mem_id);
		
//		ServletContext sc =getServletContext();
//		sc.setAt
		
		List<BoardVO> list = bservice.getBoardList(1);
		
		request.setAttribute("list", list);
		
		
		if(member==null){
			response.sendRedirect("login/login.jsp");
		}else if(member!=null){
			
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
