/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptfms.Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LucaB
 */
public class MockDiagnosticService implements DiagnosticService {
    private final Map<String, Integer> faultDB = new HashMap<>();
    private String componentName;

    public MockDiagnosticService() {
        // simulate a fault: e.g. engine overheating = code 5
        faultDB.put("bus123:Engine", 5);
    }

    @Override
    public int getFaultCode(Object vehicleId) {
        
        return faultDB.getOrDefault(vehicleId + ":" + componentName, 0);
    }

    @Override
    public int getFaultCode(Object vehicle, String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
