package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService registerService;
	private ChangePasswordService passwordService;
	public Assembler() {
		this.memberDao = new MemberDao();
		this.registerService = 
			new MemberRegisterService(this.memberDao);
		this.passwordService =
			new ChangePasswordService(this.memberDao);
	}
	public MemberDao getMemberDao() {
		return this.memberDao;
	}
	public MemberRegisterService getMemberRegisterService() {
		return this.registerService;
	}
	public ChangePasswordService getChangePasswordService() {
		return this.passwordService;
	}
}
