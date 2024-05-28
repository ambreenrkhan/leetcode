package binaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value){
     this.value = value;
    }


    public boolean isLeafNode(){
        return left ==null && right ==null;
    }

    public String toString(){
        return value.toString();
    }

}
