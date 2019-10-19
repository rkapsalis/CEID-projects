import java.io.*;
import java.util.*;

public class MerosA {
    public static int count=0;
   public static List<Integer> initialArray = new ArrayList<Integer>();
    public static void readIntegers()throws IOException {
        BufferedReader br=null;
        //List<Integer> initialList = new ArrayList<Integer>();  
        count= 0;
        try{
        FileReader fr =new FileReader("C:\\integers.txt");
        br = new BufferedReader(fr);
        String line=br.readLine();
        while(line !=null){
            initialArray.add(Integer.parseInt(line));
            count++;
            line=br.readLine();
        }
    }
    catch (IOException ioe){
       System.out.println("Σφάλμα"+ioe);
    }
    
    finally{
     br.close();
    }
    //for(int i = 0;i<initialArray.size();i++)
     //System.out.println(initialArray.get(i));
    // System.out.println(count);
     //int a= initialList.size();
     //System.out.println(a);
  }   
  public static void  mergeSort(List<Integer> initialArray)
  {
       List<Integer> LeftArrayList;
       List<Integer> RightArrayList;
      if(initialArray.size()>1){
       LeftArrayList = new ArrayList<Integer>(initialArray.subList(0,initialArray.size()/2));
       RightArrayList= new ArrayList<Integer>(initialArray.subList(initialArray.size()/2,initialArray.size()));
    }else{return;}
       //int LeftArrayList[middle-1]
       //int RightArrayList[count-middle-1]
       //for(int i=0; i=middle-1; i++){LeftArrayList[i]=initialArray[i];}
       //for(int i=middle; i=count-1; i++){RightArrayList[i]=initialArray[i];}
       mergeSort(LeftArrayList);
       mergeSort(RightArrayList);
       merge(initialArray, LeftArrayList, RightArrayList);
       
    }
  public static void merge(List<Integer> initialArray,  List<Integer> LeftArrayList, List<Integer> RightArrayList){
    int SumOfSize;        
    int i, j, k;// i counter 8eshs gia ton arxiko pinaka j countergia aristero kai k gia dexio
    i=0;
    j=0;
    k=0;
    int leftSize= LeftArrayList.size();
    int rightSize=RightArrayList.size();
    SumOfSize= LeftArrayList.size() + RightArrayList.size();  
    
    while ( i < SumOfSize) {
       if ((j< leftSize) && (k<rightSize)) {
          if (LeftArrayList.get(j) < RightArrayList.get(k)) {
                    initialArray.set(i,LeftArrayList.get(j));
                    i++;
                    j++;
          }
          else {
              initialArray.set(i,RightArrayList.get(k));
              i++;
              k++;
                }
       }
       else {
        if (i >= leftSize) {
          while (k < RightArrayList.size()) {
           initialArray.set(i,RightArrayList.get(k));
           i++;
           k++;
          }
        }
        if (k >= rightSize) {
         while (j < LeftArrayList.size()) {
           initialArray.set(i,LeftArrayList.get(j));
           j++;
           i++;
         }
        }
       }
    }
  }
  
}
   

