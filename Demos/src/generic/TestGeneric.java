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
		m.put("aaa", 1);//�Զ�װ��, new Integer(1);������ֻ��Ӧ����������
		m.put("key", 234);
		m.put("b", 999);
		
//Map.Entry��Interface Map.Entry<K,V>��;��ǿforѭ��ֻ�ܶ������ʵ����Iterator�ӿڵģ���Ϊmapû��ʵ��iterator�ӿڣ��Ȱ�mapת��entrySet()��keySet()�����õĽ�֮�٣����ϣ���set���ϵ���,����ÿ��Ԫ����һ��Map,Entry
		Iterator<Entry<String, Integer>> it = m.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String, Integer> e = it.next();
			//��ӡ˳����װ��˳��һ�£���Ϊ��HashMap��ʹ��LinkedHashMap�Ϳ��Ա���һ�£����ﳵ��
			System.out.println(e.getKey() + "--" + e.getValue());
		}
		
		//��ǿforѭ��
		for(Entry<String,Integer>e : m.entrySet())
		{
			System.out.println(e.getKey() + "----" + e.getValue());
		}
	}
	
	public static void main(String[] args)
	{
		
	}

}
