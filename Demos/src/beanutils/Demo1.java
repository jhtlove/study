package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.*;//为啥不认识了？
import org.apache.commons.logging.*;


public class Demo1
{
	//用map集合的值填充到bean中;map中key与bean 属性名称一致
	//为了能让字符串复制到bean中Date类型的birthday中，需要提前注册转换器
	public void test1()
	{
		Map<String,String> m = new HashMap<String,String>();
		m.put("name", "李四");
		m.put("age","15" );
		m.put("birthday", "1999-09-09");
		m.put("pwd", "aa134");
		User u = new User();
		
		//为了能让字符串复制到bean的birthday中，给beanutils注册一个转换器
//Register a custom Converter for the specified destination Class, replacing any previously registered Converter.
		//“new接口”（内部类）的时候，实现其中方法
		ConvertUtils.register(new Converter(){

			@Override
			public <T> T convert(Class<T> type, Object value)
			{
				if(!(value instanceof String))
				{
					
				}
				else
				{
					String s = ((String)value).trim();//去掉字符串前后空格，防止传一个“   ”去转换成日期
					if(s == null) return null;
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try
					{
						return (T) df.parse(s);
					}
					catch (ParseException e)
					{
						new RuntimeException(e);//异常链不能断，把原来异常信息e封装进去
					}
				}
				return null;
			}
			
		}, Date.class);
		
		try
		{
			BeanUtils.populate(u, m);//populate 移植
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
		//从表单拿到的数据，都是字符串
		String name = "Tom";
		String pwd = "123";
		String birthday = "1990-6-25";
		String age = "22";
		User u = new User();
		
		//text包中
		//y	Year	Year	1996; 96
		//Y	Week year	Year	2009; 09
		//D	Day in year	Number	189
		//d	Day in month	Number	10
		//例子： "yyyy.MM.dd G 'at' HH:mm:ss z" 结果： 2001.07.04 AD at 12:08:56 PDT
		SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-DD");
//System.out.println(null instanceof String);//false;空值不是string类型
		try
		{
			BeanUtils.getProperty(u, "name");
			//age是String而bean中是int，只支持8中基本数据类型自动转换
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
