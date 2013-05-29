package com.sirma.itt.javacourse.fluent;

import java.util.ArrayList;
import java.util.List;

/**
 * Create base structure of e-mail using Fluent Interface concept.
 * 
 * @version 1.1 29 May 2013
 * @author Stella Djulgerova
 */
public class Mail {

	// class private members
    private String from = "";
    private String to = "";
    private String subject = "";
    private String content = "";
    private String CC = "";
    private List<String> attachments;

    /**
     * Constructor. Make field "from" mandatory for each email
     * 
     * @param from - sender e-mail
     */
    public Mail(String from) {
    	this.from = from;
    	attachments = new ArrayList<String>();
    }

    /**
     * Add receiver e-mail to the mail object.
     * 
     * @param to - receiver email
     * @return mail object
     */
    public Mail addReciver(String to)
    {
        this.to = to;
        return this;
    }

    /**
     * Add subject to the e-mail object.
     * 
     * @param subject - e-mail subject
     * @return mail object
     */
    public Mail addSubject(String subject)
    {
        this.subject = subject;
        return this;
    }
    
    /**
     * Add content to the e-mail object.
     * 
     * @param content - e-mail content
     * @return mail object
     */
    public Mail addContent(String content)
    {
        this.content = content;
        return this;
    }

    /**
     * Add CC to the e-mail object.
     * 
     * @param CC - e-mail CC
     * @return mail object
     */
    public Mail addCC(String CC)
    {
        this.CC = CC;
        return this;
    }

    /**
     * Add attachment to the e-mail object.
     *      
     * @param attachment - attachment to be added
     * @return mail object
     */
    public Mail addAttachment(String attachment)
    {
        this.attachments.add(attachment);
        return this;
    }
    
    /**
     * Print constructed from user e-mail.
     */
    public void print()
    {
    	System.out.println("From: 	 	" + this.from );
    	System.out.println("To: 	 	" + this.to);
    	System.out.println("Subject: 	" + this.subject);
    	System.out.println("Content: 	" + this.content);
    	System.out.println("CC: 	 	" + this.CC);
    	System.out.println("Attachments:");
    	
    	for(String att: attachments) {
    		System.out.println("		" + att);
    	}
    }
}
