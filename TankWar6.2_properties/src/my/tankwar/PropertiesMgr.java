package my.tankwar;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr
{
	public static Properties p = new Properties();
	static
	{
		try
		{
			p.load(PropertiesMgr.class.getResourceAsStream("config/tank.properties"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//为了防止new PropertiesMgr;构造函数改成私有的
	private PropertiesMgr(){}
	
	public static String getProperties(String key)
	{
		return p.getProperty(key);
	}
}
