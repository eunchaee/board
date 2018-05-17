package member.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import member.dao.MemberDao;
import member.dao.MemberDaoInf;
import member.vo.MemberVO;

import org.junit.Test;

public class MemberServiceTest {

	@Test
	public void MemberServiceTest() {
		/***Given***/
		MemberServiceInf service = new MemberService();
		/***When***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", "test01");
		map.put("mem_pass", "1234");
		MemberVO member =service.getMember(map);
		
		
		
		/***Then***/
		assertEquals("test01", member.getMem_id());
		
		
		
		
		
	}

}
