import java.util.*;

public class Scheduler {
	private List<Employee> employees;
	private Parser parser;
	
	public Scheduler() {
		this.employees = new ArrayList<Employee>();
		this.parser = new Parser();
	}
	
	public void add(Employee e){
		this.employees.add(e);	
	}
	
	public void remove(Employee e){
		this.employees.remove(e);
	}
	
	public void schedule(){
		
	}
}
