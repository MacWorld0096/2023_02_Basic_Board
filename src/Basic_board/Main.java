package Basic_board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				//���� ��¥ �ð� String
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date date = new Date(); //System.currentTimeMillis()
				String regDate = formatter.format(date);
				// ���� class�� ���� static �޼���ν� �����ͼ� ��� �� �� �ִ�. -> Ŭ���� �̸�.�޼ҵ��̸�();
				// /** ~*/�� �ϸ� ������ ������ �ִ�.
				int id = lastArticleId + 1;
				System.out.printf("���� : ");
				title = sc.nextLine();
				System.out.printf("���� : ");
				content = sc.nextLine();
				
				
				Article article = new Article(id,title,content,regDate);
				articles.add(article);
				
				
				System.out.printf("%d������ �����Ǿ����ϴ�.\n", id);
				lastArticleId++;
			}
		
			else if(command.startsWith("article detail ")) {
				
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				
//				boolean found = false;
				Article foundArticle = null;
				
				for(int i = 0; i < articles.size(); i++) {
					
					Article article = articles.get(i);
					if( article.id == id) {
//						found = true;
						foundArticle = article;
						break;
					}
				}
				
				if(foundArticle == null) {
					System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}
				System.out.printf(id + "�� ���� �����մϴ�.");
				System.out.printf("��ȣ : %d\n", foundArticle.id);
				System.out.printf("��¥ : %s\n", foundArticle.regDate);
				System.out.printf("���� : %s\n", foundArticle.title);
				System.out.printf("���� : %s\n", foundArticle.content);

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
	String title, content,regDate;
	Article(int id, String title, String content, String regDate) {
		this.id = id;
		this.title = title;
		this.content =content;
		this.regDate = regDate;
	}
	
}


