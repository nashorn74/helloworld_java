package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;
import chap07.ExecuteTimeCalculator;
import chap07.ImplementCalculator;
import chap07.RecursiveCalculator;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
			new GenericXmlApplicationContext("classpath:aopPojo.xml");
		Calculator aspectImplementCalc =
				ctx.getBean("implementCalculator", Calculator.class);
		Calculator aspectRecursiveCalc =
				ctx.getBean("recursiveCalculator", Calculator.class);
		long aspectResult1 = aspectImplementCalc.factorial(5000);
		long aspectResult2 = aspectRecursiveCalc.factorial(5000);
		
		///////////////////////////////////////////////////////////
		
		ImplementCalculator implementCalculator =
				new ImplementCalculator();
		RecursiveCalculator recursiveCalculator =
				new RecursiveCalculator();
		
		ExecuteTimeCalculator execTimeCalc1 =
				new ExecuteTimeCalculator(implementCalculator);
		ExecuteTimeCalculator execTimeCalc2 =
				new ExecuteTimeCalculator(recursiveCalculator);
		execTimeCalc1.factorial(5000);
		execTimeCalc2.factorial(5000);
		ExecuteTimeCalculator execTimeCalc3 =
				new ExecuteTimeCalculator(execTimeCalc1);
		execTimeCalc3.factorial(5000);
		
		//////////////////////////////////////////
		
		long start1 = System.currentTimeMillis();//시작시간
		long result1 = implementCalculator.factorial(5000);
		long end1 = System.currentTimeMillis();//종료시간
		
		long start2 = System.currentTimeMillis();//시작시간
		long result2 = recursiveCalculator.factorial(5000);
		long end2 = System.currentTimeMillis();//종료시간
		
		System.out.printf("실행시간1=%d\n실행시간2=%d\n",
				(end1-start1), (end2-start2));
	}
}
