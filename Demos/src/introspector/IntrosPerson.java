package introspector;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;

public class IntrosPerson
{

	public static void main(String[] args) throws IntrospectionException
	{
		BeanInfo bif = Introspector.getBeanInfo(Person.class);
		Introspector.getBeanInfo(Person.class, Object.class);//剁掉父类集成的属性—— class，只保留自己特有的属性
		
		PropertyDescriptor dis[] = bif.getPropertyDescriptors();//属性描述器
		PropertyDescriptor d = new PropertyDescriptor("age",Person.class);//拿到age属性的描述器
		Person p = new Person();
		try
		{
			
			d.getWriteMethod().invoke(p, 20);
			System.out.println(d.getReadMethod().invoke(p, null));
		}
		catch (IllegalAccessException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IllegalArgumentException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (InvocationTargetException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(PropertyDescriptor ps:dis)
		{
			String name = ps.getName();
			System.out.print(name + " ");
			try
			{
				//getReadMethod()拿到属性的读方法
				System.out.print("属性值： " + ps.getReadMethod().invoke(p, null));
				System.out.println(" 属性类型：" + ps.getPropertyType());
			}
			catch (IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IllegalArgumentException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (InvocationTargetException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}