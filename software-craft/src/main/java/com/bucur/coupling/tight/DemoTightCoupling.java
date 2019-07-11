package com.bucur.coupling.tight;

public class DemoTightCoupling {

}

class Subject {

    Topic topic = new Topic();

    public void startReading() {
        topic.understand();
    }
}


class Topic {

    // if this changes I also need to change it everywhere it is called
    public void understand() {
        System.out.println("tight coupling concept");
    }
}