package information;

import java.util.Scanner;

public class Readers {
	
	public void ReadersFunction() {//读者功能
		System.out.print("请键入所需要求对应编号（1.查询   2.管理借还图书  3.返回主界面）：");
		int number;
		Scanner input = new Scanner(System.in);
		number = input.nextInt();

		while (number != 1 && number != 2 && number != 3) {
			System.out.print("编号错误。请重新输入功能编号：");
			number = input.nextInt();
		}
		if (number == 1) {// 进入图书查询
			Refer re = new Refer();

			re.refer();
		}
		if (number == 2) {// 进入借还图书管理
			BorrowAndReturn bAr = new BorrowAndReturn();
			bAr.borrowAndreturn();

		}
		if (number == 3) {
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}

		input.close();
	}
}