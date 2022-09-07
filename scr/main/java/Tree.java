package scr.main.java;

public interface Tree<T extends Comparable<T>>{

    Tree<T> insert(T data);
    void cross();
    void delete (T data);
    T getMin();
    T getMax();
    boolean isEmpty();

}



