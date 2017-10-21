package information;

import java.util.Scanner;

public class ReadersManagement {// 读者信息管理 1)录入新读者，增加新读者信息 2)所有读者信息列表显示

	public void readersManagement() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入读者信息管理编号（ 1.录入新读者，增加新读者信息   2.所有读者信息列表显示  3.返回上一级   4.返回主界面）：");
		int number = input.nextInt();
		while (number < 1 || number > 4) {
			System.out.print("编号错误。请重新输入功能编号：");
			number = input.nextInt();
		}
		if (number == 1) {// 增加
			AddNewReader ANR = new AddNewReader();
			ANR.addNewReader();
		}
		if (number == 2) {// 显示
			ReadersRecord R = new ReadersRecord();
			R.display();

		}
		if (number == 3) {// 返回上一级
			Administrator A = new Administrator();
			A.AdministratorFunction();
		}
		if (number == 4) {// 返回主界面
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}
		input.close();

	}
}
