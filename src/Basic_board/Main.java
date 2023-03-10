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

	static List<Article> articles = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		System.out.println("==프로그램 시작==");
		
		makeTestData();
		
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
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
				System.out.println("   번호   /   제목   /     조회");
				String tempTitle = null;
				for(int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					if(article.title.length() > 4) {
						tempTitle = article.title.substring(0, 4);
						System.out.printf("%5d   /  %4s  /  %5d\n", 
								article.id, 
								tempTitle + "...", 
								article.hit);
						continue;
					}
					System.out.printf("%5d   /  %4s  /  %5d\n", 
							article.id, 
							article.title,
							article.hit);
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
				
				int id = articles.size() + 1;
				System.out.printf("제목 : ");
				title = sc.nextLine();
				System.out.printf("내용 : ");
				content = sc.nextLine();
				
				
				Article article = new Article(id, title, content, regDate, regDate);
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
				foundArticle.increasHit();
				System.out.printf(id + "번 글은 존재합니다.\n");
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("작성날짜 : %s\n", foundArticle.regDate);
				System.out.printf("수정날짜 : %s\n", foundArticle.updateregDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.content);
				System.out.printf("조회 : %d\n", foundArticle.hit);
			}
			else if(command.startsWith("article delete ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				
				/*
				Article article_id = new Article();
				articles.remove(article_id.id);
				remove(Object o); -> 개체를 활용한 제거
				*/
				
				
				int foundIndex = -1;
				
				for(int i = 0; i < articles.size(); i++) {
					
					Article article = articles.get(i);
					if( article.id == id) {
						foundIndex = i;
						break;
					}
				}
				
				if(foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물이 삭제 되었습니다.\n", id);
			}
			
			
			else if(command.startsWith("article modify ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				
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

				System.out.printf("제목 :");
				String title = sc.nextLine();
				System.out.printf("내용 :");
				String content = sc.nextLine();
				
				foundArticle.title = title;
				foundArticle.content = content;
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date date = new Date(); //System.currentTimeMillis()
				foundArticle.updateregDate = formatter.format(date);
				System.out.printf("%d번 글이 수정되었습니다.\n", id);
				
				
//				System.out.printf("제목 : ");
//				articles.get(foundIndex).title = sc.nextLine();
//				System.out.printf("내용 : ");
//				articles.get(foundIndex).content = sc.nextLine();
//				System.out.printf("%d번 글이 수정되었습니다.\n", id);
				
			}
			
			
			
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}

		}
		
		System.out.println("==프로그램 끝==");
		
		sc.close();
	}

	static void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다.");
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(); //System.currentTimeMillis()
		String regDate = formatter.format(date);
		
		articles.add(new Article(1,"제목1", "내용1", regDate, regDate,11));
		articles.add(new Article(2,"제목3", "내용2", regDate, regDate,22));
		articles.add(new Article(3,"제목3", "내용3", regDate, regDate,33));
		
		
	}

}


class Article{
	int id;
	String title, content,regDate;
	String updateregDate = "";
	int hit;
	
	Article(int id, String title, String content, String regDate, String updateregDate, int hit){
		this.id = id;
		this.title = title;
		this.content =content;
		this.regDate = regDate;
		this.updateregDate = updateregDate;
		this.hit = hit;
	
	}
	
	
	Article(int id, String title, String content, String regDate, String updateregDate) {
		this(id, title, content, regDate, updateregDate, 0);
	}
	
	void increasHit() {
		hit++;
	}
}

