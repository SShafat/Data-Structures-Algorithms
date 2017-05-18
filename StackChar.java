public class StackChar 
{
	private char [] A;
	private int top = -1;
	
	public StackChar(int size)
	{
		A = new char[size];
	}
	
	public void push(char x)
	{
		top++;
		
		if (top == A.length) resize();
		
		A[top] = x;
	}
	
	public char pop()
	{
		char temp = A[top];
		
		top--;
		
		return temp;
	}
	
	public char top()
	{
		return A[top];
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	public void resize()
	{
		char [] B = new char [A.length * 2];
		for(int i = 0; i < A.length; i++)
			B[i] = A[i];
		A = B;
	}

}
