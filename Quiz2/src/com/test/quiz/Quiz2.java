package com.test.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String args[]) {
		int start1, start2, inc1, inc2;
		char char1, char2;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("숫자를 입력하세요.");
			String select = scanner.nextLine();
			if (select.equals("1")) {
				start1=1;start2=4;inc1=1;inc2=-1;char1='*';char2=' ';
			} else if (select.equals("2")) {
				start1=4;start2=1;inc1=-1;inc2=1;char1=' ';char2='*';
			} else if (select.equals("3")) {
				start1=0;start2=5;inc1=1;inc2=-1;char1=' ';char2='*';
			} else {
				start1=5;start2=0;inc1=-1;inc2=1;char1='*';char2=' ';
			}
			for (int i = 0; i < 5; i++,start1+=inc1,start2+=inc2) {
				for (int j=0; j<start1; j++)
					System.out.print(char1);
				for (int j=0; j<start2; j++)
					System.out.print(char2);
				System.out.println();
			}
			System.out.println("계속하시겠습니까?(y/n)");
		} while(scanner.nextLine().equals("y"));
	}
}
