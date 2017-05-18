public class LinkedList 
{
	//Node tail = new Node(-1); // dummy node
	Node head = new Node(-1); // dummy node
	Node previous = head;
	//Node current = head;
	
	public void insertAfter(int x)
	{ // O(1) operation
		if(!isEmpty()) previous = previous.next;
		insertBefore(x);
	}
	
	public void insertBefore(int x)
	{ // O(1) operation
		previous.next = new Node(x,previous.next);
		
	}
	
	//O(n)
	public void setCurrent(int index)
	{
		previous = head;
		for(int i = 0; i < index;i++)
			previous = previous.next;
	}
	
	public void insertAt(int index, int value)
	{
		setCurrent(index);
		insertBefore(value);
	}
	
	
	// Not mentioned in class
	public boolean isEmpty()
	{
		return previous.next == null;
	}
	

}
