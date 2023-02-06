public class Person {
  

  //first name and last name
    private String firstName;
    private String lastName;
    
    public Person(String firstName) {
      this.firstName = firstName;
      this.lastName = "";
    }
    
    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
    //getters and setters
    public String getFirstName() {
      return firstName;
    }
    
    public String getLastName() {
      return lastName;
    }
    
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
      this.lastName = lastName;

    }

    
  }// End of Person
  
