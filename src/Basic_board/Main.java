package Basic_board;

import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("==���α׷� ����==");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.printf("��ɾ� ) ");
			String command = sc.nextLine();
			
			if(command.equals("system exit")) {
				break;
			}
		}
		
		System.out.println("==���α׷� ��==");
		
		sc.close();
	}

}
/* �ڹ� ����
 * �ڹٷ�~~~����� 
 * DB
 * DB + �ڹٷ�~~~�����
 * Front (HTML, CSS, JS)
 * JSP�� Ȱ���� ~~~ �����
 * DB + �ڹ� + JSP
 * Spring
 * 
 *  �ϳ��� ������ ������Ʈ ����� �ϳ��ϳ� ��ġ�鼭 ũ�� �����
 */
