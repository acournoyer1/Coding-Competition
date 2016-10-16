import java.time.LocalDate;
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
	
	public Item(String name, LocalDate expirydate, int quantity){
		this(name,expirydate);
		this.quantity = quantity;
		this.popularity = 0;
	}
	
	public Item(String name, LocalDate expirydate){
		this.name = name;
		this.expirydate = expirydate;
		this.popularity = 0;
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
}
