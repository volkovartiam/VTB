package examples.eleven_11_12_hibernate.ex_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main( String[] args ) {

        DAO dao = new DAO();

        String unparsedCommand = "";
        String command = "";
        String productTitle = "";
        String customerName = "";

        String del = " ";
        boolean run = true;

        while ( run ){
            System.out.println("Введите команду");
            Scanner scanner = new Scanner(System.in);

            unparsedCommand = scanner.nextLine();
            List<String> list = getParsedData(unparsedCommand, del);
            //System.out.println(list);

            if( !list.isEmpty() || !list.equals(null) ){
                command = list.get(0);
                if(list.size() == 2){
                    customerName = list.get(1);
                    productTitle = list.get(1);
                }

                if(list.size() == 3){
                    customerName = list.get(1);
                    productTitle = list.get(2);
                }
            }

            switch (command) {
                //    /showProductsByPerson Bob
                case "/showProductsByPerson" :
                        dao.getCustomerByName(customerName);
                        //System.out.println("Show products by person/persons with name " + customerName);
                    break;

                // /findPersonsByProductTitle prod_1
                case "/findPersonsByProductTitle" :
                    dao.findPersonsByProductTitle(productTitle);
                    System.out.println("Find persons by products title " + productTitle);
                    break;

                // /removePerson Chad
                case "/removePerson" :
                    if(dao.removeCustomer(customerName) ){
                        System.out.println("Removed person with name " + customerName);
                    } else {
                        System.out.println("Unsuccessfull removed " + customerName + ". Check name.");
                    }
                    break;

                //  /removeProduct prod
                case "/removeProduct" :
                    if(dao.removeProduct(productTitle) ){
                        System.out.println("Removed product with title " + productTitle);
                    } else {
                        System.out.println("Unsuccessfull removed " + productTitle + ". Check product`s title.");
                    }
                    break;

                case "/buy" :
                    System.out.println("Customer " + customerName + " buy product "   + productTitle);
                    break;

                case "/exit" :
                    dao.close();
                    System.out.println("Exit from program");
                    run = false;
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }

            command = "";
            productTitle = "";
            customerName = "";

        }
    }

    public static List<String> getParsedData(String unparsed, String delimiter){
        unparsed = unparsed.concat(delimiter);
        List<String> list = new ArrayList<>();
        list.clear();

        Pattern pattern = Pattern.compile("\\S*" + delimiter );
        Matcher matcher = pattern.matcher(unparsed);
        while (matcher.find()) {
            String str = unparsed.substring( matcher.start(), matcher.end() - 1 );
            list.add(str);
        }
        return list;
    }

}
