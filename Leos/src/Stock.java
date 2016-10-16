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

	public void addItem(ArrayList<Item> food){
		items.addAll(food);
	}
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	
	public ArrayList<Item> criticalItems(){
		ArrayList<Item> critical = new ArrayList<Item>();
		Date currentTime = new Date(System.currentTimeMillis());
		int currentYear = currentTime.getYear();
		int currentMonth = currentTime.getMonth();
		int currentDay = currentTime.getDay();
		
		for(Item it: items){
			int itYear = it.getExpirydate().getYear();
			int itMonth = it.getExpirydate().getMonthValue();
			
		}
	}
	
	
	public Item getTopSeller(){
		topSeller = items.get(0);
		for(Item it: items){
			if(it.getPopularity() > topSeller.getPopularity()){
				topSeller = it;
			}
		}
		return topSeller;
	}
	
	
	public static void main(String args[]) throws IOException{
		Stock s = new Stock();
		System.out.println("TEST");
		
		s.addItem(Parser.parseItems());
		System.out.println(s.items.size());
		for(Item i : s.items){
			System.out.println(i);
		}
	}
		
}
