
package information;

import java.util.Arrays;
import java.util.Scanner;

public class AddNewReader {// 增加新读者
	public void addNewReader() {

		int i;
		Scanner input = new Scanner(System.in);

		do {
			int l = ReadersRecord.BookCardCode.length;// 原有读者的数量，方便后面的调用
			int nBCC[] = new int[l + 1];// 创建一个临时数组储存原有读者并预留一个位置给新读者，下同
			System.arraycopy(ReadersRecord.BookCardCode, 0, nBCC, 0, l);
			String nN[] = new String[l + 1];
			System.arraycopy(ReadersRecord.Name, 0, nN, 0, l);
			String nG[] = new String[l + 1];
			System.arraycopy(ReadersRecord.Gender, 0, nG, 0, l);
			int nSC[] = new int[l + 1];
			System.arraycopy(ReadersRecord.StudentCode, 0, nSC, 0, l);

			System.out.println("输入借书卡号：");
			nBCC[l] = input.nextInt();
			while (Arrays.binarySearch(ReadersRecord.BookCardCode, nBCC[l])>=0){
				System.out.println("卡号已存在，请重新输入");
				nBCC[l] = input.nextInt();
			}
			System.out.println("输入姓名：");
			nN[l] = input.next();
			System.out.println("输入性别：（男或女）");
			nG[l] = input.next();
			while (nG[l].equals("男") == false && nG[l].equals("女") == false) {
				System.out.println("输入无效！请重新输入");
				nG[l] = input.next();
			}
			System.out.println("输入学生学号：");
			nSC[l] = input.nextInt();
			while (Arrays.binarySearch(ReadersRecord.StudentCode, nSC[l])>=0){
				System.out.println("学号已存在，请重新输入");
				nBCC[l] = input.nextInt();
			}

			ReadersRecord.BookCardCode = nBCC.clone();// 将临时数组克隆到原数组（将新增读者的信息同步到整个程序中）
			ReadersRecord.Name = nN.clone();
			ReadersRecord.Gender = nG.clone();
			ReadersRecord.StudentCode = nSC.clone();

			System.out.print("是否继续录入？（1.继续 2.返回上一级）");
			i = input.nextInt();
		} while (i == 1);// i=1可一次性无限录入新读者
		while (i != 2) {
			System.out.println("输入错误！请重新输入");
			i = input.nextInt();
		}

		ReadersManagement RM = new ReadersManagement();
		RM.readersManagement();
		input.close();
	}

}
