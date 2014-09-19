package my.demo;

import static java.lang.System.out;//静态引用

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * Junit运行整个程序，反倒是先打印后面的，执行顺序
 * Before
 * 断言
 * after
Before
aaa
bbb
ccc
after

 *
 */
public class Demo1
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		

	}
	
	@Before
	public void before()
	{
		System.out.println("Before");
	}
	
	@Test
	public void test1()
	{
		ArrayList <String> arr = new ArrayList<String>();
		arr.add("aaa");
		arr.add("bbb");
		arr.add("ccc");
		//增强for循环，限于集合、数组中取值，不用来改变其中的值
		for(String str : arr)
		{
			out.println(str);//静态应用了，直接用out，不过反倒代码可读性下降，较少使用
		}
	}
	
	public int test2(int a)
	{
		return a;
	}
	
	@Test
	public void test3()
	{
		Assert.assertEquals(5, test2(5));//断言
		System.out.println("断言："  );
	}
	
	//可变参数,把它看成数组
	public void test(int ...num)
	{
		
	}
	
	@After
	public void after()
	{
		System.out.println("after");
	}
}
