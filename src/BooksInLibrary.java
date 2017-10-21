package information;

import java.util.Date;
import java.util.ArrayList;

public class BooksInLibrary {// 显示在馆图书
	static ArrayList<Integer> BookCode = new ArrayList<Integer>();//图书编号
	static ArrayList<String> BookName = new ArrayList<String>();//书名
	static ArrayList<Double> UnitPrice = new ArrayList<Double>();//单价
	static ArrayList<Integer> Amount = new ArrayList<Integer>();//数量
	static ArrayList<String> BookShelf = new ArrayList<String>();//书架编号
	static ArrayList<Boolean> InLibrary = new ArrayList<Boolean>();//是否在馆
	static ArrayList<Date> CreateDate = new ArrayList<Date>();//入馆日期

	public void display() {

		for (int i = 0; i < Amount.size(); i++) {
			String a = "———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————";
			System.out.printf(
					"%-20s                %-20s                          %-20s                         %-20s                         %-20s                  %-20s\n%s\n",
					"图书编号", "书名", "单价", "数量", "是否在馆", "入馆日期", a);
			System.out.printf("%-20d%-20s%-20.2f%-20d%-20s%-20s\n%s\n", BookCode.get(i), BookName.get(i), 
					UnitPrice.get(i), Amount.get(i), BookCondition.toString(InLibrary.get(i)), DateFormat.toString(CreateDate.get(i)), a);

		}

	}
}
