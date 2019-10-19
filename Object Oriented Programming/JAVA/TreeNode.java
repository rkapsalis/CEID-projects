 public class TreeNode{
           public static final int red = 0;
           public static final int black = 1;
           protected int data;
           protected int color;
           private static int temp;
           protected TreeNode left;
           protected TreeNode right;
           protected TreeNode parent;
            public TreeNode(){
                right=left=parent=null;
            }
            public TreeNode(int x){
              data=x;
              temp=red;
              this.color=temp;
              left=right=parent=null;
            }
            public int getData(){
             return data;
            }
            public TreeNode getLeft(){
             return left;
            }
            public TreeNode getRight(){
             return right;
            }
            public int getColor(){
             return temp;
            }
            public void setData(int d){
             data=d;
            }
            public void setLeft(TreeNode l){
             left=l;
            }
            public void setRight(TreeNode r){
             right=r;
            }
            public void setColor(int c){
             temp=c;                    
            }
        }