import java.io.*;
import java.util.Scanner;
public class Main 
{
    public static void main(String args[]){
       try{ MerosA.readIntegers();}catch(IOException e){}
     //MerosA.mergeSort(MerosA.initialArray);
     //for(int i = 0;i<MerosA.initialArray.size();i++)
   //  System.out.println(MerosA.initialArray.get(i));
    // System.out.println(initialArray.MerosA);
    int number=0;
    int choise=0;
    do{
        System.out.println("");
        System.out.println("Menu:");                            //Εδω με την βοηθεια τον εντολων εκτυπωσης δημιουργουμε ενα Menu απο το οποιο ο χρηστης διαλεγει πια επιλογη θελει
        System.out.println("0:Read Integers.txt(file position is in C//integers.txt) and Merge Sort the numbers!");               //γραφοντας τον αριθμο της καθε επιλογης που αναγραφεται και ακολουθοντας προσεκτικα τις συμβουλες που ακολουθουν
        System.out.println("1:Lineral Search");
        System.out.println("2:Binary Search)");
        System.out.println("3:Interpolation Search");
        System.out.println("4:Red-Black Tree Menu");
        System.out.println("5:Digital Tree(Trie) Menu");
        System.out.println("6:ΜέροςΔ execute searches and store times for each search to csv in the directory. ");
        System.out.println("7:Print Menu");
        System.out.println("8:Exit Programm");
        System.out.println("*******Important Note********"); 
        System.out.println("(In order to correctly run 1 or 2 or 3 case 0 must be first be run!!! ");
        Scanner keyboard=new Scanner(System.in); //δημιουργια αντικειμενου keyboard τυπου Scanner για την εισαγωγη δεδομενων απο το πληκτρολογιο
        System.out.println("Choose choise 0 or 1 or 2 or 3 or 4 or 5 or 6 or 7 or 8");
        choise=keyboard.nextInt();//εδω με αυτη την εντολη εισαγεται απο το πληκτρολογιο το νουμερο που εγραψε ο χρηστης για να εκτελεστει η συγκεκριμενη ενεργεια που θελει
        switch(choise){ //με την βοηθεια της switch φτιαχνουμε ολες τις δυνατε επιλογες που θελουμε και αναλογα με το τι απαντησει ο χρηστης  χρησιμοποιειται το καθε αντισοιχο case.
        case 0:
        System.out.println("(Reading and Merge Sorting the integers in the integers.txt file)");
        //try{ MerosA.readIntegers();}catch(IOException e){}
        MerosA.mergeSort(MerosA.initialArray);
        System.out.println("Merge Sort Finished");
        break; 
        
        case 1: 
        System.out.println("Lineral Search");
        System.out.println("Reminder:");
        System.out.println("(In order to correctly run  the Integer array must be Merge Sorted) ");
        System.out.println("Enter the number you want to search\n");
        number=keyboard.nextInt();
        MerosB.lineralSearch(number);
        System.out.println("Lineral Search Finished");
        break;

        case 2:
        System.out.println("Binary Search");
        System.out.println("Reminder:");
        System.out.println("(In order to correctly run  the Integer array must be Merge Sorted) ");
        System.out.println("Enter the number you want to search\n");
        number=keyboard.nextInt();
        MerosB.binarySearch(number);
        System.out.println("Binary Search Finished");
        break;
        
        case 3:    
        System.out.println("Interpolation Search");
        System.out.println("Reminder:");
        System.out.println("(In order to correctly run the integer array must be Merge Sorted )");
        System.out.println("Enter the number you want to search\n");
        number=keyboard.nextInt();
        MerosB.interpolationSearch(number);
        System.out.println("Interpolation Search Finished");
        break;
        
        case 4:    
        System.out.println("Red-Black Tree Menu");
        System.out.println("Reminder:");
        System.out.println("(In order to correctly run the integer array must be Merge Sorted )");
        int RBchoise=0;
        do{
            System.out.println("");
            System.out.println("Red-Black Tree.");
            System.out.println("0:Read integers.txt and create Red-Black Tree.");
            System.out.println("1:Search a word in Red-Black Tree.");
            System.out.println("2:Insert a word in Red-Black Tree..");
            System.out.println("3:Exit Red-Black Tree Menu.");
            switch(RBchoise){
                case 0:
                MerosA.mergeSort(MerosA.initialArray);
                for(int j=0; j<MerosA.initialArray.size(); j++){
                    MerosC.RBTreeInsert(MerosA.initialArray.get(j));
                }
                break;
                
                case 1:
                int w;
                System.out.println("Red-Black Tree Search");
                System.out.println("Reminder:");
                System.out.println("(In order to correctly run you must first read integers.txt!!! )");
                System.out.println("Enter the number you want to search\n");
                w=keyboard.nextInt();
                MerosC.RBTreeSearch(w);
                System.out.println("Search of number " + w + " completed!!!");
                break;
                
                case 2:
                int t;
                System.out.println("Red-Black Tree Search");
                System.out.println("Reminder:");
                System.out.println("(In order to correctly run you must first read integers.txt!!! )");
                System.out.println("Enter the number you want to search\n");
                t=keyboard.nextInt();
                MerosC.RBTreeInsert(t);
                System.out.println("Insertion of number " + t + " completed!!!");
                break;
                
                case 3:break;
                default:break;
            }
        }while (RBchoise!=3);
        break;
        
        case 5:
        System.out.println("5:Digital Tree(Trie) Menu(words.txt position is in C//integers.txt)");
        int trieChoise=0;
        do{
            String output[] = {" is not present in trie", " is present in trie"};
            Scanner word=new Scanner(System.in);
            Scanner key=new Scanner(System.in);
            System.out.println("");
            System.out.println("Trie");
            System.out.println("0:Read words.txt and create Trie.");
            System.out.println("1:Search a word in Trie.");
            System.out.println("2:Insert a word in Trie..");
            System.out.println("3:Delete a word from Trie..");
            System.out.println("4:Exit Trie Menu.");
           trieChoise=key.nextInt();
           switch(trieChoise){
            case 0:
            try{MerosE.readString();}catch (IOException e){}
            break;
            
            case 1:
            System.out.println("Search a word in Trie. ");
            try{  MerosE.readString();}catch(IOException e){}
            //String output[] = {" is not present in trie", " is present in trie"};
            MerosE.root = new TrieNode();
            String y;
            System.out.println("Enter the word you want to search");
            y=word.nextLine();
            y=y.toLowerCase();
            // Construct trie
            for (int i = 0; i < MerosE.stringArray.size() ; i++)
                MerosE.insert( MerosE.stringArray.get(i));
      
             // Search for different keys
            if( MerosE.search(y) == true)
            System.out.println(y + output[1]);
            else System.out.println(y + output[0]);
            //MerosE.delete(y);
            //if( MerosE.search(y) == true)
            //System.out.println(y + output[1]);
            //else System.out.println(y + output[0]);
         
            break;
            
            case 2:
            System.out.println("Insert a word in Trie. ");
            try{  MerosE.readString();}catch(IOException e){}
            MerosE.root = new TrieNode();
            String x;
            System.out.println("Enter the word you want to insert\n");
            x=word.nextLine(); 
            x=x.toLowerCase();
            for (int i = 0; i < MerosE.stringArray.size() ; i++)
                MerosE.insert( MerosE.stringArray.get(i));
            MerosE.insert(x);
            System.out.println("Insertion of " + x + " completed!!!");
            if( MerosE.search(x) == true)
            System.out.println(x + output[1]);
            else System.out.println(x + output[0]);
            break;
            
            case 3:
            MerosE.root = new TrieNode();
            String z;
            System.out.println("Delete a word in Trie. ");
            System.out.println("Enter the word you want to delete\n");
            z=word.nextLine(); 
            z=z.toLowerCase();
            MerosE.insert(z);
            MerosE.delete(z);
            System.out.println("Deletion of "+ z +" completed!!!");
            if( MerosE.search(z) == true)
                    System.out.println(z + output[1]);
            else System.out.println(z + output[0]);
            break;
            
            case 4:break;
            default:break;
            }
         }while(trieChoise != 4);
        
         case 6:
        System.out.println("6:MerosD executing searches and store times for each search to csv in the directory of the package.");
        MerosD.times();
        break;
         
        case 7:
        System.out.println("7:Print Menu");
        int printChoise=0;
        do{
            System.out.println("");
            System.out.println("Print Menu:");
            System.out.println("0:Print Initial (No Merge Sort) List");
            System.out.println("1:Print Merge Sorted List");
            System.out.println("2:Print all the words of words.txt");
            System.out.println("3:Exit Printing Programm.");
           printChoise=keyboard.nextInt();
           switch(printChoise){
            case 0:
            try{Printer.printInitial();}catch(IOException e){}
            break;
            
            case 1:
            Printer.printMerged();
            break;
            
            case 2:
            Printer.printWords();
            break;
            
            case 3:break;
            default:break;
            }
         }while(printChoise != 3);
        break;
        
        case 8:break; //Τερματισμος προγραμματος
        default:break;
       }
      }while(choise != 8);
    
    
    }
}
