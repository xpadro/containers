package xpadro.bootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tweet {
    @Id
    private Long id;
    private String screenName;
    private String text;

    public Tweet() {
    }

    public Tweet(Long id, String screenName, String text) {
        this.id = id;
        this.screenName = screenName;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", screenName='" + screenName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
