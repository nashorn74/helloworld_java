package main;

import java.util.Date;
import java.util.List;

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
		
		System.out.println("--------------------------------------");
		List<Member> memberList = memberDao.selectAll();
		for (int i = 0; i < memberList.size(); i++) {
			Member mem = memberList.get(i);
			System.out.println((i+1)+":"+mem.getName());
		}
		
		System.out.println("count="+memberDao.count());
		
		Member updateMember = 
				new Member("test@test.net","9999","홍길동",null);
		memberDao.update(updateMember);
		member = memberDao.selectByEmail("test@test.net");
		System.out.println(member.getName());
		
		Member insertMember =
			new Member("hello@world.com","1111","헬로월드",new Date());
		memberDao.insert(insertMember);
		System.out.println(insertMember.getId());
		System.out.println("--------------------------------------");
		memberList = memberDao.selectAll();
		for (int i = 0; i < memberList.size(); i++) {
			Member mem = memberList.get(i);
			System.out.println((i+1)+":"+mem.getName());
		}
		
		ctx.close();
	}
}
