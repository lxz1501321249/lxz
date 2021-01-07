package com.lxz.demo;

class A {
    private int i;
    public int j;

    private void f() {
    }

    public void g() {
    }

    public A() {
        this.i = 100;
        this.j = 200;
    }

    private A(int i, int j) {
        this.i = i;
        this.j = j;
    }


}

public class Test {
    public static void main(String[] args) {


        Class<A> c1 = A.class;

        Class<A> c2;

        {
            try {
                c2 = (Class<A>) Class.forName("com.example.demo.A");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        A a = new A();
        Class<? extends A> c3 = a.getClass();


        System.out.println(c1.getName());


    }

}


