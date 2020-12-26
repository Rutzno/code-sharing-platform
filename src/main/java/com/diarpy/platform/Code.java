package com.diarpy.platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author Mack_TB
 * @version 1.0.7
 * @since 12/20/2020
 */

@Entity
public class Code {

    private static final String DATE_FORMATTER = "YYYY/MM/dd HH:mm:ss";

    @Id
    @JsonIgnore
    private String id;
    private String code;
    private String date;
    private long time;
    private int views;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "views_limit")
    private boolean viewsLimit = false;

    {
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        date = LocalDateTime.now().toString();
    }

    public Code() { }

    public Code(String code, long time, int views) {
        this.code = code;
        this.time = time;
        this.views = views;
        if (views > 0) {
            viewsLimit = true;
        }
    }

    public Code(String id, String code, String date, long time, int views) {
        this(code, time, views);
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


    public boolean isViewsLimit() {
        return viewsLimit;
    }

    public void setViewsLimit(boolean viewsLimit) {
        this.viewsLimit = viewsLimit;
    }

    public static String getFormattedDateTime(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        return localDateTime.format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }
}
