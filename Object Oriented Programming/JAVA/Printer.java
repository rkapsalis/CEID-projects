import java.io.*;
import java.util.*;;
public class Printer
{
    public static List<Integer> copyOfInitialArray = new ArrayList<Integer>();
    public static void printInitial()throws IOException
    {
       System.out.println("");
       System.out.println("Initial Array without Merge Sort:");
           BufferedReader br2=null;
        try{
        FileReader fr2 =new FileReader("C:\\integers.txt");
        br2 = new BufferedReader(fr2);
        String line=br2.readLine();
        while(line !=null){
            copyOfInitialArray.add(Integer.parseInt(line));
            line=br2.readLine();
        }
      }
      catch (IOException ioe){
       System.out.println("Σφάλμα"+ioe);
      }
    
      finally{
      br2.close();
      }
      for(int i = 0;i<copyOfInitialArray.size();i++)
       {System.out.println(copyOfInitialArray.get(i));}
    }
    public static void printMerged()
    {
       System.out.println("");
       System.out.println("Initial Array with Merge Sort:");
       MerosA.mergeSort(MerosA.initialArray);
       for(int i = 0;i<MerosA.initialArray.size();i++)
           {System.out.println(MerosA.initialArray.get(i));}
    }
    public static void printWords()
    {
    System.out.println("All the words inside words.txt :");
    System.out.println("\n");
    try{MerosE.readString();}catch(IOException e){}
    for(int i = 0;i<MerosE.stringArray.size();i++)
     System.out.println(MerosE.stringArray.get(i));
    }
    }
