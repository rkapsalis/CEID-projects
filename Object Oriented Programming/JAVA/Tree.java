public abstract class Tree{
            public static TreeNode root;
            public Tree(){
                root=null;
            }
            public static void makeRoot(int x){
                root=new TreeNode(x);
            }
            public static boolean empty(){
                return (root==null);}
                public static TreeNode getRoot(){
                    return root;
                }
                public static int getData(){
                    if (root !=null){
                        return root.getData();}
                        return 0;
                    }
              public static TreeNode getLeft(){
                  if (root!= null){
                   return root.getLeft();}
                  else
                   return null;
                       }
                 public static TreeNode getRight(){
                  if (root!= null){
                   return root.getRight();}
                    else
                    return null;
               }
               public static void setData(int d){
                if (root!= null)
                root.setData(d);
               }
                 public static void insertLeft(TreeNode p, int x){
                 if ((p!=null)&&(p.getLeft()==null)){
                  TreeNode q=new TreeNode(x);
                  p.setLeft(q);
                                }
               }
              public static void insertRight(TreeNode p, int x){
               if((p!=null)&&(p.getRight()==null)){
                TreeNode q=new TreeNode(x);
                 p.setRight(q);
                                }
                            }
    
                        }