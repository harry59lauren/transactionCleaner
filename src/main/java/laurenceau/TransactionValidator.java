package laurenceau;

import java.math.BigInteger;

public class TransactionValidator {

    public static boolean isValidTransaction(Transaction transaction) {
        return isValidTransactionID(transaction.getTransactionID()) &&
                isValidUsername(transaction.getUsername1()) &&
                isValidUsername(transaction.getUsername2()) &&
                isValidPointTransfer(transaction.getPoints());

    }

    public static boolean isValidUsername(String username) {
        return username.matches("^[A-Za-z][A-Za-z0-9]{3,24}");
    }

    public static boolean isValidTransactionID(String id) {
        return id.matches("[[A-Z]{1,},[0-9]{1,}]{10}");
    }

    public static boolean isValidPointTransfer(BigInteger points) {
        return (points.compareTo(new BigInteger("0")) + new BigInteger("4294967296").compareTo(points) == 2);
    }


}
