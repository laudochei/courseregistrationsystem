/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.service;


import com.courseregistration.model.CourseRegistration;
import java.util.List;

/**
 *
 * @author Laud.Ochei
 */
public interface CourseRegistrationService {
    List<CourseRegistration> findAll();
    CourseRegistration findID(Integer regID);
    void save(CourseRegistration courseregistration);
    void update(CourseRegistration courseregistration);
    void delete(Integer regID);
    int RegIDExists(Integer regID);
        
}
