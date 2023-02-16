// begin of Players 
public class Players extends Person {
    private int money;

  // getters and setters
    public int getMoney() {
      return money;
    }
  
    public void setMoney(int money) {
      this.money = money;
    }// end of getters and setters

    public Players(String firstName, String lastName) {
      super(firstName, lastName);
      this.money = 1000;
    }
  
    public Players(String firstName) {
      super(firstName);
      this.money = 1000;
    }

  //override the toString method
    @Override
    public String toString() {
      return "Player: " + getFirstName() + " " + getLastName() + " - Current of money: $" + money;
    }

    public void addWinnings(int iNCREMENT_AMOUNT) {
    }

    public void addLosses(int dECREMENT_AMOUNT) {
    }

  }// End of Players class
