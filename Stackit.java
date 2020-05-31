package Chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stackit {
	static long hcf(long a,long b)
	  {
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; 
	        a = temp;
	    }
	    return a;
	   }
	public static void main(String[] args) {
		int n ;
		String s  ;
		try
		{
			
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in)) ;
			System.out.println("Enter limit  : ");
			n = Integer.parseInt(br.readLine()) ;
			
			System.out.println("Enter number of books  : ");
			s=br.readLine() ;
			String str[] = s.split(" ") ;
			Integer[] arr = new Integer[n] ;
			
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(str[i]) ;
			}
			long result = arr[0];
			for(int i = 1; i < arr.length; i++)
			{
			     result= hcf(result, arr[i]);
			}     
			System.out.println("The stack count is ="+result);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
