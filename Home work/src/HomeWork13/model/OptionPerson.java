package HomeWork13.model;

public class OptionPerson implements IGetPersonInfo {
    @Override
    public String getInfo(Person person) {
        return person.id + " " +
                person.midlName + " " +
                person.firstName + " " +
                person.lastName + " " +
                person.dateOfBirth + " " +
                person.gender + " " +
                person.phone;
    }
}
