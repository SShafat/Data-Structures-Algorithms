public class StackIntLL 
{
	private Node top = null;
	
	public void push (int x)
	{
		top = new Node(x, top);
	}
	
	public int pop()
	{
		int temp = top.x;
		
		top = top.next;
		
		return temp;
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	public int top()
	{
		return top.x;
	}

}
