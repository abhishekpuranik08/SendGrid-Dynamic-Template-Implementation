package com.example.demo;

import java.io.IOException;

import org.apache.catalina.connector.Response;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class SendGridTemplate {

	public static void SendGridUtilHost() throws IOException {
		Email from = new Email("From Sender Email");
		String subject = "";
		Email to = new Email("To Reciepient Email");
		Mail mail = new Mail();
		mail.setFrom(from);
		mail.setSubject("");
		Personalization personalisation = new Personalization();
		personalisation.addDynamicTemplateData("Your Template Key", "Your Dynamic Value");

		personalisation.addTo(to);
		mail.addPersonalization(personalisation);
		mail.setTemplateId("Your Template Id");

		SendGrid sg = new SendGrid("SendGrid Api Key");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			com.sendgrid.Response response = sg.api(request);
			System.out.println(response);

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
