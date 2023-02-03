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
		System.out.println("==프로그램 시작==");
		
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		
		List<Article> articles = new ArrayList<>();
		
		while(true) {
			
			
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();
			
			if(command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if(command.equals("system exit")) {
				break;
			}
			
			if(command.equals("article list")) {
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("번호  /  제목");
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
				//현재 날짜 시간 String
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date date = new Date(); //System.currentTimeMillis()
				String regDate = formatter.format(date);
				// 따로 class를 만들어서 static 메서드로써 가져와서 사용 할 수 있다. -> 클래스 이름.메소드이름();
				// /** ~*/를 하면 설명을 적을수 있다.
				int id = lastArticleId + 1;
				System.out.printf("제목 : ");
				title = sc.nextLine();
				System.out.printf("내용 : ");
				content = sc.nextLine();
				
				
				Article article = new Article(id,title,content,regDate);
				articles.add(article);
				
				
				System.out.printf("%d번글이 생성되었습니다.\n", id);
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
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				System.out.printf(id + "번 글은 존재합니다.");
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : %s\n", foundArticle.regDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.content);

			}

			
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}

		}
		
		System.out.println("==프로그램 끝==");
		
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


