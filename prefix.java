import java.util.*;

public class Prefix<T> {
    
    public static <T> ArrayList<T> slice(ArrayList<T> lst, int from, int to) {
        ArrayList<T> sliced = new ArrayList<T>();
        
        for(int i = from; i < to; i++) {
            sliced.add(lst.get(i));
        }
        
        return sliced;
    }
    
    public static <T> ArrayList<ArrayList<T>> prefix(ArrayList<T> lst) {
        ArrayList<ArrayList<T>> newList = new ArrayList<ArrayList<T>>();
        
        for(int i = 0; i <= lst.size(); i++) {
            newList.add(slice(lst,0,i));    
        }
        
        return newList;
    }
}
