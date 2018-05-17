package member.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import member.vo.MemberVO;

import org.junit.Test;

public class MemberDaoTest {

	@Test
	public void MemberDaoTest() {
		/***Given***/
		MemberDaoInf dao = new MemberDao();
		/***When***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", "test01");
		map.put("mem_pass", "1234");
		MemberVO member =dao.getMember(map);
		
		
		
		/***Then***/
		assertEquals("test01", member.getMem_id());
		
		
		
		
		
	}

}
