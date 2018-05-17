package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface BoardServiceInf {

	public List<BoardVO> getBoardList(int category_seq);
	
	public BoardVO getBoard(int board_seq);
	
	public int deleteBoard(BoardVO boardVO);
	
	public int insertBoard(BoardVO boardVO);
	
	public int modifyBoard(BoardVO boardVO);
	
	public Map<String, Object> getBoardPageList(int page , int pageSize);
}
