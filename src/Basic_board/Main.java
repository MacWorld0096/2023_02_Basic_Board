package Basic_board;

import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine();
			
			if(command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			if(command.equals("system exit")) {
				break;
			}
			
			if(command.equals("article list")) {
				if(num == 0) {
					System.out.println("게시글이 없습니다.");
				}
				else {
					System.out.printf("현재 %d개의 게시물이 있습니다.\n", num);
				}
			}
			else if(command.equals("article write")) {
				String title, content;
				System.out.printf("제목 : ");
				title = sc.nextLine();
				System.out.printf("내용 : ");
				content = sc.nextLine();
				num++;
				System.out.printf("%d번글이 생성되었습니다.\n", num);
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
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
