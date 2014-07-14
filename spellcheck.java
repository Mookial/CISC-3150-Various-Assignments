import java.util.*;

public class SpellCheck<T> {
    
    public static <T> ArrayList<T> spell_check(List<T> doc, Set<T> dict) {
        ArrayList<T> wrong_words = new ArrayList<T>();
        
        for(int i = 0; i < doc.size(); i++) {
            if(!dict.contains(doc.get(i))) {
                wrong_words.add(doc.get(i));
            }
        }
        
        return wrong_words;
       
    }
    
    public static void main(String []args) {
        List<String> document = new ArrayList<String>();
        
        document.add("Hello"); document.add("World"); document.add("HACKS");
        
        Set<String> dict = new HashSet<String>();
        
        dict.add("Hello"); dict.add("World"); dict.add("Mary");
        
        ArrayList<String> result = new ArrayList<String>();
        result = spell_check(document, dict);
        
        System.out.print(result);
           
    }
}
