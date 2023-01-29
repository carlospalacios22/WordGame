
//Person class begin

public class Person {
    // private variables 
    private String firstName;
    private String lastName;
    private int money;  //may need to remove
  
  //Create two overloaded constructors for the Person class
    // First constructor
    public Person(String firstName) 
    {
        this.firstName = firstName;
        this.lastName = "";
    }

    // Second constructor
    public Person(String firstName, String lastName) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

  
  // Getters and Setters for the names
    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    
  
    public void increaseMoney(int amount) {
        money += amount;
    }
    
    public void decreaseMoney(int amount) {
        money -= amount;
    }
 

}// end of person class
