package tstJavaPrj;

class testClass1 {
	static void SMethod() {
		System.out.println("static in testClass1");
	}
}

class testClass2 extends testClass1 {
	static void SMethod() {
		System.out.println("static in testClass2");
	}
}

/*
	��Employee���еķ�����д��static��main�����Ϳ��Ե����ˡ�
	����֪����static�����ڳ���ִ��ǰ��ϵͳ��Ϊ�����̶����ڴ档
	������з�������������ϵͳ��������
*/
class Employee {
	private Integer id;
	private String name;
	private String pwd;
	private String email;
	
	public Employee() {
	
	}
	
	public Integer getId() {
	    return id;
	}
	public void setId(Integer id) {
	    this.id = id;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	
	public String getPwd() {
	    return pwd;
	}
	public void setPwd(String pwd) {
	    this.pwd = pwd;
	}
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
}

public class main {
	public void B() {
		System.out.println("b��������");
	}	
	
	/*
			java��main������ô�����ⲿ��static����
		
			ʹ���ⲿ����ʱ(������static���Ƿ�static), ��Ҫ��newһ������, ����ʹ�øö���ķ�����
			
			static�����ڳ���ִ��ǰ, ϵͳ��Ϊ�����̶����ڴ�!
			
			ʹ���ⲿ��static����ʱ, Ҫ��newһ������, ����ʹ�øö���ķ���.			
	 */
	public static void main(String[] args) {
	// public void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello!!!");
		
		for (int i = 0; i < args.length; i++) {
			System.out.printf("i = %d\n", i);
		}
		
		//main.testJavaPrint();
		
		//testJavaCallFunc newClass = 
		
		 //����A��Ķ���a.
		testJavaCallFunc a = new testJavaCallFunc();
		//����C������
		
		testJavaCallFunc.main1(args);			// javaͬһ��������ε�����������еľ�̬����!!!
		
		a.sayHello("adsadsadadsa");
		
		testClass1 tc1 = new testClass2();
		testClass2 tc2 = new testClass2();
		
		/*
	 		��Java�̳��������static����ǳ̸�������������
	 		
	 		��java�У�static��Ա�����Ƿ���Ա���д�أ�
	 		
	 		���������������дһ��static����, ������������������������ķ�static�����������С�
	 		
	 		��Ȼ����Զ���һ����д����, ���Ǹú���û�ж�̬���� 		
	 		
	 		�ӽ���п��Կ���,  �������ø����ʵ������(ʵ���ϸ�ʵ����һ������)����static����ʱ,  ���õ��Ǹ����static������
	 		
	 		ԭ�����ڷ��������ص�˳��
	 		
	 		��һ������������ʱ, JVM���ȼ�����ǲ����෽����
	 		�����, ��ֱ�Ӵӵ��ø÷������ñ������������ҵ��÷�����ִ��, ������ȷ�����Ƿ���д(����), 
	 				�������, �Ż�ȥ������������(���綯̬������ѯ)
	 		�����е���һ�Ĵ��ȣ��ⲻ����java�ľ�̬/��̬����ô��
	 		�е���, �����治��, ��̬�����붯̬����������ȷ�����غ���д�߼��ġ�
	 		�����ع�����, ���������ݷ��������ľ�̬����(����tc1�ľ�̬������class1, tc2����class2, ���������ﲻ�����أ�)
	 							��ȷ��ʹ�÷����İ汾, �������̬���ɡ�
	 		
	 		��̬���������ڷ�����д��, �����ҵ���һ����A�ķ���f, �������������a, ��ô����a������f��ʱ��, ���õ�ʵ����a.f����A.f!!!
	 		
	 		�������������̬�����ǲ��ǣ����ǽ�������ϰ���
	 				�����ԭ������, ��̬����ʱ, ����ʵ����������Java��invokevirtualָ�����Ϊ:
	 						���ָ�����Ȼ�ȥѰ�ҵ����ߵ�����ʱ����, 
	 							Ȼ�����䷽��������Ѱ��ƥ��ķ���,
	 						����Ҳ���, �ٴ��丸�����ҡ�
	 				������̾���Java�з�����д�ı���, Ҳ���Ƕ�̬����!!!
	 		
	 		��static������ͨ��invokestaticָ�������õġ�
	 		
	 		����static������һ�ֱ����ڿ�֪, �����ڲ��ɱ�ķ���, ���Ծ�������͸��඼��ͬ���ķ�����,
	 						����ʵ�������ǲ�ͬ�ķ���, Ҳ����ȫ�������ֵķ�����
	 		
			�ڵ���static����ʱ, �������ͻ�ֱ���������ʱ����������ý���Ϊֱ������,
							������˵�����Ҳ�������֮����ȥ������������Ϊ, ����Ҳ�н������á�
			
			���������������п�����������д�ķ���ȴû�в�����д��Ч����ԭ��!	 			 			
		*/		
		tc1.SMethod(); //������Ϊ static in testClass1
		tc2.SMethod(); //������Ϊ static in testClass2
		
		
		//   ͬһ�����в�ͬ����֮��ĵ����������(ʡ�Ե���������this)
		/*
				���á����Java���塷�е�һ�λ�
				
				��ΪJava��ķ������ܶ������ڣ�
				      ����������һ�����һ������, 
				     ��˷���Ҳ����ֱ����������������ִ�У�
				     ִ�з���ʱ����ʹ����������Ϊ�����ߣ�
				     	�����еķ���������ʹ�á���.�������򡰶���.����������ʽ�����á�
			
				������ܲ���һ�����⣺ͬһ�����ﲻͬ����֮���໥����ʱ�����Ϳ���ֱ�ӵ�����������Ҫָ�����ǣ�
					ͬһ�����һ������������һ������ʱ����������÷�������ͨ��������Ĭ��ʹ��this��Ϊ�����ߣ�
					��������÷���ʱ��̬��������Ĭ��ʹ������Ϊ�����ߡ�
					Ҳ����˵�����Ͽ�����ĳЩ�������Ա�����ִ�У���ʵ���ϻ���ʹ��this��������Ϊ�����ߡ�
					����������һ�� B(); ��ʵ��ʡ����this�ģ����������Ӧ����this.B();		 
		 */		

		// ʹ���ⲿ��static����ʱ, Ҫ��newһ������, ����ʹ�øö���ķ���
		/*
			Employee employee = new Employee();
			employee.setName("����"); 
			employee.setEmail("ww@qq.com");
			employee.setPwd("123333");
			
			System.out.println(employee.getName()+"  "+employee.getEmail()+"  "+employee.getPwd());
        */
        
		/*
			Employee employee = null;
			
			employee.setName("����"); //�о��棬��������Ҳִ�в���ȥ
			employee.setEmail("ww@qq.com");
			employee.setPwd("123333");
			
			System.out.println(employee.getName()+"  "+employee.getEmail()+"  "+employee.getPwd());
        */
		
		// javaPri tstJavaPri = new javaPri();		
		// tstJavaPri.main(args);
		
		javaPri.main(args);
		
		FormatTest2.main(args);
				
	}
	
	/*
	 * 		java����---->Java�ĸ�ʽ�����
	 * 		
	 * 		��JavaSe5��, �Ƴ���C������printf()���ĸ�ʽ�������
	 * 		�ⲻ��ʹ�ÿ�������Ĵ�����Ӽ򵥣�ͬʱҲ����Java�����߶��������ʽ�����и���Ŀ���������
	 * 		���ǿ�ʼѧϰJava�еĸ�ʽ�����:
	 * 				System.out.format()
	 * 				Formatter��
	 * 				��ʽ��˵����
	 * 				Formatterת��
	 * 				�򵥵�ʮ������ת������
	 * 
	 *  	Java Se5�����format����������PrintStream��PrintWriter��������Ҳ����System.out����
	 */
	public void testJavaPrint() {
		int x = 5;
		double y = 3.141592;
		
		// һ�㷽ʽ
        System.out.println("x = " + x + ", y = " + y);
        
        // printf()��ʽ
        System.out.printf("x = %d, y = %f\n", x, y);
        
        // format()��ʽ
        System.out.format("x = %d, y = %f\n", x, y);		
	}
	

}


