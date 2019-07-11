import java.lang.String;
public class DigitalTree {
	final static int alphabet_size = 26;
	
    public static class TrieNode
    {
        TrieNode[] children = new TrieNode[alphabet_size];
      
        boolean EndOfWord;
         
        TrieNode(){
            EndOfWord = false;
            for (int i = 0; i < alphabet_size; i++) //every node has 26 children(arrays), initialized null
                children[i] = null;
        }
    }	
	static TrieNode root;
	DigitalTree()
	    {
	        this.root = new TrieNode();
	    }
	 
	public static boolean access(String word){
		 if (word == null)
	        {
	            return false;
	        }
		TrieNode currentNode = root;
		for(int i=0; i<word.length(); i++){
			if(currentNode!=null){
			 int j=word.charAt(i)-'a'; //a equals to zero
			 if(currentNode.children[j] == null){
			    return false;
			 }
			 currentNode =currentNode.children[j] ;
			}
		}
		return (currentNode.EndOfWord);
	}
	public  void insert(String word){
		TrieNode currentNode = root;
		if (word == null) return; //first we check if the word is null
        
        word = word.toLowerCase(); //we convert capital letters to lower
		int j;
		for(int i=0; i<word.length(); i++){
		    j=word.charAt(i)-'a';
			if(currentNode.children[j] == null){
				currentNode.children[j] = new TrieNode();
			}
			currentNode=currentNode.children[j];
		}
		currentNode.EndOfWord = true; //last node
	}
	private boolean childless(TrieNode insertedNode){ //we check if the node has children(of course not null)
		for (int i = 0; i < insertedNode.children.length; i++)
		{
		if ((insertedNode.children[i]) != null)
			    return false;
	    }
	         return true;
	}
	private boolean deleteHelper(String inWord,TrieNode inNode,int length,int level){
		boolean deletedSuc = false;
		if(inNode == null){
			return deletedSuc;
		}
		if(level == length){ //if we have reached the end of the word we've inserted
			if(childless(inNode)){ //if the node has no children, then we can delete it
				deletedSuc=true;
				inNode = null;
			}
			else{
				deletedSuc=false;
				inNode.EndOfWord = false;
			}
		}
		else{
			TrieNode child = inNode.children[inWord.charAt(level)-'a'];
            boolean childDel = deleteHelper(inWord, child, length, level + 1); // recursive call to delete the node which is child of our node
            if(childDel) { //if the child was deleted
            	inNode.children[inWord.charAt(level)-'a'] = null;
            	if(inNode.EndOfWord == true){ //if a node other than the last node is leaf node, then the rest of the key is part of another key
            		deletedSuc= false;
            	}
            	else if(childless(inNode)== false){ //if the node has more children, then probably is part of another word 
            		deletedSuc= false;
            	}
            	else{
            		inNode = null;
            		deletedSuc= true;
            	}
            }
            else{ //if it wasn't deleted, our node must be part of another word, thus we cannot delete it
            	deletedSuc= false;
            }
			
		}
		return deletedSuc;
	}
	public void delete(String word1){
		 if ((root == null) || (word1 == null))
	        {
	            System.out.println("Null key or Empty trie error");
	            return;
	        }
		 if (access(word1)== false){
			 System.out.println("Word doesn't exist in trie");
		 }
		 else{
			 deleteHelper(word1,root,word1.length(),0);
		 }
	 
	}
}
