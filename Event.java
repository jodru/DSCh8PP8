
public class Event {
	
	
	private int time;
	private String which;
	private int timeTaken;
	
	//Arrival Event
	public Event(String which, int time, int timeTaken){ 
		this.time = time;
		this.which = which;
		this.timeTaken = timeTaken;
		
	}
	
	//Departure Event
	public Event(String which, int time) { 
		this.time = time;
		this.which = which;
	}
	
	public int getTime() { 
	    return time;
    }
	public int getTimeTaken() { 
	    return timeTaken;
    }

	public String getWhich() {
    	return which;
	}
}
