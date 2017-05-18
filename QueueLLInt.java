public class QueueLLInt 
{
	Node front = null;
	Node back = null;
	
	public void enqueue(int x)
	{
		if (isEmpty())
		{
			front = new Node(x);
			back = front;
		}
		else
		{
			back.next = new Node(x);
			back = back.next;
		}

	}
	public int dequeue()
	{
		int temp = front.x;
		front = front.next;
		return temp;
	}
	public boolean isEmpty()
	{
		return front == null;
	}
	public int front()
	{
		return front.x;
	}
	public int back()
	{
		return back.x;
	}

}
