package information;

import java.util.*;

public class ReturnBooks {//还书

	
	private Date DateNow;


	public void returnBook() {
		OverTime.allDebCheck();
		Scanner in = new Scanner(System.in);
		DateNow = new Date();
		System.out.print("请输入你想要还的书名：");
		String bookName = in.next();
		int ttp = bookNameCheck(bookName);//书的在馆数量

		if (ttp == 0) {

			System.out.print("书名错误 （1.重输 2.返回）:");
			int kk = in.nextInt();
			while (kk != 1 && kk != 2) {
				System.out.print("编号无效！请重新输入：");
				kk = in.nextInt();
			}
			if (kk == 1) {
				returnBook();
			}
			if (kk == 2) {
				BorrowAndReturn bar = new BorrowAndReturn();
				bar.borrowAndreturn();
			}
		}

		int n = 0;
		for (int i = 0; i < BorrowBooks.BookName.size(); i++) {
			if (BorrowBooks.BookName.get(i).contains(bookName) == true) {
				n = i;
				break;
			}
		}
	
		BooksInLibrary.Amount.set(getBookIndex(bookName), BooksInLibrary.Amount.get(getBookIndex(bookName))
				+ BorrowBooks.BorrowNumber.get(getBBookIndex(bookName)));
		BorrowBooks.BookCardCode.remove(n);
		BorrowBooks.BookName.remove(n);

		BorrowBooks.BorrowNumber.remove(n);

		BorrowBooks.Renew.remove(n);

		System.out.println("还书成功!");
		System.out.println("下面显示未归还图书：");
		if (BorrowBooks.BookCardCode.size() == 0) {
			System.out.println("并没有未归还图书！");
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
		System.out.print("是否继续还书（1.继续    2.返回上一层    3.返回主界面）:");

		int a = in.nextInt();
		while (a < 1 || a > 3) {
			System.out.print("编号错误。请重新输入编号：");
			a = in.nextInt();
		}
		if (a == 1) {// 继续还书
			returnBook();

		}
		if (a == 2) {// 返回上一层
			BorrowAndReturn BAR = new BorrowAndReturn();
			BAR.borrowAndreturn();

		}
		if (a == 3) {// 返回主界面
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}
		in.close();

	}

	public int bookNameCheck(String sp) {//检查书名是否在图书馆内

		for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {
			if (BooksInLibrary.BookName.get(i).equals(sp)) {
				return 1;
			}
		}
		return 0;
	}

	public int getBBookIndex(String kw) {//获得图书在借的图书中的索引
		int i = 0;
		for (String j : BorrowBooks.BookName) {

			i++;

			if (j.equals(kw)) {
				break;
			}

		}
		return i - 1;
	}

	public int getBookIndex(String kw) {//获得图书在图书馆中的索引
		int i = 0;
		for (String j : BooksInLibrary.BookName) {

			i++;

			if (j.equals(kw)) {
				break;
			}

		}
		return i - 1;
	}

	public Date getDateNow() {
		return DateNow;
	}

	public void setDateNow(Date dateNow) {
		DateNow = dateNow;
	}

}
