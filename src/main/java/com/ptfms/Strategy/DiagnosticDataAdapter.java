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
public class DiagnosticDataAdapter implements AlertStrategy {
    private final DiagnosticService service;

    public DiagnosticDataAdapter(DiagnosticService service) {
        this.service = service;
    }

    @Override
    public boolean shouldAlert(Component component) {
        int code = service.getFaultCode(
            component.getVehicle(),
            component.getName()
        );
        return code > 0;
    }
}
