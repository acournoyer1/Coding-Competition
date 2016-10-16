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
	
	/*
	 * Converts a date string to a LocalDate object
	 */
	private LocalDate convertDate(String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		formatter = formatter.withLocale(Locale.US);  
		LocalDate d = LocalDate.parse(date, formatter);
		return d;
	}
	
	/*
	 * Returns the expiry date
	 */
	public LocalDate getExpirydate() {
		return expirydate;
	}

	/*
	 * Sets the expiry date
	 */
	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}
	
	/*
	 * Returns the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/*
	 * Decrements the quantity and increments the quantity, called if someone buys an item
	 */
	public void decrementQuantity() {
		quantity--;
		popularity++;
	}
	
	/*
	 * Returns a string representation of the Item
	 */
	public String toString(){
		return ("Item: "+name + ", " + "Expiry: " + expirydate + ", "+ "Quantity: "+quantity);
	}

	/*
	 * Returns an item's popularity
	 */
	public int getPopularity() {
		return popularity;
	}
	
	/*
	 * Sets an item's popularity
	 */
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}

