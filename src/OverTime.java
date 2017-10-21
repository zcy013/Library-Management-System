package information;

import java.util.*;

public class OverTime {//逾期图书处理
  
	static void allDebCheck() {// 所有书是否有欠款的检查
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
			int counter=0;
			long total=0;
			for (int i = 0; i < BorrowBooks.BookName.size(); i++) {
				if(overDay(BorrowBooks.BookName.get(i))>0){
				counter++;	
				total=total+overDay(BorrowBooks.BookName.get(i));
				}else{}
			}
			if(counter>0){
				System.out.printf("您共有欠款%s元。是否缴纳欠款（1.是   2.否并返回上一级）：",total);
				int n=input.nextInt();
				while(n!=1&&n!=2){
					System.out.print("编号错误。请重新输入编号：");
					n = input.nextInt();
				}

				if (n == 1) {
					System.out.println("还款成功！");
					
					}
					if (n == 2) {
						BorrowAndReturn bAr = new BorrowAndReturn();
						bAr.borrowAndreturn();
						
					}
				}
			else{}
	
			
		}
	 static long overDay(String a) {//计算逾期天数
			Date DateNow = new Date();
			int temp = 0;
			for (String i : BorrowBooks.BookName) {
				if (a.equals(i)) {
					break;
				}
				temp++;
			}

			long diff = DateNow.getTime() - BorrowBooks.ReturnDate.get(temp).getTime();//毫秒
			long day = diff / ((1000) * 60 * 60 * 12);//逾期天数
			return day;
		}

}
