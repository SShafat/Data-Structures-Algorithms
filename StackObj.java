public class StackObj 
{
	private Object [] A;
	
	int top = -1;
	
	public StackObj (int size)
	{
		A = new Object [size];
	}
	
	public void push(Object x)
	{
		top++;
		if(top == A.length) resize();
		A[top] = x;
	}
	public Object pop()
	{
		Object temp = A[top];
		top--;
		return temp;
	}
	public boolean isEmpty()
	{
		return top == -1;
	}
	public Object top()
	{
		return A[top];
	}
	
	public void resize()
	{
		Object [] B = new Object[A.length * 2];
		for(int i = 0; i < A.length; i++)
			B[i] = A[i];
		A = B;
	}

}
