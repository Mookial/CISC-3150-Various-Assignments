import java.util.*;

public class Sublists<T> {
    
    public static <T> ArrayList<T> slice(ArrayList<T> lst, int from, int n) {
        ArrayList<T> sliced = new ArrayList<T>();
        
        for(int i = 0; i < n; from++, i++) {
            sliced.add(lst.get(from));
        }
        
        return sliced;
    }
    
    public static <T> ArrayList<ArrayList<T>> sublist(ArrayList<T> lst, int n) {
        ArrayList<ArrayList<T>> newList = new ArrayList<ArrayList<T>>();
        
        for(int i = 0; i <= lst.size() - n; i++) {
            newList.add(slice(lst,i,n));    
        }
        
        return newList;
    }
}
