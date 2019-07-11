import java.util.ArrayList;

public class MergeSort {
	public static ArrayList<Integer>  mergesort(ArrayList<Integer> arr){
		ArrayList<Integer> leftSA = new ArrayList<Integer>();
		ArrayList<Integer> rightSA = new ArrayList<Integer>();
		int size = arr.size();
		int mid = size/2;
		//if (size<2){
			//return ;
		//}		 
		 for (int i = 0; i < mid; i++) {
			    leftSA.add( arr.get(i)); 			    
			}
		 for (int i = mid; i < arr.size(); i++) {
			    rightSA.add(arr.get(i)); 
			}		
		 if(leftSA.size()>1){
		leftSA = MergeSort.mergesort(leftSA);
		 }
		 if(rightSA.size()>1){
		rightSA = MergeSort.mergesort(rightSA);}
		return MergeSort.merge(leftSA,rightSA);		
	}
	 private static ArrayList <Integer>  merge(ArrayList <Integer> left,ArrayList <Integer> right){
		 ArrayList<Integer> A = new ArrayList<Integer>();
		 int i=0,j=0; //left,right index		   
	        while (i < left.size() && j < right.size() )
	        {
	            if (left.get(i) < right.get(j))
	            {	                
	            	A.add(left.get(i));
	                i++;
	            }
	            else
	            {	                
	            	A.add(right.get(j));
	                j++;
	            }	            
	        }
	        if(i< left.size()){
	          while (i < left.size())
	          {	            
	        	A.add(left.get(i));
	            i++;	            
	          }
	        }
	        else{
	          while (j < right.size())
	          {	            
	        	A.add(right.get(j));
	            j++;	            
	          }
	        }
	        return A;
	 }

}
