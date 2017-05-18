public class UseHeap 
{
	public static void main(String [] args)
	{
		int [] x = {93, 17, 100, 6, 89, 26, 11, 8, 23, 150, 55, 500, 3, 29};
		
		Heap heap = new Heap();
		for(int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + ", ");
		}
		
		x = heap.sort(x);
		
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + ", ");
		}
		
	
	}

}
