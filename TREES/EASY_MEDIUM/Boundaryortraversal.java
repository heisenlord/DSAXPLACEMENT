package TREES.EASY_MEDIUM;
class Solution
{
    List<Integer> leftdfs=new ArrayList<>();
    List<Integer> leaves=new ArrayList<>();
    List<Integer> rightdfs=new ArrayList<>();

    
   void leftdfs(Node node)
    {
        if((node==null)||(node.left==null&&node.right==null))
        {
            return;
            
        }
        leftdfs.add(node.data);
        if(node.left!=null)
        {
        leftdfs(node.left);
        }else{
        leftdfs(node.right);
        }
    }
    void leaves(Node node)
    {
        if(node==null)
        {
            return;
        }
        if(node.left==null&&node.right==null)
        {
            leaves.add(node.data);
        }
        
        leaves(node.left);
        leaves(node.right);
        
    }
    void rightdfs(Node node)
    {
        if(node==null||(node.left==null&&node.right==null))
        {
            return;
        }
        if(node.right!=null)
        {
            
    
        rightdfs(node.right);
        }
        else{
        rightdfs(node.left);}
        rightdfs.add(node.data);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    leftdfs(node.left);
	    leaves(node);
	    rightdfs(node.right);
	    ArrayList<Integer> ls=new ArrayList<>();
	    if(node!=null&&(node.left!=null||node.right!=null))ls.add(node.data);
	    ls.addAll(leftdfs);
	    ls.addAll(leaves);
	    ls.addAll(rightdfs);
	    return ls;
	}
}
