package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig;
import spring.ChangePasswordService;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;

public class Main {
	private static ApplicationContext ctx = null;
	public static void main(String[] args) {
		/*ctx = new GenericXmlApplicationContext(
				"classpath:applicationContext.xml");*/
		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		MemberRegisterService registerService =
			ctx.getBean("memberRegisterService",MemberRegisterService.class);
		ChangePasswordService changePasswordService = 
			ctx.getBean("changePasswordService",ChangePasswordService.class);
		MemberInfoPrinter infoPrinter =
			ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo("test@test.net");
	}
}
