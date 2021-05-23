/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.exception;

/**
 *
 * @author Laud.Ochei
 */
public class MessageException extends Exception{
        private static final long serialVersionUID = 1L;
	private String statusMessage;
        private String strField;

	public String getStatusMessage() {
            return statusMessage;
	}
        
        public String getstrField() {
            return strField;
	}
        
        
	public MessageException(String statusMessage) {
		super(statusMessage);
		this.statusMessage = statusMessage;
	}
	public MessageException() {
		super();
	}
    
    
}
