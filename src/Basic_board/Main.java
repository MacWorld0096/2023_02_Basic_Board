package Basic_board;

import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine();
			
			if(command.equals("system exit")) {
				break;
			}
		}
		
		System.out.println("==프로그램 끝==");
		
		sc.close();
	}

}
/* 자바 문법
 * 자바로~~~만들기 
 * DB
 * DB + 자바로~~~만들기
 * Front (HTML, CSS, JS)
 * JSP를 활용한 ~~~ 만들기
 * DB + 자바 + JSP
 * Spring
 * 
 *  하나씩 가지고 프로젝트 만들고 하나하나 합치면서 크게 만들것
 */
