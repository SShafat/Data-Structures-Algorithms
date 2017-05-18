public class BSTNode 
{
	int x;
	BSTNode left = null;
	BSTNode right = null;
	
	public BSTNode(int x)
	{
		this.x = x;
	}
	
	public int min()
	{
		if(left!= null)	return left.min();
		else			return x;
	}
	
	public int max()
	{
		if(right!= null) return right.max();
		else			 return x;
	}
	
	public int max (int a, int b)
	{
		if (a >= b) return a;
		else	   return max(b,a);
	}
	
	public void func2()
	{
		if(left!= null) left.func2();
		System.out.println(x);
		if(right!= null) right.func2();
		
	}
	
	public int count()
	{
		int count = 0;
		if(left!=null) left.count();
		count++;
		if(right!=null) right.count();
		return count;
	}
	
	
	public int height()
	{
		int hLeft = 0;
		int hRight = 0;
		
		if(left!= null) hLeft = left.height();
		if(right!= null) hRight = right.height();
		
		return max(hLeft,hRight) + 1;
	}

}
