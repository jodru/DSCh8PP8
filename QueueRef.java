import java.util.NoSuchElementException;

public class QueueRef {
	
	private Node head;
	private Node tail;
	private int size;
		
		public QueueRef() {
			size = 0;
		
		}
		public class Node {
			Object element;
			Node next;
			Node prev;
			public Node(Object element, Node next, Node prev) {
				this.element = element;
				this.next = next;
				this.prev = prev;
			}
		}
		
		public int size() { return size; }
		public boolean isEmpty() { return size == 0; }
		
		
		public void enqueue(Object element) {
			Node tmp = new Node(element, null, tail);
			if(tail != null) {tail.next = tmp;}
			tail = tmp;
			if (head == null) { head = tmp; }
			size++;
		}
		
		public Object dequeue() {
			if(!isEmpty()) {
				Object tmp = head.element;
				head = head.next;
				size--;
				return tmp;
			}
			else
				throw new NoSuchElementException();
			
		
		}
		public Object peek() {
			return head.element;
		}
		
		//Test to make sure everything exists
		public void iterateForward() {
			Node tmp = head;
			while (tmp != null) {
				System.out.println(tmp.element);
				tmp = tmp.next;
			}
			
		}}
		
		






































/*import java.util.*;

public class QueueRef {
	class Node { public Object data; public Node next;  }
	private Node first;
	private Node last;
	public QueueRef() {
		first = null;
		last = null;
	}
	public Object peek()
	{
		if(isEmpty()) {throw new NoSuchElementException();}
		return first.data;
	}
	
	public void enqueue(Object element)
	{
		Node newNode = new Node();
		newNode.data = element;
		if(isEmpty()){
            
			newNode.next = newNode;
            first = newNode;
            first = last;
		}
		newNode.data = element;
		newNode.next = last.next;
		last.next = newNode;
		last = newNode;
	}
	
	public Object dequeue() {
		if(isEmpty()) {throw new NoSuchElementException();}
		Object element = first.data;
		first = last.next;
		last.next = first.next;
		return element;
	
	}
	
	public boolean isEmpty() {
	
		return(first == null);
	}
	public static void main(String[] args) {
		QueueRef names = new QueueRef();
		names.enqueue("1");
		names.enqueue("1");
		names.enqueue("2");
		names.enqueue("3");
		
		while (!names.isEmpty()) {
			System.out.println(names.dequeue());
		}
	}

	
	
	
	
}*/
