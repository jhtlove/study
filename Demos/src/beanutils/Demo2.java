package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class Demo2
{
	@Test
	public void test()
	{
		User u = new User();
		String bir = "";
//System.out.println("".equals(null));//false,空字符串不是空值；null代表空对象，未分配对内存空间
		
		//Apache定义好的Converter，健壮性不够，有bug，可以自己动手定义converter
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try
		{
			BeanUtils.setProperty(u, "birthday", bir);
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
		
	}

}
