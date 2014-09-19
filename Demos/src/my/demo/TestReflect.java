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


//���䣺�����࣬�����ʳ��� ��  �ĸ�����ɲ��֡�
//�õ�Class������ĳ������ֽ��� forName(String className)
//�õ�����ֽ���Class�����ַ��� new Person().getClass();Class.forName("");Person.class;
//getConstruct();���ʳ�public�Ĺ��캯��
//getDeclaredConstruct();�õ�private�Ĺ��캯��
//������ã���ܻ��������ļ�

//java����Զ���Method
public class TestReflect
{
	private String s = null;
	public String name = null;
	public TestReflect()
	{
		System.out.println("construct 1 !");
	}
	
//˽�й��캯����ֻ�ܱ���ʹ�ã����ⲿ�޷��øù��캯��new �����;��������ģʽʱ��������ô��
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
			cla = Class.forName("my.demo.P");//��\�Ҳ���class�ļ�;���ϰ������� .  �ָ�
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
			d = cla.getMethod("display", int.class,String.class);//������������
			
			//����main���������䣬����Ϊ����ķ���ʱ��ҪС�ģ�
			m = cla.getMethod("main", String[].class);
			
			
			Field f = cla.getField("age");
			//f.setAccessible(true);//��˽���ֶ�
			Object obj = f.get(new P());//��ȡ�ֶε�ֵ ;�����ֶε�ֵ f.set(new P(),25);
			Type type = f.getType();//��ȡ�ֶε�����
			if(type.equals(int.class))
			{
				//����equals Integer.class
				int s = (int)obj;
				System.out.println("�ֶ�ת���ɹ��� " + s);
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
			//���䣬����Ϊ����ķ���ʱ��ҪС�ģ�
			//jdk1.5�ɱ����Ϊ�˼���jdk1.4�ַ������飬�����ַ�������ͻ������ֳ�һ�����ַ���"a","b"������
			//�ã�object�����Σ���ƭ������������Ϊ���ַ������飻
			//���� new Object(new String[]{"a","b"});
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
	
	//��ȡ�ֶΣ��ֶ�����
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
		//���÷�����ƴ��������
		//Class<?> c = null ;
		Class<?> c = Class.forName("my.demo.TestReflect");//���ϰ������� .  �ָ�
		//c = Class.forName("D:\\Workspace\\Demos\\src\\my\\demo\\TestReflect"); ����
		//c = Class.forName("Demos"+File.separator+"src"+File.separator+"my"+File.separator+"demo"+File.separator+"TestReflect");����
//	c = Class.forName("/Demos/src/my/demo/TestReflect");
		Constructor con1 = c.getConstructor();
		
		Class<?> info;
		try
		{
			
			info =c.getDeclaredField("s").getType();//˽�еģ�дgetField���쳣������getDeclaredField
			System.out.println(info);
		}
		catch (NoSuchFieldException e2)
		{
			e2.printStackTrace();
		}
		
		//���÷��似��,���ù��캯�����������
//Ҳ����class����ֱ��c.newInstance()ʵ�����Ƿ�������޲ι��캯�������Ա���Ҫ���޲ι��캯��
		try
		{
			TestReflect tf = (TestReflect)con1.newInstance();
		}
		catch (InstantiationException e1)
		{
			e1.printStackTrace();
		}
		Constructor con2 = c.getDeclaredConstructor(String.class);//˽�й��캯��������ͨ��������Ʒ���
		con2.setAccessible(true);//�������䣬�򿪷���Ȩ��
		try
		{
			TestReflect t1 = (TestReflect)con2.newInstance("aaa");
		}
		catch (InstantiationException e1)
		{
			e1.printStackTrace();
		}
		
		Method dis = c.getMethod("dis", null);
		dis.invoke(new TestReflect(), null);//���и÷�������һ������������һ������ָ�����øö���ķ���
		//��̬�����������ֱ�Ӵ�null�����������û����
		
		//c.getMethod("main", String[].class).invoke(null, new String[]{"a","b"});
		
		try
		{
			c.newInstance();//�����޲ι��캯�������䣻���Զ������вι��캯������ö���һ���޲ι��캯����
			//��Ч�ڣ�c.getConstruct().newInstance();
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
			Constructor<?> cs = c.getDeclaredConstructor(String.class);//"java����Ķ�������һ����" int.class
			//cs.setAccessible(true);//�������䣬ǿ�ƣ�����������Ҳ����ʹ��˽�й��캯��new������
			
			try
			{
				TestReflect tf =  (TestReflect) cs.newInstance("abc");//����������;��Ϊ����
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
