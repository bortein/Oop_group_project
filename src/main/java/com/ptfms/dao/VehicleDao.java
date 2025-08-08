/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptfms.dao;
// VehicleDao.java

import com.ptfms.model.Vehicle;
import java.util.List;

public interface VehicleDao {
    void save(Vehicle v);
    Vehicle findById(String id);
    List<Vehicle> findAll();
}
