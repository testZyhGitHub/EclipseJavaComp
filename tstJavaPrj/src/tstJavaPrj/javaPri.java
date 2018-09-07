package tstJavaPrj;
import java.util.Formatter;

// package com.tomhu.format;

/*
		java基础---->Java的格式化输出
		
		在JavaSe5中, 推出了C语言中printf()风格的格式化输出。
	这不仅使得控制输出的代码更加简单, 同时也给与Java开发者对于输出格式与排列更大的控制能力。
	今天, 我们开始学习Java中的格式化输出。
				
		System.out.format()
		Formatter类
		格式化说明符
		Formatter转换
		简单的十六进制转换工具		

	 Java Se5引入的format方法可用于PrintStream或PrintWriter对象, 其中也包括System.out对象。
	
		
 */

// java错误提示------ The public type must be defined in its own file
// 			翻译：公共类必须被定义在它自己的文件中
//	
//		产生错误的原因:
//			1.定义Java类名同文件名不一样, 2.一个文件中有多个类,只有与文件名一致的类名,才能声明为：public
//		内部类不能声明为：public
//		一个文件中只能有一个public类
//
public class javaPri {

	/*
			可以看到, format与printf是等价的, 它们只需要一个简单的格式化字符串,
					加上一串参数即可, 每个参数对应一个格式修饰符。
					
			public PrintStream printf(String format, Object ... args) {
			    return format(format, args);
			}
			
			在format的具体代码中, 其实就是调用Formatter的format方法:
					formatter.format(Locale.getDefault(), format, args);
					
			public PrintStream format(String format, Object ... args) {
			    try {
			        synchronized (this) {
			            ensureOpen();
			            if ((formatter == null)
			                || (formatter.locale() != Locale.getDefault()))
			                formatter = new Formatter((Appendable) this);
			            formatter.format(Locale.getDefault(), format, args);
			        }
			    } catch (InterruptedIOException x) {
			        Thread.currentThread().interrupt();
			    } catch (IOException x) {
			        trouble = true;
			    }
			    return this;
			}			

			Formatter类
				在Java中, 所有新的格式化功能都由Formatter类处理, 上述的printf与format也是。
				可以将Formatter看作是一个翻译器, 它将你的格式化字符串与数据翻译成需要的结果。
				当你创建一个Formatter对象的时候, 需要向其构造器传递一些信息, 告诉它最终的结果将向哪里输出!!!
							
			格式化说明符
				在插入数据时, 如果想要控制空格与对齐, 就需要精细复杂的格式修饰符, 以下是其抽象的语法:
					%[argument_index$][flags][width][.precision]conversion
					
		The optional argument_index is a decimal integer indicating the position of the argument in the argument list. 
							The first argument is referenced by "1$", the second by "2$", etc.
							
		The optional flags is a set of characters that modify the output format. 
							The set of valid flags depends on the conversion.
							
		The optional width is a non-negative decimal integer indicating the minimum number of characters to be written to the output.
		
		The optional precision is a non-negative decimal integer usually used to restrict the number of characters. 
							The specific behavior depends on the conversion.
							
		The required conversion is a character indicating how the argument should be formatted. 
							The set of valid conversions for a given argument depends on the argument's data type.		

			最常见的应用是控制一个域的最小尺寸, 这可以通过指定width来实现。
			Formatter对象通过在必要时添加空格, 来确保一个域至少达到某个长度。
			在默认的情况下, 数据是右对齐的, 通过"-"标志可以改变对齐的方向。
			与width相对的是precision(精确度), 它用来指明最大尺寸。
			width可以应用各种类型的数据转换, 并且其行为方式都一样。
			precision则不一样, 不是所有类型的数据都能使用precision, 而且, 应用于不同的类型的数据转换时, precision的意义也不同。
		(1).precision应用于String时, 它表示打印String时输出字符的最大数量
		(2).precision应用于浮点数时, 它表示小数点要显示出来的位数, 默认是6位小数, 如果小数位数过多则舍入, 过少则在尾部补零。
		(3).由于整数没有小数部分, 所以precision不能应用于整数, 如果你对整数应用precision, 则会触发异常!!!	
		
		Formatter转换
		下面的表格包含了最常用的类型转换:
			类型转换字符
d	整数型(10进制 )	e	浮点数(科学计数)
c	Unicode字符	x	整数(16进制)
b	Boolean值	h	散列码(16进制)
s	String	%	字符"%"
f	浮点数(10进制)	 	 			
			
		String.format()是一个static方法,  它接受与Formatter.format()方法一样的参数, 但返回一个String对象。
		当你只需要用format方法一次的时候,  String.format()还是很方便的。
		
		其实String.format方法的实质还是Formatter.format(), 只不过是做了简单封装而已:
		
		public static String format(String format, Object... args) {
		    return new Formatter().format(format, args).toString();
		}		

					
						
	*/
    public static void main(String[] args) {
        int x = 5;
        double y = 3.141592;
        
        System.out.println("x = " + x + ", y = " + y);	// 一般方式       
        System.out.printf("x = %d, y = %f\n", x, y);	// printf()方式	        
        System.out.format("x = %d, y = %f\n", x, y);	// format()方式
    }
}

class FormatTest2 {
    public static void main(String[] args) {
        String name = "huhx";
        int age = 22;
        
        Formatter formatter = new Formatter(System.out);
        formatter.format("My name is %s, and my age is %d ", name, age);
        formatter.close();
    }
}

class FormatTest3 {
    static Formatter formatter = new Formatter(System.out);

    public static void printTitle() {
        formatter.format("%-15s %-5s %-10s\n", "huhx", "linux", "liuli");
        formatter.format("%-15s %-5s %-10s\n", "zhangkun", "yanzi", "zhangcong");
        formatter.format("%-15s %-5s %-10s\n", "zhangkun", "yanzhou", "zhangcong");
    }

    public static void print() {
        formatter.format("%-15s %5d %10.2f\n", "My name is huhx", 5, 4.2);
        formatter.format("%-15.4s %5d %10.2f\n", "My name is huhx", 5, 4.1);
    }
    
    public static void main(String[] args) {
        printTitle();
        System.out.println("----------------------------");
        print();
        formatter.close();
    }
}

class FormatTest4 {

    public static void main(String[] args) {
        int age = 22;
        String name = "huhx";

        String info = String.format("My name is %s and my age is %d", name, age);
        System.out.println(info);
    }
}

// 简单的十六进制转换工具
class FormatTest5 {
    
    public static String format(byte[] data) {
        StringBuilder builder = new StringBuilder();
        int n = 0;
        for(byte b: data) {
            if (n %16 == 0) {
                builder.append(String.format("%05x: ", n));
            }
            builder.append(String.format("%02x ", b));
            n ++;
            if (n % 16 == 0) {
                builder.append("\n");
            }
        }
        builder.append("\n");
        return builder.toString();
    }

    public static void main(String[] args) {
        String string = "my name is huhx, welcome to my blog";
        System.out.println(format(string.getBytes()));
    }
}

// java中格式化输出
class TestNumber
{
	public static void main(String[] args)
	{
		String name = "盖伦";
		int kill = 8;
		String title = "超神";
		
		String sentence = name + " 在进行了连续  " + kill + " 次击杀后，获得了 " + title + " 的称号 ";
		//直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差，易读性差
		System.out.println(sentence);
		
		String sentenceFormat = "%s 在进行了连续 %d 次击杀后， 获得了 %s 的称号%n";
		//格式化输出，%s表示字符串，%d表示数字，%n表示换号
		System.out.printf(sentenceFormat, name, kill, title);
		System.out.format(sentenceFormat, name, kill, title);
		//format和printf能够达到一模一样的效果
		
		int year = 2020; 
		
		System.out.format("%d%n",year);		//用%n或\n没差
		//直接打印数字
		System.out.printf("%8d%n",year);	//用printf还是format没差
		//总长度为8，默认右对齐
		System.out.printf("%-8d%n",year);
		//总长度为8，默认左对齐
		System.out.printf("%08d%n",year);
		//总长度为8，不够补0
		System.out.printf("%,8d%n",year*10000);
		//千位分隔符
		System.out.format("%.2f%n",Math.PI);
		//小数点位数
	
	}	
}


