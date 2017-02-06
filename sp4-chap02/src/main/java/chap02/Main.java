package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
		Greeter greeter = new Greeter();
		greeter.setFormat("%s,안녕하세요!");
		System.out.println(greeter.greet("자바"));
		////////////////////////////////////////////////////
		Greeter greeterBean = ctx.getBean("greeter",Greeter.class);
		System.out.println(greeterBean.greet("스프링"));
		ctx.close();
	}
}
