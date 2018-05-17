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
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBoardServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String del_yn=request.getParameter("del_yn");
		String title =request.getParameter("title");
		String reg_id=request.getParameter("reg_id");
		
		///////////////
		
		BoardServiceInf service =BoardService.getInstance();
		
		BoardVO vo = new BoardVO();
		vo.setBoard_seq(board_seq);
		vo.setDel_yn(del_yn);
		System.out.println();
		vo.setReg_id(reg_id);
		vo.setTitle(title);
		
//		List<BoardVO> list= service.getBoardList(1);T
//		System.out.println(list+"fdjskfjlkjf");
//		
//		request.setAttribute("list", list);
//		
		String mem_id=(String) request.getSession().getAttribute("mem_id");
		int delete =service.deleteBoard(vo);
		
		if(mem_id.equals(reg_id)){
			
			if(delete==1){
				
				RequestDispatcher rd =request.getRequestDispatcher("main.jsp");
	    		rd.forward(request, response);
				
			}else if(delete==0){
				response.sendRedirect("board/boardView.jsp");
			}
		}else{
			response.sendRedirect("board/nosession.jsp");
		}
				
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String content =request.getParameter("content");
		System.out.println(content);
		String title = request.getParameter("title");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		BoardServiceInf service = BoardService.getInstance();
		
		BoardVO vo = new BoardVO();
		vo.setBoard_seq(board_seq);
		vo.setTitle(title);
		vo.setContent(content);
		System.out.println(vo);
		
		request.setAttribute("vo", vo);
		int modify = service.modifyBoard(vo);
		
		if(modify==1){
			
			 response.sendRedirect(request.getContextPath()+"/getBoard?board_seq="+board_seq);
		}else if(modify==0){
			response.sendRedirect("");
		}
	}

}
