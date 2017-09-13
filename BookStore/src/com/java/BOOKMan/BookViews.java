package com.java.BOOKMan;
/**
 * 图书系统的视图
 * @author wf
 * 2017年8月26日
 */

import java.util.Scanner;

public class BookViews {

	private Scanner input = null;
	private BookBiz bookBiz = null;

	public BookViews() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();

		System.out.println("***************************************");
		System.out.println("\t欢迎使用x9版图书管理系统");
		System.out.println("\t 1、 登录\t\t 2、退出系统");
		System.out.println("***************************************");
		System.out.print("请选择：");
		String choice = input.next();
		if ("1".equals(choice)) {
			//
			showMainView();
			//}
		}
		System.out.println("x9版图书管理系统已退出，欢迎下次使用");
	}

	public void showMainView() {
		System.out.println("\nx9版图书管理系统>>主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询图书\t5、入库\t6、出库\t7、退出\t\t");
		System.out.println("请选择：");
		String choice = input.next();
		switch (choice) {
		case "1"://添加
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
		//return true;
		showMainView();//再次显示主界面
	}
	/**
	 * 删除图书界面
	 * @param 
	 * @name showDelBookView
	 * @return 
	 * @Description TODO
	 */
	public void showDelBookView(){
		System.out.println("\nx9版图书管理系统>>删除图书");
		//实现根据ID删除
		System.out.println("请输入要删除的图书编号：");
		String delId = input.next();
		Book delBook = new Book();
		delBook.setBookId(delId);
		if(bookBiz.delBook(delBook)){
			System.out.println("删除成功~~");
			showBooks(null);
		}else{
			System.out.println("删除失败~~");
		}
		
		
		
	}
	
	
	public Book showAddBookView(){
		System.out.println("\nx9版图书管理系统>>新增图书");
		System.out.println("内部编号：");
		String bookId = input.next();
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.println("名称：");
			newBook.setBookName(input.next());
			System.out.println("库存：");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);
		}else{
			System.out.println("图书已存在，请重新录入");
			newBook = showAddBookView();
		}
		return newBook;
	}

	public void showOutStore(){
		System.out.println("\nX9图书管理系统 >> 图书出库");
		System.out.print("出库的图书编号：");
		String bookId = input.next();
		System.out.print("出库的数量：");
		int bookCount = input.nextInt();
		if(bookBiz.outStore(bookId, bookCount)){
			System.out.println("出库成功！");
			showBooks(null);
		}else{
			System.out.println("出库失败，请检查输入的图书编号或出库数量是否超限！");
		}
//	}
	}
	
		public void showInStore(){
		//入库需要两个参数：图书id，入库的数量
		System.out.println("\nX9图书管理系统 >> 图书入库");
		System.out.print("入库的图书编号：");
		String bookId = input.next();
		System.out.print("入库的数量：");
		int bookCount = input.nextInt();
		if(bookBiz.inStore(bookId, bookCount)){
			System.out.println("入库成功！");
			showBooks(null);
		}else{
			System.out.println("入库失败，请检查输入的图书编号！");
		}
	}
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
	public void showFindById(){
		System.out.println("\nX9图书管理系统 >> 按编号查询");
		System.out.println("请输入要查询的图书编号：");
		String bookId = input.next();	
		Book book = bookBiz.findById(bookId);
		if(book == null){
			System.out.println("没有找到任何的图书信息！");
			return;
		}
		showBooks(book);
	}
	/**
	 * 显示所有的图书信息
	 * @param 
	 * @name showBooks
	 * @return 
	 * @Description TODO
	 * @param bookArray
	 */
	public void showBooks(Book ...  bookArray){
		System.out.println("内部编号\t名称\t库存");
		if(bookArray == null){
			bookArray = Datas.bookStor;
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		for(int i = 0;i < bookCount;i++){
			System.out.printf("%s%s%s\n",bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
		}
	}
}
