import java.sql.Time;;

public class AvailabilityTime {
	WorkingTime start;
	WorkingTime end;
	
	public AvailabilityTime() {
		this.start = null;
		this.end = null;
	}
	
	public AvailabilityTime(WorkingTime start, WorkingTime end) {
		this.start = start;
		this.end = end;
	}

	public WorkingTime getStart() {
		return start;
	}

	public void setStart(WorkingTime start) {
		this.start = start;
	}

	public WorkingTime getEnd() {
		return end;
	}

	public void setEnd(WorkingTime end) {
		this.end = end;
	}
}
