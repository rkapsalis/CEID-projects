import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class MerosD
{
    static long maxLineral=Long.MIN_VALUE;
    static long maxBinary=Long.MIN_VALUE;
    static long maxInterpolation=Long.MIN_VALUE;//μεγιστος χρονος
    static long maxRBTree=Long.MIN_VALUE;
    static long minLineral= Long.MAX_VALUE;
    static long minBinary= Long.MAX_VALUE;
    static long minInterpolation= Long.MAX_VALUE;//ελαχιστος χρονος αρχικοποιειται με το μαχ του long
    static long minRBTree=Long.MAX_VALUE;
    static long moLineral=0;
    static long moBinary=0;
    static long moInterpolation=0;//μεσος ορος χρονου
    static long moRBTree=0;
    static long sumLineral=0;//αθροισμα ολων των χρονων
    static long sumBinary=0;
    static long sumInterpolation=0;
    static long sumRBTree=0;
    static int number;
    static int i=0;
    public static void times(){
        try{
        PrintWriter pw = new PrintWriter(new File("Searching Time.csv"));
        StringBuilder sb = new StringBuilder();
        
            sb.append("Linear Search Time");
            sb.append(';');
            sb.append("Binary Search Time");
            sb.append(';');
            sb.append("Interpolation Search Time");
            sb.append(';');
            sb.append("Red-Black Tree Search Time");
            sb.append(';');
            sb.append("Search Number");
            sb.append('\n');
        
       try{ MerosA.readIntegers();}catch(IOException e){}
       MerosA.mergeSort(MerosA.initialArray);
        for(int i=0; i<=100; i++){  //100anazhthseis!
       //  Random rand = new Random();
        //int  randomNumber = rand.nextInt(100) ;
       // number=randomNumber;
        number=i;
        
        long startLineral = System.nanoTime();
        MerosB.lineralSearch(number);
        long elapsedNanoTimeLineral = System.nanoTime()-startLineral;
        System.out.println("Lineral Search Finished\n");

        sumLineral=elapsedNanoTimeLineral + sumLineral;
        if(elapsedNanoTimeLineral>maxLineral){maxLineral=elapsedNanoTimeLineral;}
        if(elapsedNanoTimeLineral<minLineral){minLineral=elapsedNanoTimeLineral;}
       
        long startBinary = System.nanoTime();
        MerosB.binarySearch(number);
        long elapsedNanoTimeBinary = System.nanoTime()-startBinary;
        System.out.println("Binary Search Finished\n");
        sumBinary=elapsedNanoTimeBinary + sumBinary;
        if(elapsedNanoTimeBinary>maxBinary){maxBinary=elapsedNanoTimeBinary;}
        if(elapsedNanoTimeBinary<minBinary){minBinary=elapsedNanoTimeBinary;}
        
        long startInterpolation = System.nanoTime();
        MerosB.interpolationSearch(number);
        long elapsedNanoTimeInterpolation= System.nanoTime()-startInterpolation;
        System.out.println("Interpolation Search Finished\n");
        sumInterpolation=elapsedNanoTimeInterpolation + sumInterpolation;
        if(elapsedNanoTimeInterpolation>maxInterpolation){maxInterpolation=elapsedNanoTimeInterpolation;}
        if(elapsedNanoTimeInterpolation<minInterpolation){minInterpolation=elapsedNanoTimeInterpolation;}
        
          /*  int y;
            for(int j=0; j<MerosA.count; j++){
                
                //MerosA.initialArray.get(y)=
                RBTreeInsert(MerosA.initialArray.get(y));
                
            }
        long startRBTree = System.nanoTime();
        MerosC.RBTreeSearch(number);
        long elapsedNanoTimeRBTree= System.nanoTime()-startRBTree;
        System.out.println("Interpolation Search Finished\n");
        sumInterpolation=elapsedNanoTimeRBTree + sumRBTree;
        if(elapsedNanoTimeRBTree>maxRBTree){maxRBTree=elapsedNanoTimeRBTree;}
        if(elapsedNanoTimeRBTree<minRBTree){minRBTree=elapsedNanoTimeRBTree;}*/


            
            
            sb.append(elapsedNanoTimeLineral);
            sb.append(';');
            sb.append(elapsedNanoTimeBinary);
            sb.append(';');
            sb.append(elapsedNanoTimeInterpolation);
            sb.append(';');
            //sb.append(elapsedNanoTimeRBTree);
           // sb.append(';');
            sb.append(number);
            sb.append('\n');

               
    }
        
        
    moLineral = sumLineral/10;
    
    moBinary=sumBinary/10;
    
    moInterpolation=sumInterpolation/10;
    
    //moRBTree=sumRBTree/100;
    
    sb.append(';');
    sb.append(';');
    sb.append(';');
    sb.append('\n');
    
     sb.append("Min Linear");
     sb.append(';');
     sb.append("Min Binary");
     sb.append(';');
     sb.append("Min Interpolation");
    // sb.append(';');
    // sb.append("Min RBTree");
     sb.append('\n');
     
     sb.append(minLineral/1000);
     sb.append(';');
     sb.append(minBinary/1000);
     sb.append(';');
     sb.append(minInterpolation/1000);
    // sb.append(';');
    // sb.append(minRBTree);
     sb.append('\n');
     
     sb.append("Max Linear");
     sb.append(';');
     sb.append("Max Binary");
     sb.append(';');
     sb.append("Max Interpolation");
     // sb.append(';');
    // sb.append("Max RBTree");
     sb.append('\n');
     
     sb.append(maxLineral/1000);
     sb.append(';');
     sb.append(maxBinary/1000);
     sb.append(';');
     sb.append(maxInterpolation/1000);
    // sb.append(';');
    // sb.append(maxRBTree);
     sb.append('\n');
     
     sb.append("Mid Linear");
     sb.append(';');
     sb.append("Mid Binary");
     sb.append(';');
     sb.append("Mid Interpolation");
     sb.append(';');
     sb.append("Mid RBTree");
     sb.append('\n');
     
     sb.append(moLineral/1000);
     sb.append(';');
     sb.append(moBinary/1000);
     sb.append(';');
     sb.append(moInterpolation/1000);
    // sb.append(';');
    // sb.append(moRBTree);
     sb.append('\n');
    pw.write(sb.toString());
    pw.close();
    
    }catch(FileNotFoundException e){}
    

    
    //moRBTree=sumInterpolation/100;
    
    System.out.println("Lineral Search");
    System.out.println("Μέσος Χρόνος Αναζήτησης : "+moLineral+"");
    System.out.println("Ελάχιστος Χρόνος Αναζήτησης : "+minLineral+"");
    System.out.println("Μέγιστος Χρόνος Αναζήτησης : "+maxLineral+"");
    System.out.println("-----------------------------------");
    System.out.println("Binary Search");
    System.out.println("Μέσος Χρόνος: "+moBinary);
    System.out.println("Ελάχιστος Χρόνος Αναζήτησης : "+minBinary);
    System.out.println("Μέγιστος Χρόνος Αναζήτησης : "+maxBinary);
    System.out.println("-----------------------------------");
    System.out.println("Interpolation Search");
    System.out.println("Μέσος Χρόνος: "+moInterpolation);
    System.out.println("Ελάχιστος Χρόνος Αναζήτησης : "+minInterpolation);
    System.out.println("Μέγιστος Χρόνος Αναζήτησης : "+maxInterpolation);
    System.out.println("-----------------------------------");
    /*System.out.println("Red-Black Tree Search");
    System.out.println("Μέσος Χρόνος: "+moRBTree);
    System.out.println("Ελάχιστος Χρόνος Αναζήτησης : "+minRBTree);
    System.out.println("Μέγιστος Χρόνος Αναζήτησης : "+maxRBTree);
    System.out.println("-----------------------------------");*/
    System.out.println("Δημιουργήθηκε αρχείο Excell(csv) με όλους του χρόνους για την κάθε ");
    System.out.println("αναζήτηση στον φάκελο του Project!!!");

  }
}
