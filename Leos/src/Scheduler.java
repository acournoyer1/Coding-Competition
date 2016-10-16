import java.awt.List;
import java.lang.reflect.Array;
import java.time.*;
import java.util.ArrayList;
public class Scheduler {
	private ArrayList<Employee> employees;
	boolean dayFilled;
	boolean overnightFilled;
	String day;
	
	/**
	 * 
	 * @param day	day that needs to be scheduled
	 */
	
	public Scheduler(String day) {
		this.employees = new ArrayList<Employee>();
		this.day = day;
	}
	
	/**
	 * schedules the day
	 */
	public void schedule()
	{
		switch (day){
        case "Monday":
        	for(Employee e : employees) {
        		if(e.isCanWorkMonday()) {
        			dayFilled = true;
        		}
        	}
            break;
        case "Tuesday":
        	for(Employee e : employees) {
        		if(e.isCanWorkTuesday()) {
        			dayFilled = true;
        		}
        	}
            break;
        case "Wednesday":
        	for(Employee e : employees) {
        		if(e.isCanWorkWednesday()) {
        			dayFilled = true;
        		}
        	}
            break;
        case "Thursday":
        	for(Employee e : employees) {
        		if(e.isCanWorkThursday()) {
        			dayFilled = true;
        		}
        	}
          
            break;
        case "Friday":
        	for(Employee e : employees) {
        		if(e.isCanWorkFriday()) {
        			dayFilled = true;
        		}
        	}
            
            break;
        case "Saturday":
        	for(Employee e : employees) {
        		if(e.isCanWorkSaturday()) {
        			dayFilled = true;
        		}
        	}
        	for(Employee e : employees) {
        		if(e.isCanWorkOvernight()) {
        			overnightFilled = true;
        		}
        	}
        	
            break;
        default:
            break;
		}
	}
	
	/**
	 * 
	 * @param list complete arraylist of employees
	 */
	public void addEmployees(ArrayList<Employee> list)
	{
		employees.addAll(list);
	}
	/**
	 * 
	 * @return list of employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

}
