package com.java.BOOKMan;

import java.util.Scanner;

public  abstract class AbstractBookViews {
	//private Scanner input = null;
	

	public AbstractBookViews() {
		
		 
		
	}
/**
 * �����������涨�̶��ĳ����߼�
 * @param 
 * @name doMainView
 * @return 
 * @Description TODO
 */
	public void doMainView(){
//		System.out.println("\nx9��ͼ�����ϵͳ>>���˵�");
//		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯͼ��\t5�����\t6������\t7���˳�\t\t");
//		System.out.println("��ѡ��");
//		String choice = input.next();
		String result = showMainView();
		switch (result) {
		case "1"://���ͼ��
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
		doMainView();//�ٴ���ʾ��ҳ��
	
	}
	
	public abstract String showMainView() ;
		
	/**
	 * ɾ��ͼ�����
	 * @param 
	 * @name showDelBookView
	 * @return 
	 * @Description TODO
	 */
	public abstract void showDelBookView();
		
		
		
		
	
	
	
	public abstract Book showAddBookView();

	public abstract void showOutStore();
	
		public abstract void showInStore();
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
	public abstract void showFindById();
	/**
	 * ��ʾ���е�ͼ����Ϣ
	 * @param 
	 * @name showBooks
	 * @return 
	 * @Description TODO
	 * @param bookArray
	 */
	public abstract void showBooks(Book ...  bookArray);
		
}
