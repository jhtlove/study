package my.demo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.JToolBar.Separator;

import org.junit.Test;


//反射：加载类，并解剖出来 类  的各个组成部分。
//得到Class，代表某个类的字节码 forName(String className)
//得到类的字节码Class的三种方法 new Person().getClass();Class.forName("");Person.class;
//getConstruct();解剖出public的构造函数
//getDeclaredConstruct();得到private的构造函数
//做框架用，框架基于配置文件

//java万物皆对象；Method
public class TestReflect
{
	private String s = null;
	public String name = null;
	public TestReflect()
	{
		System.out.println("construct 1 !");
	}
	
//私有构造函数，只能本地使用，让外部无法用该构造函数new 类对象;构建单例模式时，可以这么做
	private TestReflect(String s)
	{
		System.out.println("Construct 2 !");
	}
	
	private TestReflect(String s,int i,ArrayList[] arr)
	{
		System.out.println("Construct 3 !");
	}
	
	public void dis()
	{
		System.out.println("dis");
	}

	@Test
	public static void test1() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		P p = new P();
		Class<?> cla = null;
		try
		{
			cla = Class.forName("my.demo.P");//用\找不到class文件;加上包名，用 .  分隔
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Class Not Found!");
			e.printStackTrace();
		}
		Method d = null;
		Method m = null;
		try
		{
			d = cla.getMethod("display", int.class,String.class);//方法名，参数
			
			//反射main方法，反射，参数为数组的方法时候，要小心！
			m = cla.getMethod("main", String[].class);
			
			
			Field f = cla.getField("age");
			//f.setAccessible(true);//对私有字段
			Object obj = f.get(new P());//获取字段的值 ;设置字段的值 f.set(new P(),25);
			Type type = f.getType();//获取字段的类型
			if(type.equals(int.class))
			{
				//不能equals Integer.class
				int s = (int)obj;
				System.out.println("字段转换成功： " + s);
			}
		}
		catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			d.invoke(p, 1,"abc");
			//反射，参数为数组的方法时候，要小心！
			//jdk1.5可变参数为了兼容jdk1.4字符串数组，遇到字符串数组就会把它拆分成一个个字符串"a","b"参数；
			//用（object）修饰，欺骗它，不让它以为是字符串数组；
			//或者 new Object(new String[]{"a","b"});
			String ss[] = {"abc","e"};
			m.invoke(null, (Object)new String[]{"a","b"});
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
	
	//获取字段，字段类型
	public void test2()
	{
		Class cla = null;
		try
		{
			cla = Class.forName("my.demo.TestReflect");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			cla.getField("name");
			cla.getDeclaredField("s");
		}
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException
	{
		try
		{
			test1();
		}
		catch (NoSuchFieldException e1)
		{
			e1.printStackTrace();
		}
		//利用反射机制创建类对象
		//Class<?> c = null ;
		Class<?> c = Class.forName("my.demo.TestReflect");//加上包名，用 .  分隔
		//c = Class.forName("D:\\Workspace\\Demos\\src\\my\\demo\\TestReflect"); 不对
		//c = Class.forName("Demos"+File.separator+"src"+File.separator+"my"+File.separator+"demo"+File.separator+"TestReflect");不对
//	c = Class.forName("/Demos/src/my/demo/TestReflect");
		Constructor con1 = c.getConstructor();
		
		Class<?> info;
		try
		{
			
			info =c.getDeclaredField("s").getType();//私有的，写getField出异常，必须getDeclaredField
			System.out.println(info);
		}
		catch (NoSuchFieldException e2)
		{
			e2.printStackTrace();
		}
		
		//利用反射技术,调用构造函数创建类对象；
//也可用class对象，直接c.newInstance()实际上是反射类的无参构造函数，所以必须要有无参构造函数
		try
		{
			TestReflect tf = (TestReflect)con1.newInstance();
		}
		catch (InstantiationException e1)
		{
			e1.printStackTrace();
		}
		Constructor con2 = c.getDeclaredConstructor(String.class);//私有构造函数，可以通过反射机制访问
		con2.setAccessible(true);//暴力反射，打开访问权限
		try
		{
			TestReflect t1 = (TestReflect)con2.newInstance("aaa");
		}
		catch (InstantiationException e1)
		{
			e1.printStackTrace();
		}
		
		Method dis = c.getMethod("dis", null);
		dis.invoke(new TestReflect(), null);//运行该方法，第一个参数，传递一个对象，指定调用该对象的方法
		//静态方法无需对象，直接传null，传对象更加没问题
		
		//c.getMethod("main", String[].class).invoke(null, new String[]{"a","b"});
		
		try
		{
			c.newInstance();//利用无参构造函数，反射；所以定义了有参构造函数，最好定义一个无参构造函数！
			//等效于：c.getConstruct().newInstance();
		}
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			Constructor<?> cs = c.getDeclaredConstructor(String.class);//"java里面的东西都是一个类" int.class
			//cs.setAccessible(true);//暴力反射，强制，在其他类中也可以使用私有构造函数new出对象
			
			try
			{
				TestReflect tf =  (TestReflect) cs.newInstance("abc");//创建出对象;因为是在
				tf.dis();
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
			
		}
	}

}
