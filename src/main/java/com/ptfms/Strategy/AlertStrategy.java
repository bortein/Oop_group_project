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
public interface AlertStrategy {
    /**
     * Return true if this component’s state warrants an alert.
     * @param component
     * @return 
     */
    boolean shouldAlert(Component component);
}

