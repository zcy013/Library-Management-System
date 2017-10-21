package information;

public class ReadersRecord {//读者信息记录
	static int BookCardCode[] = { 11510370, 11510371, 11510374 };//增加默认读者
	static String Name[] = { "张庞淼淼", "徐颖", "周宸宇" };
	static String Gender[] = { "女", "女", "女" };
	static int StudentCode[] = { 11510370, 11510371, 11510374 };

	public void display() {//读者信息输出
		String a = "————————————————————————————————————————————————————————————————————————";
		System.out.printf("%-15s        %-15s                  %-15s                %-15s\n%s\n", "借书卡号", "姓名", "性别",
				"学号", a);

		for (int j = 0; j < StudentCode.length; j++) {
			System.out.printf("%-15d%-15s%-15s%-15d\n%s\n", BookCardCode[j], Name[j], Gender[j], StudentCode[j], a);
		}
		ReadersManagement management = new ReadersManagement();
		management.readersManagement();
	}

}
