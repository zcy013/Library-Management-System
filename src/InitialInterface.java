package information;

import java.util.Scanner;

public class InitialInterface {//主界面
	public void Initial() {
		int number;

		System.out.print("请输入系统功能编号（1.管理员登陆    2.读者登陆  ）：");
		Scanner input = new Scanner(System.in);
		number = input.nextInt();
		while (number < 1 || number > 2) {
			System.out.print("编号错误。请重新输入功能编号：");
			number = input.nextInt();
		}

		if (number == 1) {// 管理员登陆
			AdministratorLogin login1 = new AdministratorLogin();
			login1.Login();
		}
		if (number == 2) {// 读者登陆
			ReaderLogin login2 = new ReaderLogin();
			login2.login();
		}
		
		input.close();
	}

}
