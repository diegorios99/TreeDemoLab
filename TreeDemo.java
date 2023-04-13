class Node {
   int value;
   Node left, right;

   public Node(int value) {
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree {

   Node root;

   /**
    * insest method that puts new values into the BST
    * 
    * @param root  node that is going to be added
    * @param value the value for the node
    * @return returns a Node
    */
   public Node insert(Node root, int value) {
      // base case
      if (root == null) {
         root = new Node(value);
         return root;
      }

      // recursive step
      if (value < root.value) {
         root.left = insert(root.left, value);
      } else {
         root.right = insert(root.right, value);
      }

      return root;
   }

   /**
    * preOrderTravesal method that walks the BST and prints out the values in pre
    * order
    * 
    * @param root
    */
   public void preOrderTraversal(Node root) {
      // implement me
      if (root == null) {
         return;
      }

      System.out.println(root.value + ", ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   /**
    * inOrderTraversal method that walks the BST and prints out the values in
    * order
    * 
    * @param root
    */
   public void inOrderTraversal(Node root) {
      // implement me
      if (root == null) {
         return;
      }

      inOrderTraversal(root.left);
      System.out.print(root.value + ", ");
      inOrderTraversal(root.right);
   }

   /**
    * postOrderTraversal method that walks the BST and prints out the values post
    * order
    * 
    * @param root
    */
   public void postOrderTraversal(Node root) {
      // implement me
      if (root == null) {
         return;
      }

      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + ", ");

   }

   /**
    * find method that searches the BST for the key
    * 
    * @param root current node that is being looked at
    * @param key  value that is being looked for
    * @return return a boolean value
    */
   public boolean find(Node root, int key) {
      // implement me

      if (root == null) {
         return false;
      }

      if (root.value == key) {
         return true;
      }

      if (root.value < key) {
         return find(root.right, key);
      }

      if (root.value > key) {
         return find(root.left, key);
      }

      return false;
   }

   /**
    * getMin method that searches the BST for the minimum value
    * 
    * @param root current node that is being looked at
    * @return return an int value
    */
   public int getMin(Node root) {
      // implement me
      if (root.left == null) {
         return root.value;
      } else {
         return getMin(root.left);
      }
   }

   /**
    * getMax method that searches the BST for the maximum value
    * 
    * @param root current node that is being looked at
    * @return return an int value
    */
   public int getMax(Node root) {
      // implement me
      if (root.right == null) {
         return root.value;
      } else {
         return getMax(root.right);
      }
   }

   /**
    * delete method that takes in a Node and a value
    * 
    * @param root current root that is being looked at
    * @param key  the value that needs to be deleted
    * @return returns a Node
    */
   public Node delete(Node root, int key) {

      if (root == null) {
         return root;
      } else if (key < root.value) {
         root.left = delete(root.left, key);
      } else if (key > root.value) {
         root.right = delete(root.right, key);
      } else {
         // node has been found
         if (root.left == null && root.right == null) {
            // case #1: leaf node
            root = null;
         } else if (root.right == null) {
            // case #2 : only left child
            root = root.left;
         } else if (root.left == null) {
            // case #2 : only right child
            root = root.right;
         } else {
            // case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;
   }

   /**
    * insert method that adds to BST
    * 
    * @param value value that is being added
    */
   public void insert(int value) {
      // tree is empty
      if (root == null) {
         root = new Node(value);
         return;
      } else {
         Node current = root;
         Node parent = null;

         while (true) {
            parent = current;

            if (value < current.value) {
               current = current.left;
               if (current == null) {
                  parent.left = new Node(value);
                  return;
               }
            } else {
               current = current.right;
               if (current == null) {
                  parent.right = new Node(value);
                  return;
               }
            }

         } // closing while

      } // closing main if-else
   }
}

public class TreeDemo {
   public static void main(String[] args) {
      BinarySearchTree t1 = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);

      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();

   }
}