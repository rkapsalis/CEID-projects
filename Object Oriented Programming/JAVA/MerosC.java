import java.io.*;
import java.util.*;
public class MerosC extends Tree //Red-Black Tree
{
     public static void RBTreeInsert(int x){
        TreeNode t,q=null;
        t=root;
        while(t!=null&&(x!=t.getData())){
          q=t;
          if(x<t.getData()){
             t=t.getLeft();
           }
           else
            t=t.getRight();
        }
        if(t!=null)
         return;
        if(q==null){
         makeRoot(x);
         return;
        }
        if (x<q.getData()){
        insertLeft(q,x);}
        else
        {insertRight(q,x);}
        TreeFix(q);
        }

     public static void TreeFix(TreeNode a){
        TreeNode parent=null;
        TreeNode grandparent=null;
       // if(a!=root && grandparent==null){
       // return;}
       parent=a.parent;
       grandparent=parent.parent;
        while(a !=root && a.getColor()== TreeNode.red && a.parent.getColor()==TreeNode.red){
            parent=a.parent;
            grandparent=parent.parent;
            if(parent==grandparent.getLeft()){
                TreeNode uncle = grandparent.getRight();
            
            if(uncle.getColor()==TreeNode.red){
              uncle.setColor(TreeNode.black);
              parent.setColor(TreeNode.black);
              grandparent.setColor(TreeNode.red);
              a=grandparent;
            }
            else
            {
            if(a==parent.getRight()){
             leftRotate(parent);
             a=parent;
             parent=a.parent;
            }
            rightRotate(grandparent);
            TreeNode temp=null; //swap(parent.getColor,grandparent.getColor);
            temp.setColor(parent.getColor());
            parent.setColor(grandparent.getColor());
            grandparent.setColor(temp.getColor());
            a=parent;
           }
        }
            else{
                TreeNode uncle=grandparent.getLeft();
                if (uncle.getColor()==TreeNode.red){
                    uncle.setColor(TreeNode.black);
                    parent.setColor(TreeNode.black);
                    grandparent.setColor(TreeNode.red);
                    a=grandparent;
                }
                else{
                    if(a==parent.getLeft()){
                    rightRotate(parent);
                    a=parent;
                    parent=a.parent;
                    }
                    leftRotate(grandparent);
                    TreeNode temp=null; //swap(parent.getColor,grandparent.getColor);
                    temp.setColor(parent.getColor());
                    parent.setColor(grandparent.getColor());
                    grandparent.setColor(temp.getColor());
                    a=parent;
                }
        }
    }
    root.setColor(TreeNode.black);
  }
  
  public static void leftRotate(TreeNode a){
      TreeNode rightChild = a.getRight();
      a.setRight(rightChild.getLeft());
      if(a.getRight()!=null)
        {a.getRight().parent=a;}
        rightChild.parent=a.parent;
        if(a.parent==null)
        {root=rightChild;}
        else if(a==a.parent.getLeft())
        {a.parent.setLeft(rightChild);}
        else
        {a.parent.setRight(rightChild);}
        rightChild.setLeft(a);
        a.parent=rightChild;
        }
    
    
    public static void rightRotate(TreeNode a){
        TreeNode leftChild=a.left;
        a.setLeft(leftChild.getRight());
        if(a.getLeft() != null)
            {a.getLeft().parent=a;}
        leftChild.parent=a.parent;
        if(a.parent==null)
        {root=leftChild;}
        else if(a==a.parent.getLeft())
        {a.parent.setLeft(leftChild);}
        else
        {a.parent.setRight(leftChild);}
        leftChild.setRight(a);
        a.parent=leftChild;
        }
    

    public static void RBTreeSearch(int x){
        int counter=-1;
        int counterArray=0;
        ArrayList<String> TreeArray = new ArrayList<String>();
        char left,right;
        boolean found=false;
        TreeNode t,q=null;
        t=root;
        while(t!=null&&(x!=t.getData())){
            q=t;
       
          if(x<t.getData()){
             counter++;
             t=t.getLeft();
             TreeArray.add("left");
             counterArray++;
           }
           else
           { counter++;
            t=t.getRight();  
            TreeArray.add("right");
            counterArray++;
            }
        }
        if(t!=null && (x==t.getData()))
        {
          found=true;
          System.out.println("The number" + x +" is found at the height "+ counter );
          System.out.println("The position of the number is : ");
          for(int i = 0;i<MerosA.initialArray.size();i++)
             {System.out.println(MerosA.initialArray.get(i));}
            TreeArray.clear();
        }
        if(found==false)
         System.out.println("The number" + x +"  was not found at the tree.");
        }

       public static void main(String args[]){
           TreeNode root= new TreeNode();
       try{ MerosA.readIntegers();}catch(IOException e){}
       MerosA.mergeSort(MerosA.initialArray);
        for(int i = 0;i<MerosA.initialArray.size();i++)
           {RBTreeInsert(MerosA.initialArray.get(i));}
        

    }
}
        
   