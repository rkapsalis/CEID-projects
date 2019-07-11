import java.util.List;
public class InterpolationSearch {
 static int interpolation(List <Integer> arr,int x){
	int left=0;
	int right= arr.size()-1;
	while(left<=right && x>=arr.get(left) && x<=arr.get(right)){
		int next=(int)( left +((double)((x-arr.get(left)))*(right-left))/(double)((arr.get(right)-arr.get(left))));
		//typecasting is used to support a wider range of numbers
		if (arr.get(next)==x){
			  return next;
		  }
		else if(x < arr.get(next)){
			  right=next-1;
		  }
		  else{
			  left=next+1;
		  }	 
	}
	return -1;
 }
}
