
public class EventList {
	
	private final int currentSize = 2;  	
	Object[] list ;
		public EventList() {
			list = new Object[currentSize];
		}
	
		public boolean isEmpty() {
		
		return(list == null);
	}
	
		public void insert(Object anEvent) {
		if (list[0] == null) {
			list[0] = anEvent;
		}
		else {
			Object temp = list[0];
			
			if (((Event) anEvent).getTime() < ((Event) list[0]).getTime()) {
				list[0] = anEvent;
				list[1] = temp;
			}
			else
				list[1] = anEvent;
		}
	}
	
	public Object get(int pos)
	   { return list[pos]; }

	public void delete() {
		list[0] = null;
		list[1] = list[0];
	}
	

	//+retrieve():Event// Retrieves the first event in an event list.

}
