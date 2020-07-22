public class BSTNode
{
   private int info;
   private BSTNode left;
   private BSTNode right;

   public BSTNode(int info)
   {
      this.info = info;
      this.left = null;
      this.right = null;
   }

   public void setInfo(int info)
   {
      this.info = info;
   }

   public int getInfo()
   {
      return this.info;
   }

   public void setRight(BSTNode right)
   {
      this.right = right;
   }

   public BSTNode getRight()
   {
      return this.right;
   }

   public void setLeft(BSTNode left)
   {
      this.left = left;
   }

   public BSTNode getLeft()
   {
      return this.left;
   }
}
