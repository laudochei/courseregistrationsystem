/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.controller;


/**
 *
 * @author laud.c.ochei
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.courseregistration.model.CourseRegistration;
import com.courseregistration.model.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import com.courseregistration.service.CourseRegistrationService;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.util.UriComponentsBuilder;
import com.courseregistration.exception.MessageException;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Laud.Ochei
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CourseRegistrationController {
    
        private CourseRegistrationService courseregistrationService;
	@Autowired
	public void setStudentService(CourseRegistrationService courseregistrationService) {
		this.courseregistrationService = courseregistrationService;
	}

	 
        
        // list courses registered
        @RequestMapping(value = "/courseregistration", method=GET)
        public List<CourseRegistration> displayCoursesRegistered(Model model) {
            return courseregistrationService.findAll();
        }
        
        
        
        //display a single record
        @RequestMapping(value = "/courseregistration/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getCourseRegistered(@PathVariable("id") Integer id) {
           
            CourseRegistration courseregistration = courseregistrationService.findID(id);
            if (courseregistration == null) {
		return new ResponseEntity("No record found for student ID " + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(courseregistration, HttpStatus.OK);
        }
        
        
        
        //add a single record
        @RequestMapping(value = "/courseregistration", method = RequestMethod.POST, headers = "Accept=application/json")
        public ResponseEntity<Void> addCourseRegistered(@RequestBody CourseRegistration courseregistration, UriComponentsBuilder ucb) throws MessageException {   
            int courseregistrationStatus = courseregistrationService.RegIDExists((int)courseregistration.getId());     
            if (courseregistrationStatus > 0) { 
                throw new MessageException("Record already exist for Course registered ID: " + courseregistration.getId());
            }
            courseregistrationService.save(courseregistration);
            HttpHeaders headers = new HttpHeaders();
            URI companyUri = ucb.path("/courseregistration/").path(String.valueOf(courseregistration.getId())).build().toUri();
            headers.setLocation(companyUri);
            headers.add("RegID", String.valueOf(courseregistration.getId()));
            ResponseEntity<Void> responseEntity = new ResponseEntity<Void> (headers, HttpStatus.CREATED);
            //return responseEntity;
            throw new MessageException("Record added successfully ID: " + courseregistration.getId());
        }
        
        
        //update a single record
        @RequestMapping(value = "/courseregistration/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
        public ResponseEntity<Void> updateCourseRegistered(@PathVariable("id") Integer id, @RequestBody CourseRegistration courseregistration) throws MessageException {
            CourseRegistration coursereg = courseregistrationService.findID(id);
            if (coursereg == null) {
		//return new ResponseEntity("No record found for course reg ID " + id, HttpStatus.NOT_FOUND);
                throw new MessageException("No record found for course reg ID: " + id);
            }
            
            courseregistrationService.update(courseregistration);
            String Msg ="Record updated for Course Registration ID: " + courseregistration.getId();
            HttpHeaders headers = new HttpHeaders();
            headers.add("SuccessMsg", Msg);
            ResponseEntity<Void> responseEntity = new ResponseEntity<Void> (headers, HttpStatus.CREATED);
            //return responseEntity;
            throw new MessageException("Record updated for Course Registration ID: " + courseregistration.getId());
        }
        
        
        //delete a single record
        @RequestMapping(value = "/courseregistration/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<CourseRegistration>  deleteCourseRegistered(@PathVariable("id") Integer id) throws MessageException {
            CourseRegistration courseregistration = courseregistrationService.findID(id);
            if (courseregistration == null) {
                throw new MessageException("No record found for course reg id: " + id);
            }  
           
            courseregistrationService.delete(id);
            throw new MessageException("Record deleted for course reg ID: " + courseregistration.getId());
        } 
        
        @ExceptionHandler(MessageException.class)
	public ResponseEntity<Message> exceptionMsgHandler(Exception ex) {
		Message mg = new Message();
		mg.setMessage(ex.getMessage());
		return new ResponseEntity<Message>(mg, HttpStatus.OK);
	}
    
}
