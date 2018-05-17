package board.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardPageServlet
 */
@WebServlet("/BoardPageServlet")
public class BoardPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageSting =request.getParameter("page");
		int page =pageSting==null ? 1 : Integer.parseInt(pageSting);
		
		
		String pageSizeString =request.getParameter("pageSize");
		int pageSize=pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		BoardServiceInf service = BoardService.getInstance();
		
		Map<String, Object> resultMap=(Map<String, Object>) service.getBoardPageList(page, pageSize);
		request.setAttribute("userList", resultMap.get("userList"));
		request.setAttribute("pageNav", resultMap.get("pageNav"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
