import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Managing {
    private double faire;
    private Card[] cardArray = new Card[10];
    private int cardIndex = 0;
    private Terminal[] terminalArray = new Terminal[10];
    private int terminalIndex = 0;

    private Transaction[] transactionArray = new Transaction[10];
    private int transactionIndex = 0;
    private int generalId = 1;

    public void setFaire(double faire) {
        this.faire = faire;
    }

    public Card addCard(Integer id, double balance) {
        Card card = new Card();
        card.setId(id);
        card.setBalance(balance);

        if (cardArray.length == cardIndex) {
            Card[] newArr = new Card[cardArray.length * 2];
            for (int i = 0; i < cardArray.length; i++) {
                newArr[i] = cardArray[i];
            }
            cardArray = newArr;
        }
        cardArray[cardIndex++] = card;
        return null;
    }

    public Card getCard(Integer id) {
        for (int i = 0; i < cardArray.length; i++) {
            Card card = cardArray[i];
            if (card != null && card.getId().equals(id)) {
                return card;
            }
        }
        return null;
    }

    public Card recharge(Integer id, double amount) {
        Card card = getCard(id);
        if (card == null) {
            return null;
        }
        double nb = card.getBalance() + amount;
        card.setBalance(nb);


        return card;
    }

    public Card[] getCardList() {
        return cardArray;
    }

    public Terminal addTerminal(Integer id, String address) {
        Terminal terminal = new Terminal();
        terminal.setId(id);
        terminal.setAddress(address);

        if (terminalArray.length == terminalIndex) {
            Terminal[] newArr = new Terminal[terminalArray.length * 2];
            for (int i = 0; i < terminalArray.length; i++) {
                newArr[i] = terminalArray[i];
            }
            terminalArray = newArr;
        }
        terminalArray[terminalIndex++] = terminal;
        return terminal;
    }

    public Terminal getTerminalById(int id) {
        for (Terminal terminal : terminalArray) {
            if (terminal != null && terminal.getId().equals(id)) {
                return terminal;
            }
        }
        return null;

    }

    public Terminal[] terminalList() {
        return terminalArray;
    }

    public Transaction makeTransaction(Integer terminalId, Integer cardId) {
        Terminal terminal = getTerminalById(terminalId);
        if (terminal == null) {
            return null;
        }

        Card card = getCard(cardId);
        if (card == null) {
            return null;
        }

        if (card.getBalance() < faire) {
            return null;
        }
        LocalDateTime checkTime = LocalDateTime.now().minusMinutes(1);
        for (Transaction t : transactionArray) {
            if (t != null &&
                    t.getCard().getId().equals(cardId) &&
                    t.getTerminal().getId().equals(terminalId) &&
                    t.getCreateDate().isAfter(checkTime)) {

                return null;
            }
        }

        Transaction transaction = new Transaction();
        transaction.setId(generalId++);
        transaction.setTerminal(terminal);
        transaction.setCard(card);
        transaction.setFaire(faire);
        transaction.setCreateDate(LocalDateTime.now());

        double nb = card.getBalance() - faire;
        card.setBalance(nb);

        if (transactionArray.length == transactionIndex) {
            Transaction[] newArr = new Transaction[transactionArray.length * 2];
            for (int i = 0; i < transactionArray.length; i++) {
                newArr[i] = transactionArray[i];
            }
            transactionArray = newArr;
        }
        transactionArray[transactionIndex++] = transaction;

        return transaction;

    }

    public Transaction getById(Integer id) {
        for (Transaction t : transactionArray) {
            if (t != null && t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Transaction[] transactionListByTerminal(int terminalId) {
        Transaction[] tempArray = new Transaction[transactionIndex];
        int tempIndex = 0;
        for (Transaction t : transactionArray) {
            if (t != null && t.getTerminal().getId().equals(terminalId)) {
                tempArray[tempIndex++] = t;
            }
        }
        return tempArray;
    }

    public Transaction[] transactionListByCard(int cardId) {
        Transaction[] tempArr = new Transaction[transactionIndex];
        int tempIndex = 0;
        for (Transaction t : transactionArray) {
            if (t != null && t.getCard().getId().equals(cardId)) {
                tempArr[tempIndex++] = t;
            }
        }
        return tempArr;
    }

    public Transaction[] getTransactionsByDate(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(dataStr, formatter);

        Transaction[] tempArr = new Transaction[transactionIndex];
        int i = 0;
        for (Transaction t : transactionArray) {
            if (t != null && t.getCreateDate().toLocalDate().isEqual(date)) {
                tempArr[i++] = t;
            }
        }
        return tempArr;
    }

    public Transaction[] transactionList() {
        Transaction[] tempArr = new Transaction[transactionIndex];
        int tempIndex = 0;
        for (Transaction t : transactionArray) {
            if (t != null) {
                tempArr[tempIndex++] = t;
            }
        }
        return tempArr;
    }

    public Object[] getAmountByDay(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        for (Transaction t : transactionArray) {
            if (t != null && t.getCreateDate().toLocalDate().equals(date)) {
                System.out.println(t);
            }
        }
        return null;
    }

    public Transaction[] todayTransactionList() {
        Transaction[] tempArr = new Transaction[transactionIndex];
        int tempIndex = 0;
        for (Transaction t : transactionArray) {
            if (t != null && t.getCreateDate().toLocalDate().equals(LocalDate.now())) {
                tempArr[tempIndex++] = t;
            }
        }
        return tempArr;
    }

}
