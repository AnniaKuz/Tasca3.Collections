import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40));
        System.out.println(list);
        System.out.println("________________________________________________");

        doReverseList(list);

    }

    public static void doReverseList(List<Integer> list){
        /* The simplest way to reverse an arrayList

        List<Integer> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);*/


        Collections.reverse(list);
        List<Integer> reverseList = new ArrayList<>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            reverseList.add(it.next());
        }
        System.out.println("This is the list in reverse order\n" + reverseList);

    }

}
