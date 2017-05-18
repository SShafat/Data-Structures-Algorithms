public class UseStack 
{
	public static void main (String [] args)
	{
		String infix = "2*(4+3*5-8)+4*2";
		
		int x = evalInfix(infix);
		
		System.out.println(x);
		
		
	}
	
	public static int evalInfix(String infix)
	{
		return evalPostfix(infixToPostfix(infix));
	}
	
	public static String infixToPostfix (String infix)
	{
		StackChar s = new StackChar(infix.length() / 2);
		
		String postfix  = "";
		
		for (int i = 0; i < infix.length(); i++)
		{
			char c = infix.charAt(i);
			if(isOperator(c))
			{
				while((!s.isEmpty() /*&& prec(c) <= prec(i)*/))
				{
					postfix+= s.pop();
				}
				
				s.push(c);
			}
			else
			if(c == '(')
				s.push(c);
			
			else
			if(c == ')')
			{
				while(s.top() != '(')
					postfix+= s.pop();
				s.pop();
			}
			else
				postfix += c;
		}
		while(!s.isEmpty())
			postfix+= s.pop();
		
		return postfix;
		
	}
	
	public static int prec(char op)
	{
		if((op == '+') || (op == '-')) return 1;
		else
		if((op == '*') || (op == '/')) return 2;
		else
		if (op == '^')                 return 3;
		
		else						   return 0;
		
	}
	
	public static boolean isOperator(char op)
	{
		return (op == '+') || (op == '-') || (op == '*') || (op == '/') || (op == '^');
	}
	
	public static int evalPostfix(String postfix)
	{
		return 0;
	}

}
