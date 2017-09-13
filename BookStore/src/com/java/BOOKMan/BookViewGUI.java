package com.java.BOOKMan;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 * ʹ�öԻ���������ͼ��������
 * @author wf
 * 2017��9��1��
 */
public class BookViewGUI extends AbstractBookViews{
	private BookBiz bookBiz = null;
	
	public BookViewGUI() {
		 bookBiz = new BookBiz();
		
		 showMainView(); 
	}

	@Override
	public String showMainView() {
		
		
		JOptionPane.showMessageDialog(null,"��ӭ����x9��ͼ�����ϵͳ","��ӭ����", 0, new ImageIcon("images/ͼ��.jpg"));
//		System.out.println("\nx9��ͼ�����ϵͳ>>���˵�");
//		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯͼ��\t5�����\t6������\t7���˳�\t\t");
//		System.out.println("��ѡ��");
		String strMenu = "\nx9��ͼ�����ϵͳ>>���˵�\n";
		strMenu += "1������ͼ��\n2��ɾ��ͼ��\n3���鿴����ͼ��\n4������Ų�ѯͼ��\n5�����\n6������\n7���˳�\n\n";
		strMenu += "��ѡ��";
		String result  = (String) JOptionPane.showInputDialog(null,strMenu,"���˵�", 0,new ImageIcon("images/ͼ��.jpg"), new String[]{"1","2","3","4","5","6","7"}, 7);//��ʾ����Ի���
		//if(result == null) result = "7";
		
//		if(result == "1"){
//			 showAddBookView() ;
//		}else if(result == "2"){
//			showDelBookView() ;
//		}else if(result == "3"){
//			showBooks(null);
//		}else if(result == "4"){
//			showFindById();
//		}else if(result == "5"){
//			showInStore() ;
//		}else if(result == "6"){
//			showOutStore() ;
//		}
		
		return result;
		}
		
			
		
	

	@Override
	public void showDelBookView() {
//		System.out.println("\nx9��ͼ�����ϵͳ>>ɾ��ͼ��");
//		//ʵ�ָ���IDɾ��
//		System.out.println("������Ҫɾ����ͼ���ţ�");
//		String delId = input.next();
//		Book delBook = new Book();
//		delBook.setBookId(delId);
//		if(bookBiz.delBook(delBook)){
//			System.out.println("ɾ���ɹ�~~");
//			showBooks(null);
//		}else{
//			System.out.println("ɾ��ʧ��~~");
//		}
		
		Book delBook = new Book();
		String bookId = null;
		JOptionPane.showMessageDialog(null,"\nx9��ͼ�����ϵͳ>>ɾ��ͼ��");
		bookId = JOptionPane.showInputDialog("������Ҫɾ����ͼ���ţ�");
		delBook.setBookId(bookId);
		if(bookBiz.delBook(delBook)){
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�~~");
			showBooks(null);
		}else{
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��~~");
		}
	}

	@Override
	public Book showAddBookView() {
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count  = -1;
		bookId = JOptionPane.showInputDialog("������ͼ���ţ�");
		bookName = JOptionPane.showInputDialog("ͼ������");
		count = Integer.parseInt(JOptionPane.showInputDialog("�����:"));
		
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		if(bookBiz.addBook(newBook)){
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
		}else{
			JOptionPane.showMessageDialog(null, "���ʧ��");
		}
		showBooks(newBook);
		return newBook;
	}

	@Override
	public void showOutStore() {
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
		JOptionPane.showMessageDialog(null,"\nx9��ͼ�����ϵͳ>>ͼ�����");
		String bookId = JOptionPane.showInputDialog("�����ͼ���ţ�");
		int bookCount = Integer.parseInt(JOptionPane.showInputDialog("�����������"));
		if(bookBiz.outStore(bookId, bookCount)){
			JOptionPane.showMessageDialog(null,"����ɹ���");
			showBooks(null);
		}else{
			JOptionPane.showMessageDialog(null,"����ʧ�ܣ����������ͼ���Ż���������Ƿ��ޣ�");
		}
	}

	@Override
	public void showInStore() {
//		//�����Ҫ����������ͼ��id����������
//		System.out.println("\nX9ͼ�����ϵͳ >> ͼ�����");
//		System.out.print("����ͼ���ţ�");
//		String bookId = input.next();
//		System.out.print("����������");
//		int bookCount = input.nextInt();
//		if(bookBiz.inStore(bookId, bookCount)){
//			System.out.println("���ɹ���");
//			showBooks(null);
//		}else{
//			System.out.println("���ʧ�ܣ����������ͼ���ţ�");
//		}
		JOptionPane.showMessageDialog(null,"\nx9��ͼ�����ϵͳ>>ͼ�����");
		String bookId = JOptionPane.showInputDialog("����ͼ���ţ�");
		int bookCount = Integer.parseInt(JOptionPane.showInputDialog("����������"));
		if(bookBiz.inStore(bookId, bookCount)){
			JOptionPane.showMessageDialog(null,"���ɹ���");
			showBooks(null);
		}else{
			JOptionPane.showMessageDialog(null,"���ʧ�ܣ����������ͼ���ţ�");
		}
	}

	@Override
	public void showFindById() {
//		System.out.println("\nX9ͼ�����ϵͳ >> ����Ų�ѯ");
//		System.out.println("������Ҫ��ѯ��ͼ���ţ�");
//		String bookId = input.next();	
//		Book book = bookBiz.findById(bookId);
//		if(book == null){
//			System.out.println("û���ҵ��κε�ͼ����Ϣ��");
//			return;
//		}
//		showBooks(book);
		JOptionPane.showMessageDialog(null,"\nX9ͼ�����ϵͳ >> ����Ų�ѯ");
		String bookId = JOptionPane.showInputDialog("������Ҫ��ѯ��ͼ���ţ�");
		Book book = bookBiz.findById(bookId);
		if(book == null){
			JOptionPane.showMessageDialog(null,"û���ҵ��κε�ͼ����Ϣ��");
			return;
		}else{
		showBooks(book);
		}
	}

	@Override
	public void showBooks(Book... bookArray) {
//		System.out.println("�ڲ����\t����\t\t���");
//		if(bookArray == null){
//			bookArray = Datas.bookStor;
//		}
//		int bookCount = bookBiz.getBookCount(bookArray);
//		for(int i = 0;i < bookCount;i++){
//			System.out.printf("%s\t%s\t%s\n",bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
//		}
//	}		
		//JOptionPane.showMessageDialog(null,"�ڲ����\t����\t\t���");
		if(bookArray == null){
			bookArray = Datas.bookStor;
			//JOptionPane.showMessageDialog(null, bookArray.toString(), "ȫ��ͼ��", 0, new ImageIcon("images/ͼ��.jpg"));
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		String str = "�ڲ����\t����\t\t���\n";
		for(int i = 0;i < bookCount;i++){
			str  += String.format("%s %s  %s\n",bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
			
		}
		JOptionPane.showMessageDialog(null, str, "ȫ��ͼ��", 0, new ImageIcon("images/ͼ��.jpg"));
	}

	
}
