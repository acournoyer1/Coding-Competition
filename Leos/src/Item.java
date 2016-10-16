import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;



/**
 * Items in the store
 * @author dan
 *
 */
public class Item {
	private String name;
	private LocalDate expirydate;
	private int quantity;
	private int popularity;
	
	public Item(String name, String expirydate, int quantity){
		this(name,expirydate);
		this.quantity = quantity;
		this.popularity = 0;
	}
	
	public Item(String name, String expirydate){
		this.name = name;
		this.expirydate = convertDate(expirydate);
		this.popularity = 0;
	}
	public Item(){}
	private LocalDate convertDate(String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		formatter = formatter.withLocale(Locale.US);  
		LocalDate d = LocalDate.parse(date, formatter);
		return d;
	}
	
	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void decrementQuantity() {
		quantity--;
		popularity++;
	}
	
	public static void main(String args[]){
		//Item t = new Item();
		//LocalDate d = t.convertDate("Jun 16, 2018");
		//System.out.println(d);
	}
}
