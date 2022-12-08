package br.com.alura.escola.infra.indication;

import java.util.Properties;

import br.com.alura.escola.application.indication.EnviarEmailIndicacao;
import br.com.alura.escola.domain.aluno.Aluno;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		// lógica de envio de email com a lib Java Mail
		Properties props = new Properties();
		
		/* GMAIL
		props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    */
		
		props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
         
	    Session session = Session.getDefaultInstance(props,
	    		new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("emailempresa@email.com", "12345");
				}
		});
	    
	    session.setDebug(true);
	    
	    try {
	    	Message message = new MimeMessage(session);
	    	message.setFrom(new InternetAddress("emailempresa@email.com"));
	    	
	    	message.setRecipients(Message.RecipientType.TO,
	    			InternetAddress.parse("Luquinhas.martins@live.com"));
	    	
	    	message.setSubject("Title");
	    	message.setText("Content");
	    	
	    	Transport.send(message);
	    	
	    	System.out.println("Executado o envio");
	    	
	    } catch (MessagingException e) {
	    	throw new RuntimeException(e);
	    }
	}

}
