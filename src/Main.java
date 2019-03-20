import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

public class Main {

	public static void main(String [] args) throws IOException
	{	
		 File f=new File(".\\src\\result.txt");
		 if(!f.exists())
			{	 
			 f.createNewFile();
			}
		 PrintStream outPrintStream=new PrintStream(f);

		Scanner in = new Scanner(System.in);
		int n1=in.nextInt();
		int nc=0;
		System.out.println("2017010302");
		outPrintStream.println("2017010302");
//		outPrintStream.println("2017010302");
		while(nc<n1)
		{	int modelrdn=((int) (Math.random() * 10000))%3;
		
		
		if(modelrdn==0||modelrdn==2){	
			 int nFuhao = ((int) (Math.random() * 10000))%3+3;//产生符号个数  
//			 System.out.println(nFuhao);
			 
			String fuhao[]={"+","-","×","÷"};
			
//			System.out.println(fuhao[0]+fuhao[1]+fuhao[2]+fuhao[3]);
			 String nFirstNumS = String.valueOf(((int) (Math.random() * 10000))%101);//产生第一个数 数值随机产生  并转化成字符串
//			 System.out.println(nFirstNum);
			 
			 for(int j=0;j<nFuhao;j++)
			 {	
				 int fuhaoSuiji=((int) (Math.random() * 10000)%4);
				 nFirstNumS=nFirstNumS+fuhao[fuhaoSuiji];
				 if(fuhaoSuiji!=3){
				 int numSuiji=((int) (Math.random() * 10000)%101);
				 nFirstNumS=nFirstNumS+String.valueOf(numSuiji);
				 }//处理除号部分：查重
				 else {//从生成上来限制必须是整数除是最正确的，因为要求是过程
						char[] cfn = nFirstNumS.toCharArray();
						int k=cfn.length-1;
						k--;
						String qianyigenum="";
						qianyigenum+=String.valueOf(cfn[k]);
						k--;
						while(true)
						{	
							if(k<0)break; //判断是否越界
							if(cfn[k]=='×'||cfn[k]=='÷'||cfn[k]=='+'||cfn[k]=='-'){ //判断是否是数字
								
								break;
							}
							{
								qianyigenum+=String.valueOf(cfn[k]);
								k--;
							}
							
						}
						qianyigenum=new StringBuilder(qianyigenum).reverse().toString();
						 int numSuiji=((int)((Math.random() * 10000)%100+1));
						while(true)
						{
							if(numSuiji!=0){
							 if((Integer.parseInt(qianyigenum)>=numSuiji&&Integer.parseInt(qianyigenum)%numSuiji==0)||Integer.parseInt(qianyigenum)==0)
							 {
								 break;
							 }
							}
							 numSuiji=((int) ((Math.random() * 10000)%100+1));
						
						}
						 
						 nFirstNumS=nFirstNumS+String.valueOf(numSuiji);
						 
						 
						String panduans=new caculate().judges(nFirstNumS);
						if(panduans.equals("error"))
							break;
				}
				
			 
			 }
			 
			
			 String rs;
			 caculate cl=new caculate();
			 try{
			 rs=cl.judges(nFirstNumS);
			 }catch (NumberFormatException e) {
				// TODO: handle exception
				 continue;
			}
			
			 
			
			
			if(rs.equals("error")){
					continue;
			}else {
				if(modelrdn==0){
				nc++;
				System.out.println(nFirstNumS+"="+rs);
				outPrintStream.println(nFirstNumS+"="+rs);
				}
				else if(modelrdn==2)
				{
					kuohao kh=new kuohao();
					String s=kh.init(nFirstNumS, 5);
					int ys=1000;//达到一定次数一定可以生成
					while(true){
						
					if(s!="error"){
						
						String rs1=kh.jieshi(s);
						if(rs1!="error")
						{		
							String rss1=new caculate().judges(rs1);
							if(rss1!="error")
							{
								System.out.print(s);
								System.out.println("="+rss1);
								outPrintStream.print(s);
								outPrintStream.println("="+rss1);
								nc++;
								break;
							}
						}
					}
					ys--;
					if(ys<=0)break;
					 s=kh.init(nFirstNumS, 5);
				}
					
				}
			}
//			System.out.println( cl.caluJiajian(nFirstNumS));
		}
		else if(modelrdn==1){
			String isproceed=new zhenfenshu().init();
			while(isproceed.equals("error"))
				isproceed=new zhenfenshu().init();
			
			nc++;
			System.out.println(isproceed);
			outPrintStream.println(isproceed);
		}
		
		}
	
		System.out.println("生成完毕，文件所在目录是"+f.getCanonicalPath());
	}
}
