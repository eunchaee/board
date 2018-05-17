package member.service;

import java.util.Map;

import member.vo.MemberVO;

public interface MemberServiceInf {

	public MemberVO getMember(Map<String,String> map);
}
