package com.example.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pattern.ProtoTypeFalse;
import com.pattern.ProtoTypeTrue;
import com.pattern.SingleB;
import com.pattern.adapter.BugattiVeyron;
import com.pattern.adapter.Movable;
import com.pattern.adapter.MovableAdapter;
import com.pattern.adapter.MovableAdapterImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryPatternApplicationTests {

	@Autowired
	public SingleB singleB1;
	@Autowired
	public SingleB singleB2;
	
	
	
	
	@Autowired
	public ProtoTypeFalse PTF1;
	
	@Autowired
	public ProtoTypeFalse PTF2;
	
	
	@Autowired
	public ProtoTypeTrue PTT1;
	
	@Autowired
	public ProtoTypeTrue PTT2;
	
	
	
	@Test
	public void adapterTest()
	{
		
		Movable bugattiVeyron =new BugattiVeyron();
		 MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
		 System.out.print(bugattiVeyronAdapter.getSpeed());
		 assertEquals(bugattiVeyronAdapter.getSpeed(), 431.30312, 0.00001);
	}
	
	/*
	@Test
	public void prototypeTest()
	{
		assertSame(PTF1, PTF2);
		assertNotSame(PTT1, PTT2);
	}
	
	
	@Test
	public void singletoneTest() {
		
	SingleA singleA1= SingleA.getInstance();
	SingleA singleA2= SingleA.getInstance();
		
		assertNotNull(singleB1);
		assertEquals(singleB1, singleB2);
		assertNotNull(singleA1);
		assertEquals(singleA1, singleA2);
		
	}
*/
}
