package io.aadeesh.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Value("${io.aadeesh.itinerary.email.body}")
	private String EMAIL_BODY;
	
	@Value("${io.aadeesh.itinerary.email.subject}")
	private String EMAIL_SUBJECT;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("Inside sendItinerary() ");
		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);

		} catch (MessagingException e) {
			LOGGER.error("Exception occured " + e);
		}
	}
}
