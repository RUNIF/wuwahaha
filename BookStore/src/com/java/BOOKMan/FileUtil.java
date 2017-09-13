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
 * �ļѹ����࣬�������ļ��Ķ�д��̬����������ʵ��
 * 
 * @author wf
 * 2017��9��1��
 */
public class FileUtil {
private static final String BookFile = "src/com/java/BOOKMan/BookInfo";
/**�����ָ����Եķָ�����Ĭ��Ϊ������*/
private static final String SepAttr = ",";
/**Ĭ���еķָ���*/
private static final String SepLine = System.getProperty("line.separator");

/**
 * �������ͼ�����д�뵽�ļ���
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
			try(FileWriter fout = new FileWriter(bookFile,false);//��׷��
					BufferedWriter out = new BufferedWriter(fout);){
				StringBuffer content = new StringBuffer();
				int bookCount = bb.getBookCount(bookArray);//���ͼ�������е�ͼ��������
				for(int i = 0;i < bookCount; i++){
					content.append(bookArray[i].getBookId()); content.append(SepAttr);
					content.append(bookArray[i].getBookName()); content.append(SepAttr);
					content.append(bookArray[i].getCount()); content.append(SepLine);
				}
				//���ַ���д�뵽�ļ�
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
//	try(FileWriter fout = new FileWriter(bookFile, false);//��׷�ӣ��Ḳ�ǵ�ǰ�ļ�
//		BufferedWriter out = new BufferedWriter(fout);	
//		){
//		StringBuffer content = new StringBuffer();
//		int bookCount = bookBiz.getBookCount(bookArray);//��ô���ͼ�������е�ͼ������������Ϊnull�ģ�
//		for(int i = 0; i < bookCount; i++){//������ʱʵ�ֵ��Ǽ򵥵�����ƴ��
//			content.append(bookArray[i].getBookId());	content.append(SepAttr);
//			content.append(bookArray[i].getBookName());	content.append(SepAttr);
//			content.append(bookArray[i].getCount());	content.append(SepLine);//һ�н�������ƴ���еķָ���
//		}
//		//���ַ���д�뵽�ļ�
//		out.write(content.toString());
	/**
	 * ���ļ��ж�ȡ���ݣ������ݲ�⣬�������ϳɶ��󣬶������鲢����
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
				String[] attrs = line.split(SepAttr);//����ȡ����һ�������Էָ������зָ�
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
