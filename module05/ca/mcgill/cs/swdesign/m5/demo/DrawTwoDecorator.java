package ca.mcgill.cs.swdesign.m5.demo;


import java.util.ArrayList;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * Enable attaching additional responsibility of drawing two cards 
 * and return a higher ranked one according to the ordering algorithm 
 * defined in Card compareTo() method.
 */
public class DrawTwoDecorator implements CardSource
{
	private CardSource aCardSource;
	
	/**
	 * @param pCardSource the decorated card source.
	 */
	public DrawTwoDecorator(CardSource pCardSource) 
	{
		aCardSource = pCardSource;
	}
	
	@Override
	public Card draw()
	{
		assert size()>0;
		Card card1 = aCardSource.draw();
		if (aCardSource.size() > 0) 
		{
			Card card2 = aCardSource.draw();
			if (card1.compareTo(card2)>0)
			{
				return card1;
			}
			return card2;
		} 
		
		return card1;
	}

	@Override
	public int size()
	{
		return aCardSource.size();
	}
	
	@Override
	public CardSource clone() 
	{
		DrawTwoDecorator clone;
		try
		{
			clone = (DrawTwoDecorator)super.clone();
			clone.aCardSource = aCardSource.clone();
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		} 
		
	}
	

}
