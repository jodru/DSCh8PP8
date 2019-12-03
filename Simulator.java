
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {
public static void main(String[] args) throws FileNotFoundException {
	simulate();	
	}
	
	public static void simulate() throws FileNotFoundException  /*throws FileNotFoundException*/ {
	//Performs simulation
		System.out.println("Starting simulation... Ready!");
		QueueRef bankQueue = new QueueRef();
		EventList anEventList = new EventList();
		File text = new File("ArrivalFile.txt");
	     
        
        Scanner scanner = new Scanner(text);
		
		String line = scanner.nextLine();
		String split[] = line.split(" ");
		int time = Integer.parseInt(split[0]);
		int timeTaken = Integer.parseInt(split[1]);
		Object arrivalEvent = new Event("A", time, timeTaken);
		int people = 1;
		int avg = 0;		
		EventList list = new EventList();
		list.insert(arrivalEvent);
		
			while (!list.isEmpty()) {
				Object newEvent = list.get(0);
				int ADTime = ((Event) newEvent).getTime();
				if (((Event) newEvent).getWhich() == "A") {
					processArrival(newEvent, scanner, list, bankQueue);
					System.out.println("Processing arrival at time: " + ADTime);
					people++;
				}
				else {
					avg = avg + processDeparture(newEvent, list, bankQueue);
					System.out.println("Processing departure at time: " + ADTime);
					
				}
			}
			System.out.println("Simulation completed.");
			System.out.println("Customer count = " + people);
			System.out.println("Average time spent waiting = " + avg);
	}	
	public static void processArrival(Object newEvent, Scanner scanner, EventList list, QueueRef bankQueue) {
	//Processes an arrival event
		
		boolean atFront = bankQueue.isEmpty(); //present queue status
		
		bankQueue.enqueue(newEvent); //update the bankQueue by inserting the customer, as described in arrivalEvent, into the queue
		
		list.delete(); //delete arrivalEvent from anEventList
		
		if (atFront) {
			//the line was empty, so new customer is at front of line and begins transaction immediately
			Object top = bankQueue.peek();
			int time = ((Event) top).getTime();
			int timeTaken = ((Event) top).getTimeTaken();
			Event departureEvent = new Event("D", (time + timeTaken));
			list.insert(departureEvent);
			
		}
		
		if (scanner.hasNext()) {
			String line = scanner.nextLine();
			String split[] = line.split(" ");
			int time = Integer.parseInt(split[0]);
			int timeTaken = Integer.parseInt(split[1]);
			Event arrivalEvent = new Event("A", time, timeTaken);
			list.insert(arrivalEvent);
		}
		
	}
	
	public static int processDeparture(Object newEvent, EventList list, QueueRef bankQueue){
	//Processes a departure event
		
		Object queuePull = bankQueue.peek();
		int initialTime = ((Event) queuePull).getTime();
		Object listPull = list.get(0);
		int currentTime = ((Event) listPull).getTime();
		
		bankQueue.dequeue();//update the line by deleting the front customer
		list.delete(); //deblete from EventList
		
		if (!bankQueue.isEmpty()){
			Object top = bankQueue.peek();
			int timeTaken = ((Event) top).getTimeTaken();
			Event departureEvent = new Event("D", (currentTime + timeTaken));
			list.insert(departureEvent);
		}
		return currentTime-initialTime;
	}
}