package com.java.BOOKMan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文佳工具类，包含对文件的读写静态方法，方便实用
 * 
 * @author wf
 * 2017年9月1日
 */
public class FileUtil {
private static final String BookFile = "src/com/java/BOOKMan/BookInfo";
/**用来分割属性的分隔符，默认为“，”*/
private static final String SepAttr = ",";
/**默认行的分隔符*/
private static final String SepLine = System.getProperty("line.separator");

/**
 * 将传入的图书对象写入到文件中
 * @param 
 * @name SaveBooks
 * @return 
 * @Description TODO
 * @param bookArray
 */
	public static void SaveBooks(Book ...bookArray){
		if(bookArray == null || bookArray.length == 0) return;
		BookBiz bb = new BookBiz();
		File bookFile = new File(BookFile);
		if(!bookFile.exists())
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try(FileWriter fout = new FileWriter(bookFile,false);//不追加
					BufferedWriter out = new BufferedWriter(fout);){
				StringBuffer content = new StringBuffer();
				int bookCount = bb.getBookCount(bookArray);//获得图书数组中的图书对象个数
				for(int i = 0;i < bookCount; i++){
					content.append(bookArray[i].getBookId()); content.append(SepAttr);
					content.append(bookArray[i].getBookName()); content.append(SepAttr);
					content.append(bookArray[i].getCount()); content.append(SepLine);
				}
				//将字符串写入到文件
				out.write(content.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
//	if(bookArray == null || bookArray.length == 0) return;
//	BookBiz bookBiz = new BookBiz();
//	File bookFile = new File(BookFile);
//	if(!bookFile.exists())
//		try {
//			bookFile.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	try(FileWriter fout = new FileWriter(bookFile, false);//不追加，会覆盖当前文件
//		BufferedWriter out = new BufferedWriter(fout);	
//		){
//		StringBuffer content = new StringBuffer();
//		int bookCount = bookBiz.getBookCount(bookArray);//获得传入图书数组中的图书对象个数（不为null的）
//		for(int i = 0; i < bookCount; i++){//这里暂时实现的是简单的属性拼接
//			content.append(bookArray[i].getBookId());	content.append(SepAttr);
//			content.append(bookArray[i].getBookName());	content.append(SepAttr);
//			content.append(bookArray[i].getCount());	content.append(SepLine);//一行结束，就拼接行的分隔符
//		}
//		//将字符串写入到文件
//		out.write(content.toString());
	/**
	 * 从文件中读取内容，将内容拆解，重新整合成对象，对象数组并返回
	 * @param 
	 * @name loadBooks
	 * @return 
	 * @Description TODO
	 * @return
	 */
	public static Book[] loadBooks(){
		File bookFile = new File(BookFile);
		if(!bookFile.exists()){
			return null;
		}
		Book[] bookArray = new Book[999];
		try(FileReader freader = new FileReader(bookFile);
				BufferedReader reader = new BufferedReader(freader);
				){
			String line = null;
			int count = 0;
			while((line = reader.readLine()) != null){
				Book currBook = new Book();
				String[] attrs = line.split(SepAttr);//将读取出的一行以属性分隔符进行分割
				currBook.setBookId(attrs[0].trim());
				currBook.setBookName(attrs[1].trim());
				currBook.setCount(Integer.parseInt(attrs[2].trim()));
				
				bookArray[count] = currBook;
				count++;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookArray;
	}
}
