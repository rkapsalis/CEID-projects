import java.util.ArrayList;
public class BinarySearch {
 static int binary(ArrayList <Integer> arr,int x){
  int start=0;
  int end= arr.size()-1;
  while (start<=end){
	  int middle=(start+end)/2;
	  
	  if (arr.get(middle)==x){
		  return middle;
	  }
	  else if(x < arr.get(middle)){
		  end=middle-1;
	  }
	  else{
		  start=middle+1;
	  }	 
  }
  return -1; //in case the element isn't in the array
}
}