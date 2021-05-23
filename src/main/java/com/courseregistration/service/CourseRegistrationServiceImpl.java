/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.service;




/**
 *
 * @author laud.c.ochei
 */



import com.courseregistration.data.CourseRegistrationDao;
import com.courseregistration.model.CourseRegistration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("courseregistrationService")
public class CourseRegistrationServiceImpl implements CourseRegistrationService {
	CourseRegistrationDao courseregistrationDao;

	@Autowired
	public void setCourseRegistrationDao(CourseRegistrationDao courseregistrationDao) {
		this.courseregistrationDao = courseregistrationDao;
	}

	
        
        @Override
	public List<CourseRegistration> findAll() {
		return courseregistrationDao.findAll();
	}
        
        
        @Override
	public CourseRegistration findID(Integer id) {
		return courseregistrationDao.findID(id);
	}
        
        
        @Override
	public void save(CourseRegistration courseregistration) {
            courseregistrationDao.save(courseregistration);
	}
       
        
        @Override
	public void update(CourseRegistration courseregistration) {
            courseregistrationDao.update(courseregistration);
	}
        
        
        @Override
        public void delete(Integer id) {    
            courseregistrationDao.delete(id);
        }
          
        
        @Override
        public int RegIDExists(Integer id) {
            return courseregistrationDao.RegIDExists(id);
        }
        
        
}
