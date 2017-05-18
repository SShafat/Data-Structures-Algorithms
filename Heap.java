public class Heap 
{
	int [] value;
	
	int last = -1;
	
	final int root = 0;
	
	public int [] sort(int [] x)
	{
		value = x;
		
		for(int i = 0; i < value.length; i++)
			
			insert();
		
		for(int i = 0; i < value.length; i++)
			
			remove();
		
		return value;
	}
	
	public void insert()
	{
		last++;
				
		heapifyUpward(last);
	}
	
	public void heapifyUpward (int node)
	{
		if((node != root) && (value[node] > value[parent(node)]))
		{
			swap(node,parent(node));
			
			heapifyUpward(parent(node));
		}
	}
	
	public void remove()
	{
		swap(root,last);
		
		last--;
		
		heapifyDownward(root);
			
	}
	
	public void heapifyDownward(int node)
	{
		if (right(node) <= last)							// if two children
		{
			if(
				(value[left(node)] > value[right(node)]) && // if left child is bigger
				(value[node] < value[left(node)]))			// if node is smaller
			{
				swap(node, left(node));
			
				heapifyDownward(left(node));
			}
			
				
			if (				
				(value[right(node)] > value[left(node)]) && // if right child is bigger
				(value[node] < value[right(node)]))			// if node is smaller
				{
					swap(node, right(node));
				
					heapifyDownward(right(node));
				}
		}
		
		else
		if (left(node) == last)								// if one child only
		{
			if (value[node] < value[left(node)])
			{
				swap(node,left(node));
			}
		}
		
	}
	
	public int parent (int n)
	{
		return (n - 1) / 2;
	}
	
	public int right(int n)
	{
		int right = 2*n + 2;
		
		return right;
	}
	
	public int left(int n)
	{
		int left = 2*n + 1;
		
		return left;
	}
	
	public void swap(int A, int B)
	{
		int temp = value[A];
		value[A] = value[B];
		value[B] = temp;
	}
	
	
	

}
