package introspector;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;

public class IntrosPerson
{

	public static void main(String[] args) throws IntrospectionException
	{
		BeanInfo bif = Introspector.getBeanInfo(Person.class);
		Introspector.getBeanInfo(Person.class, Object.class);//������༯�ɵ����ԡ��� class��ֻ�����Լ����е�����
		
		PropertyDescriptor dis[] = bif.getPropertyDescriptors();//����������
		PropertyDescriptor d = new PropertyDescriptor("age",Person.class);//�õ�age���Ե�������
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
				//getReadMethod()�õ����ԵĶ�����
				System.out.print("����ֵ�� " + ps.getReadMethod().invoke(p, null));
				System.out.println(" �������ͣ�" + ps.getPropertyType());
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