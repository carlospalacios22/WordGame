
// This class represents a person with a first name and a last name.
public class Person {

  // Instance variables
    private String firstName;
    private String lastName;

    // Constructor
    public Person(String firstName) {
      this.firstName = firstName;
      this.lastName = "";
    }
    // Constructor
    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }


    // Getters and setters  {getFirstName, setFirstName, getLastName, setLastName}
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

    }//end of getters and setters



  }//end of Person class
  
