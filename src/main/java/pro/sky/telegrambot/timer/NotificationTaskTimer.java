package pro.sky.telegrambot.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.service.NotificationTaskService;
import pro.sky.telegrambot.service.TelegramBotService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationTaskTimer {

    private final NotificationTaskService notificationTaskService;
    private final TelegramBotService telegramBotService;

    public NotificationTaskTimer(NotificationTaskService notificationTaskService,
                                 TelegramBotService telegramBotService) {
        this.notificationTaskService = notificationTaskService;
        this.telegramBotService = telegramBotService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void task() {
        notificationTaskService.findByDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
                .forEach(notificationTask ->
                        telegramBotService.sendMessage(notificationTask.getUserID(),
                        notificationTask.getMessage()
                        )
                );
    }



}
