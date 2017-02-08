package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import assembler.Assembler;
import spring.ChangePasswordService;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main {
	//private static Assembler assembler = new Assembler();
	private static ApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext(
				"classpath:applicationContext.xml");
		////////////////////////////////////////////////////////회원가입
		MemberRegisterService registerService =
				//assembler.getMemberRegisterService();
				ctx.getBean("memberRegisterService",
						MemberRegisterService.class);
		RegisterRequest request = new RegisterRequest();
		request.setEmail("test@test.net");
		request.setName("홍길동");
		request.setPassword("1234");
		request.setConfirmPassword("1234");
		try {
			registerService.regist(request);
		} catch(Exception e) {
			e.printStackTrace();
		}
		ChangePasswordService changePasswordService = 
				//assembler.getChangePasswordService();//암호변경
				ctx.getBean("changePasswordService",
						ChangePasswordService.class);
		try {
			changePasswordService.changePassword("test@test.net", 
					"1234", "7777");
		} catch(Exception e) {
			e.printStackTrace();
		}
		//////////////////////////////////
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo("test@test.net");

	}

}
