package CodeSequence;

public class C {
    C(){
        System.out.println("构造方法调用");
    }
    {
        System.out.println("代码块调用");
    }
    static {
        System.out.println("静态代码块调用");
    }
}
