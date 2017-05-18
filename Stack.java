public class Stack 
{
	private int [] A;
	private int top = -1;
	
	public Stack(int size)
	{
		A = new int [size];
	}
	
	public void push(int x)
	{
		top++;
		
		if(top == A.length) resize();
		
		A[top] = x;
	}
	
	public int pop()
	{
		int temp = A[top];
		top--;
		return temp;
	}
	
	public int top()
	{
		return A[top];
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	private void resize()
	{
		int [] B = new int[A.length * 2];
		for(int i = 0; i < A.length; i++)
		{
			B[i] = A[i];
		}
		A = B;
	}

}
