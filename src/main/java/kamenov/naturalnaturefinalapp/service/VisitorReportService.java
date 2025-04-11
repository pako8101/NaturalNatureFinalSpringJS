package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.repositories.DailyVisitorCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VisitorReportService {

    @Autowired
    private DailyVisitorCountRepository dailyVisitorCountRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "0 44 21 * * *") // Всеки ден в 23:59
    public void sendDailyVisitorReport() {
        LocalDate today = LocalDate.now();
        Long uniqueVisitors = dailyVisitorCountRepository.findByDate(today)
                .map(dvc -> dvc.getUniqueVisitors())
                .orElse(0L);

        // Изпращане на имейл
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("pako810129@gmail.com"); // Замени с твоя имейл
        message.setSubject("Daily Visitor Report for " + today);
        message.setText("Hello,\n\nToday, " + today + ", your website had " + uniqueVisitors + " unique visitors.\n\nBest regards,\nYour Website Team");
        mailSender.send(message);
    }
}
