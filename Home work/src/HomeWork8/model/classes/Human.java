package HomeWork8.model.classes;

public abstract class Human {
    private String firstName;
    private String midlName;
    private String lastName;

    public Human(String firstName, String midlName, String lastName) {
        this.firstName = firstName;
        this.midlName = midlName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidlName() {
        return midlName;
    }

    public String getLastName() {
        return lastName;
    }

}
