package HomeWork9.model.data;

import java.util.Date;

public abstract class SimpleNote {
    private int counterID = 100000;
    private int id;
    private String title;
    private StringBuilder text;
    private String data;

    public SimpleNote() {
        this.id = ++this.counterID;
        this.data = new Date().toString().replaceAll(" ", "-");
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
