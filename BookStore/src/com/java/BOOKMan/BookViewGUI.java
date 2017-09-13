package com.java.BOOKMan;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 * 使用对话框升级的图书管理界面
 * @author wf
 * 2017年9月1日
 */
public class BookViewGUI extends AbstractBookViews{
	private BookBiz bookBiz = null;
	
	public BookViewGUI() {
		 bookBiz = new BookBiz();
		
		 showMainView(); 
	}

	@Override
	public String showMainView() {
		
		
		JOptionPane.showMessageDialog(null,"欢迎来到x9版图书管理系统","欢迎界面", 0, new ImageIcon("images/图书.jpg"));
//		System.out.println("\nx9版图书管理系统>>主菜单");
//		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询图书\t5、入库\t6、出库\t7、退出\t\t");
//		System.out.println("请选择：");
		String strMenu = "\nx9版图书管理系统>>主菜单\n";
		strMenu += "1、新增图书\n2、删除图书\n3、查看所有图书\n4、按编号查询图书\n5、入库\n6、出库\n7、退出\n\n";
		strMenu += "请选择：";
		String result  = (String) JOptionPane.showInputDialog(null,strMenu,"主菜单", 0,new ImageIcon("images/图书.jpg"), new String[]{"1","2","3","4","5","6","7"}, 7);//显示输入对话框
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
//		System.out.println("\nx9版图书管理系统>>删除图书");
//		//实现根据ID删除
//		System.out.println("请输入要删除的图书编号：");
//		String delId = input.next();
//		Book delBook = new Book();
//		delBook.setBookId(delId);
//		if(bookBiz.delBook(delBook)){
//			System.out.println("删除成功~~");
//			showBooks(null);
//		}else{
//			System.out.println("删除失败~~");
//		}
		
		Book delBook = new Book();
		String bookId = null;
		JOptionPane.showMessageDialog(null,"\nx9版图书管理系统>>删除图书");
		bookId = JOptionPane.showInputDialog("请输入要删除的图书编号：");
		delBook.setBookId(bookId);
		if(bookBiz.delBook(delBook)){
			JOptionPane.showMessageDialog(null, "删除成功~~");
			showBooks(null);
		}else{
			JOptionPane.showMessageDialog(null, "删除失败~~");
		}
	}

	@Override
	public Book showAddBookView() {
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count  = -1;
		bookId = JOptionPane.showInputDialog("请输入图书编号：");
		bookName = JOptionPane.showInputDialog("图书名称");
		count = Integer.parseInt(JOptionPane.showInputDialog("库存量:"));
		
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		if(bookBiz.addBook(newBook)){
			JOptionPane.showMessageDialog(null, "添加成功");
		}else{
			JOptionPane.showMessageDialog(null, "添加失败");
		}
		showBooks(newBook);
		return newBook;
	}

	@Override
	public void showOutStore() {
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
		JOptionPane.showMessageDialog(null,"\nx9版图书管理系统>>图书出库");
		String bookId = JOptionPane.showInputDialog("出库的图书编号：");
		int bookCount = Integer.parseInt(JOptionPane.showInputDialog("出库的数量："));
		if(bookBiz.outStore(bookId, bookCount)){
			JOptionPane.showMessageDialog(null,"出库成功！");
			showBooks(null);
		}else{
			JOptionPane.showMessageDialog(null,"出库失败，请检查输入的图书编号或出库数量是否超限！");
		}
	}

	@Override
	public void showInStore() {
//		//入库需要两个参数：图书id，入库的数量
//		System.out.println("\nX9图书管理系统 >> 图书入库");
//		System.out.print("入库的图书编号：");
//		String bookId = input.next();
//		System.out.print("入库的数量：");
//		int bookCount = input.nextInt();
//		if(bookBiz.inStore(bookId, bookCount)){
//			System.out.println("入库成功！");
//			showBooks(null);
//		}else{
//			System.out.println("入库失败，请检查输入的图书编号！");
//		}
		JOptionPane.showMessageDialog(null,"\nx9版图书管理系统>>图书入库");
		String bookId = JOptionPane.showInputDialog("入库的图书编号：");
		int bookCount = Integer.parseInt(JOptionPane.showInputDialog("入库的数量："));
		if(bookBiz.inStore(bookId, bookCount)){
			JOptionPane.showMessageDialog(null,"入库成功！");
			showBooks(null);
		}else{
			JOptionPane.showMessageDialog(null,"入库失败，请检查输入的图书编号！");
		}
	}

	@Override
	public void showFindById() {
//		System.out.println("\nX9图书管理系统 >> 按编号查询");
//		System.out.println("请输入要查询的图书编号：");
//		String bookId = input.next();	
//		Book book = bookBiz.findById(bookId);
//		if(book == null){
//			System.out.println("没有找到任何的图书信息！");
//			return;
//		}
//		showBooks(book);
		JOptionPane.showMessageDialog(null,"\nX9图书管理系统 >> 按编号查询");
		String bookId = JOptionPane.showInputDialog("请输入要查询的图书编号：");
		Book book = bookBiz.findById(bookId);
		if(book == null){
			JOptionPane.showMessageDialog(null,"没有找到任何的图书信息！");
			return;
		}else{
		showBooks(book);
		}
	}

	@Override
	public void showBooks(Book... bookArray) {
//		System.out.println("内部编号\t名称\t\t库存");
//		if(bookArray == null){
//			bookArray = Datas.bookStor;
//		}
//		int bookCount = bookBiz.getBookCount(bookArray);
//		for(int i = 0;i < bookCount;i++){
//			System.out.printf("%s\t%s\t%s\n",bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
//		}
//	}		
		//JOptionPane.showMessageDialog(null,"内部编号\t名称\t\t库存");
		if(bookArray == null){
			bookArray = Datas.bookStor;
			//JOptionPane.showMessageDialog(null, bookArray.toString(), "全部图书", 0, new ImageIcon("images/图书.jpg"));
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		String str = "内部编号\t名称\t\t库存\n";
		for(int i = 0;i < bookCount;i++){
			str  += String.format("%s %s  %s\n",bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
			
		}
		JOptionPane.showMessageDialog(null, str, "全部图书", 0, new ImageIcon("images/图书.jpg"));
	}

	
}
