package information;

import java.util.*;

public class BorrowBooks {// 借书
	static ArrayList<Integer> BookCardCode = new ArrayList<Integer>();// 借书卡号
	static ArrayList<Date> BorrowDate = new ArrayList<Date>();// 借书日期
	static ArrayList<Date> ReturnDate = new ArrayList<Date>();// 还书日期
	static ArrayList<Integer> BorrowNumber = new ArrayList<Integer>();// 借阅数量
	static ArrayList<String> BookName = new ArrayList<String>();// 书名
	static ArrayList<Integer> Renew = new ArrayList<Integer>();// 续借次数

	static Date borrowDate;
	private static String bookName;

	public int getBookIndex(String kw) {// 得到一本书在arraylist中的索引
		int i = 0;
		for (String j : BooksInLibrary.BookName) {

			i++;

			if (j.equals(kw)) {
				break;
			}

		}
		return i - 1;
	}

	public int bookNameCheck(String sp) {// 检查书名是否存在于图书馆内

		for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {
			if (BooksInLibrary.BookName.get(i).equals(sp)) {
				return 1;
			}
		}
		return 0;
	}

	public void reCheckNum2(String bookname1, int numberT) {// 比较想借阅的数量和在馆数（在查询中调用）
		Scanner input = new Scanner(System.in);
		if (numberT > BooksInLibrary.Amount.get(getBookIndex(bookName))) {
			System.out.printf("该图书在馆数量仅为%d本。请输入编号(1.重输  2.返回 3.上一层)：",
					BooksInLibrary.Amount.get(getBookIndex(bookname1)));

			int kk = input.nextInt();
			while (kk != 1 && kk != 2 && kk != 3) {
				System.out.print("编号错误。请重新输入编号：");
				kk = input.nextInt();
			}

			if (kk == 1) {
				System.out.print("请输入你想要借的数量：");
				int N2 = input.nextInt();

				reCheckNum(bookname1, N2);
			}

			if (kk == 2) {
				borrownew(1);
			}

			if (kk == 3) {
				Refer rr = new Refer();
				rr.refer();
			}
		} else {
			canBorrow(numberT);
		}

		input.close();
	}

	public void borrownew(int t) {// 借新书的方法（在查询中调用，为底下borrownew方法的重载）
		OverTime.allDebCheck();
		Scanner input = new Scanner(System.in);

		System.out.print("请输入你想要借的书名：");
		bookName = input.next();
		System.out.print("请输入你想要借的数量：");
		int number = input.nextInt();

		int n = 0;// n代表含有该关键字的图书数量

		for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {
			if (BooksInLibrary.BookName.get(i).equals(bookName)) {
				n = 1;
			}
		}

		if (n == 0) {
			System.out.print("您输入的图书不存在!请输入编号（1.重新输入  2.主界面 ）：");
			int n1 = input.nextInt();// n1为功能编号
			while (n1 < 1 || n1 > 3) {
				System.out.print("编号错误。请重新输入编号：");
				n1 = input.nextInt();
			}
			if (n1 == 1) {// 重新输入
				borrownew(1);

			}
			if (n1 == 2) {// 返回上一层
				Refer tt = new Refer();
				tt.refer();

			}

		}

		else {

			reCheckNum2(bookName, number);
		}

		input.close();
	}

	public void reCheckNum(String bookname1, int numberT) {// 比较想借阅的数量和在馆数（借书中使用）
		Scanner input = new Scanner(System.in);
		if (numberT > BooksInLibrary.Amount.get(getBookIndex(bookName))) {
			System.out.printf("该图书在馆数量仅为%d本。请输入编号(1.重输  2.返回 3.返回上一层)：",
					BooksInLibrary.Amount.get(getBookIndex(bookname1)));

			int kk = input.nextInt();
			while (kk != 1 && kk != 2 & kk != 3) {
				System.out.print("编号错误。请重新输入编号：");
				kk = input.nextInt();
			}

			if (kk == 1) {
				System.out.print("请输入你想要借的数量：");
				int N2 = input.nextInt();

				reCheckNum(bookname1, N2);
			}

			if (kk == 2) {
				borrownew();
			}

			if (kk == 3) {
				BorrowAndReturn bar = new BorrowAndReturn();
				bar.borrowAndreturn();
			}
		} else {
			canBorrow(numberT);
		}

		input.close();
	}

	public void borrownew() {// 借新书

		OverTime.allDebCheck();
		Scanner input = new Scanner(System.in);

		System.out.print("请输入你想要借的书名：");
		bookName = input.next();
		System.out.print("请输入你想要借的数量：");
		int number = input.nextInt();

		int n = 0;// n代表含有该关键字的图书

		for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {
			if (BooksInLibrary.BookName.get(i).equals(bookName)) {
				n = 1;
			}
		}

		if (n == 0) {
			System.out.print("您输入的图书不存在。是否按关键字查阅图书？（1.是  2.返回上一层  3.返回主界面）：");
			int n1 = input.nextInt();// n1为功能编号
			while (n1 < 1 || n1 > 3) {
				System.out.print("编号错误。请重新输入编号：");
				n1 = input.nextInt();
			}
			if (n1 == 1) {// 按关键字查阅
				Refer R = new Refer();
				R.searchBook(R.getKeyword());

			}
			if (n1 == 2) {// 返回上一层
				BorrowAndReturn BAR = new BorrowAndReturn();
				BAR.borrowAndreturn();

			}
			if (n1 == 3) {// 返回主界面
				InitialInterface face1 = new InitialInterface();
				face1.Initial();

			}
		}

		else {
			reCheckNum(bookName, number);

		}

		input.close();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookname) {
		bookName = bookname;
	}

	public void canBorrow(int number) {// 确定可以借书时候的方法

		ReaderLogin login1 = new ReaderLogin();
		login1.setCardNumber(ReaderLogin.cardNumber);
		BookCardCode.add(login1.getCardNumber());
		borrowDate = new Date();

		BorrowNumber.add(number);

		BooksInLibrary.Amount.set(getBookIndex(getBookName()),
				BooksInLibrary.Amount.get(getBookIndex(getBookName())) - number);
		if (BooksInLibrary.Amount.get(getBookIndex(getBookName())) == 0) {
			BooksInLibrary.InLibrary.set(getBookIndex(getBookName()), false);
		} else {
			BooksInLibrary.InLibrary.set(getBookIndex(getBookName()), true);
		}

		Renew.add(0);// 增加已续借次数
		BorrowDate.add(getBorrowdate());// 增加借书日期

		// 增加还书日期
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.MONTH, 1);
		ReturnDate.add(c1.getTime());

		BookName.add(getBookName());// 借书名

		System.out.println("借书成功！");

		System.out.print("是否继续借书？（1.继续    2.返回上一层    3.返回主界面）：");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while (n < 1 || n > 3) {
			System.out.print("编号错误。请重新输入编号：");
			n = input.nextInt();
		}
		if (n == 1) {// 继续借书
			borrownew();

		}
		if (n == 2) {// 返回上一层
			BorrowAndReturn BAR = new BorrowAndReturn();
			BAR.borrowAndreturn();

		}
		if (n == 3) {// 返回主界面
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}
		input.close();

	}

	public Date getBorrowdate() {
		return borrowDate;
	}

	public void setBorrowdate(Date borrowdate) {
		borrowDate = borrowdate;
	}

	// 续借
	public void renewBooks() {
		Scanner input = new Scanner(System.in);
		if (BorrowBooks.BookCardCode.size() == 0) {
			System.out.println("并没有已借图书！");
			BorrowAndReturn BAR = new BorrowAndReturn();
			BAR.borrowAndreturn();
		} else {

			System.out.print("请输入你想要续借的书名：");
			bookName = input.next();
			if (OverTime.overDay(bookName) > 0) {
				System.out.printf("您该本书欠款%s元。是否缴纳欠款（1.是   2.否并返回上一级）：", OverTime.overDay(bookName));
				int n1 = input.nextInt();
				while (n1 != 1 && n1 != 2) {
					System.out.print("编号错误。请重新输入编号：");
					n1 = input.nextInt();
				}
				if (n1 == 1) {
					System.out.println("还款成功！");
					int n = 0;
					for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {
						if (BooksInLibrary.BookName.get(i).contains(bookName) == true) {
							n = i;
							break;
						}
					}
					if (Renew.get(n) == 0) {// 只能续借一次

						// 续借后的还书日期，在续借时加一个月
						Calendar c2 = Calendar.getInstance();
						c2.add(Calendar.MONTH, 1);
						ReturnDate.set(BookName.indexOf(bookName), c2.getTime());

						System.out.println("续借成功！");
						Renew.set(n, Renew.get(n) + 1);

						System.out.print("是否继续续借（1.继续    2.返回上一层    3.返回主界面）：");

						int a = input.nextInt();
						while (a < 1 || a > 3) {
							System.out.print("编号错误。请重新输入编号：");
							a = input.nextInt();
						}
						if (a == 1) {// 继续借书
							renewBooks();

						}
						if (a == 2) {// 返回上一层
							BorrowAndReturn BAR = new BorrowAndReturn();
							BAR.borrowAndreturn();

						}
						if (a == 3) {// 返回主界面
							InitialInterface face1 = new InitialInterface();
							face1.Initial();

						}

					} else {
						System.out.println("续借次数已用光！");
						BorrowAndReturn bar = new BorrowAndReturn();
						bar.borrowAndreturn();

					}

				}
				if (n1 == 2) {
					BorrowAndReturn bAr = new BorrowAndReturn();
					bAr.borrowAndreturn();

				}

			} else {

				int n = 0;
				for (int i = 0; i < BooksInLibrary.BookName.size(); i++) {
					if (BooksInLibrary.BookName.get(i).contains(bookName) == true) {
						n = i;
						break;
					}
				}
				if (Renew.get(n) == 0) {// 只能续借一次

					// 续借后的还书日期，在续借时加一个月
					Calendar c2 = Calendar.getInstance();
					c2.add(Calendar.MONTH, 1);
					ReturnDate.set(BookName.indexOf(bookName), c2.getTime());

					System.out.println("续借成功！");
					Renew.set(n, Renew.get(n) + 1);

					System.out.print("是否继续续借（1.继续    2.返回上一层    3.返回主界面）：");

					int a = input.nextInt();
					while (a < 1 || a > 3) {
						System.out.print("编号错误。请重新输入编号：");
						a = input.nextInt();
					}
					if (a == 1) {// 继续借书
						renewBooks();

					}
					if (a == 2) {// 返回上一层
						BorrowAndReturn BAR = new BorrowAndReturn();
						BAR.borrowAndreturn();

					}
					if (a == 3) {// 返回主界面
						InitialInterface face1 = new InitialInterface();
						face1.Initial();

					}

				} else {
					System.out.println("续借次数已用光！");
					BorrowAndReturn bar = new BorrowAndReturn();
					bar.borrowAndreturn();
				}
			}

		}
		input.close();
	}
}