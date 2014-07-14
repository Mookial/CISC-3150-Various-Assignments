import java.util.*;
import java.lang.*;

public class MaxSublist<T> {

    public static <T extends Comparable<? super T>> ArrayList<T> max_sublist(ArrayList<T> lst, int n) {

        ArrayList<T> tempList = lst;
        ArrayList<T> newList = new ArrayList<T>();
          
        for(int i = 0; i < n; i++) {
            Collections.sort(tempList); 
            newList.add(tempList.get(lst.size()-1));
            tempList.remove(tempList.get(lst.size()-1));   
        }
        
        Collections.sort(newList);
        return newList;
    }
}
