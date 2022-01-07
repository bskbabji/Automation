package com.java;

public class string_BufferAndStringBuilder {

	public static void main(String[] args) {
		String str = "Practical";// string literal , stored in string constand
									// pool
		String str2 = new String("Learning");// stored in heap area
		StringBuffer sb = new StringBuffer("HelloWorld");
		System.out.println("string buffer capacity 1...." + sb.capacity());
		sb.append("Welcome");
		System.out.println("string buffer capacity 2...." + sb.capacity());
		System.out.println(sb);// HelloWorldWelcome
		sb.insert(3, "Hi");
		System.out.println("string buffer capacity 3...." + sb.capacity());
		System.out.println(sb);// HelHiloWorldWelcome
		sb.replace(7, 10, "abc");
		System.out.println("string buffer capacity 4...." + sb.capacity());
		System.out.println(sb);// HelHiloabcldWelcome
		sb.delete(3, 5);
		System.out.println("string buffer capacity 5...." + sb.capacity());
		System.out.println(sb);// HelloabcldWelcome
		sb.reverse();
		System.out.println("string buffer capacity 6...." + sb.capacity());
		System.out.println(sb);//emocleWdlcbaolleH
		System.out.println(sb.capacity());// 
		sb.ensureCapacity(10);//now no change  
		System.out.println(sb.capacity());//now 26
		sb.ensureCapacity(50);//now (26*2)+2=54 i.e (oldcapacity*2)+2  
		System.out.println(sb.capacity());//now 54
		System.out.println("-------------------------------------");
		StringBuilder sbuild=new StringBuilder("selenium");
		System.out.println("sbuild capacity 1   " + sbuild.capacity());
		sbuild.append("Java");
		System.out.println("sbuild capacity 2   " + sbuild.capacity());
		System.out.println(sbuild);//seleniumJava
		sbuild.insert(4, "Hello");//
		System.out.println("sbuild capacity 3    " + sbuild.capacity());
		System.out.println(sbuild);//seleHelloniumJava
		sbuild.replace(9, 12, "How");
		System.out.println("sbuild capacity 4    " + sbuild.capacity());
		System.out.println(sbuild);//seleHelloHowmJava
		sbuild.deleteCharAt(7);
		System.out.println("sbuild capacity 5    " + sbuild.capacity());
		System.out.println(sbuild);//seleHeloHowmJava
		sbuild.delete(5, 8);
		System.out.println("sbuild capacity 6    " + sbuild.capacity());
		System.out.println(sbuild);//seleHHowmJava
		sbuild.reverse();
		System.out.println("sbuild capacity 7    " + sbuild.capacity());
		System.out.println(sbuild);//avaJmwoHHeles
		System.out.println(sb.capacity());//now 54  
		sb.append("java is my favourite language. HI How are doing . I am good , how about you");  
		System.out.println(sb.capacity());//now (54*2)+2=110 i.e (oldcapacity*2)+2  
		sb.ensureCapacity(10);//now no change  
		System.out.println(sb.capacity());//now 110  
		sb.ensureCapacity(120);//now (110*2)+2 = 222  
		System.out.println(sb.capacity());//now 222
	}

}
