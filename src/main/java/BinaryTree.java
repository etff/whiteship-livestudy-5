import java.util.*;

public class BinaryTree {
    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean find(int value) {
        return findRecursive(root, value);
    }

    public void delete(int value) {
        deleteRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private boolean findRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? findRecursive(current.left, value)
                : findRecursive(current.right, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    /**
     * 중위 순회
     * @param node
     */
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    /**
     * 전위 순회
     * @param node
     */
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    /**
     * 후위 순회
     * @param node
     */
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> dfsInOrder() {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            while(current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            result.add(current.value);
            if(current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
        return result;
    }

    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            result.add(node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return result;
    }


}
