package genericLib;


import org.apache.commons.mail.*;


public class SentEmail{
public static void sentEmail() throws Exception {
  // Create the attachment
  EmailAttachment attachment = new EmailAttachment();
  attachment.setPath(System.getProperty("user.dir")+"\\IndexErpReports\\IndexErp.html");
  attachment.setDisposition(EmailAttachment.ATTACHMENT);
  attachment.setDescription("Automation test report");
  attachment.setName("IndexErpReport");

  // Create the email message
  MultiPartEmail email = new MultiPartEmail();
  email.setHostName("smtp.gmail.com");
  email.setSmtpPort(25);
  email.setAuthenticator(new DefaultAuthenticator("nanda.guin@gmail.com", "myattitude"));
  email.setSSLOnConnect(true);
  email.setFrom("nanda.guin@gmail.com");
  email.setSubject("TestMail");
  email.setMsg("This is a test mail ... :-)");
  email.addTo("sibanandaguin123@gmail.com");

  // add the attachment
  email.attach(attachment);

  // send the email
  email.send();
}
}