import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RedBlackTree {
	private static final int red = 0;
    private static final int black = 1;
	public static class Node{
		int data=-1;
		Node left=nl;
		Node right=nl;
		Node parent;
		int NodeColor = black;
		//boolean nil;
		Node(int data) { //constructor
            this.data = data;
        } 
	}
	Node root = null;
	private static final Node nl = new Node(-1); //leaf node
	public static Node access(Node root,Node x){ //we define the position of the newly inserted node
		if(root == nl){
			return x;
		}
		if(x.data <= root.data){
			root.left = access(root.left,x);
			root.left.parent = root;
		}
		else if(x.data > root.data){
			root.right = access(root.right,x);
			root.right.parent = root;
		}
		return root;
	}	
	public Node search(Node myNode){ //binary search tree search
		Node in=root;
		while(in!=nl){
			if(in.data==myNode.data){
				return in;
			}
			else if(myNode.data < in.data){
				in = in.left;
			}
			else{
				in = in.right;
			}
		}
		return null;
	}
	private void leftRotation(Node x){
		Node y = x.right;
		x.right = y.left;
		if(x.right!=nl){
			x.right.parent = x;
		}
		y.parent=x.parent;
		if(x.parent == nl){
			root = y;
		}
		else if(x == x.parent.left){
			x.parent.left = y;
		}
		else{
			x.parent.right = y;
		}
		 y.left = x;
         x.parent = y;
	}
    private  void rightRotation(Node x){
    	Node y = x.left;
		x.left = y.right;
         if(x.left!=nl){
			x.left.parent = x;
		}
         y.parent = x.parent;
         if(x.parent == nl){
 			root = y;
 		}
 		
 		else if(x == x.parent.left){
 			x.parent.left = y;
 		}
 		else{
 			x.parent.right = y;
 		}
         y.right = x;
         x.parent = y;
	}
    public void insertNode(int n){
    	Node myNode = new Node(n);
    	if(root== null){    		
    		 root = myNode;
             myNode.NodeColor = black;
             myNode.parent = nl;
             
    		}
    	else{    	
    		myNode.NodeColor =red;
    		myNode.left.NodeColor = black;
    		myNode.right.NodeColor = black;
    	root = access(root,myNode); 
    	fixInsertNode(myNode); 
    	}
    	
    }
    
    private  void fixInsertNode(Node newNode){  // int data
		Node parent = nl;
	    Node grandparent = nl;
	   // Node sibling = nl;		
		while( newNode != root){	
			Node sibling = nl;
			if(newNode.parent.NodeColor == black || newNode.NodeColor==black ){
				break;
			}
			
			  parent = newNode.parent;
		      grandparent = parent.parent;
			
			if(parent == grandparent.left){ //
			   sibling = grandparent.right;
				if(sibling.NodeColor == red){ //if the sibling is red recolor and check again
					grandparent.NodeColor = red;
					sibling.NodeColor = black;
					parent.NodeColor = black;
					newNode = grandparent; //1
					continue;
				}
				else{ //if the sibling is black rotate, recolor and check again
					if (newNode == parent.right){ //if the node we have inserted is right child we rotate left and then right
						leftRotation(parent);
						newNode = parent; //newNode becomes the parent of the node, to see if the properties of tree are fulfilled
						parent = newNode.parent;
					}
					rightRotation(grandparent); //if the node we have inserted is not right child we only do a single left rotation				
					int sw2=parent.NodeColor; //then we swap the colors of parent and grandparent 
					parent.NodeColor=grandparent.NodeColor;
					grandparent.NodeColor=sw2; 					
					newNode=parent;//2
				}
			}
			else{ //if parent is grandparent right
			    sibling = grandparent.left;	
			    if(sibling!=nl){
				if(sibling.NodeColor == red ){ //if the sibling is red recolor and check again
					sibling.NodeColor = black;
					parent.NodeColor = black;
					grandparent.NodeColor = red;
					newNode=grandparent;//3
					continue;
				} }				
				if(sibling.NodeColor == black || sibling == nl) {//if the sibling is black rotate, recolor and check again
					if (newNode == parent.left){ //if the node we have inserted is right child we rotate left and then right
						rightRotation(parent);
						newNode = parent;
						parent = newNode.parent;
					}
					leftRotation(grandparent);
					int sw1;
					sw1=parent.NodeColor;
					parent.NodeColor=grandparent.NodeColor;
					grandparent.NodeColor=sw1; 					
					newNode=parent;//4					
				}
			}			
		}
		root.NodeColor = black;
	}	
    //PrintWriter writer2 = null;
    public void printTree(Node node) {
        if (node == nl) {
            return;
        }
        printTree(node.left);      
		
        System.out.print(((node.NodeColor==red)?"Color: Red ":"Color: Black ")+"Key: "+node.data+" Parent: "+node.parent.data+"\n");
        printTree(node.right);
    } 
    

}

