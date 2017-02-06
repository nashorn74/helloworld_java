package spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {//기존에 이미 같은 이메일 사용자가 있으면 예외처리
			throw new AleadyExistingMemberException(
					"dup email "+req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				new Date());//새로운 Member 객체 생성
		memberDao.insert(newMember);//데이터베이스에 추가
	}
}
