package com.bucur.coupling.loose;

interface Topic {

    void understand();
}

/*
If the only knowledge that class A has about class B,
is what class B has exposed through its interface, then
class A and class B are said to be loosely coupled.
 */
public class DemoLooseCoupling {

    public static void main(String[] args) {
        Topic topic = new Topic1();
        topic.understand();
    }
}

class Topic1 implements Topic {

    @Override
    public void understand() {
        System.out.println("got it!");
    }
}

class Topic2 implements Topic {

    @Override
    public void understand() {
        System.out.println("understand");
    }
}

