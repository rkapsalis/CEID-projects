import java.util.Scanner;
import java.util.ArrayList;
public class MerosB 
{
    static Scanner keyboard=new Scanner(System.in);
    public static int number;
    public static void lineralSearch(int x)
    {
      System.out.println("Lineral Search");
      //System.out.println("Enter the number you want to search\n");
      //number=keyboard.nextInt();
      number=x;
      int a, b;
      boolean found =false;
      for ( a=0;  a < MerosA.count; a++){
       if(MerosA.initialArray.get(a)==number){
           System.out.println("******The number " + number + " is present at the " + (a + 1)+ " position of the array.");
           found=true;
        } 
        }
        if(found == false)
         {System.out.println("The number "+ number +" does not exist in the array. ");}
    }
      public static void binarySearch(int x)
    {
      System.out.println("Binary Search");
      //System.out.println("Enter the number you want to search\n");
      //number=keyboard.nextInt();
      number=x;
      int low=0;
      int high=(MerosA.count-1);
      boolean found = false;
      while(low<=high){ 
        int middle=(low+high)/2;
          if (middle-((int)middle)==0)
        {middle=(low+high)/2;}
        else
        {middle=((low+high)/2)+1;}//an middle perittos tote pernei to ont meros kai a8roizei 
        if(MerosA.initialArray.get(middle) > number)
        {high=middle-1;}
        else if(MerosA.initialArray.get(middle) < number)
        {low=middle+1;}
        else 
        {
         found=true;
         System.out.println("******The number " + number + " is present at the " + (middle + 1)+ " position of the array.");
         break;
        }
         }
         if(found == false)
         {System.out.println("******The number "+ number +" does not exist in the array. ");}
    }
      public static void interpolationSearch(int x)
      {
      System.out.println("Interpolation Search");
      //System.out.println("Enter the number you want to search\n");
      //number=keyboard.nextInt();
      number=x;
      int low=0;
      int high=(MerosA.count-1);
      boolean found = false;
      while(low<=high && number>= MerosA.initialArray.get(low) && number <= MerosA.initialArray.get(high))
      {//Condition number is found
       int a=(high-low);
       int b=(MerosA.initialArray.get(high) - MerosA.initialArray.get(low));
       int pos=low+((a/b)*(number - MerosA.initialArray.get(low)));  
       if(MerosA.initialArray.get(pos)==number)
       {System.out.println("******The number "+ number +" is found at position "+ (pos+1));
        found=true;
        }
       if(MerosA.initialArray.get(pos) < number)
       {low =pos+1;}
       else
       {high=pos-1;}
      }
      if(found == false)
         {System.out.println("******The number "+ number +" does not exist in the array. ");}
    }
}
