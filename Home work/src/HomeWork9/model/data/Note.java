package HomeWork9.model.data;

public class Note extends SimpleNote {
    private String status;
    private String state;

    public Note(String status, String title, String text, String state) {
        this.setStatus(status);
        super.setTitle(title);
        super.setText(new StringBuilder(text));
        this.setState(state);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return super.getId() + " " + super.getData() + " " + this.getStatus() + " " + super.getTitle() + " " + super.getText() + " " + this.getState();

    }
}
