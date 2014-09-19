/**
 * 
 */
package junit;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.junit.BeforeClass;

/**
 * @author Administrator
 * 
 */
public class JunitTestCase1 extends TestCase
{

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	public static int add(int a, int b)
	{
		return a + b;
	}

	// @Test
	public void testAdd()
	{
		// assert.assertEquals(expected, actual); ÊÇÊ²Ã´£¿
		assertEquals(5, JunitTestCase1.add(2, 3));
	}

	// @Test
	// public void test()
	// {
	// fail("Not yet implemented");
	// }

	public static void main(String args[])
	{

		TestRunner.run(JunitTestCase1.class);
	}
}
