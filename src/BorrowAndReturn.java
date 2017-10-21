package information;

import java.util.Scanner;

public class BorrowAndReturn {//借还图书管理

	public void borrowAndreturn() {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入所需编号（1.借书  2.还书   3.返回上一界面  4.返回主界面）：");
		int number = input.nextInt();

		while (number < 1 || number > 4) {
			System.out.print("编号错误。请重新输入编号：");
			number = input.nextInt();
		}

		if (number == 1) {// 借书
			BorrowBooks borrow = new BorrowBooks();
			System.out.print("请输入所需编号（1.借新书   2.续借）：");
			int n = input.nextInt();
			while (n < 1 || n > 2) {
				System.out.print("编号错误。请重新输入编号：");
				n = input.nextInt();
			}

			if (n == 1) {// 借新书
				
				borrow.borrownew();
			}
			if (n == 2) {// 续借
				borrow.renewBooks();
			}

		}

		if (number == 2) {// 还书
			ReturnBooks return1 = new ReturnBooks();
			return1.returnBook();

		}

		if (number == 3) {// 返回上一界面
			Readers reader = new Readers();
			reader.ReadersFunction();
		}

		if (number == 4) {// 返回主界面
			InitialInterface initial = new InitialInterface();
			initial.Initial();

		}
		input.close();

	}
}
