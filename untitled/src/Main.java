public class Main {
    public static void main(String[] args) {
        Managing managing = new Managing();
        managing.setFaire(2000);

        Card card1 = managing.addCard(1, 10000);
        Card card2 = managing.addCard(2, 5500);
        Card card3 = managing.addCard(4, 1000);
        Card card4 = managing.addCard(3, 5900);


        Terminal terminal1 = managing.addTerminal(1, "Chilonzor");
        Terminal terminal2 = managing.addTerminal(2, "Olmazor");
        Terminal terminal3 = managing.addTerminal(3, "Mirzo Ulug`bek");
//
//        System.out.println(managing.getTerminalById(1));
//
//
//        Terminal[] terminals = managing.terminalList();
//        for (Terminal c : terminals) {
//            if (c != null) {
//                System.out.println(c);
//            }
//        }
        Transaction transaction = managing.makeTransaction(1, 1);
        Transaction transaction5 = managing.makeTransaction(2, 2);
        Transaction transaction2 = managing.makeTransaction(3, 3);
        Transaction transaction4 = managing.makeTransaction(2, 4);


//        Transaction[] tempTransactionArr = managing.transactionListByTerminal(1);
//        for (Transaction t : tempTransactionArr) {
//            if (t != null) {
//                System.out.println(t);
//            }
//        }

//        Transaction[] tempTransactionArr = managing.transactionListByCard(1);
//        for (Transaction t : tempTransactionArr) {
//            if (t != null) {
//                System.out.println(t.toString());
//            }
//        }

//        Transaction[] tempTransactionArr = managing.getTransactionsByDate("2024.06.24");
//        for (Transaction t : tempTransactionArr) {
//            if (t != null) {
//                System.out.println(t.toString());
//            }
//        }

//        Transaction[] tempTransactionArr = managing.transactionList();
//        for (Transaction t : tempTransactionArr) {
//            if (t != null) {
//                System.out.println(t);
//            }
//        }

//        Object[] tempArr = managing.getAmountByDay("2024.06.25");
//        for (Object t : tempArr) {
//            if (t != null) {
//                System.out.println(t);
//            }
//        }

        Transaction[] tempArr = managing.todayTransactionList();
        for (Transaction t : tempArr) {
            if (t != null) {
                System.out.println(t);
            }
        }


    }
}
