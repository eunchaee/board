package member.dao;

import java.util.Map;

import member.vo.MemberVO;


public interface MemberDaoInf {

	public MemberVO getMember(Map<String,String> map);
}
