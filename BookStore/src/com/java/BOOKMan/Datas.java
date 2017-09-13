package com.java.BOOKMan;
/**
 * 模拟的数据仓库
 * @author wf
 * 2017年8月26日
 */
public class Datas {
	//用来保存所有图书信息的数组-可以理解成图书的仓库
		public static Book[] bookStor = new Book[999];
		//使用静态快为图书仓库数组添加书籍信息，以便测试
		static{
			Book book1 = new Book();
			book1.setBookId("1000");
			book1.setBookName("武林外传1");
			book1.setIsbn("100-101");
			book1.setCount(10);
			book1.setPrice(99.9);
			bookStor[0] = book1;
			
			Book book5 = new Book();
			book5.setBookId("1004");
			book5.setBookName("武林外传5");
			book5.setIsbn("100-105");
			book5.setCount(10);
			book5.setPrice(99.9);
			bookStor[4] = book5;
			
			Book book2 = new Book();
			book2.setBookId("1001");
			book2.setBookName("武林外传2");
			book2.setIsbn("100-102");
			book2.setCount(10);
			book2.setPrice(99.9);
			bookStor[1] = book2;
			
			Book book3 = new Book();
			book3.setBookId("1002");
			book3.setBookName("武林外传3");
			book3.setIsbn("100-103");
			book3.setCount(10);
			book3.setPrice(99.9);
			bookStor[2] = book3;
			
			Book book4 = new Book();
			book4.setBookId("1003");
			book4.setBookName("武林外传4");
			book4.setIsbn("100-103");
			book4.setCount(10);
			book4.setPrice(99.9);
			bookStor[3] = book4;
			
			//new BookViews().showBooks(bookStor);
		}
}
