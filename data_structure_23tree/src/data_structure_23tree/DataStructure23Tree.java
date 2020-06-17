package data_structure_23tree;
//@author - Eleanor Ezimah
public class DataStructure23Tree { 

	@SuppressWarnings("unused")
	private static class TwoThreeST<Key extends Comparable<Key>, Value> {
    private class Node {
        Node left, right;
        int size;

        Node(int size) {
            this.size = size;
        }
    }

    private class TwoNode extends Node {
        Key key;
        Value value;

        TwoNode(Key key, Value value, int size) {
            super(size);
            this.key = key;
            this.value = value;
        }
    }

    private class ThreeNode extends Node {
        Node middle;

        Key leftKey;
        Value leftValue;

        Key rightKey;
        Value rightValue;

        ThreeNode(Key leftKey, Value leftValue, Key rightKey, Value rightValue, int size) {
            super(size);

            this.leftKey = leftKey;
            this.leftValue = leftValue;
            this.rightKey = rightKey;
            this.rightValue = rightValue;
        }
    }


    private Node root;
    

    private enum NodePosition {
        LEFT, MIDDLE1, MIDDLE2, RIGHT
    }

    @SuppressWarnings("incomplete-switch")
	private int getNodePositionValue(Node parent, NodePosition nodePosition) {
        int value = 0;

        if (is2Node(parent)) {
            switch (nodePosition) {
                case LEFT: value = 0; break;
                case RIGHT: value = 1; break;
            }
        } else if (is3Node(parent)) {
            switch (nodePosition) {
                case LEFT: value = 0; break;
                case MIDDLE1: value = 1; break;
                case RIGHT: value = 2; break;
            }
        } else {
            switch (nodePosition) {
                case LEFT: value = 0; break;
                case MIDDLE1: value = 1; break;
                case MIDDLE2: value = 2; break;
                case RIGHT: value = 3; break;
            }
        }

        return value;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.size;
    }

    public boolean isEmpty() {
        return size(root) == 0;
    }

    private boolean is2Node(Node node) {
        if (node == null) {
            return false;
        }

        return node instanceof TwoThreeST.TwoNode;
    }

    private boolean is3Node(Node node) {
        if (node == null) {
            return false;
        }

        return node instanceof TwoThreeST.ThreeNode;
    }

    }

	}