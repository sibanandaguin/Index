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
  email.setAuthenticator(new DefaultAuthenticator("sibanandaguin123@gmail.com", "myhighvision"));
  email.setSSLOnConnect(true);
  email.setFrom("sibanandaguin123@gmail.com");
  email.setSubject("IndexErp Test Reports");
  email.setMsg("Automation Test Result");
  email.addTo("nanda.guin@gmail.com");
  email.addTo("kkbeura1993@gmail.com");

  // add the attachment
  email.attach(attachment);

  // send the email
  email.send();
}
}