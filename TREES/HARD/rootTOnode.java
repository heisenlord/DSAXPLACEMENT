package TREES.HARD;
import java.util.*;
class Node{
    int val;
    Node left,right;
    public Node(int val)
    {
        this.val=val;
    }
}
class Tree{
    public ArrayList<Integer> rootTonode(Node root,int ans)
    {
        ArrayList<Integer> al=new ArrayList<>();
      rootToNodeHelp(root, al, ans);
        return al;
    }

   boolean rootToNodeHelp(Node root,ArrayList<Integer> al,int ans)
   {
    if(root==null)
    {
        return false;
    }
    if(ans==root.val)
    {
        return true;
    }
    if(rootToNodeHelp(root.left, al, ans)||  rootToNodeHelp(root.right, al, ans))
    {
        return true;
    }
  
    al.remove(al.size()-1);
    return false;


   }
}

public class rootTOnode {
    public static void main(String[] args) {
    
}
    
}
