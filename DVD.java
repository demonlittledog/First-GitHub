/**
 * @author ë��
 */
import java.util.Scanner;
//DVD��
public class DVD {
	int xuhao;     //���
	String zhuangtai;    //���״̬
	String mingcheng;    //DVD����
	String riqi;         //�������
	String cishu;        //�������
	int ri;              //����
	int time;            //ʱ��
	int xuanze;          //
	int fanhui;          //������һ��
	DVD[] dvd = new DVD[5];   //���������5��DVD
	Scanner input = new Scanner(System.in);
	//��ʼ��3����Ϣ
	public void start(){
				DVD d1= new DVD();
				d1.xuhao=1;
				d1.zhuangtai="�ѽ��";
				d1.mingcheng="��������ա�";
				d1.ri=1;
				d1.riqi=d1.ri+"��";
				d1.time=15;
				d1.cishu=d1.time+"��";
				dvd[0]=d1;
				
				DVD d2= new DVD();
				d2.xuhao=2;
				d2.zhuangtai="�ɽ�";
				d2.mingcheng="��������ড�";
				d2.riqi="  ";
				d2.time=12;
				d2.cishu=d2.time+"��";
				dvd[1]=d2;
				
				DVD d3= new DVD();
				d3.xuhao=3;
				d3.zhuangtai="�ɽ�";
				d3.mingcheng="���������ݡ�";
				d3.riqi="  ";
				d3.time=30;
				d3.cishu=d3.time+"��";
				dvd[2]=d3;
	}
	//���˵�����
	public void showDVDMainMenu(){
		System.out.println("��ӭʹ������DVD������");
		System.out.println("----------------------------");
		System.out.println("1. ����DVD");
		System.out.println("2. �鿴DVD");
		System.out.println("3. ɾ��DVD");
		System.out.println("4. ���DVD");
		System.out.println("5. �黹DVD");
		System.out.println("6. �˳�DVD");
		System.out.println("----------------------------");
		System.out.print("��ѡ��");
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
			 System.out.println("����������������룡");
			 showDVDMainMenu();
			 break;
		 }
	}
	//����DVD����
	public void addNewDVD(){
		System.out.println("---> ����DVD");
		System.out.println();
		System.out.print("������DVD���ƣ�");
		String xinDVD = input.next();
		int i;
		//����δ��ʱ���ӳɹ�
		for(i =0;i<dvd.length;i++){
			if(dvd[i] ==null){
				 System.out.println("������"+xinDVD+"���ɹ���");
				 dvd[i] = new DVD();
				 dvd[i].xuhao = i+1;
				 dvd[i].mingcheng = "��"+xinDVD+"��";
				 dvd[i].zhuangtai = "�ɽ�";
				 dvd[i].riqi = "  ";
				 dvd[i].time =0;
				 dvd[i].cishu = time+"��";
				 break;
					}
			 }
		 //�������˲�������
		 if(i>=dvd.length){
				System.out.println("������"+xinDVD+"��ʧ�ܣ�����������");	
				
				 }
		 //����
		System.out.println("����0����"); 
        fanhui=input.nextInt();
        if(fanhui==0){
       	 showDVDMainMenu();
        }
        }
	//�鿴DVD
	public void showDVDList(){
		 System.out.println("---> �鿴DVD");
		 System.out.println();
		 System.out.println("���\t״̬\t����\t\t�������\t�������");
         //�б����
		 for(int i =0;i<dvd.length;i++){
			 if(dvd[i] !=null){
			System.out.println(dvd[i].xuhao+"\t"+dvd[i].zhuangtai+"\t"+dvd[i].mingcheng+"\t"+dvd[i].riqi+"\t"+dvd[i].cishu);	 
			 }
         }
         System.out.println("����0����"); 
         fanhui=input.nextInt();
         if(fanhui==0){
        	 showDVDMainMenu();
         }
	}
	//ɾ��DVD
	public void deleteDVD(){
		boolean panduan = false;
		boolean cunzai = true;
		int index=-1;
		System.out.println("---> ɾ��DVD");
		System.out.println();
		System.out.print("������DVD���ƣ�");
		String oldDVD = input.next();
		int i;
		for(i =0;i<dvd.length;i++){
			//����Ƿ��Ѿ����
			if(dvd[i] != null && dvd[i].mingcheng.equals("��"+oldDVD+"��")){
					cunzai = true;
					if(dvd[i].zhuangtai.equals("�ѽ��")){
						System.out.println("��"+oldDVD+"��Ϊ���״̬����ɾ����");
						break;
						}else{
							//ɾ���ɹ�
							index=i;
							System.out.println("ɾ����"+oldDVD+"���ɹ���");
							panduan = true;
							cunzai = false;
							break;
							}
					 }
		}
		//û���ҵ�
		if(cunzai){
			System.out.println("û���ҵ�ƥ����Ϣ��");
		}
		//����������ǰһλ
		if(panduan){
			for(i =index;i<dvd.length-1;i++){
				dvd[i]=dvd[i+1];
				if(dvd[i] != null){
				dvd[i].xuhao=dvd[i].xuhao-1;
				
				}
			}
			dvd[dvd.length-1]=null;
		}
		 System.out.println("����0����"); 
         fanhui=input.nextInt();
         if(fanhui==0){
        	 showDVDMainMenu();
         }
	}
	//���DVD
	public void borrowDVD(){
		System.out.println("---> ���DVD");
		System.out.println();
		System.out.print("������DVD���ƣ�");
		String borrow = input.next();
		int i;
		for(i =0;i<dvd.length;i++){    //����Ƿ���
			if(dvd[i] != null && dvd[i].mingcheng.equals("��"+borrow+"��")){
					if(dvd[i].zhuangtai.equals("�ѽ��")){
						System.out.println("��"+borrow+"���ѱ������");
						dvd[i].zhuangtai="�ѽ��";
						break;
						}else{   //����ɹ�
							System.out.print("������������ڣ�");
							dvd[i].ri = input.nextInt();
							System.out.println("�����"+borrow+"���ɹ���");
							dvd[i].zhuangtai="�ѽ��";
							dvd[i].riqi=dvd[i].ri+"��";
							dvd[i].cishu = (dvd[i].time+1)+"��";
							break;
							}
					 }
		}
		System.out.println("����0����"); 
        fanhui=input.nextInt();
        if(fanhui==0){
       	 showDVDMainMenu();
        }
	}
	//�黹DVD
	public void returnDVD(){
		int jieshu;
		System.out.println("---> �黹DVD");
		System.out.println();
		System.out.print("������DVD���ƣ�");
		String guihuan = input.next();
		for(int i=0;i<dvd.length;i++){
			if(dvd[i] != null && dvd[i].mingcheng.equals("��"+guihuan+"��")){ 
					if(dvd[i].zhuangtai.equals("�ѽ��")){  //����Ƿ��ѽ��
						System.out.print("������黹���ڣ�");
						jieshu=input.nextInt();
						System.out.println("�黹��"+guihuan+"���ɹ���");
						dvd[i].zhuangtai="�ɽ�";
						System.out.println("�������Ϊ��"+dvd[i].riqi);
						System.out.println("�黹����Ϊ��"+jieshu+"��");
						System.out.println("Ӧ�����Ԫ����"+(jieshu-dvd[i].ri)+"Ԫ");
						dvd[i].riqi="  ";
						break;
						}else{   //DVDδ���
							System.out.println("����δ�����");
							break;
							}
					 }
		}
		System.out.println("����0����"); 
        fanhui=input.nextInt();
        if(fanhui==0){
       	 showDVDMainMenu();
        }
	}
	//�˳�ϵͳ
	public void exitDVD(){
		System.out.println("ллʹ��ʹ������DVD��������");
	}
	
}
