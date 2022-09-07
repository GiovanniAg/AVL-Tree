package scr.main.java;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node<T extends Comparable<T>> {

    @NonNull
    private T data;
    private int height = 0;
    private Node<T> right;
    private Node<T> left;

}
