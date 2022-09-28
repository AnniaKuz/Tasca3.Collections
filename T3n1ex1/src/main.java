import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* Enter 11 months without August. Add August in the correct position and check the order.
 * ArrayList to HashSet. Run the list using for loop and iterator */

public class main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<Month>();

        Month january0 = new Month("January");
        months.add(january0);
        Month february1 = new Month("February");
        months.add(february1);
        Month march2 = new Month("March");
        months.add(march2);
        Month april3 = new Month("April");
        months.add(april3);
        Month may4 = new Month("May");
        months.add(may4);
        Month june5 = new Month("June");
        months.add(june5);
        Month july6 = new Month("July");
        months.add(july6);
        Month september = new Month("September");
        months.add(september);
        Month october = new Month("October");
        months.add(october);
        Month november = new Month("November");
        months.add(november);
        Month december = new Month("December");
        months.add(december);

        //Add August to the ArrayList
        Month august7 = new Month("August");
        months.add(7, august7);
        System.out.println("________________________________\n"
                            +"ArrayList\n");;
        for (Month m : months) {
            System.out.println(m.getName());
        }

        HashSet<Month> monthsHashSet = new HashSet<>(months);
        System.out.println("________________________________\n"
                            +"FOR LOOP\n");
        for (Month mhs : monthsHashSet) {
            System.out.println(mhs.getName());
        }

        //HashSet doesn't allow duplicate but let's try to add a duplicate element
        Month duplicate = new Month("August");
        monthsHashSet.add(duplicate);
        System.out.println("________________________________\n"
                            +"ITERATOR\n");
        Iterator<Month> monthsIter = monthsHashSet.iterator();
        while (monthsIter.hasNext()) {
            System.out.println(monthsIter.next().getName());
        }
    }
}

