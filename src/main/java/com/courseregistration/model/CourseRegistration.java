/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.model;

/**
 *
 * @author Me
 */

public class CourseRegistration {
    private int id;
    private String matno;
    private String coursecode;
    private int term;
    private String academicsession;
	
    
    public CourseRegistration() {
		
    }
	
    public CourseRegistration(String matno, String coursecode, int term, String academicsession) {
        this.matno = matno;
        this.coursecode = coursecode;
        this.term = term;
        this.academicsession = academicsession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatno() {
        return matno;
    }

    public void setMatno(String matno) {
        this.matno = matno;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getAcademicsession() {
        return academicsession;
    }

    public void setAcademicsession(String academicsession) {
        this.academicsession = academicsession;
    }
    
    
}

