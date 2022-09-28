import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Read the CSV file with three data(name, last name and dni) and create methods to sort the list.
 */
public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Person> list = new ArrayList<>();
    static String PATH = "src\\file.csv";


    public static void main(String[] args) throws FileNotFoundException {
        int option = 0;
        /**
         * Calling the method createList() before to start to use the program to create the ArrayList
         */
        createList();

        do {
            System.out.println("Choose an option:\n"
                    + "1.Enter new person\n"
                    + "2.Sort list by name from A to Z\n"
                    + "3.Sort list by name from Z to A\n"
                    + "4.Sort list by last name from A to Z\n"
                    + "5.Sort list by last name from Z to A\n"
                    + "6.Sort list by DNI from 1 to 9\n"
                    + "7.Sort list by DNI from 9 to 1\n"
                    + "0.Exit");

            option = scan.nextInt();
            switch (option) {
                case 1: System.out.println(addPerson());
                    break;
                case 2: sortByNameAZ();
                    break;
                case 3: sortByNameZA();
                    break;
                case 4: sortByLastNameAZ();
                    break;
                case 5: sortByLastNameZA();
                    break;
                case 6: sortByDNIAsc();
                    break;
                case 7: sortByDNIDesc();
                    break;
            }


        } while (option != 0);

    }

    /**
     * method creates a new object of type Person and adds it to the ArrayList
     * in case the file is not found, the method throws FileNotFoundException
     * @return was added or wasn't
     * @throws FileNotFoundException
     */
    public static String addPerson() throws FileNotFoundException {
        String ans = "";
        Person person0 = new Person();
        System.out.println("Enter the name");
        person0.setName(scan.next());
        scan.nextLine();   
        System.out.println("Enter the last name");
        person0.setLastName(scan.nextLine());
        scan.nextLine();
        System.out.println("Enter DNI");
        person0.setDNI(scan.next());
        list.add(person0);
        try {
            FileWriter fr = new FileWriter(PATH,true);
            fr.write(person0.getName() + ", " + person0.getLastName() + ", " + person0.getDNI() +"\n");
            fr.close();
            ans = person0.getName() +" " + person0.getLastName() + " was added successfully";
        } catch (IOException e) {
            ans = "Something went wrong";
        }
        return ans;
    }


    /**
     * Method which reads the CSV file and saves it in the ArrayList
     */
    public static void createList(){
        String currentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            while ((currentLine = br.readLine()) != null) {
                String arLine[] = currentLine.split(", ");
                Person person1 = new Person(arLine[0], arLine[1], arLine[2]);
                person1.setName(arLine[0]);
                person1.setLastName(arLine[1]);
                person1.setDNI(arLine[2]);
                list.add(person1);
                //System.out.println(person1.getName() + "  " + person1.getLastName() + "   " + person1.getDNI());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static void sortByNameAZ(){
        System.out.println("Sorted by Name(A-Z)\n"
                +"___Name___ ____Last Name___ __NIF__ ");
        Collections.sort(list, (p1, p2) -> Integer.valueOf(p1.getName().compareTo(p2.getName())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getLastName()
                    + "   "+ list.get(i).getDNI());
        }
        System.out.println("___________________________");
    }

    public static void sortByNameZA(){
        System.out.println("Sorted by Name(Z-A)\n"
                +"___Name___ ____Last Name___ __NIF__ ");
        Collections.sort(list, (p1, p2) -> Integer.valueOf(p2.getName().compareTo(p1.getName())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getLastName()
                    + "   "+ list.get(i).getDNI());
        }
        System.out.println("___________________________");
    }

    public static void sortByLastNameAZ(){
        System.out.println("Sorted by Last Name(A-Z)\n"
                +"___Name___ ____Last Name___ __NIF__ ");
        Collections.sort(list, (p1, p2) -> Integer.valueOf(p1.getLastName().compareTo(p2.getLastName())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getLastName()
                    + "   "+ list.get(i).getDNI());
        }
        System.out.println("___________________________");
    }

    public static void sortByLastNameZA(){
        System.out.println("Sorted by Last Name(Z-A)\n"
                +"___Name___ ____Last Name___ __NIF__ ");
        Collections.sort(list, (p1, p2) -> Integer.valueOf(p2.getLastName().compareTo(p1.getLastName())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getLastName()
                    + "   "+ list.get(i).getDNI());
        }
        System.out.println("___________________________");
    }

    public static void sortByDNIAsc(){
        System.out.println("Sorted by DNI(1-9)\n"
                +"___Name___ ____Last Name___ __NIF__ ");
        Collections.sort(list, (p1, p2) -> Integer.valueOf(p1.getDNI().compareTo(p2.getDNI())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getLastName()
                    + "   "+ list.get(i).getDNI());
        }
        System.out.println("___________________________");
    }

    public static void sortByDNIDesc(){
        System.out.println("Sorted by DNI(9-1)\n"
        +"___Name___ ____Last Name___ __NIF__ ");
        Collections.sort(list, (p1, p2) -> Integer.valueOf(p2.getDNI().compareTo(p1.getDNI())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getLastName()
                    + "   "+ list.get(i).getDNI());
        }
        System.out.println("___________________________");
    }
}


