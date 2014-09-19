package go.where;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

//һ����¼
class DateRecord
{
	String info;// ԭ��Ϣ
	String inDate;// string�Ļ����ô����𣿻��ǲ�ֳ������գ�
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
		this.inDate = this.info.split("��")[0];
		this.outDate = this.info.split("��")[1].split("\\s{1,}")[0];//�����ո�ͷֲ������ˣ�������������ʽ��
//System.out.println("price:" + this.info.split("��")[1].split("\\s{1,}")[1]);
		this.price = Integer.parseInt(this.info.split("��")[1].split("\\s{1,}")[1]);
	}

	DateRecord(String inDate, String outDate, int price)
	{
		this.inDate = inDate;
		this.outDate = outDate;
		this.price = price;
		this.info = inDate + "��" + outDate + " " + price;
	}

	public void display()
	{
		System.out.println("info: " + info + ", inDate: " + inDate
				+ " outDate: " + outDate + " price: " + price);
	}

}

public class MergeDate
{
	// �����DateRecord���͵����飬���߶���ɼ��ϣ��ĸ����أ�
	private ArrayList<DateRecord> allInfo = new ArrayList<DateRecord>();// ��������ԭ��Ŀ
	private ArrayList<DateRecord> mergedInfo = new ArrayList<DateRecord>();// �Ѻϲ��õģ�����ģ���Ŀ

	//��ȡtxt�ļ��еļ�¼���ݣ�һ��һ���ر��浽allInfo������
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
			String s = null;// �ĵ��Բ�ͬ�ı����ʽ���棬��������Ч���Ͳ�һ����ANSI�Ĵ�ӡ����
			while ((s = br.readLine()) != null)
			{
				if(!"".equals(s))
				{
					DateRecord dr = new DateRecord(s);
//dr.display();//��ӡ��¼
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
	//a,b�������У����Ҳ��������
	public ArrayList<DateRecord> merge(ArrayList<DateRecord> arr,int left,int right)
	{
		//left == rightһ��Ԫ�أ����úϲ���
		if(left < right)
		{
			//ֻ���Ƹôδ��ϲ���Ԫ���в��У� �У�������b���ƶ����±������ı䣬ÿ�ζ��Ǵ�0��ʼ
			ArrayList<DateRecord> b = new ArrayList<DateRecord>();
			for(int i=left;i<=right;i++)
			{
				b.add(arr.get(i));
			}
			int l = 0;
			int r = b.size()-1;//��¼�ұ߽�
			int mid = (0 + r) / 2;//��¼��߽�
			int m = mid + 1;//���Σ���ʼλ��Ҫ����
			int k = left;//k�Ǵ˴�arr�ϴ��ϲ�Ԫ�ص���ʼλ�ã�����ÿ�ζ���0��ʼ��
			while(l <= mid && m <= r)
			{
				//�е��ڣ�����ȡǰ����еģ������������ȶ���
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
		return arr;//���ã��ı��˴�����������arr�ϵ�Ԫ������
		
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




	// һ������¼�ϲ�,������������ʱ����Ϻϲ�,����ʱ��㣬��ʧȥ�˳ɶ�pair��Ϣ;
	// �ϲ����Ƴ��ɵģ�����µ�
	//��mergedInfoȡrec1����allInfoȡrec2,ֻ�ϲ��������໥����Ӱ��ļ�¼�����ڲ��ȼ۵Ĳ��迼��
	//ÿ�κϲ���ӵ�add��󣬻�����mergedInfo��Ҫ����
	//�ϲ���۸���Ӱ�죬����ԭʼ�����к����ļ�¼rec2�����ۣ�����Ҫ��rec2��inDate��outDateΪ�ָ��
	public void mergeTwoRecord(DateRecord rec1, DateRecord rec2)
	{
//		boolean noeffect = false;//rec2��rec1��Ӱ�죿
		String s1 = null;
		String s2 = null;
		String d1 = null;
		String d2 = null;
		boolean changed = false;
		//��rec1 ��ǰͷ�����������ĸ����λ��
		if(rec1.inDate.compareTo(rec2.inDate) <= 0)
		{
			s1 = rec1.inDate;
			d1 = rec1.outDate;
			s2 = rec2.inDate;//�ָ��
			d2 = rec2.outDate;//�ָ��
		}
		else
		{
			s1 = rec2.inDate;//�ָ��
			d1 = rec2.outDate;//�ָ��
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
		//�۸�ͬ
		else
		{
			if (s1.compareTo(s2) == 0 && d1.compareTo(d2) <= 0)
			{
				// rec2��ȫ���ǵ�rec1�����ܰ�rec1��ɣ�1��1��û��rec1��
				mergedInfo.add(rec2);
			}
			else if (d1.compareTo(d2) <= 0)
			{
				// ���ָ��ǣ�����rec1�ĺ��Σ��м䲿���غϣ��ֳ�����
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
				// ֻ����rec1���в����ָ�������
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

	// �ϲ���¼�Լ��ϲ��õ���ʼʱ��Σ���ʹ�м��пհ׶�
	// �ϲ����еģ�ÿ��������һ�Σ������ֱ����κϲ���-
	public void mergeAllDate()
	{
		if (allInfo.size() == 0)
			return;
//mergeSort(allInfo);����Ļ���Υ��������¼���Ϊ׼���Ĺ���
		DateRecord rec2 = allInfo.get(0);
		mergedInfo.add(rec2);
		allInfo.remove(rec2);
		DateRecord rec1 = null;
		int i = 0;
		String s1 = null;
		String s2 = null;
		String d1 = null;
		String d2 = null;
		ArrayList<DateRecord> effectedRecords = new ArrayList<DateRecord>();//��¼��Щ��Ӱ����ϲ���ԭ���ݾ�Ҫ�Ƴ�
		
		//һ������allInfo�ó�������mergedInfo����ȥ�ϲ�
		while(allInfo.size()>0)
		{
			rec2 = allInfo.get(0);//���ź���ĵ�һ��
			boolean effected = false;
			int currentSize = mergedInfo.size();
			
			for(i=0;i<currentSize;i++)
			{
				rec1 = mergedInfo.get(i);
				//���ܱ�֤rec1,rec2����
				//��rec1 ��ǰͷ�����������ĸ����λ��
				if(rec1.inDate.compareTo(rec2.inDate) <= 0)
				{
					s1 = rec1.inDate;
					d1 = rec1.outDate;
					s2 = rec2.inDate;//�ָ��
					d2 = rec2.outDate;//�ָ��
				}
				else
				{
					s1 = rec2.inDate;//�ָ��
					d1 = rec2.outDate;//�ָ��
					s2 = rec1.inDate;
					d2 = rec1.outDate;
				}
				//�ж������߶��Ƿ��н�����s1�� <= s2��
				if(s2.compareTo(d1) < 0 || (s2.compareTo(d1) == 0 && rec1.price == rec2.price))
				{
//System.out.println("���κϲ�" + rec1.info + ",   " + rec2.info);
					//ֻ�ϲ���Ӱ���,��֮�ཻ�ġ�������ͬ�۵ĵ�
					mergeTwoRecord(rec1,rec2);

					effected = true;
					effectedRecords.add(rec1);
				}
				
			}
			//�����֮ǰ��¼��û��Ӱ�죬ֱ�����
			if(effected == false)
			{
				mergedInfo.add(rec1);
			}
			else
			{
				mergedInfo.removeAll(effectedRecords);
				effectedRecords.clear();//��ռ�¼
			}
			allInfo.remove(0); //allInfo.remove(rec2);

			mergeSort(mergedInfo,0,mergedInfo.size()-1);//ÿ�εĺϲ���add����󣬻�����mergedInfo��Ҫ����.
			//�������������������򣬺�������ӵ��п����ŵ�ǰ�棬0��currentSize��ʾ�µĴ��Ͼ�������

			
			//������޳����ڵ��ظ���
			for(int j=0;j<mergedInfo.size()-1;j++)
			{
				DateRecord r1 = mergedInfo.get(j);
				DateRecord r2 = mergedInfo.get(j+1);
				if(r1.inDate==r2.inDate&&r1.outDate==r2.outDate)
				{
					mergedInfo.remove(r1);
					j = 0;//�Ƴ�һ�����ִ�ͷ��ʼ���
				}
			}
//System.out.println("���κϲ����mergedInfo��");
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
			System.out.println(rec.info);//��ӡ�ϲ���ļ�¼������̨
		}
	}

	public static void main(String[] args)
	{
		MergeDate instance = new MergeDate();
		instance.readDate();
		System.out.println("  ����ǰ���ݣ�");
		instance.displayInfo(instance.allInfo);
		instance.mergeAllDate();
		System.out.println("  ��������ݣ�");
		instance.displayInfo(instance.mergedInfo);
	}

}
