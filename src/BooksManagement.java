package information;

import java.util.Scanner;

public class BooksManagement {// 图书信息管理
	Scanner input = new Scanner(System.in);

	public void ManageBooks() {

		System.out.print("请输入图书信息管理编号（1.新书入馆    2.编辑图书信息   3.显示在馆图书   4.返回主界面）：");
		int number = input.nextInt();

		while (number < 1 || number > 4) {
			System.out.print("编号错误。请重新输入功能编号：");
			number = input.nextInt();
		}
		if (number == 1) {// 进入新书入馆
			AddNewBook ANB = new AddNewBook();
			ANB.addNewBook();
		}
		if (number == 2) {// 进入图书信息编辑
			BooksEditor BE = new BooksEditor();
			BE.editor();
			ManageBooks();
		}
		if (number == 3) {// 显示在馆图书
			BooksInLibrary BIL = new BooksInLibrary();
			BIL.display();
			ManageBooks();
		}

		if (number == 4) {// 返回主界面
			InitialInterface face1 = new InitialInterface();
			face1.Initial();

		}
		input.close();
	}

}
