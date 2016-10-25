import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFunctions {

	public static void main(String[] args) throws ParseException {
		
		String date = "02/13/2016";
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Date d = sdf.parse(date);
		
		String month = new SimpleDateFormat("MMM").format(d);
		System.out.println(month);

		String year = new SimpleDateFormat("YYYY").format(d);
		System.out.println(year);
	}

}
