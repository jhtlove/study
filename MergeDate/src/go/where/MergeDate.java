package go.where;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

//一条记录
class DateRecord
{
	String info;// 原信息
	String inDate;// string的话，好处理吗？还是拆分成年月日？
	String outDate;
	int price;

	DateRecord()
	{
		price = 0;
	}

	DateRecord(String info)
	{
		
		this.info = info.trim();
		if ("".equals(this.info) || this.info.equals(null))
			return;
		this.inDate = this.info.split("～")[0];
		this.outDate = this.info.split("～")[1].split("\\s{1,}")[0];//两个空格就分不出来了！？请用正则表达式！
//System.out.println("price:" + this.info.split("～")[1].split("\\s{1,}")[1]);
		this.price = Integer.parseInt(this.info.split("～")[1].split("\\s{1,}")[1]);
	}

	DateRecord(String inDate, String outDate, int price)
	{
		this.inDate = inDate;
		this.outDate = outDate;
		this.price = price;
		this.info = inDate + "～" + outDate + " " + price;
	}

	public void display()
	{
		System.out.println("info: " + info + ", inDate: " + inDate
				+ " outDate: " + outDate + " price: " + price);
	}

}

public class MergeDate
{
	// 定义成DateRecord类型的数组，或者定义成集合，哪个好呢？
	private ArrayList<DateRecord> allInfo = new ArrayList<DateRecord>();// 保存所有原条目
	private ArrayList<DateRecord> mergedInfo = new ArrayList<DateRecord>();// 已合并好的，有序的，条目

	//读取txt文件中的记录数据，一条一条地保存到allInfo集合中
	public void readDate()
	{
		String filePath = "D:" + File.separator + "Workspace" + File.separator
				+ "HotelDataTest.txt";
//System.out.println(filePath);
		FileReader fr = null;
		BufferedReader br = null;
		try
		{
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String s = null;// 文档以不同的编码格式保存，读出来的效果就不一样，ANSI的打印正常
			while ((s = br.readLine()) != null)
			{
				if(!"".equals(s))
				{
					DateRecord dr = new DateRecord(s);
//dr.display();//打印记录
					allInfo.add(dr);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(br!=null)
				{
					br.close();
				}
				if(fr!=null)
				{
					fr.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
	}
	//a,b升序排列，最后也升序排列
	public ArrayList<DateRecord> merge(ArrayList<DateRecord> arr,int left,int right)
	{
		//left == right一个元素，不用合并了
		if(left < right)
		{
			//只复制该次待合并的元素行不行？ 行，就是在b上移动的下标有所改变，每次都是从0开始
			ArrayList<DateRecord> b = new ArrayList<DateRecord>();
			for(int i=left;i<=right;i++)
			{
				b.add(arr.get(i));
			}
			int l = 0;
			int r = b.size()-1;//记录右边界
			int mid = (0 + r) / 2;//记录左边界
			int m = mid + 1;//后半段，起始位置要定对
			int k = left;//k是此次arr上待合并元素的起始位置，不是每次都从0开始！
			while(l <= mid && m <= r)
			{
				//有等于，优先取前半段中的，所以排序是稳定的
				if(b.get(l).inDate.compareTo(b.get(m).inDate) <= 0)
				{
					arr.set(k, b.get(l));
					l++;
				}
				else
				{
					arr.set(k, b.get(m));
					m++;
				}
				k++;
			}
			while(l <= mid)
			{
				arr.set(k, b.get(l));
				l++;
				k++;
			}
			while(m <= r)
			{
				arr.set(k, b.get(m));
				m++;
				k++;
			}
		}
		return arr;//引用，改变了传进来的数组arr上的元素排序
		
	}
		
	public void mergeSort(ArrayList<DateRecord> arr,int head,int tail)
	{
		if(head < tail)
		{
			int mid = (head + tail) / 2;
			mergeSort(arr,head,mid);
			mergeSort(arr,mid+1,tail);
			merge(arr,head,tail);
		}
	}




	// 一条条记录合并,而不是在所有时间点上合并,所有时间点，就失去了成对pair信息;
	// 合并，移除旧的，添加新的
	//从mergedInfo取rec1，从allInfo取rec2,只合并两个会相互产生影响的记录，相邻不等价的不予考虑
	//每次合并添加到add最后，会乱序，mergedInfo需要排序
	//合并后价格受影响，按照原始数据中后来的记录rec2来定价！所以要以rec2的inDate或outDate为分割点
	public void mergeTwoRecord(DateRecord rec1, DateRecord rec2)
	{
//		boolean noeffect = false;//rec2对rec1有影响？
		String s1 = null;
		String s2 = null;
		String d1 = null;
		String d2 = null;
		boolean changed = false;
		//当rec1 在前头，这样定义四个点的位置
		if(rec1.inDate.compareTo(rec2.inDate) <= 0)
		{
			s1 = rec1.inDate;
			d1 = rec1.outDate;
			s2 = rec2.inDate;//分割点
			d2 = rec2.outDate;//分割点
		}
		else
		{
			s1 = rec2.inDate;//分割点
			d1 = rec2.outDate;//分割点
			s2 = rec1.inDate;
			d2 = rec1.outDate;
			changed = true;
		}
		if (rec1.price == rec2.price)
		{
			DateRecord temp = new DateRecord(s1,d1.compareTo(d2) > 0 ? d1 : d2,rec1.price);
			
			mergedInfo.add(temp);
			return;
		}
		//价格不同
		else
		{
			if (s1.compareTo(s2) == 0 && d1.compareTo(d2) <= 0)
			{
				// rec2完全覆盖掉rec1，不能把rec1变成：1到1，没有rec1了
				mergedInfo.add(rec2);
			}
			else if (d1.compareTo(d2) <= 0)
			{
				// 部分覆盖，覆盖rec1的后半段，中间部分重合，分出两段
				DateRecord temp1 = null;
				DateRecord temp2 = null;
				if(!changed)
				{
					temp1 = new DateRecord(s1, s2,rec1.price);
					temp2 = new DateRecord(s2, d2, rec2.price);
				}
				else
				{
					temp1 = new DateRecord(s1, d1,rec2.price);
					temp2 = new DateRecord(d1, d2, rec1.price);
				}
				mergedInfo.add(temp1);
				mergedInfo.add(temp2);
			}
			else
			{
				// 只覆盖rec1的中部，分隔成三段
				DateRecord temp1 = null;
				DateRecord temp3 = null;
				if(!changed)
				{
					temp1 = new DateRecord(s1, s2,rec1.price);
					temp3 = new DateRecord(d2, d1, rec1.price);
					mergedInfo.add(temp1);
					mergedInfo.add(rec2);
					mergedInfo.add(temp3);
				}
				else
				{
					mergedInfo.remove(rec1);
					mergedInfo.add(rec2);
				}
			}
		}
	}

	// 合并记录以及合并好的起始时间段，即使中间有空白段
	// 合并所有的，每个都作用一次？段与段直接如何合并？-
	public void mergeAllDate()
	{
		if (allInfo.size() == 0)
			return;
//mergeSort(allInfo);排序的话，违背“后面录入的为准”的规则
		DateRecord rec2 = allInfo.get(0);
		mergedInfo.add(rec2);
		allInfo.remove(rec2);
		DateRecord rec1 = null;
		int i = 0;
		String s1 = null;
		String s2 = null;
		String d1 = null;
		String d2 = null;
		ArrayList<DateRecord> effectedRecords = new ArrayList<DateRecord>();//记录哪些受影响而合并，原数据就要移除
		
		//一个个从allInfo拿出来，与mergedInfo集合去合并
		while(allInfo.size()>0)
		{
			rec2 = allInfo.get(0);//拿排好序的第一个
			boolean effected = false;
			int currentSize = mergedInfo.size();
			
			for(i=0;i<currentSize;i++)
			{
				rec1 = mergedInfo.get(i);
				//不能保证rec1,rec2升序
				//当rec1 在前头，这样定义四个点的位置
				if(rec1.inDate.compareTo(rec2.inDate) <= 0)
				{
					s1 = rec1.inDate;
					d1 = rec1.outDate;
					s2 = rec2.inDate;//分割点
					d2 = rec2.outDate;//分割点
				}
				else
				{
					s1 = rec2.inDate;//分割点
					d1 = rec2.outDate;//分割点
					s2 = rec1.inDate;
					d2 = rec1.outDate;
				}
				//判断两个线段是否有交集，s1是 <= s2的
				if(s2.compareTo(d1) < 0 || (s2.compareTo(d1) == 0 && rec1.price == rec2.price))
				{
//System.out.println("本次合并" + rec1.info + ",   " + rec2.info);
					//只合并受影响的,与之相交的、相邻且同价的的
					mergeTwoRecord(rec1,rec2);

					effected = true;
					effectedRecords.add(rec1);
				}
				
			}
			//如果和之前记录都没有影响，直接添加
			if(effected == false)
			{
				mergedInfo.add(rec1);
			}
			else
			{
				mergedInfo.removeAll(effectedRecords);
				effectedRecords.clear();//清空记录
			}
			allInfo.remove(0); //allInfo.remove(rec2);

			mergeSort(mergedInfo,0,mergedInfo.size()-1);//每次的合并都add到最后，会乱序，mergedInfo需要排序.
			//但是如果这里进行了排序，后面新添加的有可能排到前面，0到currentSize标示新的带毕竟的数据

			
			//排序后，剔除相邻的重复的
			for(int j=0;j<mergedInfo.size()-1;j++)
			{
				DateRecord r1 = mergedInfo.get(j);
				DateRecord r2 = mergedInfo.get(j+1);
				if(r1.inDate==r2.inDate&&r1.outDate==r2.outDate)
				{
					mergedInfo.remove(r1);
					j = 0;//移除一个，又从头开始检查
				}
			}
//System.out.println("本次合并后的mergedInfo：");
//displayInfo(mergedInfo);
		}
		
	}

	public void displayInfo(ArrayList<DateRecord> arr)
	{
		if(arr.size()==0)return;
		Iterator<DateRecord> it = arr.iterator();
		DateRecord rec = null;
		//
		while (it.hasNext())
		{
			rec = it.next();
			System.out.println(rec.info);//打印合并后的记录到控制台
		}
	}

	public static void main(String[] args)
	{
		MergeDate instance = new MergeDate();
		instance.readDate();
		System.out.println("  处理前数据：");
		instance.displayInfo(instance.allInfo);
		instance.mergeAllDate();
		System.out.println("  处理后数据：");
		instance.displayInfo(instance.mergedInfo);
	}

}
