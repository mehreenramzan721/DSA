import java.util.*;

class BinaryTree {
    private Node root;

    public BinaryTree() {}

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void populate(Scanner scanner) {
        System.out.print("Enter the root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        // Left Node Logic
        System.out.println("Do you want to enter left of " + node.value + "? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of the left of " + node.value + ": ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        // Right Node Logic
        System.out.println("Do you want to enter right of " + node.value + "? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of the right of " + node.value + ": ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, " ");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        // Print the current node
        System.out.println(indent + node.value);
        // Recursively display children with indentation
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        // 1. Process Right child first (appears at the top)
        prettyDisplay(node.right, level + 1);

        // 2. Print current node with indentation
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t"); // Print vertical bars for levels
            }
            System.out.println("|-------" + node.value);
        } else {
            System.out.println(node.value); // Root node
        }

        // 3. Process Left child (appears at the bottom)
        prettyDisplay(node.left, level + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bn = new BinaryTree();
        bn.populate(scanner);
        System.out.println("\nTree Structure:");
        bn.display();
    }
}