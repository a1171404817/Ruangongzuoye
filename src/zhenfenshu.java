import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.naming.InitialContext;


public class zhenfenshu {
	public  String init() throws IOException{
		

		 
			int[] fenziar= new int[10];
			for(int i=0;i<fenziar.length;i++)fenziar[i]=0;
			int[] fenmuar= new int[10];
			for(int i=0;i<fenmuar.length;i++)fenmuar[i]=0;
			int[] fsnum=new int[1];
			fsnum[0]=0;
			
			String[] fuhaoStrings=new String[10];
			int fuhaoStringsnum=0;
			
			for(int i=0;i<fuhaoStrings.length;i++)fuhaoStrings[i]="";
			
			
			 int nFuhao = ((int) (Math.random() * 10000))%3+3;//�������Ÿ���  

			 
			String fuhao[]={"+","-"};
			//���ɵ�һ�������
			
			String nFirstNumS=creatZhenfenshu(fenziar,fenmuar,fsnum);
			
 
			 
			 for(int j=0;j<nFuhao;j++)
			 { 
				 int fuhaoSuiji=((int) (Math.random() * 10000)%2);
				 
				 nFirstNumS+=fuhao[fuhaoSuiji];
				 fuhaoStrings[fuhaoStringsnum++]=fuhao[fuhaoSuiji];
				 nFirstNumS=nFirstNumS+creatZhenfenshu(fenziar,fenmuar,fsnum);
				 
//				 System.out.println("��"+j+"�֣�"+nFirstNumS+" "+fsnum[0]);
//					for(int i=0;i<fenziar.length;i++)
//					{
//						System.out.print(fenziar[i]+" ");
//					}
//					System.out.println();
//					for(int i=0;i<fenmuar.length;i++)
//					{
//						System.out.print(fenmuar[i]+" ");
//					}
//					for(int i=0;i<fuhaoStrings.length;i++)
//					{
//						System.out.print(fuhaoStrings[i]+" ");
//					}
					 String rs=new zhenfenshu().caculate(fenziar, fenmuar, fuhaoStrings, fsnum);
					 if(!rs.equals("error"))
					 { 
					 }
					 else
						 return "error";
			 }
			 
			 
			 String rs=new zhenfenshu().caculate(fenziar, fenmuar, fuhaoStrings, fsnum);
			 if(!rs.equals("error"))
			 { 
			
			 return nFirstNumS+"="+rs;
			 }
			 else
				 return "error";
			
			
		
	}//���ɱ��ʽ
	
	public String proceed(){
		
		
		return "";
	}//������ʽ�����ɽ��
	

	public  int judgeKeYue(int fenzi,int fenmu)
	{	
		for(int i=2;i<=fenzi;i++)
		{
			if(fenmu%i==0&&fenzi%i==0)
			{	
				return i; //��Լ�鷵���������
			}
		}
			return -1;//-1��ʾ����Լ
	}
	
	 public String creatZhenfenshu(int[]fenziar,int[]fenmuar,int[]fsnum) //��������
	{ 	
//		 System.out.println("�ҽ�����creat����");
		 //��ô���澲̬����
		int fenmu=((int) (Math.random() * 10000))%9+2;//1~10;
		int fenzi=((int) (Math.random() * 10000))%9+1;
		
		
		while(fenzi>=fenmu)
		{
//			System.out.println("����ѭ��0");
			fenzi=((int) (Math.random() * 10000))%9+1;
		
		}
	
		while(true)
		{	
//			System.out.println("����ѭ��1");
			int yinzi=judgeKeYue(fenzi, fenmu);
			if(yinzi==-1)break;
			fenzi=fenzi/yinzi;
			fenmu=fenmu/yinzi;
			
		
		}
		fenziar[fsnum[0]]=fenzi;
		fenmuar[fsnum[0]++]=fenmu;
		
		 String nFirstNumS= "";
		 nFirstNumS+=String.valueOf(fenzi)+"/"+String.valueOf(fenmu);
		 return nFirstNumS;
	}
	
	public  String caculate(int[]fenziar,int[]fenmuar,String[] fuhaoStrings,int[]fsnum)
	{
//		for(int i=0;i<fenziar.length;i++)
//		{
//			System.out.print(fenziar[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<fenmuar.length;i++)
//		{
//			System.out.print(fenmuar[i]+" ");
//		}
//		for(int i=0;i<fuhaoStrings.length;i++)
//		{
//			System.out.print(fuhaoStrings[i]+" ");
//		}
		int zongfenmu=1;
		for(int i=0;i<fsnum[0];i++)
		{
			zongfenmu*=fenmuar[i];
		}
		
		int[] newfenziar= new int[10];
		for(int i=0;i<newfenziar.length;i++)newfenziar[i]=fenziar[i];
		int[] newfenmuar= new int[10];
		for(int i=0;i<newfenmuar.length;i++)newfenmuar[i]=fenmuar[i];
		
		for(int i=0;i<fsnum[0];i++)
		{
			for(int j=0;j<fsnum[0];j++)
			{
				if(i!=j)
				newfenziar[i]*=fenmuar[j];
				
				
			}
		}
		
		for(int i=0;i<fsnum[0];i++)
		{
			newfenmuar[i]=zongfenmu;
		}
		
		String s="";
		 s=String.valueOf(newfenziar[0]);
		 
		for(int i=0;i<fsnum[0]-1;i++)
		{
			s+=fuhaoStrings[i];
			s+=String.valueOf(newfenziar[i+1]);
		}
		
		
	
		int resultsn=Integer.parseInt(new caculate().caluJiajian(s));
		
	
		while(true)
		{
			int yinzi=judgeKeYue(resultsn, zongfenmu);
			if(yinzi==-1)break;
			resultsn=resultsn/yinzi;
			zongfenmu=zongfenmu/yinzi;
//			System.out.println("����ѭ��2");
		
		}
		
		if(resultsn<zongfenmu&&resultsn>0)
		return String.valueOf(resultsn)+"/"+String.valueOf(zongfenmu);
		else if(resultsn<zongfenmu&&resultsn==0)
			return "0";
		else
			return"error";
	}
	
	

}


