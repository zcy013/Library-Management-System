
package information;

import java.util.Scanner;

public class Refer {

	Scanner in = new Scanner(System.in);

	public void refer() {
		System.out.print("请输入查询编号（1.输入关键字，查询可借阅图书    2.查询已借图书信息   3.返回上一级   4.返回主界面）：");
		int number = in.nextInt();
		while (number < 1 || number > 4) {
			System.out.print("编号错误。请重新输入编号：");
			number = in.nextInt();
		}
		if (number == 1) {// 查询可借阅
			searchBook(getKeyword());

		}
		if (number == 2) {// 查询已借
			borrowedBooks();

		}
		if (number == 3) {// 返回上一级
			Readers R = new Readers();
			R.ReadersFunction();
		}
		if (number == 4) {// 返回主界面
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}

		in.close();
	}

	public String getKeyword() {// 5.1.1-1 获取关键字
		System.out.println("输入关键字：");
		String keyword = in.next();
		return keyword;
	}

	public void searchBook(String kw) {// 5.1.1-2 搜书
		int n = 0;// 含关键字的书的数量
		System.out.println("正在搜索...请稍后");
		for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {// 遍历书名数组

			if (BooksInLibrary.BookName.get(i).contains(kw)) {// 判断是否某书名字符串是否含有该关键字字符串
				System.out.printf("\n图书编号·：%s\t书名： %s\t书架编号： %s\t数量： %s\n", BooksInLibrary.BookCode.get(i),
						BooksInLibrary.BookName.get(i), BooksInLibrary.BookShelf.get(i), BooksInLibrary.Amount.get(i));
				n++;
			}
		}

		if (n == 0) {
			System.out.println("哎呀...未搜索到相关书名TUT");
			System.out.print("请输入功能编号（1.重试 2.继续查询 3.返回上一层  4.返回主界面）：");
		} else {
			System.out.println("已显示所有相关图书");
			System.out.print("请输入功能编号（1.借书 2.继续查询 3.返回上一层  4.返回主界面）：");
		}

		int z = in.nextInt();
		while (z < 1 || z > 4) {
			System.out.print("编号无效！请重新输入：");
			z = in.nextInt();
		}

		if (z == 1) {
			if (n == 0) {// 重新遍历书名数组
				searchBook(kw);
			}
			if (n != 0) {// 借书

				BorrowBooks BB = new BorrowBooks();

				BB.borrownew(1);

			}

		}

		if (z == 2) {// 输入新的关键字进行查询
			searchBook(getKeyword());
		}

		if (z == 3) {// 返回上一层
			refer();
		}
		if (z == 4) {// 返回主界面
			InitialInterface II = new InitialInterface();
			II.Initial();
		}
	}

	public void borrowedBooks() {// 5.1.2 查询已借图书信息
		if (BorrowBooks.BookCardCode.size() == 0) {
			System.out.println("并没有已借图书！");
		} else {
			for (int i = 0; i < BorrowBooks.BookCardCode.size(); i++) {
				String a = "————————————————————————————————————————————————————————————————————————————————————————————";
				System.out.printf("%-15s        %-15s                  %-15s                %-15s         %-15s\n%s\n", "借书卡号", "书名",
						"数量","借书日期", "还书日期", a);

				System.out.printf("%-15d%-15s%-15s%-15s%-15s\n%s\n",
						BorrowBooks.BookCardCode.get(i),BorrowBooks.BookName.get(i), BorrowBooks.BorrowNumber.get(i), 
						DateFormat.toString(BorrowBooks.BorrowDate.get(i)), DateFormat.toString(BorrowBooks.ReturnDate.get(i)),a);
			}
		}
		System.out.print("请输入功能编号（1.返回上一层  2.返回主界面）：");

		int z = in.nextInt();
		while (z < 1 || z > 2) {
			System.out.print("编号无效！请重新输入：");
			z = in.nextInt();
		}

		if (z == 1) {// 返回上一层
			refer();
		}

		if (z == 2) {// 返回主界面
			InitialInterface II = new InitialInterface();
			II.Initial();
		}

	}

}
