public class Person {

// made some changes to reduce the warnings suggestions by the IDE.

    protected static String firstName; // changed to protected so that it can be accessed by the Players class
    private String lastName; // changed to private so that it can only be accessed by the Person class

    public Person(String firstName) 
    {
        Person.firstName = firstName;
        this.lastName = "";// added a "blank" to lastName
    }


// added a constructor to set the first and last name
    public Person(String firstName, String lastName) {
        Person.firstName = firstName;
        this.lastName = lastName;
    }
// added a toString method to return the first name
    public String getFirstName() {
        return firstName;
    }
// added a toString method to return the first name
    public void setFirstName(String firstName) {
        Person.firstName = firstName;
    }
// added a toString method to return  and last name
    public String getLastName() {
        return lastName;
    }
// added a toString method to return the last name
    public void setLastName(String lastName) {
        
        this.lastName = lastName;

        
    }// end of setLastName method
}// end of Person class
