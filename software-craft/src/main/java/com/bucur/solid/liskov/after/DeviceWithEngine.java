package com.bucur.solid.liskov.after;

import com.bucur.solid.liskov.before.Engine;

public class DeviceWithEngine {

    private Engine engine;

    void startEngine() {
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
