

//  a person with a first name and a last name.
public class Person {
    private String firstName;
    private String lastName;
    //  a person with a first name and a last name.
    public Person(String firstName) {
      this.firstName = firstName;
      this.lastName = "";
    }
  
    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
    
    // getters and setters
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
    }// End of getters and setters


  }// End of Person class


  
