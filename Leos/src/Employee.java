import java.util.HashMap;

import org.omg.PortableServer.ServantActivator;

import java.time.*;

public class Employee {
	private String name;
	private HashMap<DayOfWeek, AvailabilityTime> availability;
	private boolean overnight;
	
	public Employee(String name, String availablility) {
		this.name = name;
		String[] days = availablility.split(", ");
		for(String day: days){
			day.split(" ");
			
		}
	}
	
	public void parseAvailability(String[] a){
		DayOfWeek day;
		boolean dayInFront = true;
		for (int i = 0; i < a.length; i++){
			switch (a[i]){
				case "Monday":
					day = DayOfWeek.MONDAY;
					break;
				case "Tuesday":
					day = DayOfWeek.TUESDAY;
					break;
				case "Wednesday":
					day = DayOfWeek.WEDNESDAY;
					break;
				case "Thursday":
					day = DayOfWeek.THURSDAY;
					break;
				case "Friday":
					day = DayOfWeek.FRIDAY;
					break;
				case "Saturday":
					day = DayOfWeek.SATURDAY;
					break;
				case "Sunday":
					day = DayOfWeek.SUNDAY;
					break;
				default:
					dayInFront = false;
					break;
			}
			if(dayInFront){
				if (a[i].equals("no") && a[i + 1].equals("overnight")){
					
				} else if (a[i].equals("overnight")){
					
				}
			} else {
				
			}
		}
	}
	
	public static void main(String[] args){
		
	}
}
