package laurenceau;

import java.math.BigInteger;

public class Transaction {

    private String transactionID;
    private String username1;
    private String username2;
    private BigInteger points;


    public Transaction(String transactionID, String username1, String username2, BigInteger points) {
        this.transactionID = transactionID;
        this.username1 = username1;
        this.username2 = username2;
        this.points = points;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public BigInteger getPoints() {
        return points;
    }

    public void setPoints(BigInteger points) {
        this.points = points;
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Transaction)) return false;
        Transaction t = (Transaction)o;
        return transactionID.equals(t.getTransactionID()) && username1.equals(t.username1) && username2.equals(t.username2) &&
                points.equals(t.getPoints());

    }

    @Override
    public String toString() {
        return "[" + transactionID + " " + username1 + " " + username2 + " " + points + " ]";
    }

}
