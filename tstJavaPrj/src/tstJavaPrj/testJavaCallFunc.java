package tstJavaPrj;

// java中main函数怎么调用外部非static方法,
// 		方法可以分为静态方法和实例方法, 
//			在main函数里调用非static方法(实例方法),
//				那么可以通过创建实例对象,然后来调用实例方法!!!
//
public class testJavaCallFunc {
	// 静态方法
	public static void sayHello(String name){
	    System.out.println("Hello " + name);
	}
	
	// main方法
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
		testJavaCallFunc.sayHello("tom");				// 类名.方法名去调用静态的方法
		
		sayHello("jack");								// 本类里调用静态方法,类名就可以省略了
		
		testJavaCallFunc fn = new testJavaCallFunc();	// 创建本类的实例对象
		fn.sayBye("tom");								// 实例对象.方法名       去调用 实例方法
		fn.sayBye("jack");
		fn.sayHello("Word");							// 虽然实例对象也可以调用静态方法, 但是不推荐这种调用方式
	}
	
	// 实例方法
	public void sayBye(String name){
	    System.out.println("Bye Bye " + name);;
	}
}
