public class Players extends Person {
    private int money;
  
    public int getMoney() {
      return money;
    }
  
    public void setMoney(int money) {
      this.money = money;
    }
  
    public Players(String firstName, String lastName) {
      super(firstName, lastName);
      this.money = 1000;
    }
  
    public Players(String firstName) {
      super(firstName);
      this.money = 1000;
    }
  
    @Override
    public String toString() {
      return "Player: " + getFirstName() + " " + getLastName() + " - Current of money: $" + money;
    }
  }
  
