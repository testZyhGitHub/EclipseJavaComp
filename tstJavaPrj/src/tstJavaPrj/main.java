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
	把Employee类中的方法都写成static，main函数就可以调用了。
	但都知道，static类型在程序执行前，系统会为其分配固定的内存。
	如果所有方法都这样做，系统不崩溃了
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
		System.out.println("b方法运行");
	}	
	
	/*
			java中main函数怎么调用外部非static方法
		
			使用外部方法时(不管是static还是非static), 都要先new一个对象, 才能使用该对象的方法。
			
			static类型在程序执行前, 系统会为其分配固定的内存!
			
			使用外部非static方法时, 要先new一个对象, 才能使用该对象的方法.			
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
		
		 //创建A类的对象a.
		testJavaCallFunc a = new testJavaCallFunc();
		//调用C方法。
		
		testJavaCallFunc.main1(args);			// java同一个类中如何调用另外的类中的静态方法!!!
		
		a.sayHello("adsadsadadsa");
		
		testClass1 tc1 = new testClass2();
		testClass2 tc2 = new testClass2();
		
		/*
	 		从Java继承类的重名static函数浅谈解析调用与分派
	 		
	 		在java中，static成员函数是否可以被重写呢？
	 		
	 		你可以在子类中重写一个static函数, 但是这个函数并不能像正常的非static函数那样运行。
	 		
	 		虽然你可以定义一个重写函数, 但是该函数没有多态特性 		
	 		
	 		从结果中可以看到,  当我们用父类的实例引用(实际上该实例是一个子类)调用static函数时,  调用的是父类的static函数。
	 		
	 		原因在于方法被加载的顺序。
	 		
	 		当一个方法被调用时, JVM首先检查其是不是类方法。
	 		如果是, 则直接从调用该方法引用变量所属类中找到该方法并执行, 而不再确定它是否被重写(覆盖), 
	 				如果不是, 才会去进行其它操作(例如动态方法查询)
	 		可能有的人一拍大腿，这不就是java的静态/动态分派么！
	 		有点像, 但还真不是, 静态分派与动态分派是用来确定重载和重写逻辑的。
	 		在重载过程中, 编译器根据方法参数的静态类型(比如tc1的静态类型是class1, tc2的是class2, 但本文这里不是重载！)
	 							来确定使用方法的版本, 这叫做静态分派。
	 		
	 		动态分派是用于方法重写的, 比如我调用一个类A的方法f, 如果该类有子类a, 那么我以a来调用f的时候, 调用的实际是a.f而非A.f!!!
	 		
	 		看起来还真的像动态分派是不是？但是结果不符合啊！
	 				这里的原因在于, 动态分派时, 我们实际是在讨论Java的invokevirtual指令的行为:
	 						这个指令首先会去寻找调用者的运行时类型, 
	 							然后在其方法表里面寻找匹配的方法,
	 						如果找不到, 再从其父类里找。
	 				这个过程就是Java中方法重写的本质, 也就是动态分派!!!
	 		
	 		而static方法是通过invokestatic指令来调用的。
	 		
	 		由于static方法是一种编译期可知, 运行期不可变的方法, 所以尽管子类和父类都有同样的方法名,
	 						而事实上它们是不同的方法, 也是完全可以区分的方法。
	 		
			在调用static方法时, 编译器就会直接在类加载时把其符号引用解析为直接引用,
							不存在说子类找不到方法之后再去父类找这种行为, 所以也叫解析调用。
			
			这就是上面的例子中看起来像是重写的方法却没有产生重写的效果的原因!	 			 			
		*/		
		tc1.SMethod(); //输出结果为 static in testClass1
		tc2.SMethod(); //输出结果为 static in testClass2
		
		
		//   同一个类中不同方法之间的调用相关问题(省略的类名或者this)
		/*
				引用《疯狂Java讲义》中的一段话
				
				因为Java里的方法不能独立存在，
				      它必须属于一个类或一个对象, 
				     因此方法也不能直接像函数那样被独立执行，
				     执行方法时必须使用类或对象作为调用者，
				     	即所有的方法都必须使用“类.方法”或“对象.方法”的形式来调用。
			
				这里可能产生一个问题：同一个类里不同方法之间相互调用时，不就可以直接调用吗？这里需要指出的是：
					同一个类的一个方法调用另一个方法时，如果被调用方法是普通方法，则默认使用this作为调用者；
					如果被调用方法时静态方法，则默认使用类作为调用者。
					也就是说表面上看起来某些方法可以被独立执行，但实际上还是使用this或类来作为调用者。
					所以上面这一句 B(); 其实是省略了this的，完整的语句应该是this.B();		 
		 */		

		// 使用外部非static方法时, 要先new一个对象, 才能使用该对象的方法
		/*
			Employee employee = new Employee();
			employee.setName("旺旺"); 
			employee.setEmail("ww@qq.com");
			employee.setPwd("123333");
			
			System.out.println(employee.getName()+"  "+employee.getEmail()+"  "+employee.getPwd());
        */
        
		/*
			Employee employee = null;
			
			employee.setName("旺旺"); //有警告，况且这里也执行不下去
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
	 * 		java基础---->Java的格式化输出
	 * 		
	 * 		在JavaSe5中, 推出了C语言中printf()风格的格式化输出。
	 * 		这不仅使得控制输出的代码更加简单，同时也给与Java开发者对于输出格式与排列更大的控制能力。
	 * 		我们开始学习Java中的格式化输出:
	 * 				System.out.format()
	 * 				Formatter类
	 * 				格式化说明符
	 * 				Formatter转换
	 * 				简单的十六进制转换工具
	 * 
	 *  	Java Se5引入的format方法可用于PrintStream或PrintWriter对象，其中也包括System.out对象。
	 */
	public void testJavaPrint() {
		int x = 5;
		double y = 3.141592;
		
		// 一般方式
        System.out.println("x = " + x + ", y = " + y);
        
        // printf()方式
        System.out.printf("x = %d, y = %f\n", x, y);
        
        // format()方式
        System.out.format("x = %d, y = %f\n", x, y);		
	}
	

}


