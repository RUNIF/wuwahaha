package com.java.BOOKMan;
/**
 * ͼ��ϵͳ����ͼ
 * @author wf
 * 2017��8��26��
 */

import java.util.Scanner;

public class BookViews {

	private Scanner input = null;
	private BookBiz bookBiz = null;

	public BookViews() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();

		System.out.println("***************************************");
		System.out.println("\t��ӭʹ��x9��ͼ�����ϵͳ");
		System.out.println("\t 1�� ��¼\t\t 2���˳�ϵͳ");
		System.out.println("***************************************");
		System.out.print("��ѡ��");
		String choice = input.next();
		if ("1".equals(choice)) {
			//
			showMainView();
			//}
		}
		System.out.println("x9��ͼ�����ϵͳ���˳�����ӭ�´�ʹ��");
	}

	public void showMainView() {
		System.out.println("\nx9��ͼ�����ϵͳ>>���˵�");
		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯͼ��\t5�����\t6������\t7���˳�\t\t");
		System.out.println("��ѡ��");
		String choice = input.next();
		switch (choice) {
		case "1"://���
			showAddBookView();
			showBooks(Datas.bookStor);
			break;

		case "2"://ɾ��ͼ��
			showDelBookView();
			break;
		case "3"://�鿴����ͼ��
			showBooks(null);
			break;
		case "4"://����Ų�ѯ
			showFindById();
			break;
		case "5"://���
			showInStore();
			break;
		case "6":
			showOutStore();
			break;
		case "7":
			//System.exit(0);//�˳�ϵͳ
			return;
		default:
			break;
		}
		//return true;
		showMainView();//�ٴ���ʾ������
	}
	/**
	 * ɾ��ͼ�����
	 * @param 
	 * @name showDelBookView
	 * @return 
	 * @Description TODO
	 */
	public void showDelBookView(){
		System.out.println("\nx9��ͼ�����ϵͳ>>ɾ��ͼ��");
		//ʵ�ָ���IDɾ��
		System.out.println("������Ҫɾ����ͼ���ţ�");
		String delId = input.next();
		Book delBook = new Book();
		delBook.setBookId(delId);
		if(bookBiz.delBook(delBook)){
			System.out.println("ɾ���ɹ�~~");
			showBooks(null);
		}else{
			System.out.println("ɾ��ʧ��~~");
		}
		
		
		
	}
	
	
	public Book showAddBookView(){
		System.out.println("\nx9��ͼ�����ϵͳ>>����ͼ��");
		System.out.println("�ڲ���ţ�");
		String bookId = input.next();
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.println("���ƣ�");
			newBook.setBookName(input.next());
			System.out.println("��棺");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);
		}else{
			System.out.println("ͼ���Ѵ��ڣ�������¼��");
			newBook = showAddBookView();
		}
		return newBook;
	}

	public void showOutStore(){
		System.out.println("\nX9ͼ�����ϵͳ >> ͼ�����");
		System.out.print("�����ͼ���ţ�");
		String bookId = input.next();
		System.out.print("�����������");
		int bookCount = input.nextInt();
		if(bookBiz.outStore(bookId, bookCount)){
			System.out.println("����ɹ���");
			showBooks(null);
		}else{
			System.out.println("����ʧ�ܣ����������ͼ���Ż���������Ƿ��ޣ�");
		}
//	}
	}
	
		public void showInStore(){
		//�����Ҫ����������ͼ��id����������
		System.out.println("\nX9ͼ�����ϵͳ >> ͼ�����");
		System.out.print("����ͼ���ţ�");
		String bookId = input.next();
		System.out.print("����������");
		int bookCount = input.nextInt();
		if(bookBiz.inStore(bookId, bookCount)){
			System.out.println("���ɹ���");
			showBooks(null);
		}else{
			System.out.println("���ʧ�ܣ����������ͼ���ţ�");
		}
	}
//	public void showOutStore(){
//		System.out.println("\nX9ͼ�����ϵͳ >> ͼ�����");
//		System.out.print("�����ͼ���ţ�");
//		String bookId = input.next();
//		System.out.print("�����������");
//		int bookCount = input.nextInt();
//		if(bookBiz.outStore(bookId, bookCount)){
//			System.out.println("����ɹ���");
//			showBooks(null);
//		}else{
//			System.out.println("����ʧ�ܣ����������ͼ���Ż���������Ƿ��ޣ�");
//		}
//	}
	public void showFindById(){
		System.out.println("\nX9ͼ�����ϵͳ >> ����Ų�ѯ");
		System.out.println("������Ҫ��ѯ��ͼ���ţ�");
		String bookId = input.next();	
		Book book = bookBiz.findById(bookId);
		if(book == null){
			System.out.println("û���ҵ��κε�ͼ����Ϣ��");
			return;
		}
		showBooks(book);
	}
	/**
	 * ��ʾ���е�ͼ����Ϣ
	 * @param 
	 * @name showBooks
	 * @return 
	 * @Description TODO
	 * @param bookArray
	 */
	public void showBooks(Book ...  bookArray){
		System.out.println("�ڲ����\t����\t���");
		if(bookArray == null){
			bookArray = Datas.bookStor;
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		for(int i = 0;i < bookCount;i++){
			System.out.printf("%s%s%s\n",bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
		}
	}
}
