package generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TestGeneric
{
	@Test
	public void test1()
	{
		Map<String,Integer> m = new HashMap<String,Integer>();
		m.put("aaa", 1);//自动装箱, new Integer(1);集合中只存应用数据类型
		m.put("key", 234);
		m.put("b", 999);
		
//Map.Entry（Interface Map.Entry<K,V>）;增强for循环只能对数组和实现了Iterator接口的，因为map没有实现iterator接口，先把map转成entrySet()（keySet()方法用的较之少）集合，对set集合迭代,集合每个元素是一个Map,Entry
		Iterator<Entry<String, Integer>> it = m.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String, Integer> e = it.next();
			//打印顺序与装入顺序不一致，因为是HashMap，使用LinkedHashMap就可以保持一致（购物车）
			System.out.println(e.getKey() + "--" + e.getValue());
		}
		
		//增强for循环
		for(Entry<String,Integer>e : m.entrySet())
		{
			System.out.println(e.getKey() + "----" + e.getValue());
		}
	}
	
	public static void main(String[] args)
	{
		
	}

}
