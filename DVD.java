/**
 * @author 毛欣
 */
import java.util.Scanner;
//DVD类
public class DVD {
	int xuhao;     //序号
	String zhuangtai;    //借出状态
	String mingcheng;    //DVD名称
	String riqi;         //借出日期
	String cishu;        //借出次数
	int ri;              //日期
	int time;            //时间
	int xuanze;          //
	int fanhui;          //返回上一级
	DVD[] dvd = new DVD[5];   //建立数组存5个DVD
	Scanner input = new Scanner(System.in);
	//初始化3个信息
	public void start(){
				DVD d1= new DVD();
				d1.xuhao=1;
				d1.zhuangtai="已借出";
				d1.mingcheng="《罗马假日》";
				d1.ri=1;
				d1.riqi=d1.ri+"日";
				d1.time=15;
				d1.cishu=d1.time+"次";
				dvd[0]=d1;
				
				DVD d2= new DVD();
				d2.xuhao=2;
				d2.zhuangtai="可借";
				d2.mingcheng="《风声鹤唳》";
				d2.riqi="  ";
				d2.time=12;
				d2.cishu=d2.time+"次";
				dvd[1]=d2;
				
				DVD d3= new DVD();
				d3.xuhao=3;
				d3.zhuangtai="可借";
				d3.mingcheng="《浪漫满屋》";
				d3.riqi="  ";
				d3.time=30;
				d3.cishu=d3.time+"次";
				dvd[2]=d3;
	}
	//主菜单界面
	public void showDVDMainMenu(){
		System.out.println("欢迎使用迷你DVD管理器");
		System.out.println("----------------------------");
		System.out.println("1. 新增DVD");
		System.out.println("2. 查看DVD");
		System.out.println("3. 删除DVD");
		System.out.println("4. 借出DVD");
		System.out.println("5. 归还DVD");
		System.out.println("6. 退出DVD");
		System.out.println("----------------------------");
		System.out.print("请选择：");
		xuanze = input.nextInt();
		 switch(xuanze){
		 case 1:
			 addNewDVD();
			 break;
		 case 2:
			showDVDList();
			 break;
		 case 3:
			 deleteDVD();
			 break;
		 case 4:
			 borrowDVD();
			 break;
		 case 5:
			 returnDVD();
			 break;
		 case 6:
			 exitDVD();
			 break;
		 default:
			 System.out.println("输入错误请重新输入！");
			 showDVDMainMenu();
			 break;
		 }
	}
	//新增DVD界面
	public void addNewDVD(){
		System.out.println("---> 新增DVD");
		System.out.println();
		System.out.print("请输入DVD名称：");
		String xinDVD = input.next();
		int i;
		//数组未满时增加成功
		for(i =0;i<dvd.length;i++){
			if(dvd[i] ==null){
				 System.out.println("新增《"+xinDVD+"》成功！");
				 dvd[i] = new DVD();
				 dvd[i].xuhao = i+1;
				 dvd[i].mingcheng = "《"+xinDVD+"》";
				 dvd[i].zhuangtai = "可借";
				 dvd[i].riqi = "  ";
				 dvd[i].time =0;
				 dvd[i].cishu = time+"次";
				 break;
					}
			 }
		 //数组满了不能增加
		 if(i>=dvd.length){
				System.out.println("新增《"+xinDVD+"》失败！货架已满！");	
				
				 }
		 //返回
		System.out.println("输入0返回"); 
        fanhui=input.nextInt();
        if(fanhui==0){
       	 showDVDMainMenu();
        }
        }
	//查看DVD
	public void showDVDList(){
		 System.out.println("---> 查看DVD");
		 System.out.println();
		 System.out.println("序号\t状态\t名称\t\t借出日期\t借出次数");
         //列表输出
		 for(int i =0;i<dvd.length;i++){
			 if(dvd[i] !=null){
			System.out.println(dvd[i].xuhao+"\t"+dvd[i].zhuangtai+"\t"+dvd[i].mingcheng+"\t"+dvd[i].riqi+"\t"+dvd[i].cishu);	 
			 }
         }
         System.out.println("输入0返回"); 
         fanhui=input.nextInt();
         if(fanhui==0){
        	 showDVDMainMenu();
         }
	}
	//删除DVD
	public void deleteDVD(){
		boolean panduan = false;
		boolean cunzai = true;
		int index=-1;
		System.out.println("---> 删除DVD");
		System.out.println();
		System.out.print("请输入DVD名称：");
		String oldDVD = input.next();
		int i;
		for(i =0;i<dvd.length;i++){
			//检查是否已经借出
			if(dvd[i] != null && dvd[i].mingcheng.equals("《"+oldDVD+"》")){
					cunzai = true;
					if(dvd[i].zhuangtai.equals("已借出")){
						System.out.println("《"+oldDVD+"》为借出状态不能删除！");
						break;
						}else{
							//删除成功
							index=i;
							System.out.println("删除《"+oldDVD+"》成功！");
							panduan = true;
							cunzai = false;
							break;
							}
					 }
		}
		//没有找到
		if(cunzai){
			System.out.println("没有找到匹配信息！");
		}
		//所有数组向前一位
		if(panduan){
			for(i =index;i<dvd.length-1;i++){
				dvd[i]=dvd[i+1];
				if(dvd[i] != null){
				dvd[i].xuhao=dvd[i].xuhao-1;
				
				}
			}
			dvd[dvd.length-1]=null;
		}
		 System.out.println("输入0返回"); 
         fanhui=input.nextInt();
         if(fanhui==0){
        	 showDVDMainMenu();
         }
	}
	//借出DVD
	public void borrowDVD(){
		System.out.println("---> 借出DVD");
		System.out.println();
		System.out.print("请输入DVD名称：");
		String borrow = input.next();
		int i;
		for(i =0;i<dvd.length;i++){    //检查是否借出
			if(dvd[i] != null && dvd[i].mingcheng.equals("《"+borrow+"》")){
					if(dvd[i].zhuangtai.equals("已借出")){
						System.out.println("《"+borrow+"》已被借出！");
						dvd[i].zhuangtai="已借出";
						break;
						}else{   //借出成功
							System.out.print("请输入出借日期：");
							dvd[i].ri = input.nextInt();
							System.out.println("借出《"+borrow+"》成功！");
							dvd[i].zhuangtai="已借出";
							dvd[i].riqi=dvd[i].ri+"日";
							dvd[i].cishu = (dvd[i].time+1)+"次";
							break;
							}
					 }
		}
		System.out.println("输入0返回"); 
        fanhui=input.nextInt();
        if(fanhui==0){
       	 showDVDMainMenu();
        }
	}
	//归还DVD
	public void returnDVD(){
		int jieshu;
		System.out.println("---> 归还DVD");
		System.out.println();
		System.out.print("请输入DVD名称：");
		String guihuan = input.next();
		for(int i=0;i<dvd.length;i++){
			if(dvd[i] != null && dvd[i].mingcheng.equals("《"+guihuan+"》")){ 
					if(dvd[i].zhuangtai.equals("已借出")){  //检查是否已借出
						System.out.print("请输入归还日期：");
						jieshu=input.nextInt();
						System.out.println("归还《"+guihuan+"》成功！");
						dvd[i].zhuangtai="可借";
						System.out.println("借出日期为："+dvd[i].riqi);
						System.out.println("归还日期为："+jieshu+"日");
						System.out.println("应付租金（元）："+(jieshu-dvd[i].ri)+"元");
						dvd[i].riqi="  ";
						break;
						}else{   //DVD未借出
							System.out.println("该书未借出！");
							break;
							}
					 }
		}
		System.out.println("输入0返回"); 
        fanhui=input.nextInt();
        if(fanhui==0){
       	 showDVDMainMenu();
        }
	}
	//退出系统
	public void exitDVD(){
		System.out.println("谢谢使用使用迷你DVD管理器！");
	}
	
}
