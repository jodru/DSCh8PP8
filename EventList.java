
public class EventList {
	
	private final int currentSize = 2;  	
	Object[] list ;
		public EventList() {
			list = new Object[currentSize];
		}
	
		public boolean isEmpty() {
	        return(list == null || list.length < 1);
	    }
	
		public void insert(Event anEvent) {
		if (isEmpty()) {
			list[0] = anEvent;
			
		}
		else {
			Object temp = list[0];
			
			if (((Event) anEvent).getTime() <= ((Event) list[0]).getTime() ) {
				list[0] = anEvent; 
				System.out.println(((Event) list[0]).getTime());
				list[1] = temp;
				System.out.println(((Event) list[1]).getTime());
			}
			else list[1] = anEvent;
		}
	}
	
	public Object get(int pos)
	   { return list[pos]; }

	public void delete() {
		list[0] = null;
		list[1] = list[0];
		System.out.println("TRIPLE?!?");
	}
	

	//+retrieve():Event// Retrieves the first event in an event list.

}
