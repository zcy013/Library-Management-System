package information;

import java.util.Scanner;

public class BooksEditor {// 编辑图书信息
	private static int i;// 要修改的图书在数组中的索引

	public void editor() {
		Scanner input2 = new Scanner(System.in);
		System.out.println("请输入要修改的图书编号：（输入0取消并返回上一级）");
		int code = input2.nextInt();
		
		while (BooksInLibrary.BookCode.contains(code) == false && code != 0) {
			System.out.println("无此书，请重新输入");
			code = input2.nextInt();
		}
		if (code == 0) {
			BooksManagement BM = new BooksManagement();
			BM.ManageBooks();
		}
		i = BooksInLibrary.BookCode.indexOf(code);
		System.out.printf("图书编号：%d\t书名：%s\t单价：%.2f\t数量：%d\t书架编号：%s\t入馆日期：%s\t\n", BooksInLibrary.BookCode.get(i),
				BooksInLibrary.BookName.get(i), BooksInLibrary.UnitPrice.get(i), BooksInLibrary.Amount.get(i),
				BooksInLibrary.BookShelf.get(i), DateFormat.toString(BooksInLibrary.CreateDate.get(i)));

		int number;//一级功能编号
		int z;//二级功能编号
		int x = 0;//x=1时进入修改成功界面
		int y = 1;// y=1时继续修改此书信息
		
		while (y == 1) {
			System.out.println("请选择要修改的项目：1.图书编号 2.书名 3.单价 4.数量 5.书架编号 6.返回上一级 7.返回主界面");
			number = input2.nextInt();
			switch (number) {
			
			case 1:
				System.out.println("输入新图书编号：");
				int newCode = input2.nextInt();
				while (BooksInLibrary.BookCode.contains(newCode)) {
					System.out.println("与现有图书编号重复！");
					System.out.println("请输入功能编号（1.重新输入 2.取消并返回上一级）：");
					z = input2.nextInt();
					
					switch (z) {
					case 1:
						System.out.println("输入新图书编号：");
						newCode = input2.nextInt();
						break;
					case 2:
						BooksManagement BM = new BooksManagement();
						BM.ManageBooks();
						break;
					default:
						System.out.println("编号无效！请重新输入：");
						z = input2.nextInt();
						break;
					}
				}
				BooksInLibrary.BookCode.set(i, newCode);
				x = 1;
				break;
				
			case 2:
				System.out.println("输入新书名：");
				String newName = input2.next();
				while (BooksInLibrary.BookName.contains(newName)) {
					System.out.println("与现有书名重复！");
					System.out.println("请输入功能编号（1.重新输入 2.确认并继续 3.取消并返回上一级）：");
					z = input2.nextInt();
					
					switch (z) {
					case 1:
						System.out.println("输入新书名：");
						newName = input2.next();
						break;
					case 2:
						x = 1;
						break;
					case 3:
						BooksManagement BM = new BooksManagement();
						BM.ManageBooks();
						break;
					default:
						System.out.println("编号无效！请重新输入：");
						z = input2.nextInt();
						break;
					}
					if (x == 1)
						break;
				}
				BooksInLibrary.BookName.set(i, newName);
				x = 1;
				break;
				
			case 3:
				System.out.println("输入新单价：");
				double newPrice = Math.round(input2.nextDouble() * 100) / 100;
				BooksInLibrary.UnitPrice.set(i, newPrice);
				x = 1;
				break;
				
			case 4:
				System.out.println("输入新数量：");
				int newAmount = input2.nextInt();
				BooksInLibrary.Amount.set(i, newAmount);
				x = 1;
				break;
				
			case 5:
				System.out.println("输入新书架编号：");
				String newShelf = input2.next();
				BooksInLibrary.BookShelf.set(i, newShelf);
				x = 1;
				break;
				
			case 6:
				BooksManagement BM = new BooksManagement();
				BM.ManageBooks();
				break;
				
			case 7:
				InitialInterface II = new InitialInterface();
				II.Initial();
				break;
				
			default:
				System.out.println("编号无效！请重新输入：");
				number = input2.nextInt();
				break;
			}
			
			if (x == 1) {
				x = 0;
				System.out.println("修改成功！");
				System.out.println("请输入功能编号：1.继续修改此书信息 2.修改其他图书信息 3.返回上一级");
				y = input2.nextInt();
				
				switch (y) {
				case 1:
					break;
				case 2:
					editor();
					break;
				case 3:
					BooksManagement BM = new BooksManagement();
					BM.ManageBooks();
					break;
				default:
					System.out.println("编号无效！请重新输入：");
					y = input2.nextInt();
					break;
				}
			}
		}
		input2.close();
	}
}
