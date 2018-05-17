package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.vo.BoardVO;

public class BoardService implements BoardServiceInf{

	private static BoardServiceInf service =new BoardService();
	
	private BoardDaoInf dao;
	
	public  BoardService() {
		dao=BoardDao.getInstance();
	}
	
	public static BoardServiceInf getInstance(){
		return service;
	}
	
	@Override
	public List<BoardVO> getBoardList(int category_seq) {
		return dao.getBoardList(category_seq);
	}

	@Override
	public BoardVO getBoard(int board_seq) {
		return dao.getBoard(board_seq);
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		return dao.deleteBoard(boardVO);
	}

	@Override
	public Map<String, Object> getBoardPageList(int page, int pageSize) {
		//service.xxxxx ->getUserPageList(), dao.getUserTotalCnt()
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<BoardVO> userList=dao.getBoardPageList(page, pageSize);
		String pageNav=makePageNav(page,dao.getBoardTotalCnt());
		
		resultMap.put("userList", userList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}
	
	private String makePageNav(int page, int userTotalCnt) {
		//userTotalCnt =26
		//pageSize 10
		//totalPage:3건
		//26/10
		int pageTotalCnt=(int)Math.ceil(userTotalCnt/(double)10);
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("<ul class=\"pagination\">");
		pageNav.append("<li><a href=\"getUserPageList?page=1&pageSize=10\" aria-label=\"Previous\"> <span");
		pageNav.append("aria-hidden=\"true\">&laquo;</span>");
		pageNav.append("</a></li>");
		
		
		/*if()*/
		for(int i=1; i<=pageTotalCnt; i++){
			if(i==page){
			pageNav.append("<li class='active'><a href=\"getUserPageList?page="+i+"&pageSize=10\">"+i+"</a></li>");
		}else{
			
			pageNav.append("<li><a href=\"getUserPageList?page="+i+"&pageSize=10\">"+i+"</a></li>");
		}
		
		}
		
		
		pageNav.append("<li><a href=\"getUserPageList?page="+pageTotalCnt+"&pageSize=10\" aria-label=\"Next\"> <span");
		pageNav.append("aria-hidden=\"true\">&raquo;</span>");
		pageNav.append("</a></li>");
		pageNav.append("</ul>");
		pageNav.append("</nav>");
		return pageNav.toString();
		
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return dao.insertBoard(boardVO);
	}

	@Override
	public int modifyBoard(BoardVO boardVO) {
		return dao.modifyBoard(boardVO);
	}
	

}
