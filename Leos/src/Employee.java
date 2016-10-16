import java.util.HashMap;

import javax.management.timer.Timer;

import org.omg.PortableServer.ServantActivator;

import java.security.spec.ECPrivateKeySpec;
import java.sql.Time;
import java.time.*;

public class Employee {
	private String name;
    private boolean canWorkMonday = false;
    private boolean canWorkTuesday = false;
    private boolean canWorkWednesday = false;
    private boolean canWorkThursday = false;
    private boolean canWorkFriday = false;
    private boolean canWorkSaturday = false;
    private boolean canWorkOvernight = false;
    private boolean alreadyNo = false;
   // private HashMap<DayOfWeek, AvailabilityTime> availability;
    
    public Employee(String name, String availablility) {
        this.name = name;
        String[] days = availablility.split(", ");
        for(String day: days){
            if(day.contains("-")){
                parseRange();
            } else {
                String[] b = day.split(" ");
                parseAvailability(b);
            }
        }
    }
    
    public void parseRange(){
        canWorkMonday = true;
        canWorkTuesday = true;
        canWorkWednesday = true;
        canWorkThursday = true;
        canWorkFriday = true;
    }
    
    public void parseAvailability(String[] a){
        DayOfWeek day = null;
        for (int i = 0; i < a.length; i++){
            switch (a[i]){
                case "Monday":
                    canWorkMonday = true;
                    break;
                case "Tuesday":
                    canWorkTuesday = true;
                    break;
                case "Wednesday":
                    canWorkWednesday = true;
                    break;
                case "Thursday":
                    canWorkThursday = true;
                    break;
                case "Friday":
                    canWorkFriday = true;
                    break;
                case "Saturday":
                    canWorkSaturday = true;
                    break;
                default:
                    checkOvernight(a[i]);
                    break;
            }       
        }
    }
    
    private void checkOvernight(String a){
        if(a.equals("overnight") && !alreadyNo){
            canWorkOvernight = true;
        } else if (a.equals("no")) {
            canWorkOvernight = false;
            alreadyNo = true;
        }
    }
    
	public boolean isCanWorkMonday() {
		return canWorkMonday;
	}

	public boolean isCanWorkTuesday() {
		return canWorkTuesday;
	}

	public boolean isCanWorkWednesday() {
		return canWorkWednesday;
	}

	public boolean isCanWorkThursday() {
		return canWorkThursday;
	}

	public boolean isCanWorkFriday() {
		return canWorkFriday;
	}

	public boolean isCanWorkSaturday() {
		return canWorkSaturday;
	}

	public boolean isCanWorkOvernight() {
		return canWorkOvernight;
	}

	public String toString()
	{
		String s = name + " can work ";
		if(canWorkMonday) s += "Monday ";
		if(canWorkTuesday) s+= "Tuesday ";
		if(canWorkWednesday) s+= "Wednesday ";
		if(canWorkThursday) s+= "Thursday ";
		if(canWorkFriday) s+= "Friday ";
		if(canWorkSaturday) s+= "Saturday ";
		if(canWorkOvernight) s+= "and overnight";
		return s;
	}
}
