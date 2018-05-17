package board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.vo.BoardVO;

public class BoardServiceTest {

	@Test
	public void getBoardListTest() {
		/***Given***/
		BoardServiceInf service =BoardService.getInstance();
		int category_seq=1;
		/***When***/
		
		List<BoardVO> list = service.getBoardList(category_seq);
		/***Then***/
		assertNotNull(list);
	}
	public void getBoardTest(){
		/***Given***/
		BoardServiceInf service= BoardService.getInstance();
		int board_seq =1;
		/***When***/
		BoardVO vo =service.getBoard(board_seq);
		/***Then***/
		assertNotNull(vo);
	}
	@Test
	public void deleteBoartTest() {
		/***Given***/
		BoardDaoInf dao = BoardDao.getInstance();
		/***When***/
		BoardVO vo =new BoardVO();
		vo.setBoard_seq(14);
		vo.setDel_yn("y");
		int deleteCnt =dao.deleteBoard(vo);
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	@Test
	public void modifyBoardTest() {
		/***Given***/
		BoardServiceInf service = BoardService.getInstance();
		/***When***/
		BoardVO vo =new BoardVO();
		vo.setBoard_seq(14);
		vo.setTitle("제목sds니s다..df");
		vo.setContent("내요ssdd옹sdf");
		
		int modifyCnt= service.modifyBoard(vo);
		/***Then***/
		assertEquals(1, modifyCnt);
	}
	@Test
	public void insertBoardTest(){
		/***Given***/
		BoardServiceInf service = BoardService.getInstance();
		
		BoardVO vo =new BoardVO();
		
		vo.setCategory_seq(1);
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setReg_id("sally");
	
		/***When***/
		int insertCnt = service.insertBoard(vo);
		/***Then***/
		assertEquals(1, insertCnt);
	}

}
