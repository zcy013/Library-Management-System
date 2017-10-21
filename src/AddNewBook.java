package information;

import java.util.Date;
import java.util.Scanner;

public class AddNewBook {// 新书入馆。手动输入图书编号，书名，单价，数量和书架编号，取有效的录入数组，打印入馆时间

	public static Date createDate;// 入馆时间

	public void addNewBook() {
		Scanner in = new Scanner(System.in);
		int z = 0;// 功能编号
		int newCode;
		String newName;

		do {
			System.out.println("输入图书编号：");
			newCode = in.nextInt();
			if (BooksInLibrary.BookCode.contains(newCode)) {
				System.out.println("与现有图书编号重复！");
				System.out.println("请输入功能编号（1.重新输入 2.取消并返回上一级）：");
				z = in.nextInt();
				while (z < 1 || z > 2) {
					System.out.print("编号无效！请重新输入：");
					z = in.nextInt();
				}
				if (z == 2) {
					BooksManagement BM = new BooksManagement();
					BM.ManageBooks();
				}
			} else
				break;
		} while (z == 1);
		do {
			System.out.println("输入书名：");
			newName = in.next();
			if (BooksInLibrary.BookName.contains(newName)) {
				System.out.println("与现有书名重复！");
				System.out.println("请输入功能编号（1.重新输入 2.确认并继续 3.取消并返回上一级）：");
				z = in.nextInt();
				while (z < 1 || z > 3) {
					System.out.print("编号无效！请重新输入：");
					z = in.nextInt();
				}
				if (z == 2)
					break;
				else if (z == 3) {
					BooksManagement BM = new BooksManagement();
					BM.ManageBooks();
				}
			} else
				break;
		} while (z == 1);
		System.out.println("输入单价：");
		double newPrice = Math.round(in.nextDouble() * 100) / 100.0;
		System.out.println("输入数量：");
		int newAmount = in.nextInt();
		System.out.println("输入书架编号：");
		String Bookshelf = in.next();

		System.out.printf("图书编号：%d  书名：%s  单价：%.2f  数量：%d  书架编号：%s\n", newCode, newName, newPrice, newAmount,
				Bookshelf);
		System.out.print("请输入功能编号（1.确认 2.修改 3.取消并返回上一级）：");
		z = in.nextInt();
		while (z < 1 || z > 3) {
			System.out.print("编号无效！请重新输入：");
			z = in.nextInt();
		}
		if (z == 1) {

			BooksInLibrary.BookCode.add(newCode);
			BooksInLibrary.BookName.add(newName);
			BooksInLibrary.UnitPrice.add(newPrice);
			BooksInLibrary.Amount.add(newAmount);
			BooksInLibrary.BookShelf.add(Bookshelf);
			createDate = new Date();
			BooksInLibrary.CreateDate.add(createDate);
			BooksInLibrary.InLibrary.add(true);
			System.out.println("录入成功！");
			BooksManagement book1 = new BooksManagement();
			book1.ManageBooks();

		}

		else if (z == 2) {
			addNewBook();
		}

		else if (z == 3) {
			BooksManagement book2 = new BooksManagement();
			book2.ManageBooks();
		}
		in.close();
	}

}
