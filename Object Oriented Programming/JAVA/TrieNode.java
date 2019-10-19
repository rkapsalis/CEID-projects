
public class TrieNode{
    protected boolean wordEnd;
    static final int alphabet=26;
    TrieNode  []wordArray=new TrieNode[alphabet];
    TrieNode(){
            wordEnd=false; 
            for (int i = 0; i <alphabet; i++)
                wordArray[i] = null; 
        }
      
    public boolean getWordEnd(){
             return wordEnd;
        }
            
    public void setWordEnd(boolean x){
              wordEnd=x;
        }   
}

