package com.korail.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




public class Mail_authController {
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET) 
	public void sendMailTest() throws Exception{
        
        String subject = "test ����";
        String content = "���� �׽�Ʈ ����";
        String from = "�������� ���̵�@�������ּ�";
        String to = "�޴��� ���̵�@�������ּ�";
        
            
            try {
                MimeMessage mail = mailSender.createMimeMessage();
                MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
                
                mailHelper.setFrom(from);
                mailHelper.setTo(to);
                mailHelper.setSubject(subject);
                mailHelper.setText(content, true);
                
                FileSystemResource file = new FileSystemResource(new File("D:\\test.txt")); 
                mailHelper.addAttachment("test.txt", file);            
                
                mailSender.send(mail);
                
            } catch(Exception e) {
                e.printStackTrace();
            }
            
	}
}