package cn.spark2fire.edu.datastructure.standard.tree.binary;

import cn.spark2fire.edu.datastructure.standard.search.balancetree.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉排序树, refer to https://www.cnblogs.com/yahuian/p/10813614.html
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BinarySortTree implements BST {
    private BinarySortNode root;
    private int size = 0;

    @Override
    public void insert(Integer data) {
        if (data != null) {
            BinarySortNode node = new BinarySortNode(data);
            if (root == null) {
                root = node;
            } else {
                root.addChild(node);
            }
            size++;
        }
    }

    @Override
    public Integer search(Integer value) {
        return null;
    }

    @Override
    public void traverse() {
        if (root != null) {
            root.inOrderTraversal();
        }
    }

    /**
     * 删除是难点
     *
     * @param value
     * @return
     */
    @Override
    public boolean delete(Integer value) {
        BinarySortNode current = root;
        BinarySortNode parent = root;
        boolean isLeftChild = true;

        //找到被删除的节点和父节点，并标识该节点是否为左节点, 这个很重要
        while (current.data != value) {
            parent = current;
            if (value < current.data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            //第一种情况，删除节点为子节点
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (current.left == null) {//第二中情况，删除节点只包含一个子节点，则将子节点移动动当前节点中
            //删除的节点的左为空, 右有值, 把右子节点付给parent就行
            if (current == root) {
                root = current.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else if (current.right == null) {
            //删除的节点右为空, 左有值, 把左子节点付给parent就行
            if (current == root) {
                root = current.left;
            } else {
                if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        } else {
            //第三种情况，删除节点中有左右两个节点
            //找到后继节点
            // 这时候其实要考虑4层, current, current parent, successor, successor parent
            BinarySortNode successor = handleSuccessor(current);
            if (current == root) {//删除是根节点，则
                root = successor;
            } else {
                //处理parent
                if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
            //处理child, successor一定没有左子树
            successor.left = current.left;
        }
        return true;
    }

    /**
     * 后继节点: 如果将一棵二叉树按照中序遍历的方式输出，则一个节点的下一个节点就是该节点的后继节点
     * 快速的方法, 就是从自己的右子树开始，一直往左子树找，找到没有左子树为止, 所有的successor都不会有left
     * 不只是找到后继节点, 还做了处理
     */
    private BinarySortNode handleSuccessor(BinarySortNode target) {
        //刚开始successorParent就是要被删除的节点
        BinarySortNode successorParent = target;        //绝对不为空
        BinarySortNode successor = target.right;        //绝对不为空
        BinarySortNode successorLeft = successor.left;

        while (successorLeft != null) {
            successorParent = successor;
            successor = successorLeft;
            successorLeft = successorLeft.left;
        }

        // 如果后继节点正好是要删除节点的右节点, 那么只需要把它的右子树提上来就行, 因为所有的successor都不会有left
        // 如果我们找到的后继节点不直接是 要删除节点的右节点  而是在其右节点左子树上面最小的一个节点
        if (successor != target.right) {
            //后继节点的父节点断开其与后继节点左边的引用，重新连接上后继节点的右子节点（因为后继节点是没有左子节点的，锁以要保存之前树的状态，还要把后继节点的右子节点处理一下，不管 其存在不存在）
            successorParent.left = successor.right;
            // 这时候后继节点的右边已经空了 上一条语句已经将其给了自己父节点的左子节点    然后让后继节点的右边 连接要删除节点的右子树
            successor.right = successorParent;
        }
        return successor;
    }


    public List<Integer> getSort() {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list = root.getArray(list);
        }
        return list;
    }
}
