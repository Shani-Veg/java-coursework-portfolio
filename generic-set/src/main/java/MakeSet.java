import java.util.Random;
import java.util.Scanner;

public class MakeSet {
    public static void main(String[] args) {

        Random random = new Random();
        Integer [] arr1 = new Integer [10];
        Integer [] arr2 = new Integer [10];
        Integer [] arr3 = new Integer [10];

        for (int i = 0 ; i < 10 ; i ++){
            arr1[i] = random.nextInt(101);
        }

        for (int i = 0 ; i < 10 ; i ++){
            arr2[i] = random.nextInt(101);
        }

        for (int i = 0 ; i < 10 ; i ++){
            arr3[i] = random.nextInt(101);
        }

        SetList <Integer> set1 = new SetList <Integer>(arr1);
        SetList <Integer> set2 = new SetList <Integer>(arr2);
        SetList <Integer> set3 = new SetList <Integer>(arr3);

        System.out.println("First set: " + set1.toString());
        System.out.println("Second set: " +set2.toString());
        System.out.println("Third set: " +set3.toString());

        set1.union(set2);
        System.out.println("Union of Set 1 and Set 2: " + set1.toString());

        set1.intersect(set3);
        System.out.println("Intersect of Set 1 and Set 3: " + set1.toString());

        Scanner scan = new Scanner(System.in);

        Integer [] arr4 = new Integer [2];
        System.out.println("Enter a number from 0 to 100: ");
        arr4[0] = scan.nextInt();
        System.out.println("Enter a number from 0 to 100: ");
        arr4[1] = scan.nextInt();

        SetList <Integer> set4 = new SetList <Integer>(arr4);

        if (set1.isSubset(set4))
            System.out.println("Your Set " + set4.toString() + " is a sub set of Set 1");
        else
            System.out.println("Your Set " + set4.toString() + " is not a sub set of Set 1");

        if (set2.isSubset(set4))
            System.out.println("Your Set " + set4.toString() + " is a sub set of Set 2");
        else
            System.out.println("Your Set " + set4.toString() + " is not a sub set of Set 2");

        if (set3.isSubset(set4))
            System.out.println("Your Set " + set4.toString() + " is a sub set of Set 3");
        else
            System.out.println("Your Set " + set4.toString() + " is not a sub set of Set 3");

        System.out.print("Enter a number from 0 to 100: ");
        int num = scan.nextInt();

        if(set1.isMember(num))
            System.out.println("Your number " + num + " is a member in Set 1");
        else
            System.out.println("Your number " + num + " is not a member in Set 1");
        System.out.println("Set 1: " +set1.toString());

        set2.insert(num);
        System.out.println("Set 2: " +set2.toString());

        set3.delete(num);
        System.out.println("Set 3: " +set3.toString());
    }
}
