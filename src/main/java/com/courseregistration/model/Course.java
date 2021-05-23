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
public class Course {
    private int id;
    private String coursecode;
    private String coursename;
    private int term;
    private int creditunit;
	
    public Course() {
		
    }
	
    public Course(String coursecode, String coursename, int term, int creditunit) {
        this.coursecode = coursecode;
        this.coursename = coursename;
        this.term = term;
        this.creditunit = creditunit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCreditunit() {
        return creditunit;
    }

    public void setCreditunit(int creditunit) {
        this.creditunit = creditunit;
    }
   
}