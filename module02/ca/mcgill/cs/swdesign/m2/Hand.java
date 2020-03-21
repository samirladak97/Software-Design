package ca.mcgill.cs.swdesign.m2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of cards, presumably in a player's hand.
 */
public class Hand implements Iterable<Card>, Comparable<Hand>, Cloneable
{
	private int aMaxCards;
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new hand that can hold between
	 * 0 and pMaxCards inclusively.
	 * @param pMaxCards A number between 0 and 52
	 */
	public Hand(int pMaxCards)
	{
		assert pMaxCards >=0 && pMaxCards <= Card.Rank.values().length * Card.Suit.values().length;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * @return True if the number of cards is the hand is the maximum permissible.
	 */
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}
	
	/**
	 * @param pCard The card to add.
	 * @pre !isFull()
	 */
	public void add(Card pCard)
	{
		assert !isFull();
		aCards.add(pCard);
	}
	
	public void remove(Card pCard)
	{
		assert aCards.contains(pCard);
		aCards.remove(pCard);
	}

	public boolean contains(Card pCard)
	{
		return aCards.contains(pCard);
	}
	
	public boolean isEmpty()
	{
		if (aCards.size() > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int size()
	{
		return aCards.size();
	}
	
	public static Comparator<Hand> acsendingComparator() 
	{
		return new Comparator<Hand> () {
				@Override
				public int compare(Hand h1, Hand h2) {
					return h1.size() - h2.size();
				}
		};
	}
	
	public static Comparator<Hand> descendingComparator()
	{
		return new Comparator<Hand> () {
			@Override 
			public int compare(Hand h1, Hand h2) {
				return h2.size() - h1.size();
			}
		};
	}
	
	public static Comparator<Hand> byRankComparator(Card.Rank pRank)
	{
		return new Comparator<Hand>() {
			@Override
			public int compare(Hand h1, Hand h2) {
				return counter(h1, pRank) - counter(h2, pRank);
			}
			private int counter(Hand pHand, Card.Rank pRank) {
				int total = 0;
				for (Card card : pHand) {
					if (card.getRank() == pRank) {
						total ++;
					}
				}
				return total;
			}
		};
	}
	
	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

	@Override
	public int compareTo(Hand o)
	{
		return aCards.size() - o.aCards.size();
	}
	
	@Override
	public Hand clone() throws CloneNotSupportedException {
		try{
			Hand clone = (Hand) super.clone();
			clone.aCards = new ArrayList<Card>();
			for (Card card : aCards) {
				clone.add(card);
			}
			return clone;
		}
		catch (CloneNotSupportedException e) {
			assert false;
			return null;
		}
		
	}
}
