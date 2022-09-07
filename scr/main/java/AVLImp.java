package scr.main.java;

public class AVLImp<T extends Comparable<T>> {


    public boolean isEmpty() {
        return root == null;
    }

    private Node<T> root;

    public Tree<T> insert (T data){
       root = insert(data, root);
       return (Tree<T>) this;
    }

    private Node<T> insert(T data, Node<T> node){
        if (node ==null){
            return new Node<>(data);
        }
        if (data.compareTo(node.getData())<0){
            node.setLeft(insert(data, node.getRight()));
        }
        else if (data.compareTo(node.getData())>0){
            node.setRight(insert(data, node.getLeft()));
        }
        else {
            return node;
        }

        updateHeight(node);
        return null;
    }

    private Node<T> rotLeft(Node<T> node){
        Node<T> rightNode = node.getRight();
        Node<T> centerNode = rightNode.getLeft();
            rightNode.setLeft(node);
            node.setRight(centerNode);
                updateHeight(node);
                updateHeight(rightNode);
                    return rightNode;
    }

    private Node<T> rotRight(Node<T> node){
        Node<T> leftNode = node.getLeft();
        Node<T> centerNode = leftNode.getRight();
            leftNode.setRight(node);
            node.setLeft(centerNode);
                updateHeight(node);
                updateHeight(leftNode);
                    return leftNode;
    }

    private int height(Node<T> node){
        return node.getHeight();
    }

    private void updateHeight(Node<T> node) {

        int max = Math.max(
                height(node.getLeft()),
                height(node.getRight())
        );
        node.setHeight(max+1);
    }
}
