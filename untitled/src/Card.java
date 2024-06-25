public class Card {
    private Integer id;
    private double balance;

    public Transaction[] todayTransactionList() {
        return null;
    }

    public double currentAmount() {
        return 0.0;
    }

    public double getTransactionAmountByDay() {
        return 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
