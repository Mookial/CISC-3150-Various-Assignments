import java.util.*;

public class subset <T>{

 public static <T> ArrayList<ArrayList<T>> subset(ArrayList <T> lst, int n){
   ArrayList<ArrayList<T>> tmplist = new ArrayList<ArrayList<T>>();  
   
   for (int i = -1; i < lst.size(); i++)
     tmplist.add(subFunc(lst, i));
   
   return tmplist;
 }
 
public static <T> ArrayList <T> subFunc(ArrayList <T> lst, int n){
  ArrayList<T> tmplist = new ArrayList<T>();
  
  if (n == -1)
   return tmplist;
  else
   for (int i = 0; i <= n; i++){
    if (!tmplist.contains(lst.get(i))){ //The test (!tmp.list.contains(i) wasn't working
     tmplist.add(lst.get(i)); 
    }
    for (int j = i; j <= n; j++){
     if (!tmplist.contains(lst.get(j)))  //Skip repeats
      tmplist.add(lst.get(j));
    }
    
   }
      
  return tmplist; 
 }
 
 
 public static void main(String [] args){
  ArrayList<Integer> list =new ArrayList<Integer>();
  list.add(1); list.add(2); list.add(3);
 
  ArrayList<ArrayList<Integer>> Tlist = new ArrayList<ArrayList<Integer>>();
  
  int n = 2;
  
  Tlist = subset(list, n);
  
  System.out.print(Tlist);
 }
}
