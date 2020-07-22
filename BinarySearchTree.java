public class BinarySearchTree
{
   protected BSTNode root;
   protected boolean success;

   public BinarySearchTree()
   {
      this.root = null;
   }

   public boolean contains(int value)
   {
      BSTNode curr = root;

      while(curr != null)
      {
         if(value == curr.getInfo())
         {
            return true;
         }
         else if(value < curr.getInfo())
         {
            curr = curr.getLeft();
         }
         else
         {
            curr = curr.getRight();
         }
      }
      return false;
   }

   public boolean add(int value)
   {
      root = add(value, root);
      return success;
   }

   private BSTNode add(int value, BSTNode curr)
   {
      if(curr == null)
      {
         curr = new BSTNode(value);
         success = true;
      }
      else if(value < curr.getInfo())
      {
         curr.setLeft(add(value, curr.getLeft()));
      }
      else if(value > curr.getInfo())
      {
         curr.setRight(add(value, curr.getRight()));
      }
      else
      {
         success = false;
      }
      return curr;
   }

   public void preOrder()
   {
      System.out.print("Pre Order: ");
      preOrder(root);
      System.out.println();
   }
   private void preOrder(BSTNode curr)
   {
      if(curr != null)
      {
         System.out.print(curr.getInfo() + " ");
         preOrder(curr.getLeft());
         preOrder(curr.getRight());
      }
   }

   public void inOrder()
   {
      //Complete this method as required in the homeowrk instructions
      System.out.print("In Order: ");
      inOrder(root);
      System.out.println();
   }
   public void inOrder(BSTNode curr)
   {
     if (curr != null) {
       inOrder(curr.getLeft());
       System.out.print(curr.getInfo() + " ");
       inOrder(curr.getRight());
     }
   }


   public void postOrder()
   {
      //Complete this method as required in the homeowrk instructions
      System.out.print("Post Order: ");
      postOrder(root);
      System.out.println();
   }
   public void postOrder(BSTNode curr)
   {
     if (curr != null) {
       postOrder(curr.getLeft());
       postOrder(curr.getRight());
       System.out.print(curr.getInfo() + " ");
     }
   }

   public int countLeaves()
   {
      //Complete this method as required in the homeowrk instructions
      return countLeaves(root);
   }

   public int countLeaves(BSTNode curr)
   {
      if (curr == null) {
        return 0;
      }
      if (curr.getLeft() == null && curr.getRight() == null) {
        return 1;
      } else {
        return countLeaves(curr.getLeft()) + countLeaves(curr.getRight());
      }


   }


   public int size()
   {
      //Complete this method as required in the homeowrk instructions
      return size(root);
   }

   public int size(BSTNode curr)
   {
      if (curr == null) {
        return 0;
      }
      return size(curr.getLeft()) + size(curr.getRight()) + 1;
   }

   // public int height()
   // {
   //    //Complete this method as required in the homeowrk instructions
   //
   //
   //
   // }

   public boolean remove(int target)
   {
      root = remove(target, root);
      return success;
   }

   private BSTNode remove(int target, BSTNode curr)
   {
      if(curr == null)
      {
         success = false;
      }
      else if(target < curr.getInfo())
      {
         curr.setLeft(remove(target, curr.getLeft()));
      }
      else if(target > curr.getInfo())
      {
         curr.setRight(remove(target, curr.getRight()));
      }
      else
      {
         curr = removeNode(curr);
         success = true;
      }
      return curr;
   }

   private BSTNode removeNode(BSTNode curr)
   {

      if(curr.getLeft() == null)
      {
         return curr.getRight();
      }
      else if(curr.getRight() == null)
      {
         return curr.getLeft();
      }
      else
      {
         int data = getRightMostData(curr.getLeft());
         curr.setInfo(data);
         curr.setLeft(remove(data, curr.getLeft()));
         return curr;
      }
   }

   private int getRightMostData(BSTNode subtree)
   {
      BSTNode temp = subtree;

      while (temp.getRight() != null)
      {
         temp = temp.getRight();
      }
      return temp.getInfo();
   }
}
