import java.util.*;

/**
 * Create a class Restaurant with String name and int punts. Use necessary methods
 * so the program couldn't add obj Restaurant with the same name and punts in Hashset created in main.
 * There can be Restaurant with the same name but different punts.
 *
 * @author Anna
 *
 */

public class Main {



    static Scanner scann = new Scanner(System.in);
    /**
     * The static set of restaurants
     */
    static HashSet<Restaurant> restaurants = new HashSet<>();

    public static void main(String[] args) {
        int option = 0;
        String ans = "";

        do{
            System.out.println("Choose an option:\n" +
                    "1. Add an restaurant\n"+
                    "0. Exit.");

            option = scann.nextInt();

            if(option==1){
                ans= newAddRest();
            }else{
                ans = "Option not found";
            }
            System.out.println(ans);
        }while(option!=0);

    }

    /**
     *
     * @return String whether the new restaurant was added or not
     */
    public static String newAddRest(){
        System.out.println("Enter the name");
        String nameRest = scann.next();
        System.out.println("Enter the score");
       int punts = scann.nextInt();
       Restaurant newRestaurant = new Restaurant(nameRest,punts);
       if(!restaurants.add(newRestaurant)){
           return  "The restaurant with this name and this score already exist";
       }
       else{
           return "The restaurant was added successfully";
       }
    }

}
