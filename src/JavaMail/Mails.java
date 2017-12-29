package JavaMail;

import java.sql.Time;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class Mails {

	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws AddressException, MessagingException {
		String destMail="fire7003@126.com";
		String subject="��һ����Ŀ�ʼ�";
		String s;
		s = generate6DigitRandomString();
		
		System.out.println(s);
		String context="������ܿ�������ʼ�˵������<font color='red'>��������ä����Ŀ���ʼ�ģ�������</font>�����ػظ���<br/>�۹��";
		
		sendMail(destMail, subject, context);//���÷����ʼ�����
	}

	/**
	 * @return ����6λ�����
	 */
	public static String generate6DigitRandomString() {
		String s;
		Random r=new Random();
		s=new String().valueOf(Math.abs(r.nextLong())).substring(0, 6);//������λ�����
		return s;
	}

	/**
	 * @param destMail Ŀ������
	 * @param subject  ����
	 * @param context  ����
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendMail(String destMail, String subject, String context)
			throws MessagingException, AddressException {
		Properties prop=new Properties();
		prop.setProperty("mail.smtp.host","smtp.sina.com") ;//��������
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.transport.protocol", "smtp");
		
		Authenticator auth=new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){//������֤
				return new PasswordAuthentication("snow_lands","4004123a");
			}
		};
		Session session=Session.getInstance(prop, auth);
		Date date=new Date();
		String timeStamp=date.toLocaleString();//����
		MimeMessage msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("snow_lands@sina.com"));//Դ����
		msg.setRecipients(RecipientType.TO, destMail);//Ŀ������
		msg.setSubject(subject);//�������
		msg.setContent(context+timeStamp, "text/html;charset=utf-8");//��������
		
		Transport.send(msg);
	}

}
