package recursion;

public class HanTower
{
	//��a���ĵ�һ���ķŵ�c��
	public void put(String a,String c)
	{
		System.out.println("��" + a + "�����ϵ�һ���ƶ���" + c + "������" );
	}
	//��ŵ���߶�height����A�Ƶ�C������B
	public void move(int height,String a,String b ,String c)
	{
		if(height == 1) 
			put(a,c);
		else
		{
			move(height-1,a,c,b);//������������put��a,c�������ǰ�a��n-1����Ų��B�����ĸ��������ϣ�������C��
			put(a,c);//������µ�Ų��C��
			move(height-1,b,a,c);//��n-1����B����aŲ��C��
		}
		
	}
	
	public static void main(String[] args)
	{
		new HanTower().move(3, "A", "B", "C");
	}

}
