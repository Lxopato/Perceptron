package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

import perc.*;

public class PerceptronTest {
	private Perceptron and;
	private Perceptron or;
	private Perceptron nand;
	private Perceptron x1;
	private Perceptron x2;
	private Perceptron carry;
	private Perceptron sum;
	private Perceptron mid;
	
	
	@Before
	public void setUp(){
		and = new Perceptron();
		or = new Perceptron();
		nand = new Perceptron();
		x1 = new Perceptron();
		x2 = new Perceptron();
		carry = new Perceptron();
		sum = new Perceptron();
		mid = new Perceptron();
		
		
	}
	/**
	 * Test for an AND Perceptron 
	 * @throws IOException
	 */
	@Test
	public void AND() throws IOException {
		and.setWeights(5, 5);
		and.setBias(-9);
		
		assertEquals(0,and.feed(0, 0));
		
		assertEquals(0,and.feed(1, 0));
		
		assertEquals(0,and.feed(0, 1));
		
		assertEquals(1,and.feed(1, 1));
		
	}
	/**
	 * Test for a NAND Perceptron
	 * @throws IOException
	 */
	@Test
	public void NAND() throws IOException{
		nand.setWeights(-5, -5);
		nand.setBias(9);
		
		assertEquals(1,nand.feed(0, 0));
		
		assertEquals(1,nand.feed(1, 0));
		
		assertEquals(1,nand.feed(0, 1));
		
		assertEquals(0,nand.feed(1, 1));
	}
	/**
	 * Test for an OR Perceptron
	 * @throws IOException
	 */
	@Test
	public void OR() throws IOException{
		or.setWeights(5, 5);
		or.setBias(-4);
		
		assertEquals(0,or.feed(0, 0));
		
		assertEquals(1,or.feed(1, 0));
		
		assertEquals(1,or.feed(0, 1));
		
		assertEquals(1,or.feed(1, 1));
	}
	/**
	 * Test for the implementation of a bit sum gate, it will sum two ones.
	 * The different gates names are shown in the attached image.   
	 * @throws IOException
	 */
	@Test
	public void Sum() throws IOException{
		int a = 1;
		int b = 1;
		mid.setWeights(-1, -1); mid.setBias(2);
		x1.setWeights(-1,-1); x1.setBias(2);
		x2.setWeights(-1, -1); x2.setBias(2);
		carry.setWeights(-1, -1); carry.setBias(2);
		sum.setWeights(-1, -1); sum.setBias(2);
		
		//Result for the sum gate
		assertEquals(0,sum.feed(x1.feed(a, mid.feed(a, b)), x2.feed(mid.feed(a, b), b)));
		
		//Result for the carry gate
		assertEquals(1,carry.feed(mid.feed(a, b), mid.feed(a, b)));
	}
}
