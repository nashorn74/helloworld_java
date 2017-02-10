package spring;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public MemberDao getMemberDao() {
		return this.memberDao;
	}
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		System.out.println(member.getName());
		System.out.println();
	}
}
