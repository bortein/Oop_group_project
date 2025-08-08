/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptfms.Strategy;

import com.ptfms.model.Component;

/**
 *
 * @author LucaB
 */
public class ElectricAlertStrategy implements AlertStrategy {
    private final double maxVoltage;
    private final double maxCurrent;

    public ElectricAlertStrategy(double maxVoltage, double maxCurrent) {
        this.maxVoltage = maxVoltage;
        this.maxCurrent = maxCurrent;
    }

    @Override
    public boolean shouldAlert(Component component) {
        // assume component stores lastMeasurement as a map
        double voltage = component.getMeasurement("voltage");
        double current = component.getMeasurement("current");
        return voltage > maxVoltage || current > maxCurrent;
    }
}

