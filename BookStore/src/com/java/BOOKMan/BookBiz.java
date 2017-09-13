package com.java.BOOKMan;
/**
 * 图书的业务类
 * 包含图书以及图书数组的基本操作
 * @author wf
 * 2017年8月26日
 */
public class BookBiz {
	//以下开始书写基本的业务方法
	//增加、出库、入库、查询
	/**
	 * 获得图书仓库中的图书个数
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
	 * 将传入的图书对象放置到图书仓库
	 * @param 
	 * @name addBook
	 * @return 是否放置成功
	 * @Description TODO
	 * @param book
	 */
	public boolean addBook(Book book){
		int bookCount = getBookCount();
		if(Datas.bookStor.length == bookCount){
			return false;
		}
		//如果仓库不满，就将传入的图书对象放置在对象数组中的最后一个位置
		Datas.bookStor[bookCount] = book;
		return true;
	}
	/**
	 * 删除传入的图书对象
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
		//执行数组删除
		for(int i = delIndex;i < bookCount - 1;i++){
			Datas.bookStor[i] = Datas.bookStor[i + 1];
		}
		//将最后一个元素置为空
		Datas.bookStor[bookCount - 1] = null;
		return true;
	}
	/**
	 * 通过图书id查找对应的图书对象
	 * @param bookId
	 * @return 没有找到，返回null
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
	 * 入库，增加库存
	 * @param 
	 * @name inStore
	 * @return 
	 * @Description TODO
	 * @param bookId 入库ID
	 * @param count 入库的数量
	 * @return
	 */
	public boolean inStore(String bookId,int count){
		Book book = findById(bookId);
		if(null == book){//如果入库的bookId不存在
			return false;
		}
		//增加库存
		book.setCount(book.getCount() + count);
		return true;
	}
	/**
	 * 将现在有库存减少
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
