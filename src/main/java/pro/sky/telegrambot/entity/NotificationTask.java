package pro.sky.telegrambot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_tasks")
public class NotificationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userID;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(name = "notificationn_date_time", nullable = false)
    private LocalDateTime notificationDateTime;

    public NotificationTask(long userID, String message, LocalDateTime notificationDateTime) {
        this.userID = userID;
        this.message = message;
        this.notificationDateTime = notificationDateTime;
    }

    public NotificationTask() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getNotificationDateTime() {
        return notificationDateTime;
    }

    public void setNotificationDateTime(LocalDateTime notificationDateTime) {
        this.notificationDateTime = notificationDateTime;
    }
}
