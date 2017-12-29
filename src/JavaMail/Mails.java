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
		String subject="第一封项目邮件";
		String s;
		s = generate6DigitRandomString();
		
		System.out.println(s);
		String context="如果您能看到这封邮件说明现在<font color='red'>我们论文盲审项目的邮件模块完成了</font>，不必回复。<br/>邵广杰";
		
		sendMail(destMail, subject, context);//调用发送邮件函数
	}

	/**
	 * @return 生成6位随机数
	 */
	public static String generate6DigitRandomString() {
		String s;
		Random r=new Random();
		s=new String().valueOf(Math.abs(r.nextLong())).substring(0, 6);//生成六位随机数
		return s;
	}

	/**
	 * @param destMail 目的邮箱
	 * @param subject  标题
	 * @param context  正文
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendMail(String destMail, String subject, String context)
			throws MessagingException, AddressException {
		Properties prop=new Properties();
		prop.setProperty("mail.smtp.host","smtp.sina.com") ;//主机属性
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.transport.protocol", "smtp");
		
		Authenticator auth=new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){//邮箱验证
				return new PasswordAuthentication("snow_lands","4004123a");
			}
		};
		Session session=Session.getInstance(prop, auth);
		Date date=new Date();
		String timeStamp=date.toLocaleString();//日期
		MimeMessage msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("snow_lands@sina.com"));//源邮箱
		msg.setRecipients(RecipientType.TO, destMail);//目的邮箱
		msg.setSubject(subject);//邮箱标题
		msg.setContent(context+timeStamp, "text/html;charset=utf-8");//邮箱正文
		
		Transport.send(msg);
	}

}
