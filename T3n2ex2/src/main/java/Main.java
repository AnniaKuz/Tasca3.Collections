import java.util.*;

/**
 * Create a class Restaurant with String name and int score. Use necessary methods
 * so the program couldn't add obj Restaurant with the same name and score in Hashset created in main.
 * There can be Restaurant with the same name but different score
 *
 * Sort the list of restaurants by name (in ascending order) and score (in descending order)
 * @author Anna
 *
 */

public class Main {



    static Scanner scann = new Scanner(System.in);
    static Set<Restaurant> restaurants = new TreeSet<>();

    public static void main(String[] args) {


        int option = 0;
        String ans = "";

        do{
            System.out.println("Choose an option:\n" +
                    "1. Add an restaurant\n"+
                    "2. Show restaurants\n"+
                    "0. Exit.");

            option = scann.nextInt();

            if(option==1){
                ans= newAddRest();
                System.out.println(ans);
            }else if(option==2){
                showRest();
            }else{
                System.out.println("Option not found");
            }

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
            return  "The restaurant with this name and this score already exists";
        }
        else{
            return "The restaurant was added successfully";
        }
    }

    /**
     *
     * @return The list of restaurants sorted by name and then by score.
     */
    public static void showRest() {

        restaurants.forEach(x-> System.out.println(x.getName()+" "+x.getScore()));
    }
}

