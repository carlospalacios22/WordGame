public class Players extends Person {
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Players() {
        super(firstName);
        this.money = 1000;
    }

    public Players(String firstName, String lastName) {
        super(firstName, lastName);
        this.money = 1000;
    }

    public Players(String firstName) {
        super(firstName);
        this.money = 1000;
    }
//have the initial money be shown in the toString method not working

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " now has $" + money + " dollars.";
    }// end of toString method

    
}// end of Players class
