package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInf;
import board.vo.BoardVO;

/**
 * Servlet implementation class GetBoardListServlet
 */
@WebServlet("/getBoard")
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String str = request.getParameter("board_seq");
		if(str == null || str.trim().equals("")){
		str = "0";
		}
		int board_seq = Integer.parseInt(str);
		
		BoardServiceInf service = BoardService.getInstance();
		
		BoardVO vo = service.getBoard(board_seq);
		
		request.setAttribute("vo", vo);
		
		 request.getRequestDispatcher("board/boardView.jsp").forward(request, response);;
	}


}
