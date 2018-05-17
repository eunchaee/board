package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import member.vo.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MemberDao implements MemberDaoInf {
	private static MemberDaoInf dao=new MemberDao();
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDaoInf getInstance(){
		return dao;
	}
		
	

	@Override
	public MemberVO getMember(Map<String,String> map) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		MemberVO memberVO=sqlSession.selectOne("member.getMember",map);
		sqlSession.close();
		return memberVO;
	}

}
