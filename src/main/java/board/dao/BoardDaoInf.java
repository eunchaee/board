package board.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface BoardDaoInf {

	public List<BoardVO> getBoardList(int category_seq);
	
	public BoardVO getBoard(int board_seq);
	
	public int deleteBoard(BoardVO boardVO);
	
	public int insertBoard(BoardVO boardVO);
	
	public int modifyBoard(BoardVO boardVO);
	
	public List<BoardVO> getBoardPageList(int page , int pageSize);
	
	public int getBoardTotalCnt();
}
