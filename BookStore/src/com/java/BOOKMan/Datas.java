package com.java.BOOKMan;
/**
 * ģ������ݲֿ�
 * @author wf
 * 2017��8��26��
 */
public class Datas {
	//������������ͼ����Ϣ������-��������ͼ��Ĳֿ�
		public static Book[] bookStor = new Book[999];
		//ʹ�þ�̬��Ϊͼ��ֿ���������鼮��Ϣ���Ա����
		static{
			Book book1 = new Book();
			book1.setBookId("1000");
			book1.setBookName("�����⴫1");
			book1.setIsbn("100-101");
			book1.setCount(10);
			book1.setPrice(99.9);
			bookStor[0] = book1;
			
			Book book5 = new Book();
			book5.setBookId("1004");
			book5.setBookName("�����⴫5");
			book5.setIsbn("100-105");
			book5.setCount(10);
			book5.setPrice(99.9);
			bookStor[4] = book5;
			
			Book book2 = new Book();
			book2.setBookId("1001");
			book2.setBookName("�����⴫2");
			book2.setIsbn("100-102");
			book2.setCount(10);
			book2.setPrice(99.9);
			bookStor[1] = book2;
			
			Book book3 = new Book();
			book3.setBookId("1002");
			book3.setBookName("�����⴫3");
			book3.setIsbn("100-103");
			book3.setCount(10);
			book3.setPrice(99.9);
			bookStor[2] = book3;
			
			Book book4 = new Book();
			book4.setBookId("1003");
			book4.setBookName("�����⴫4");
			book4.setIsbn("100-103");
			book4.setCount(10);
			book4.setPrice(99.9);
			bookStor[3] = book4;
			
			//new BookViews().showBooks(bookStor);
		}
}
