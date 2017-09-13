package com.java.BOOKMan;

import java.util.Scanner;

public  abstract class AbstractBookViews {
	//private Scanner input = null;
	

	public AbstractBookViews() {
		
		 
		
	}
/**
 * 本方法用来规定固定的程序逻辑
 * @param 
 * @name doMainView
 * @return 
 * @Description TODO
 */
	public void doMainView(){
//		System.out.println("\nx9版图书管理系统>>主菜单");
//		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询图书\t5、入库\t6、出库\t7、退出\t\t");
//		System.out.println("请选择：");
//		String choice = input.next();
		String result = showMainView();
		switch (result) {
		case "1"://添加图书
			showAddBookView();
			showBooks(Datas.bookStor);
			break;
		case "2"://删除图书
			showDelBookView();
			break;
		case "3"://查看所有图书
			showBooks(null);
			break;
		case "4"://按编号查询
			showFindById();
			break;
		case "5"://入库
			showInStore();
			break;
		case "6":
			showOutStore();
			break;
		case "7":
			//System.exit(0);//退出系统
			return;
		default:
			break;
		}
		doMainView();//再次显示主页面
	
	}
	
	public abstract String showMainView() ;
		
	/**
	 * 删除图书界面
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
//		System.out.println("\nX9图书管理系统 >> 图书出库");
//		System.out.print("出库的图书编号：");
//		String bookId = input.next();
//		System.out.print("出库的数量：");
//		int bookCount = input.nextInt();
//		if(bookBiz.outStore(bookId, bookCount)){
//			System.out.println("出库成功！");
//			showBooks(null);
//		}else{
//			System.out.println("出库失败，请检查输入的图书编号或出库数量是否超限！");
//		}
//	}
	public abstract void showFindById();
	/**
	 * 显示所有的图书信息
	 * @param 
	 * @name showBooks
	 * @return 
	 * @Description TODO
	 * @param bookArray
	 */
	public abstract void showBooks(Book ...  bookArray);
		
}
