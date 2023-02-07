public class Person {


    protected static String firstName; // changed to protected so that it can be accessed by the Players class
    private String lastName; // changed to private so that it can only be accessed by the Person class

    public Person(String firstName) {
        Person.firstName = firstName;
        this.lastName = "";
    }

    public Person(String firstName, String lastName) {
        Person.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Person.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
