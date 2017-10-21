package information;

import java.util.Scanner;

public class AdministratorLogin {//管理员登陆

	private final static String Password = "123456";// 设置默认管理员信息
	private final static String UserName = "admin";

	Scanner input = new Scanner(System.in);

	public void Login() {
		String username;
		String password;

		System.out.print("请输入用户名(输入1为返回上一级）：");
		username = input.next();
		while (username.equals(UserName) != true && username.equals("1") != true) {
			System.out.print("用户名不正确。请重新输入用户名：");
			username = input.next();
		}
		if (username.equals("1") == true) {// 判断是否返回上一级
			InitialInterface initial = new InitialInterface();
			initial.Initial();
		}
		if (username.equals(UserName) == true) {
			System.out.print("请输入用户密码：");
			password = input.next();
			while (password.equals(Password) != true) {
				System.out.print("用户密码不正确。请重新输入用户密码：");
				password = input.next();
			}
			System.out.println("欢迎管理员 admin!");

			Administrator admin = new Administrator();// 跳转至管理员界面
			admin.AdministratorFunction();
		}
		input.close();
	}
}
