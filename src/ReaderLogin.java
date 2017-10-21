package information;

import java.util.Scanner;
import java.util.Arrays;

public class ReaderLogin {//读者登陆
	static int cardNumber;

	public void login() {
		Scanner input = new Scanner(System.in);

		try {
			System.out.print("请输入你的学号（输入1为返回上一级）：");
			cardNumber = input.nextInt();
		} catch (Exception e) {
			System.out.print("学号不存在。");
			login();
		}
		while (Arrays.binarySearch(ReadersRecord.BookCardCode, cardNumber) < 0 && cardNumber != 1) {
			System.out.print("学号不存在。请重新输入你的学号(输入1为返回上一级）：");
			cardNumber = input.nextInt();
		}
		if (Arrays.binarySearch(ReadersRecord.BookCardCode, cardNumber) >= 0) {
			System.out.println("欢迎！");
			Readers r = new Readers();
			r.ReadersFunction();

		}
		if (cardNumber == 1) {
			InitialInterface initial = new InitialInterface();
			initial.Initial();

		}

		input.close();

	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardnumber) {
		cardNumber = cardnumber;
	}
}
