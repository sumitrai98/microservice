package com.capefox.common;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Configure mail sender properties such as host, port, username, password, etc.
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587); // Example port
        mailSender.setUsername("sumitraichhotu@gmail.com");
        mailSender.setPassword("sxeu zonf ktqw mwcx");
        
        
        // Additional properties (if needed)
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Enable debug mode for troubleshooting
        
        return mailSender;
    }
	/*server.port=8081
			spring.mail.properties.mail.smtp.starttls.enable=true
			spring.mail.properties.mail.smtp.auth=true
			spring.mail.host=smtp.gmail.com
			spring.mail.username=sumitraichhotu@gmail.com
			spring.mail.password=sxeu zonf ktqw mwcx
			spring.mail.port=587*/


}
