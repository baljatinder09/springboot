package com.example.demo;

public class PrimeNumberController {

	
	public static void main(String as[])
	{
		int number=100;
		boolean isPrime=true;
		for(int j=1;j<=number;j++)
		{
			isPrime=IsPrime(j);
		if(isPrime)
		{
			System.out.println("Number is Prime ::"+ j);
		}
		else
		{
		  System.out.println("Number is not Prime ::"+ j);
		}
		}
	}
	private static boolean IsPrime(int j)
	{
		for(int i=2;i<=j/2;i++)
		{
			if(j%i==0)
			{
				return false;
			}
		}
		return true;
	}
	
}
