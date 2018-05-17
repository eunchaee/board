package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.vo.BoardVO;

public class BoardDao implements BoardDaoInf {

	private static BoardDaoInf dao = new BoardDao();
	
	private SqlSessionFactory sqlSessionFactory;
	
	private BoardDao() {
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDaoInf getInstance(){
		return dao;
	}
	
	@Override
	public List<BoardVO> getBoardList(int category_seq) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		List<BoardVO> list = sqlSession.selectList("board.getBoardList",category_seq);
		sqlSession.close();
		return list;
	}

	@Override
	public BoardVO getBoard(int board_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO vo =sqlSession.selectOne("board.getBoard",board_seq);
		sqlSession.close();
		return vo;
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteCnt = sqlSession.delete("board.deleteBoard",boardVO);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public List<BoardVO> getBoardPageList(int page, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Integer> paramMap=new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		List<BoardVO> pageList = sqlSession.selectList("board.getBoardPageList", paramMap);
		return pageList;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		int insert =sqlSession.insert("board.insertBoard",boardVO);
		sqlSession.commit();
		sqlSession.close();
		return insert;
	}

	@Override
	public int modifyBoard(BoardVO boardVO) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		int modify =sqlSession.update("board.modifyBoard",boardVO);
		sqlSession.commit();
		sqlSession.close();
		return modify;
	}

	@Override
	public int getBoardTotalCnt() {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		int boardTotalCnt =sqlSession.insert("board.getBoardTotalCnt");
		sqlSession.commit();
		sqlSession.close();
		return boardTotalCnt;
	}

}
