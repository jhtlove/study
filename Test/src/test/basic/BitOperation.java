package test.basic;

import org.junit.Test;

public class BitOperation
{
	@Test
	public void test()
	{
	    int i = -100;//打印出来的二进制，是补码
	    int j = 111;
	    String binStr=Integer.toBinaryString(i);  
//	    String otcStr=Integer.toOctalString(i);  
//	    String hexStr=Integer.toHexString(i); 
	    System.out.println("100 = " + Integer.toBinaryString(100) + " B"); 
	    System.out.println("i = " + binStr + " B"); 
	    System.out.println("j = " + Integer.toBinaryString(j) + " B"); 
//	    System.out.println(otcStr + "O");  
//	    System.out.println(hexStr + "H");
	    System.out.println(" i ^ j = " + Integer.toBinaryString(i ^ j));
	    System.out.println(Integer.toBinaryString(i >> 2));
	    System.out.println(Integer.toBinaryString(i << 2));
	    System.out.println(Integer.toBinaryString(i >>>3));
	    System.out.println(Integer.toBinaryString(i & j));
	    System.out.println(Integer.toBinaryString(i | j));
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
