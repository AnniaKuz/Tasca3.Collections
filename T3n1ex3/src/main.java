import java.io.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;


/*Read file.txt > save it in HashMap.
Show the user random country. The user has to name the capital > if the answer is correct > score +1
Repeate the action 10 times > save a result in txt File with the username and the score.
 */


public class main {
    static Scanner scan = new Scanner(System.in);
    static final String PATH = "src\\Countries.txt";
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader objreader = null;
        String currentLine;
        Map<String, String> countries = new HashMap<>();
        CharSequence symbol = "_";
        try {
            objreader = new BufferedReader(new FileReader(PATH));
            while ((currentLine = objreader.readLine()) != null) {
                String arLine[] = currentLine.split(" ");
                countries.put(arLine[0].replace('_',' '), arLine[1].replace('_',' '));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        guessCapital(countries);
    }


    public static void guessCapital(Map<String, String> countries){

        int numAttempt = 0;
        int score = 0;
        String userName = "";
        System.out.println("Hello, what's your name?");
        userName = scan.next();
        System.out.println(userName + " , try to name the capital cities of these countries");
        do{
              for(int i = 0;i < 10; i++) {
                  System.out.println("The capital of ...");
                  Random generator = new Random();
                  int randomNum = generator.nextInt(countries.size());
                  Object country = countries.keySet().toArray()[randomNum];
                  Object capital = countries.get(country);
                  System.out.println(country);
                  String myCapital = "";
                  myCapital = scan.next();
                  if(myCapital.equalsIgnoreCase(countries.get(country))){
                      score += 1;
                  }
                  countries.remove(country);
                  numAttempt += 1;
              }
        }while(numAttempt!=10);
        try {
            PrintWriter writer = new PrintWriter("yourScore.txt");
            writer.println("Name: "  + userName);
            writer.println("Score: " +score);
            writer.close();
            System.out.println("Check your score");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }
    }

}
