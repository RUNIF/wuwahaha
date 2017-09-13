package com.java.BOOKMan;

public class MainTest {

	public static void main(String[] args) {

		//new BookViews().showBooks(Datas.bookStor);
		// new BookViews();
		//AbstractBookViews bookView = new BookViewConsoleImpl();
//		AbstractBookViews bookView = new BookViewGUI();
//		bookView.doMainView();
		//System.out.println(Datas.bookStor.length);
		//FileUtil.SaveBooks(Datas.bookStor);
		
		//new BookViews()while(true){
		//new BookViewGUI() ;
		AbstractBookViews ab = new BookViewGUI();
		//AbstractBookViews ab = new BookViewConsoleImpl();
		ab.doMainView();
		
		
		//		Book newBook = new Book();
//		newBook.setBookId("12");
//		newBook.setBookName("ÌìÁú°Ë²¿");
//		
//		BookBiz bookBiz = new BookBiz();
//		bookBiz.addBook(newBook);
//
//		show();
//		bookBiz.delBook(newBook);
//		show();
//		new BookViews();
	}
//
//	public static void show(){
//		BookBiz bookBiz = new BookBiz();
//		if(bookBiz.getBookCount() == 0){
//			System.out.println("²Ö¿â¿Õ¿Õ");
//			return;
//		}
//		for(int i = 0;i<bookBiz.getBookCount();i++){
//			System.out.println(Datas.bookStor[i].getBookId() + "\t" + Datas.bookStor[i].getBookName());
//		}
//	}
}
