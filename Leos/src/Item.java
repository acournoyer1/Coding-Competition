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
	
	public Item(String name, LocalDate expirydate, int quantity){
		this(name,expirydate);
		this.quantity = quantity;
	}
	
	public Item(String name, LocalDate expirydate){
		this.name = name;
		this.expirydate = expirydate;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
