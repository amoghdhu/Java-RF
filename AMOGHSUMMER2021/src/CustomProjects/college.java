package CustomProjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class college
{


    public static void main(String[] args) {

        List<String> reachList = new ArrayList<>();
        List<String> targetList = new ArrayList<>();
        List<List> collegeList = new ArrayList<>();

        reachList.add("CMU");
        reachList.add("Berkely");
        System.out.println(reachList);

        targetList.add("UC Irvine");
        targetList.add("UC San Diego");
        targetList.add("University of Washington");
        System.out.println(targetList);

        System.out.println(collegeList);
    }

}