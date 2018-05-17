package board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import board.vo.BoardVO;

public class BoardDaoTest {

	@Test
	public void getBoardListTest() {
		/***Given***/
		BoardDaoInf dao =BoardDao.getInstance();
		int category_seq=2;
		/***When***/
		
		List<BoardVO> list = dao.getBoardList(category_seq);
		/***Then***/
		assertNotNull(list);

	}
	@Test
	public void getBoardTest(){
		/***Given***/
		BoardDaoInf dao= BoardDao.getInstance();
		int board_seq =1;
		/***When***/
		BoardVO vo =dao.getBoard(board_seq);
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
	public void insertBoardTest(){
		/***Given***/
		BoardDaoInf dao = BoardDao.getInstance();
		
		BoardVO vo =new BoardVO();
		
		vo.setCategory_seq(1);
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setReg_id("sally");
	
		/***When***/
		int insertCnt = dao.insertBoard(vo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	@Test
	public void modifyBoardTest() {
		/***Given***/
		BoardDaoInf dao = BoardDao.getInstance();
		/***When***/
		BoardVO vo =new BoardVO();
		vo.setBoard_seq(14);
		vo.setTitle("제목입니다..df");
		vo.setContent("내요옹df");
		
		int modifyCnt= dao.modifyBoard(vo);
		/***Then***/
		assertEquals(1, modifyCnt);
	}
	
	/*@Test
	public void getBoardPageListTest() {
		*//***Given***//*
		BoardDaoInf dao = BoardDao.getInstance();
		*//***When***//*
		int page=1;
		int pageSize=10;
		
		List<BoardVO> list = dao.getBoardPageList(page, pageSize);
		*//***Then***//*
		assertNotNull(list);
		assertEquals(10, list.size());
	}*/
	
}

