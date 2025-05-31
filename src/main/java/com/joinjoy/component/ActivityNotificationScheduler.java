//package com.joinjoy.component;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.joinjoy.service.NotificationService;
//
//@Component
//public class ActivityNotificationScheduler {
//	
//	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//    
//	@Autowired
//    private NotificationService ntfService;
//
//    public void start() {
        // 定時任務，每天執行一次
//        scheduler.scheduleAtFixedRate(this::sendActivityRemindNotification, 0, 2, TimeUnit.MINUTES);
//    }
//
//    private void sendActivityRemindNotification() {
//    	ntfService.sendActivityRemindNotification();
//    }
//
//    public void shutdown() {
//        scheduler.shutdown();
//    }
//
//}
