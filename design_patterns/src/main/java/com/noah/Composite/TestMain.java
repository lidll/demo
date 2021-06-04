package com.noah.Composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMain
 * @Description 组合模式
 * @Author noah
 * @Date 6/1/21 8:53 PM
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {

        Node homeNode = new Node(1, "家", true);
        Node dadNode = new Node(2, "爸爸", true);
        Node momNode = new Node(3, "妈妈", true);
        Node gegeNode = new Node(4, "哥哥", false);
        Node meimeiNode = new Node(5, "妹妹", true);
        Node jojoNode = new Node(5, "jojo", true);
        Node bingioNode = new Node(6, "bingo", false);
        homeNode.addChilds(dadNode,momNode);
        dadNode.addChilds(gegeNode);
        dadNode.addChilds(jojoNode);
        momNode.addChilds(meimeiNode);
        meimeiNode.addChilds(bingioNode);

        treeView(homeNode,0);
    }

    public static void treeView(Node node,int level){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString() + node.getNodeName());
        if (node.isHasChild()) {
            level++;
            for (Node child : node.getChildNodeList()) {
                treeView(child, level);
            }

        }
    }
}



@Data
class Node{
    private int nodeId;
    private String nodeName;
    private List<Node> childNodeList = new ArrayList<>();
    private boolean hasChild;

    public Node(int nodeId,String nodeName,boolean hasChild){
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.hasChild = hasChild;
    }

    public void addChilds(Node... nodes){
        for (Node node : nodes) {
            this.childNodeList.add(node);
        }
    }
}