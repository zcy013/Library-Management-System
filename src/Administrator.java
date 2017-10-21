package information;

import java.util.Scanner;

public class Administrator {

	public void AdministratorFunction() {//图书管理员功能
		Scanner input = new Scanner(System.in);
		System.out.print("请输入图书管理员功能编号（1.读者信息管理    2.图书信息管理   3.返回主界面）：");
		int number = input.nextInt();
		while (number != 1 && number != 2 && number != 3) {
			System.out.print("编号错误。请重新输入功能编号：");
			number = input.nextInt();
		}
		if (number == 1) {// 进入读者信息管理
			ReadersManagement management1 = new ReadersManagement();
			management1.readersManagement();
		}
		if (number == 2) {// 进入图书信息管理
			BooksManagement management2 = new BooksManagement();
			management2.ManageBooks();

		}
		if (number == 3) {// 返回主界面
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}
		input.close();
	}
}