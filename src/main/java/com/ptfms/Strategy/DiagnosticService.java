/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptfms.Strategy;

/**
 *
 * @author LucaB
 */
public interface DiagnosticService {
    /**
     * Fetches the highest-severity fault code for a given component.
     * 0 means no fault; higher numbers indicate severity.
     */
    int getFaultCode(Object vehicleId);

    public int getFaultCode(Object vehicle, String name);
}

