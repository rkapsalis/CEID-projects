import java.io.*;
import java.util.*;


public class class1 { 
	public static int random(int j,Random r){
		
		 for (int i = 0; i <= j; i++) {
		int randomIndex = r.nextInt(100000)+10;        
		return randomIndex;
		 }
		 return -1;
	}
	
    public static void main(String [] args) {    	
    	 ArrayList<Integer> v = new ArrayList<Integer>();
        // The name of the file to open.
    	 BufferedReader br = null;        
        // This will reference one line at a time
        String line = null;
       
        try {
            // FileReader reads text files in the default encoding.            
        	br = new BufferedReader(new FileReader(new File("integers.txt")));
                    
            while((line = br.readLine()) != null) {
                System.out.println(line);                
                   v.add(Integer.parseInt(line));
            
            // Always close files.         
            }           
           
        }
        catch(FileNotFoundException ex) {               
        	ex.printStackTrace();
        }
        catch(IOException ex) {                        
            ex.printStackTrace();
        }
        finally {
            if (br != null) {
               try {
                  br.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
        ArrayList<String> s = new ArrayList<String>();
        BufferedReader br1 = null;                
        String line1 = null;
       
        try {            
        	br1 = new BufferedReader(new FileReader(new File("words.txt")));                        

            while((line1 = br1.readLine()) != null) {
                System.out.println(line1);              
                    s.add(line1);
                 
           }         
        }
        catch(FileNotFoundException ex) {               
        	ex.printStackTrace();
        }
        catch(IOException ex) {                           
            ex.printStackTrace();
        }
        finally {
            if (br1 != null) {
               try {
                  br1.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
        String choice = null;
        try{
        FileWriter writer1 = new FileWriter("test.csv");
        writer1.close();
        }catch(IOException e){
        	e.printStackTrace();
        }    
        do{
            System.out.println("1.Mergesort");
    		System.out.println("2.Linear Search");
    		System.out.println("3.Binary Search");
    		System.out.println("4.Interpolation Search");
    		System.out.println("5.Red Black Tree");
    		System.out.println("6.Digital Tree");		
    		System.out.println("7.Exit");
    		System.out.println("Please select something: ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            Random rand = new Random(20);           
    		 switch (choice){
    		 case "1":    			
    			 MergeSort.mergesort(v);
    			 PrintWriter writer = null;
    				try {
    					writer = new PrintWriter("./output1.txt", "UTF-8");
    				} catch (FileNotFoundException e) {} catch (UnsupportedEncodingException e) {}    				 
    					 writer.println(MergeSort.mergesort(v));
    				 writer.close();    			 
    			 break;
    		 case "2":    			 
    			 System.out.println("Please insert the number you want to find: ");
    			 int value = scan.nextInt();   				 
    			
    			 ArrayList <Integer> msv1 = MergeSort.mergesort(v);    			
    			 while (value != -999) { 	 
    			       
    			       
    				 if ( LinearSearch.linear(msv1, 100000, value)== -1){
    						 System.out.println("The number you have inserted isn't present in the list");
    					 }
    					 else{
    						 System.out.println(value + " is present at position " + LinearSearch.linear(msv1, 100000, value));
    					 }
    				 value = scan.nextInt();
    			    }   			 
    				 
    			 break;
    		 case "3":			
    			 System.out.println("Please insert the number you want to find: ");
    			 int value1 = scan.nextInt();
    			   			
    			 ArrayList <Integer> msv2 = MergeSort.mergesort(v); 
    			 
    			 while (value1 != -999) {    			        
    			        if (BinarySearch.binary(msv2,value1) == -1){
    						 System.out.println("The number you have inserted isn't present in the list");
    					 }
    					 else{
    						 System.out.println(value1 + " is present at position " + BinarySearch.binary(msv2, value1));
    					 }
    			        value1 = scan.nextInt(); 
    			    }   	   			
    			 
    				 break;			
    		 case "4":
    			 System.out.println("Please insert the number you want to find: ");
    			 int value2 = scan.nextInt();
    			   			
    			 ArrayList <Integer> msv3 = MergeSort.mergesort(v);
    			
    			 while (value2 != -999) {    			        
    			        if (InterpolationSearch.interpolation(msv3, value2)== -1){
    						 System.out.println("The number you have inserted isn't present in the list");
    					 }
    					 else{
    						 System.out.println(value2 + " is present at position " + InterpolationSearch.interpolation(msv3, value2));
    					 }
    			        value2 = scan.nextInt(); 
    			    }    						 
    			 break;
    		 case "5":				
    			 RedBlackTree rbt = new RedBlackTree();    			 
    			        Scanner scan1 = new Scanner(System.in);
    			        while (true) {
    			            System.out.println("\n1.- Add items\n"
    			                    + "2.- Search items\n"
    			                    + "3.- Print tree\n"
    			                    );
    			            int choice1 = scan1.nextInt();
    			            int item;   			            
    			            
    			            switch (choice1) {
    			                case 1:
    			                    
    			                	ArrayList <Integer> msv = MergeSort.mergesort(v);
    			                	/*item = scan1.nextInt();
    			                    while (item != -999) {
    			                        //node = new Node();
    			                    	
    			                    	RedBlackTree.Node node1 =  new RedBlackTree.Node(item);
    			                        rbt.insertNode(item); 	                       
    			                        item = scan1.nextInt();
    			                    } */    			                	
    			                    for(int i=0;i<msv.size();i++){
    			                    	RedBlackTree.Node node1 =  new RedBlackTree.Node(msv.get(i));
    			                        rbt.insertNode(msv.get(i)); 	                                     
    			                    }     			                    
    			                    //RedBlackTree.printTree(RedBlackTree.root); 
    			                   rbt.printTree(rbt.root);
    			                    //rbt.isTreeRight();
    			                   // System.out.println(rbt.isTreeRight());
    			                    break;
    			                case 2:
    			                	System.out.println("Please insert the number you want to find: ");
    			                    item = scan1.nextInt();    			                    
    			                     while (item != -999) {			                        
			                    	RedBlackTree.Node node2 =   new RedBlackTree.Node(item);			                    	
			                        System.out.println((rbt.search(node2 ) != null) ? "found" : "not found");
			                        item = scan1.nextInt();
			                        
			                    } 	                 
    			                     
    			                   /* for (int i = 0; i < item; i++) {	
    			                    	RedBlackTree.Node node2 =  new RedBlackTree.Node(random(i,rand));
    			                    	
    			    			        if (rbt.search(node2)== null){
    			    						 System.out.println("The number you have inserted isn't present in the tree");
    			    					 }
    			    					 else{
    			    						 System.out.println(random(i,rand) + " is present in the tree " );
    			    					 }
    			    			    } */
    			                    
    			                    break;
    			                case 3:
    			                    rbt.printTree(rbt.root);
    			                    break;
    			                
    			            }
    			        }   			 
    		    
    		 case "6": 
    			 Scanner scan2 = new Scanner(System.in);
    			 Scanner scan8 = new Scanner(System.in);
    			 Scanner scan9 = new Scanner(System.in);
    			 Scanner scan10 = new Scanner(System.in);
    		       		            
    		            DigitalTree dt = new DigitalTree();
    		            
    		               		            			            	
    	                   for(int i=0;i<s.size();i++){
    	                      dt.insert(s.get(i));
    	                    }
    	                   System.out.println("Please give the word you want to insert: ");
    	                   String item11 = scan10.nextLine();
    	                   dt.insert(item11);
    	                    System.out.println("Please give the word you want to search: ");
    	                    String item1 = scan8.nextLine();
    	                    System.out.println(dt.access(item1));
    	                    System.out.println("Please give the word you want to delete: ");
   		            	    String item5 = scan9.nextLine();
   		            	    dt.delete(item5);
   		            	    System.out.println(dt.access(item5)); //trexei h access gia na doume an egine diagrafh 		            	    		            		 
   		           

    		            	break;    		           
    		            
    		     
    			
    		 case "7":	
    			 break;
    		 }
            }while(!choice.equals("6")); 
          
     }
    } 
//}  
    
