package member.service;

import java.util.Map;

import member.dao.MemberDao;
import member.dao.MemberDaoInf;
import member.vo.MemberVO;

public class MemberService implements MemberServiceInf {

	private static MemberServiceInf service = new MemberService();
	
	private MemberDaoInf dao;
	
	public MemberService() {
		dao=MemberDao.getInstance();
	}
	public static MemberServiceInf getInstance(){
		return service;
	}
	
	@Override
	public MemberVO getMember(Map<String,String> map) {
		return dao.getMember(map);
	}

}
