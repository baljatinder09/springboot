package com.pattern;

public class SingleA {
	
	private static SingleA instance;
	
	private SingleA()
	{
		
	}
	public static SingleA getInstance()
	{
		if(null==instance)
		{
			synchronized (SingleA.class) 
			{
				if(null==instance)
				{
					instance= new SingleA();
				}
			}
		}
		return 	instance;
		
	}
}
