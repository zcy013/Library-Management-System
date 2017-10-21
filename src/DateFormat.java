package information;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {//日期格式的方法
	
	public static String toString( Date date ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format( date );
	}

}
