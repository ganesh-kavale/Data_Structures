package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapUsePractice1 {

    public static void solution(){

        //Duplicates


        Integer[] arr = {1,45,4,5,6,6,1,5,55,1,1,1,1,4,4,0};

        Map<Integer,Integer> intValue=new HashMap<>();


        for(Integer i:arr){

            intValue.put(i,intValue.getOrDefault(i,0)+1);

        }



    }
}
