package tstJavaPrj;
import java.util.Formatter;

// package com.tomhu.format;

/*
		java����---->Java�ĸ�ʽ�����
		
		��JavaSe5��, �Ƴ���C������printf()���ĸ�ʽ�������
	�ⲻ��ʹ�ÿ�������Ĵ�����Ӽ�, ͬʱҲ����Java�����߶��������ʽ�����и���Ŀ���������
	����, ���ǿ�ʼѧϰJava�еĸ�ʽ�������
				
		System.out.format()
		Formatter��
		��ʽ��˵����
		Formatterת��
		�򵥵�ʮ������ת������		

	 Java Se5�����format����������PrintStream��PrintWriter����, ����Ҳ����System.out����
	
		
 */

// java������ʾ------ The public type must be defined in its own file
// 			���룺��������뱻���������Լ����ļ���
//	
//		���������ԭ��:
//			1.����Java����ͬ�ļ�����һ��, 2.һ���ļ����ж����,ֻ�����ļ���һ�µ�����,��������Ϊ��public
//		�ڲ��಻������Ϊ��public
//		һ���ļ���ֻ����һ��public��
//
public class javaPri {

	/*
			���Կ���, format��printf�ǵȼ۵�, ����ֻ��Ҫһ���򵥵ĸ�ʽ���ַ���,
					����һ����������, ÿ��������Ӧһ����ʽ���η���
					
			public PrintStream printf(String format, Object ... args) {
			    return format(format, args);
			}
			
			��format�ľ��������, ��ʵ���ǵ���Formatter��format����:
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

			Formatter��
				��Java��, �����µĸ�ʽ�����ܶ���Formatter�ദ��, ������printf��formatҲ�ǡ�
				���Խ�Formatter������һ��������, ������ĸ�ʽ���ַ��������ݷ������Ҫ�Ľ����
				���㴴��һ��Formatter�����ʱ��, ��Ҫ���乹��������һЩ��Ϣ, ���������յĽ�������������!!!
							
			��ʽ��˵����
				�ڲ�������ʱ, �����Ҫ���ƿո������, ����Ҫ��ϸ���ӵĸ�ʽ���η�, �������������﷨:
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

			�����Ӧ���ǿ���һ�������С�ߴ�, �����ͨ��ָ��width��ʵ�֡�
			Formatter����ͨ���ڱ�Ҫʱ��ӿո�, ��ȷ��һ�������ٴﵽĳ�����ȡ�
			��Ĭ�ϵ������, �������Ҷ����, ͨ��"-"��־���Ըı����ķ���
			��width��Ե���precision(��ȷ��), ������ָ�����ߴ硣
			width����Ӧ�ø������͵�����ת��, ��������Ϊ��ʽ��һ����
			precision��һ��, �����������͵����ݶ���ʹ��precision, ����, Ӧ���ڲ�ͬ�����͵�����ת��ʱ, precision������Ҳ��ͬ��
		(1).precisionӦ����Stringʱ, ����ʾ��ӡStringʱ����ַ����������
		(2).precisionӦ���ڸ�����ʱ, ����ʾС����Ҫ��ʾ������λ��, Ĭ����6λС��, ���С��λ������������, ��������β�����㡣
		(3).��������û��С������, ����precision����Ӧ��������, ����������Ӧ��precision, ��ᴥ���쳣!!!	
		
		Formatterת��
		����ı���������õ�����ת��:
			����ת���ַ�
d	������(10���� )	e	������(��ѧ����)
c	Unicode�ַ�	x	����(16����)
b	Booleanֵ	h	ɢ����(16����)
s	String	%	�ַ�"%"
f	������(10����)	 	 			
			
		String.format()��һ��static����,  ��������Formatter.format()����һ���Ĳ���, ������һ��String����
		����ֻ��Ҫ��format����һ�ε�ʱ��,  String.format()���Ǻܷ���ġ�
		
		��ʵString.format������ʵ�ʻ���Formatter.format(), ֻ���������˼򵥷�װ����:
		
		public static String format(String format, Object... args) {
		    return new Formatter().format(format, args).toString();
		}		

					
						
	*/
    public static void main(String[] args) {
        int x = 5;
        double y = 3.141592;
        
        System.out.println("x = " + x + ", y = " + y);	// һ�㷽ʽ       
        System.out.printf("x = %d, y = %f\n", x, y);	// printf()��ʽ	        
        System.out.format("x = %d, y = %f\n", x, y);	// format()��ʽ
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

// �򵥵�ʮ������ת������
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

// java�и�ʽ�����
class TestNumber
{
	public static void main(String[] args)
	{
		String name = "����";
		int kill = 8;
		String title = "����";
		
		String sentence = name + " �ڽ���������  " + kill + " �λ�ɱ�󣬻���� " + title + " �ĳƺ� ";
		//ֱ��ʹ��+�����ַ������ӣ�����о���ȽϷ���������ά���Բ�׶��Բ�
		System.out.println(sentence);
		
		String sentenceFormat = "%s �ڽ��������� %d �λ�ɱ�� ����� %s �ĳƺ�%n";
		//��ʽ�������%s��ʾ�ַ�����%d��ʾ���֣�%n��ʾ����
		System.out.printf(sentenceFormat, name, kill, title);
		System.out.format(sentenceFormat, name, kill, title);
		//format��printf�ܹ��ﵽһģһ����Ч��
		
		int year = 2020; 
		
		System.out.format("%d%n",year);		//��%n��\nû��
		//ֱ�Ӵ�ӡ����
		System.out.printf("%8d%n",year);	//��printf����formatû��
		//�ܳ���Ϊ8��Ĭ���Ҷ���
		System.out.printf("%-8d%n",year);
		//�ܳ���Ϊ8��Ĭ�������
		System.out.printf("%08d%n",year);
		//�ܳ���Ϊ8��������0
		System.out.printf("%,8d%n",year*10000);
		//ǧλ�ָ���
		System.out.format("%.2f%n",Math.PI);
		//С����λ��
	
	}	
}


