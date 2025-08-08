/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptfms.dao;

import com.ptfms.business.observer.AlertLogger;
import java.util.List;

/**
 *
 * @author LucaB
 */
public interface MaintenanceAlertDao {
    void save(AlertLogger a);
    List<AlertLogger> findUnresolved();
    void markResolved(int id);
}
