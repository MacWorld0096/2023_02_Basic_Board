package Basic_board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("==���α׷� ����==");
		
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		
		List<Article> articles = new ArrayList<>();
		
		while(true) {
			
			
			System.out.printf("��ɾ� ) ");
			String command = sc.nextLine().trim();
			
			if(command.length() == 0) {
				System.out.println("��ɾ �Է����ּ���");
				continue;
			}
			
			if(command.equals("system exit")) {
				break;
			}
			
			if(command.equals("article list")) {
				if(articles.size() == 0) {
					System.out.println("�Խñ��� �����ϴ�.");
					continue;
				}
				System.out.println("��ȣ  /  ����");
				String tempTitle = null;
				for(int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					if(article.title.length() > 4) {
						tempTitle = article.title.substring(0, 4);
						System.out.printf("%d   /  %s\n", 
								article.id, 
								tempTitle + "..." );
						continue;
					}
					System.out.printf("%d   /  %s\n", 
							article.id, 
							article.title );
				}
			}
			
			else if(command.equals("article write")) {
				
				String title, content;
				int id = lastArticleId + 1;
				System.out.printf("���� : ");
				title = sc.nextLine();
				System.out.printf("���� : ");
				content = sc.nextLine();
				
				Article article = new Article(id,title,content);
				articles.add(article);
				
				
				System.out.printf("%d������ �����Ǿ����ϴ�.\n", id);
				lastArticleId++;
			}
			else {
				System.out.println("�������� �ʴ� ��ɾ� �Դϴ�.");
			}

		}
		
		System.out.println("==���α׷� ��==");
		
		sc.close();
	}

}


class Article{
	int id;
	String title, content;
	Article(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content =content;
	}
	
}


