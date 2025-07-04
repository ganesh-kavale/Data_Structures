import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicatesUseMap {


    public void solution(List<Integer> list){

        Map<Integer,Integer> ma =new HashMap();
        for(Integer num:list){
            ma.put(num, ma.getOrDefault(num,0)+1);// getOrDefault returns count.
        }

        System.out.println(ma);//{1=5, 4=1, 5=1, 54=2}

        //to get duplicates each entry will be checked and printed
        for(Map.Entry<Integer,Integer> e:ma.entrySet()){
            if(e.getValue()>1){
                System.out.println("Duplicates are: " + e);
            }
        }
    }

    public void solutionUsingStream(List<Integer> n) {

        Map<Integer, Long> ss = n.stream().collect(Collectors.groupingBy(numm->numm,Collectors.counting()));
        System.out.println("Duplicates are with stream: " + ss);

        n.stream().collect(Collectors.groupingBy(numm->numm,Collectors.counting()))
                .entrySet().stream()
                .filter(nn->nn.getValue()>1)
                .forEach(nnnn->System.out.println("nnnnnnnn: "+ nnnn));

    }

    public void solutionLongestSubstring(String str) {

        int left=0;
        int right=0;
        int maxlength=0;
        int startIndex=0;

        Map<Character,Integer> m = new HashMap<>();

        for(right=0;right<str.length();right++){

            Character current = str.charAt(right);

            if(m.containsKey(current)){
                left = Math.max(m.get(current)+1,left);
            }
            m.put(current,right);

            System.out.println(current + "       tttttttt     :          " + m);

            if(right-left+1>maxlength){
                maxlength=right-left+1;
                startIndex=left;
            }
            System.out.println(maxlength + "    :    " + startIndex  + str.substring(startIndex,startIndex+maxlength));
        }
    }
}
