/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.data;

import com.courseregistration.model.CourseRegistration;
import java.util.List;

/**
 *
 * @author Me
 */
public interface CourseRegistrationDao { 
    List<CourseRegistration> findAll();
    CourseRegistration findID(Integer regID);
    void save(CourseRegistration courseregistration);
    void update(CourseRegistration courseregistration);
    void delete(Integer regID);
    int RegIDExists(Integer regID);
    //int CourseCodeExists(String name);
    //int StudentIDExists(String name);
}
