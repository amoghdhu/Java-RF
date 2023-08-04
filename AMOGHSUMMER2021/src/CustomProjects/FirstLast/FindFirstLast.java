package CustomProjects.FirstLast;

import java.util.ArrayList;
import java.util.List;

public class FindFirstLast {
    public static void getFirstLast(List<Integer> list){
        System.out.println("Array List contains: " + list);
        int newArrayList = list.get(list.size() - 1) + 1;
        System.out.println("Last number in list + 1 is " + newArrayList);


    }

    private static int[] addOneToLastBit(int[] myints) {
        int[] newints = new int[myints.length];
        for (int i = 0; i < myints.length; i++) {
            newints[i] = myints[i];
            if(i == myints.length-1){
                newints[i] = myints[i]+1;
            }
        }
        return newints;
    }

    public static void updatedList(List<Integer> list){
        list.set(list.size()-1,list.get(list.size()-1)+1);
        System.out.println("Updated list: " + list);
    }

    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<Integer>();
        firstList.add(4);
        firstList.add(3);
        firstList.add(2);
        firstList.add(1);

        getFirstLast(firstList);
        updatedList(firstList);

        System.out.println();

        List<Integer> secondList = new ArrayList<Integer>();
        secondList.add(1);
        secondList.add(3);
        secondList.add(5);
        secondList.add(7);
        secondList.add(9);

        getFirstLast(secondList);
        updatedList(secondList);

        /**
         * another way to flip bit
         */

        int[] myints = new int[3];
        myints[0] = 14;
        myints[1] = 28;
        myints[2] = 100;

        int[] newIntArray = new int[5];
        newIntArray[0] = 1;
        newIntArray[1] = 3;
        newIntArray[2] = 5;
        newIntArray[3] = 7;
        newIntArray[4] = 9;


        System.out.println("Array after bit set") ;
        int[] afterBitSet = addOneToLastBit(myints);
        for (int q = 0; q < afterBitSet.length; q++) {
            System.out.println(afterBitSet[q]);
        }


    }


}
