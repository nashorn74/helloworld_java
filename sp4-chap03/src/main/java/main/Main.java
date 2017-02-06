package main;

import assembler.Assembler;
import spring.ChangePasswordService;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main {
	private static Assembler assembler = new Assembler();
	public static void main(String[] args) {
		////////////////////////////////////////////////////////회원가입
		MemberRegisterService registerService =
				assembler.getMemberRegisterService();
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
				assembler.getChangePasswordService();//암호변경
		try {
			changePasswordService.changePassword("test@test.net", 
					"1234", "7777");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
