import java.io.*;
import java.util.*;
public class MerosE extends TrieNode
{
   static TrieNode root;
   public static int count=0;
   public static List<String> stringArray = new ArrayList<String>();
    public static void readString()throws IOException {
        BufferedReader br=null; 
        count= 0;
        String help="#";
        try{
        FileReader fr =new FileReader("C:\\words.txt");
        br = new BufferedReader(fr);
        String line=br.readLine().toLowerCase();
        while(line !=null){
            stringArray.add(line.toLowerCase());
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
    //for(int i = 0;i<stringArray.size();i++)
    // System.out.println(stringArray.get(i));
    // System.out.println(count);
     //int a= stringArray.size();
     //System.out.println(a);
  } 
 
    public static void insert(String word){
        int length=word.length();
        int height;
        int index;
        TrieNode a=root;
        for (height = 0; height < length; height++)
        {
            index = word.charAt(height) - 'a';//to -a metatrepei to xarakthra se noumero dld apo to a-z einai 0-25
            if (a.wordArray[index] == null)
                a.wordArray[index] = new TrieNode();
            a = a.wordArray[index];//edw dhmhourgeitai to neo tetragwno-pinakas
        }
        a.wordEnd = true;
    }
    
    static boolean  search(String word)
    {
        int index;
        int length=word.length();
        int height;
        TrieNode a = root;
      
        for ( height = 0; height < length; height++)
        {
            index = word.charAt(height) - 'a';//charAt spaei thn le3h kai pernei ena ena gramma apo a-z einai 0-25
            if (a.wordArray[index] == null){
                return false;}
            a = a.wordArray[index];
        }
      return  (a!=null && a.wordEnd);
    }
    
 
    public static void delete( String word) {
     TrieNode a=root;
     int index;
     for(int height=0; height<word.length(); height++)
     {
         index = word.charAt(height) -'a';
         if(a==null)
         {throw new RuntimeException();}
         a=a.wordArray[index];
        }
        if (a.wordEnd ) {
            a.wordEnd=false;
        } else {
            throw new RuntimeException();
        }
    }
    
    
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
         try{ readString();}catch(IOException e){}
    
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
        root = new TrieNode();
      
        // Construct trie
        for (int i = 0; i < stringArray.size() ; i++)
            insert(stringArray.get(i));
      
        // Search for different keys
        if(search("stelios") == true)
            System.out.println("stelios --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("salamo") == true)
            System.out.println("salamo --- " + output[1]);
        else System.out.println("salamo --- " + output[0]);
         
        if(search("and") == true)
            System.out.println("and --- " + output[1]);
        else System.out.println("and --- " + output[0]);
        
        insert("salami");
        if(search("salami") == true)
            System.out.println("salami --- " + output[1]);
        else System.out.println("salami --- " + output[0]);
        delete("she");
        if(search("stelios") == true)
            System.out.println("stelios --- " + output[1]);
        else System.out.println("stelios --- " + output[0]);
        if(search("salamo") == true)
            System.out.println("salamo --- " + output[1]);
        else System.out.println("salamo --- " + output[0]);
        if(search("stelio") == true)
            System.out.println("stelio --- " + output[1]);
        else System.out.println("stelio --- " + output[0]);
        if(search("she") == true)
            System.out.println("she --- " + output[1]);
        else System.out.println("she --- " + output[0]);
    }
    }
  
  