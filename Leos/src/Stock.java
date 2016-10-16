import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Stock {
	public ArrayList<Item> items;
	private Item topSeller;
	
	public Stock(){
		this.items = new ArrayList<Item>();
	}
	
	/*
	 * Adds a list of items to the inventory
	 */
	public void addItem(ArrayList<Item> food){
		items.addAll(food);
	}
	
	/*
	 * Returns the items in the inventory
	 */
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	/*
	 * Returns the top selling item
	 */
	public Item getTopSeller(){
		topSeller = items.get(0);
		for(Item it: items){
			if(it.getPopularity() > topSeller.getPopularity()){
				topSeller = it;
			}
		}
		return topSeller;
	}
		
}
