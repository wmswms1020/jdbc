package com.javaex.ex02;

public class BookApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		//insert 등록하기
		
		bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22", "이문열");
		bookDao.bookInsert("삼국지", "민음사", "1998-03-01", "이문열");
		bookDao.bookInsert("토지", "마로니에북스", "1998-08-15", "박경리");
		bookDao.bookInsert("유시민의 글쓰기 특강", "생각의길", "2015-04-01", "유시민");
		bookDao.bookInsert("패션왕", "중앙북스(books)", "1998-02-22", "기안84");
		bookDao.bookInsert("순정만화", "재미주의", "1998-08-03", "강풀");
		bookDao.bookInsert("오직두사람", "문학동네", "1998-05-04", "김영하");
		bookDao.bookInsert("26년", "재미주의", "1998-02-04", "강풀");
		
		
		
		
		
	}

}
