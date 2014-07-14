import java.util.*;

public class Suffix<T> {
    
    public static <T> ArrayList<T> slice(ArrayList<T> lst, int from, int to) {
        ArrayList<T> sliced = new ArrayList<T>();
        
        for(int i = from; i < to; i++) {
            sliced.add(lst.get(i));
        }
        
        return sliced;
    }
    
    public static <T> ArrayList<ArrayList<T>> suffix(ArrayList<T> lst) {
        ArrayList<ArrayList<T>> newList = new ArrayList<ArrayList<T>>();
        
        for(int i = lst.size(); i >= 0; i--) {
            newList.add(slice(lst,i,lst.size()));    
        }
        
        return newList;
    }
}
