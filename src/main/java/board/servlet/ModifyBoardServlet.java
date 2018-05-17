package board.servlet;

import java.io.IOException;

import javafx.scene.control.Alert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import sun.print.resources.serviceui;
import board.service.BoardService;
import board.service.BoardServiceInf;
import board.vo.BoardVO;

@WebServlet("/modifyBoard")
public class ModifyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyBoardServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int board_seq =Integer.parseInt(request.getParameter("board_seq"));
    	String content = request.getParameter("content");
    	String title =request.getParameter("title");
    	String reg_id = request.getParameter("reg_id");
    	BoardServiceInf service = BoardService.getInstance();
    	
    	BoardVO vo = service.getBoard(board_seq);
    	vo.setContent(content);
    	vo.setTitle(title);
    	vo.setReg_id(reg_id);
    	request.setAttribute("vo", vo);
    	String mem_id=(String) request.getSession().getAttribute("mem_id");
    	
    	if(mem_id.equals(reg_id)){
    		
    		RequestDispatcher rd =request.getRequestDispatcher("board/boardmodi.jsp");
    		rd.forward(request, response);
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
