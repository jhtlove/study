package my.demo;

import static java.lang.System.out;//��̬����

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * Junit�����������򣬷������ȴ�ӡ����ģ�ִ��˳��
 * Before
 * ����
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
		//��ǿforѭ�������ڼ��ϡ�������ȡֵ���������ı����е�ֵ
		for(String str : arr)
		{
			out.println(str);//��̬Ӧ���ˣ�ֱ����out��������������ɶ����½�������ʹ��
		}
	}
	
	public int test2(int a)
	{
		return a;
	}
	
	@Test
	public void test3()
	{
		Assert.assertEquals(5, test2(5));//����
		System.out.println("���ԣ�"  );
	}
	
	//�ɱ����,������������
	public void test(int ...num)
	{
		
	}
	
	@After
	public void after()
	{
		System.out.println("after");
	}
}
