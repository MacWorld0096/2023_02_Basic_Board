package Basic_board;

import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("==���α׷� ����==");
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.printf("��ɾ� ) ");
			String command = sc.nextLine();
			
			if(command.length() == 0) {
				System.out.println("��ɾ �Է����ּ���");
				continue;
			}
			if(command.equals("system exit")) {
				break;
			}
			
			if(command.equals("article list")) {
				if(num == 0) {
					System.out.println("�Խñ��� �����ϴ�.");
				}
				else {
					System.out.printf("���� %d���� �Խù��� �ֽ��ϴ�.\n", num);
				}
			}
			else if(command.equals("article write")) {
				String title, content;
				System.out.printf("���� : ");
				title = sc.nextLine();
				System.out.printf("���� : ");
				content = sc.nextLine();
				num++;
				System.out.printf("%d������ �����Ǿ����ϴ�.\n", num);
			}
			else {
				System.out.println("�������� �ʴ� ��ɾ� �Դϴ�.");
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
