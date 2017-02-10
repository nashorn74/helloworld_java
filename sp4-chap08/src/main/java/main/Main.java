package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Member;
import spring.MemberDao;

public class Main {
	private static MemberDao memberDao;
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(
				"classpath:applicationContext.xml");
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		Member member = memberDao.selectByEmail("test@test.net");
		System.out.println(member.getName());
		
		ctx.close();
	}
}
