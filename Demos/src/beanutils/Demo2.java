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
//System.out.println("".equals(null));//false,���ַ������ǿ�ֵ��null����ն���δ������ڴ�ռ�
		
		//Apache����õ�Converter����׳�Բ�������bug�������Լ����ֶ���converter
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
