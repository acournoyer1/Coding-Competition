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
	public String name;
	public LocalDate expirydate;
	public int quantity;
	public int popularity;
	
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
	
	public String toString(){
		return ("Item: "+name + " " + "Expiry: " + expirydate + " "+ "Quantity"+quantity);
	}


	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}

