package tstJavaPrj;

// java��main������ô�����ⲿ��static����,
// 		�������Է�Ϊ��̬������ʵ������, 
//			��main��������÷�static����(ʵ������),
//				��ô����ͨ������ʵ������,Ȼ��������ʵ������!!!
//
public class testJavaCallFunc {
	// ��̬����
	public static void sayHello(String name){
	    System.out.println("Hello " + name);
	}
	
	// main����
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
		testJavaCallFunc.sayHello("tom");				// ����.������ȥ���þ�̬�ķ���
		
		sayHello("jack");								// ��������þ�̬����,�����Ϳ���ʡ����
		
		testJavaCallFunc fn = new testJavaCallFunc();	// ���������ʵ������
		fn.sayBye("tom");								// ʵ������.������       ȥ���� ʵ������
		fn.sayBye("jack");
		fn.sayHello("Word");							// ��Ȼʵ������Ҳ���Ե��þ�̬����, ���ǲ��Ƽ����ֵ��÷�ʽ
	}
	
	// ʵ������
	public void sayBye(String name){
	    System.out.println("Bye Bye " + name);;
	}
}
