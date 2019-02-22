package CodeSequence;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Block {

    @Test
    public void test (){
        B b = new B();
        b.go();
    }

    class B {
        B(){}
        public void go() {
//方法中的局部代码块，一般进行一次性地调用，调用完立刻释放空间，避免在接下来的调用过程中占用栈空间
//因为栈空间内存是有限的，方法调用可能会会生成很多局部变量导致栈内存不足。
//使用局部代码块可以避免这样的情况发生。
            {
                int i = 1;
                ArrayList<Integer> list = new ArrayList<>();
                while (i < 10) {
                    list.add(i ++);
                }
                for (Integer j : list) {
                    System.out.println(j);
                }
                System.out.println("gogogo");
            }
            System.out.println("hello");
        }
    }

    class A{
        int i = 1;
        int initValue;//成员变量的初始化交给代码块来完成
        {
//            代码块的作用体现于此：在调用构造方法之前，用某段代码对成员变量进行初始化。
//            而不是在构造方法调用时再进行。一般用于将构造方法的相同部分提取出来。
//
            for (int i = 0;i < 100;i ++) {
                initValue += i;
            }
        }
        {
            System.out.println(initValue);
            System.out.println(i);//此时会打印1
            int i = 2;//代码块里的变量和成员变量不冲突，但会优先使用代码块的变量
            System.out.println(i);//此时打印2
//            System.out.println(j);//提示非法向后引用，因为此时j的的初始化还没开始。
//
        }
        {
            System.out.println("代码块运行");
        }
        int j = 2;
        {
            System.out.println(j);
            System.out.println(i);//代码块中的变量运行后自动释放，不会影响代码块之外的代码
        }
        A(){
            System.out.println("构造方法运行");
        }
    }

    @Test
    public void testA (){
        A a = new A();
    }

    @Test
    public void testC (){
        C c1 = new C();
        C c2 = new C();
    }

}
