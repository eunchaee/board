package board.servlet;

import java.io.IOException;

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
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/boardInsert")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertBoardServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			int category_seq =Integer.parseInt(request.getParameter("category_seq"));
			String title =request.getParameter("title");
			String content =request.getParameter("content");
			String reg_id =request.getParameter("reg_id");
			
			BoardServiceInf service  = BoardService.getInstance();
			
			BoardVO vo = new BoardVO();
			vo.setBoard_seq(category_seq);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setReg_id(reg_id);
			String mem_id=(String) request.getSession().getAttribute("mem_id");
			
			int insert = service.insertBoard(vo);
			
			if(mem_id.equals(reg_id)){
				
				if(insert==1){
					RequestDispatcher rd =request.getRequestDispatcher("board/boardReg.jsp");
					rd.forward(request, response);
					System.out.println("여기 지나가냐 추가성공일때");
					
				}else if(insert==0){
					response.sendRedirect("main.jsp");
					System.out.println("여기 지나가냐 추가실패");
				}
			}else{
				response.sendRedirect("board/nosession.jsp");
				System.out.println("여기 지나가냐 노쎄션");
			}
			
	}

}
