public class Node 
{
	int x;
	
	Node next = null;
	
	public Node(int x )
	{
		this.x = x;
	}
	public Node (int x, Node next)
	{
		this(x);
		
		this.next = next;
	}

}
