package com.joinjoy.service;

import java.util.List;
//import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joinjoy.dto.UserFollowerDTO;
import com.joinjoy.model.FollowerRepository;
import com.joinjoy.model.bean.Follower;
import com.joinjoy.model.bean.Organizer;
import com.joinjoy.model.bean.Userinfo;

//import jakarta.mail.Authenticator;
//import jakarta.mail.Message;
//import jakarta.mail.MessagingException;
//import jakarta.mail.Multipart;
//import jakarta.mail.PasswordAuthentication;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeBodyPart;
//import jakarta.mail.internet.MimeMessage;
//import jakarta.mail.internet.MimeMultipart;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;
    @Transactional
    public Integer showOrganizerFollowed(Integer oid) {
    	return followerRepository.countByOrganizerId(oid);
    }

    // 追蹤~
    @Transactional
    public Follower followOrganizer(Userinfo user, Organizer organizer) {
        Follower follower = new Follower();
        follower.setUserid(user.getUserid());
        follower.setOid(organizer.getOid());
        return followerRepository.save(follower);
    }
    // 追蹤~
    @Transactional
    public Follower followOrganizer(UserFollowerDTO user, Organizer organizer) {
        Follower follower = new Follower();
        follower.setUserid(user.getUserid());
        follower.setOid(organizer.getOid());
        return followerRepository.save(follower);
    }


    // 取消追蹤~
    @Transactional
    public void unfollowOrganizer(Userinfo user, Organizer organizer) {
        Follower follower = followerRepository.findByUseridAndOid(user.getUserid(), organizer.getOid());
        if (follower != null) {
            followerRepository.delete(follower);
        }
    }
    @Transactional
    public void unfollowOrganizer(UserFollowerDTO user, Organizer organizer) {
        Follower follower = followerRepository.findByUseridAndOid(user.getUserid(), organizer.getOid());
        if (follower != null) {
            followerRepository.delete(follower);
        }
    }

    //檢查是否已經追蹤~
    public boolean isFollowing(Userinfo user, Organizer organizer) {
        return followerRepository.findByUseridAndOid(user.getUserid(), organizer.getOid()) != null;
    }
    public boolean isFollowing(UserFollowerDTO user, Organizer organizer) {
        return followerRepository.findByUseridAndOid(user.getUserid(), organizer.getOid()) != null;
    }

    //寄信
//    @Async
//    public void sendEmail(String toAddress, String subject, String htmlBody) throws MessagingException {
//        // 配置郵件服務器的參數
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP 服務器地址
//        properties.put("mail.smtp.port", "587");             // SMTP 服務器端口
//        properties.put("mail.smtp.auth", "true");            // 需要身份驗證
//        properties.put("mail.smtp.starttls.enable", "true"); // 啟用TLS
//
//        // 配置發件人的用戶名和密碼
//        final String username = "group2.stmp@gmail.com";
//        final String password = "tgnqxoyfsfrhudtp";
//
//        // 創建會話
//        Session session = Session.getInstance(properties,
//                new Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        // 創建一個郵件消息
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(username));
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
//        message.setSubject(subject);
//
//        // 設置郵件內容為 HTML
//        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        mimeBodyPart.setContent(htmlBody, "text/html; charset=utf-8");
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(mimeBodyPart);
//        message.setContent(multipart);
//
//        // 發送郵件
//        Transport.send(message);
//
//        System.out.println("Email sent successfully");
//        
//        
//    	};
    
    	
    	
		//會員專區-查看已追蹤的主辦單位
		public List<Follower> findByUserid(Integer userid) {
		
			return followerRepository.findByUserid(userid);
		}
}
