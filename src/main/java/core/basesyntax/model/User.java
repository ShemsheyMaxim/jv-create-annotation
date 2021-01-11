package core.basesyntax.model;

public class User {
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public User(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{"
                + "firstName = '" + firstName + '\''
                + ", lastName = '" + lastName + '\''
                + ", number = '" + phoneNumber + '\''
                + '}';
    }
}
