package test.basic;

public class Test_D_Prime
{

	
	    public Test_D_Prime(){}
	    
	    public void fengjie(int n)
	    {
	        for(int i=2;i<=n/2;i++)
	        {
	            if(n%i == 0)
	            {
	                System.out.print(i + "*");
	                fengjie(n/i);
	             }
	        }
	        System.out.print(n);
	        System.exit(0);//��������䣬�����������
	    }
	        public static void main(String[] args)
	        {
	             String str="";
	             Test_D_Prime c=new Test_D_Prime();
	             str=javax.swing.JOptionPane.showInputDialog("������N��ֵ������exit�˳�����");
	             int N = 0;
	             try{
	                     N = Integer.parseInt(str);
	                 }catch(NumberFormatException e)
	                 {
	                         e.printStackTrace();
	                 }
	            System.out.print(N + "�ֽ���������" + N + "=");
	            c.fengjie(N);
	        }    
	}


