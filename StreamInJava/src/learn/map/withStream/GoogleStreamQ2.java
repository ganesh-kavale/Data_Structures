package learn.map.withStream;


import java.util.Arrays;
import java.util.List;

/*
*
*
You have a list of transactions, each represented as a string in the format "id,amount".
*
* Write a Java method using Streams to find the top N transactions with the highest amounts.
* The method should accept a list of transaction strings and an integer N, and
*  return a list of transaction strings representing the top N transactions sorted by amount in descending order.
* If there are fewer than N transactions, return as many as available.
*
*
* */
public class GoogleStreamQ2 {

    public void solution(){


        List<String> listInteger = Arrays.asList(
                "T1,500",
                "T2,789",
                "T3,4587",
                "T4,5",
                "T5,2450"
        );

        int n=3;
        listInteger.stream().map(s -> parseTransaction(s))
                .sorted((t1,t2)->Integer.compare(t2.getAmount(),t1.getAmount()))
                .map(s -> formatTransaction(s))
                .limit(n)
                .forEach(System.out::println);



    }

    private String formatTransaction(Transaction s) {

        return s.id + "," + s.getAmount();
    }

    public Transaction parseTransaction(String s) {

        String[] splittedParts = s.split(",");

        return new Transaction(splittedParts[0],Integer.parseInt(splittedParts[1]) );

    }

    class Transaction{

        String id;
        int amount;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        Transaction(String id, int amount){
            this.id=id;

            this.amount=amount;
        }


    }

}

//        Solution google question2:
//        T3,4587
//        T5,2450
//        T2,789