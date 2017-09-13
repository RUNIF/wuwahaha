package com.java.BOOKMan;
/**
 * ͼ���ҵ����
 * ����ͼ���Լ�ͼ������Ļ�������
 * @author wf
 * 2017��8��26��
 */
public class BookBiz {
	//���¿�ʼ��д������ҵ�񷽷�
	//���ӡ����⡢��⡢��ѯ
	/**
	 * ���ͼ��ֿ��е�ͼ�����
	 * @param 
	 * @name getBookCount
	 * @return 
	 * @Description TODO
	 * @return
	 */
	public int getBookCount(){
		
		int count = 0;
		for(Book book:Datas.bookStor){
			if(book == null)break;
			count++;
		}
		return count;
		
	}
	public int getBookCount(Book ...books){
		int count = 0;
		for(Book book:Datas.bookStor){
			if(book == null)break;
			count++;
		}
		return count;
		
	}
	/**
	 * �������ͼ�������õ�ͼ��ֿ�
	 * @param 
	 * @name addBook
	 * @return �Ƿ���óɹ�
	 * @Description TODO
	 * @param book
	 */
	public boolean addBook(Book book){
		int bookCount = getBookCount();
		if(Datas.bookStor.length == bookCount){
			return false;
		}
		//����ֿⲻ�����ͽ������ͼ���������ڶ��������е����һ��λ��
		Datas.bookStor[bookCount] = book;
		return true;
	}
	/**
	 * ɾ�������ͼ�����
	 * @param 
	 * @name deBook
	 * @return 
	 * @Description TODO
	 * @param book
	 * @return
	 */
	public boolean delBook(Book book){
		int bookCount = getBookCount();
		int delIndex = -1;
		for(int i = 0; i < bookCount;i++){
			//if(book.getBookId().equals(Datas.bookStor[i].getBookId())){
			if(book.equals(Datas.bookStor[i])){
				delIndex = i;
						break;
			}
		}
		if(delIndex == -1){
			return false;
		}
		//ִ������ɾ��
		for(int i = delIndex;i < bookCount - 1;i++){
			Datas.bookStor[i] = Datas.bookStor[i + 1];
		}
		//�����һ��Ԫ����Ϊ��
		Datas.bookStor[bookCount - 1] = null;
		return true;
	}
	/**
	 * ͨ��ͼ��id���Ҷ�Ӧ��ͼ�����
	 * @param bookId
	 * @return û���ҵ�������null
	 */
	public Book findById(String bookId){
		int bookCount = getBookCount();
		for(int i = 0; i < bookCount; i++){
			if(bookId.equals(Datas.bookStor[i].getBookId())){
				return Datas.bookStor[i];
			}
		}
		return null;
	}
	/**
	 * ��⣬���ӿ��
	 * @param 
	 * @name inStore
	 * @return 
	 * @Description TODO
	 * @param bookId ���ID
	 * @param count ��������
	 * @return
	 */
	public boolean inStore(String bookId,int count){
		Book book = findById(bookId);
		if(null == book){//�������bookId������
			return false;
		}
		//���ӿ��
		book.setCount(book.getCount() + count);
		return true;
	}
	/**
	 * �������п�����
	 * @param 
	 * @name outStore
	 * @return 
	 * @Description TODO
	 * @param bookId
	 * @param count
	 * @return
	 */
	 public boolean outStore(String bookId,int count){
		 Book book = findById(bookId);
		 if(null == book){
			 return false;
		 }
		 if(book.getCount() < count){
			 return false;
		 }
		 book.setCount(book.getCount() - count);
		 return true;
	 }
}
