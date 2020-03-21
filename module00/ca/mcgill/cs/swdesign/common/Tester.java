package ca.mcgill.cs.swdesign.common;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Tester
{
	private Item aItem;
	private Field aName;
	private Field aId;
	private Field aPrice;
	private Method aSetName;
	
	@Before
	public void initialize() {
		aItem = new Item("Samir", 5, 69);
	}
	
	@Test
	public void nameCheckTest() {
		try{
			aName = Item.class.getDeclaredField("aName");
			aName.setAccessible(true);
			try {
				assertEquals("Samir", aName.get(aItem));
				System.out.println(aName.get(aItem));
				//System.out.println(aItem.getClass().toString());
			}catch(IllegalAccessException | IllegalArgumentException e) {
				fail();
			}
		}catch(NoSuchFieldException | SecurityException e) {
			fail();
		}
		try {
			aName = Item.class.getDeclaredField("aName");
			aName.setAccessible(true);
			aSetName = Item.class.getDeclaredMethod("setName");
			aSetName.setAccessible(true);
			try {
				aSetName.invoke(aItem);
				assertEquals("Samir", aSetName.invoke(aItem));
				System.out.println(aItem.setName());
			}
			catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
				{fail();}
		}catch(NoSuchMethodException | SecurityException | NoSuchFieldException | IllegalArgumentException e) 
			{fail();}
		
	}
	
}
