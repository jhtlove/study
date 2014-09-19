package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.*;//Ϊɶ����ʶ�ˣ�
import org.apache.commons.logging.*;


public class Demo1
{
	//��map���ϵ�ֵ��䵽bean��;map��key��bean ��������һ��
	//Ϊ�������ַ������Ƶ�bean��Date���͵�birthday�У���Ҫ��ǰע��ת����
	public void test1()
	{
		Map<String,String> m = new HashMap<String,String>();
		m.put("name", "����");
		m.put("age","15" );
		m.put("birthday", "1999-09-09");
		m.put("pwd", "aa134");
		User u = new User();
		
		//Ϊ�������ַ������Ƶ�bean��birthday�У���beanutilsע��һ��ת����
//Register a custom Converter for the specified destination Class, replacing any previously registered Converter.
		//��new�ӿڡ����ڲ��ࣩ��ʱ��ʵ�����з���
		ConvertUtils.register(new Converter(){

			@Override
			public <T> T convert(Class<T> type, Object value)
			{
				if(!(value instanceof String))
				{
					
				}
				else
				{
					String s = ((String)value).trim();//ȥ���ַ���ǰ��ո񣬷�ֹ��һ����   ��ȥת��������
					if(s == null) return null;
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try
					{
						return (T) df.parse(s);
					}
					catch (ParseException e)
					{
						new RuntimeException(e);//�쳣�����ܶϣ���ԭ���쳣��Ϣe��װ��ȥ
					}
				}
				return null;
			}
			
		}, Date.class);
		
		try
		{
			BeanUtils.populate(u, m);//populate ��ֲ
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		//�ӱ��õ������ݣ������ַ���
		String name = "Tom";
		String pwd = "123";
		String birthday = "1990-6-25";
		String age = "22";
		User u = new User();
		
		//text����
		//y	Year	Year	1996; 96
		//Y	Week year	Year	2009; 09
		//D	Day in year	Number	189
		//d	Day in month	Number	10
		//���ӣ� "yyyy.MM.dd G 'at' HH:mm:ss z" ����� 2001.07.04 AD at 12:08:56 PDT
		SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-DD");
//System.out.println(null instanceof String);//false;��ֵ����string����
		try
		{
			BeanUtils.getProperty(u, "name");
			//age��String��bean����int��ֻ֧��8�л������������Զ�ת��
			BeanUtils.setProperty(u, "age", age);
			System.out.println(u.getBirthday());
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
	}

}
