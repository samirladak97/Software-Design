package ca.mcgill.cs.swdesign.m4.demo;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestMathAbs
{
	private int pos;
	private int neg;
	
	@Before
	public void initialize() {
		pos = 5;
		neg = -5;
	}
	
	@Test
	public void testPos() {
		assertEquals(5, Math.abs(pos));
	}
	
	@Test
	public void testNeg() {
		assertEquals(5, Math.abs(neg));
	}
	
	@Test
	public void testMax() {
		assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MAX_VALUE));
	}
	
	@Test
	public void testMin() {
		assertEquals(Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));
	}
	
	
}
