import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private Terminal terminal;
    private Card card;
    private double faire;
    private LocalDateTime createDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public Card getCard() {
        return card;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getFaire() {
        return faire;
    }

    public void setFaire(double faire) {
        this.faire = faire;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", terminal=" + terminal +
                ", card=" + card +
                ", faire=" + faire +
                ", createDate=" + createDate +
                '}';
    }
}


