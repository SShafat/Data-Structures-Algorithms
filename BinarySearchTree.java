public class BinarySearchTree 
{
	BSTNode root = null;
	
	int [] A;
	
	int i;
	
	public void balance()
	{
		if(!isEmpty())
		{
			inorder();
			
			root = null;
			
			bisectionInsert(0, A.length-1);
		}
	}
	
	public void bisectionInsert(int front, int back)
	{
		if(front <= back)
		{
			int middle = (front + back) / 2;
			
			insert(A[middle]);
			
			bisectionInsert(front, middle - 1);
			
			bisectionInsert(middle + 1, back);
		}
	}
	
	public void inorder()
	{
		A = new int[count()];
		
		i = 0;
		
		if(!isEmpty())	root.inOrder();
	}
	
	public int count()
	{
		if(isEmpty())		return 0;
		else				return root.count();
	}
	
	public int height()
	{
		if (isEmpty())		return 0;
		else 				return root.height();
	}
	
	public int min()
	{
		if(isEmpty())		return 0;
		else				return root.min();
	}
	
	public int max()
	{
		if(isEmpty())		return 0;
		else				return root.max();
	}
	
	public void printInOrder()
	{
		if(!isEmpty())		root.printInOrder();
	}
	
	public void insert(int x)
	{
		if(isEmpty())		root = new BSTNode(x);
		else				root.insert(x);
	}
	
	public void remove (int value) 
	{
		if(value == root.x)
		{
			root = new BSTNode(-1, root, null);
			
			root.remove(value);
			
			root = root.left;
		}
		
		else				root.remove(value);
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public class BSTNode
	{
		int x;
		
		BSTNode left = null;
		BSTNode right = null;
		
		public BSTNode(int x)
		{
			this.x = x;
		}
		
		public BSTNode(int x, BSTNode left, BSTNode right)
		{
			this.x 		= 	x;
			this.left 	= 	left;
			this.right 	= 	right;
		}
		
		public void insert(int value)
		{
			if(value < x)
			{
				if(left!= null)		left.insert(value);
				else				left = new BSTNode(value);
			}
			
			if(value > x)
			{
				if(right!= null)	right.insert(value);
				else				right = new BSTNode(value);
			}
		}
		
		public int min()
		{
			if(left!= null)	return left.min();
			else 			return x;
		}
		
		public int max()
		{
			int max = 0;
			
			if(right!= null)	max = right.max();
			
			else				max = x;
			
			return max;
		}
		
		public int count()
		{
			int count = 1;
			
			if(left!= null)		count+= left.count();
			
			if(right!= null)	count+= right.count();
			
			return count;
			
		}
		
		public int height()
		{
			int leftsub_height 	= 0;
			
			int rightsub_height = 0;
			
			if(left!= null) 	leftsub_height 	= left.height();
			
			if(right!= null)	rightsub_height	= right.height();
			
			return max(leftsub_height, rightsub_height) + 1;
		}
		
		public void printInOrder()
		{
			if(left!= null)		left.printInOrder();
			
			System.out.println(x);
			
			if(right!= null)	right.printInOrder();
		}
		
		public int max(int a, int b)
		{
			if(a > b)	return a;
			
			else		return b;
		}
		
		public int search(int value)
		{
			if(value == x)		return x;
			
			if((value < x) && (left!= null))	return left.search(value);
			
			if((value > x) && (right!= null))	return right.search(value);
			
			return -1;
		}
		
		
		public void inOrder()
		{
			if(left!=null)		left.inOrder();
			
			A[i] = x;
			
			i++;
			
			if(right!= null)	right.inOrder();
		}
		
		
		
		public void remove(int value)
		{
			BSTNode parent = parentOf(value);
			
			BSTNode target = null;
			
			if((parent.right != null) && (parent.right.x == value))
			{
				target = parent.right;
				
				// if Target is a Leaf
				if((target.left == null) && (target.right == null))
				{
					parent.right = null;
				}
				else
				// if target only has a left subtree
				if((left != null) && (right == null))
				{
					parent.right = target.left;
				}
				else
				if((right != null) && (left == null))
				// if Target only has right subtree
				{
					parent.right = target.right;
				}
				else
				{
					// if Target has two subtrees
					int max = target.left.max();
					
					BSTNode parentMax = target.parentOf(max);
					
					parentMax.right = parentMax.right.left;
					
					target.x = max;
				}
				
				
			}
			
			else
			{
				// If Target is a Leaf
				if((target.left == null) && (target.right == null))
				{
					parent.left = null;
				}
				else
				// if target only has a left subtree
				if((left != null) && (right == null))
				{
					parent.left = target.left;
				}
				else
				if((right != null) && (left == null))
				// if Target only has a right subtree
				{
					parent.left = target.right;
				}
				else
				// if Target has two subtrees
				{
					int max = target.left.max();
					
					BSTNode parentMax = target.parentOf(max);
					
					parentMax.right = parentMax.right.left;
					
					target.x = max;
				}
			}
			
			
		}
		
		public BSTNode parentOf(int value)
		{
			if(left!= null)
			{
				if(value == left.x)		return this;
				
				if(value < x)			return left.parentOf(value);
			}
			if(right!= null)
			{
				if(value == right.x)	return this;
				
				if(value > x)			return right.parentOf(value);
			}
			
			return null;
		}
		
		public void removeLeaf(int value)
		{
			BSTNode parent = parentOf(value);
			
			if ((parent.left!= null) && (value == parent.left.x))		parent.left  = null; // set node to null
			
			if ((parent.right!= null) && (value == parent.left.x))		parent.right = null; // not the value
		}
		
		public void removeWLeftSub(int value)
		{
			BSTNode parent = parentOf(value);
			
			if((parent.left!= null)  && (value == parent.left.x))			parent.left = parent.left.left;
			
			if((parent.right!= null) && (value == parent.right.x))			parent.right = parent.right.left;
		}
		
		public void removeWRightSub(int value)
		{
			BSTNode parent = parentOf(value);
			
			if((parent.right!= null) && (value == parent.right.x))			parent.right = parent.right.right;
			
			if((parent.left!= null)  && (value == parent.left.x))			parent.left	 = parent.left.right;
		}
		
		/* to remove a node with both left & right subtrees replace that node with either:
		 * the node with the largest value of the left sub tree
		 * or
		 * the node with the smallest value of the right subtree
		 */
		
		public void removeBeta(int value)
		{
			BSTNode parent = parentOf(value);
			
			if((parent.left!= null) && (parent.left.x == value))
			{
				int max = parent.left.left.max();
				
				BSTNode parentMax = parentOf(max);
				
				parentMax.right = parentMax.right.left;
				
				parent.left.x = max;
			}
			
			if((parent.right!= null) && (parent.right.x == value))
			{
				int max = parent.right.left.max();
				
				BSTNode parentMax = parentOf(max);
				
				parentMax.right = parentMax.right.left;
				
				parent.right.x = max;
			}
			
			
		}
		
		public void removeBeta2(int value)
		{
			BSTNode parent = parentOf(value);
			
			BSTNode target = parent.left.x == value ? parent.left:parent.right; 
			/* if the condition is true target will get the left value,
			 * if false the target will get the right value
			 */
			
			int max = target.left.max();
			
			BSTNode parentMax = target.parentOf(max);
			
			parentMax.right = parentMax.right.left;
			
			target.x = max;
		}
	}

}
