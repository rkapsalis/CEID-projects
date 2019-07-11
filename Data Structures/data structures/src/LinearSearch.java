import java.util.List;
public class LinearSearch {
	static int linear(List <Integer> arr, int m, int x)
    {
        for (int i = 0; i < m; i++)
        {
            // Return the index of the element if the element
            // is found
            if (arr.get(i) == x)
                return i;
        }
  
        // return -1 if the element is not found
        return -1;
    }
}
