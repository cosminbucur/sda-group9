package com.bucur.solid.dependency_inversion.after;

import com.bucur.solid.dependency_inversion.after.highlevel.ElectricPowerSwitch;
import com.bucur.solid.dependency_inversion.after.highlevel.Switch;
import com.bucur.solid.dependency_inversion.after.highlevel.Switchable;
import com.bucur.solid.dependency_inversion.after.lowlevel.Fan;
import com.bucur.solid.dependency_inversion.after.lowlevel.LightBulb;

public class DependencyInversionDemo {

    public static void main(String[] args) {
        Switchable switchableBulb = new LightBulb();
        Switch bulbPowerSwitch = new ElectricPowerSwitch(switchableBulb);
        bulbPowerSwitch.press();
        bulbPowerSwitch.press();

        Switchable switchableFan = new Fan();
        Switch fanPowerSwitch = new ElectricPowerSwitch(switchableFan);
        fanPowerSwitch.press();
        fanPowerSwitch.press();
    }
}
