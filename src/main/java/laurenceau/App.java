package laurenceau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.*;

/**
 * Hello world!p[
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File logfile = new File("/Users/ianlaurenceau/Dev/transactionCleaner/src/main/java/laurenceau/log.txt");
        Hashtable<String, List<Transaction>> tset = new Hashtable<String, List<Transaction>>();


        try {

            Scanner fileScanner = new Scanner(logfile);
            while (fileScanner.hasNextLine()) {

                String data = fileScanner.nextLine();
                String pieces[] = data.split("\\s+");

                if (pieces[0].length() > 0 && Character.isLetter(pieces[0].charAt(0))) {

                    Transaction t = new Transaction(pieces[0], pieces[1], pieces[2], new BigInteger(pieces[3]));

                    if (TransactionValidator.isValidTransaction(t)) {

                        if(!tset.containsKey(t.getTransactionID()))
                            tset.put(t.getTransactionID(), new ArrayList<Transaction>());

                        List<Transaction> l = tset.get(t.getTransactionID());

                        if(l.size() == 0 || !l.get(l.size() - 1).equals(t))
                           tset.get(t.getTransactionID()).add(t);
                    }
                }

            }
            System.out.print(tset);
        }

        catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    }

}
