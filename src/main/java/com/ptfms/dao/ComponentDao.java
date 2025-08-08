/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptfms.dao;

import com.ptfms.model.Component;
import java.util.List;

public interface ComponentDao {
    void save(Component c);
    Component findById(int id);
    List<Component> findByVehicle(String vehicleId);
    void updateUsage(int id, double usage);
}
