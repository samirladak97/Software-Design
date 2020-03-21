package ca.mcgill.cs.swdesign.m2;

import java.util.ArrayList;
import java.util.List;

public class MultiDeck implements Cloneable
{
	private List<Deck> aDecks = new ArrayList<>();
	
	public MultiDeck(MultiDeck pDecks)
	{
		aDecks = new ArrayList<>();
		for (Deck deck : pDecks.aDecks) {
			aDecks.add(deck);
		}
	}
	
	public MultiDeck(Deck...decks) 
	{
		for (Deck deck : decks) {
			aDecks.add(deck);
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		try 
		{
			MultiDeck clone = (MultiDeck) super.clone();
			return clone;
		}
		catch (CloneNotSupportedException e) 
		{
			return null;
		}
	}
	
	
	
}
