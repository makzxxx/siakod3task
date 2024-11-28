package packageTask;

class PriorityQueueLinkedList {
    private class Node {
        int value;
        int priority;
        Node next;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node head;

    public PriorityQueueLinkedList() {
        head = null;
    }

    public void insert(int value, int priority) {
        Node newNode = new Node(value, priority);
        if (head == null || head.priority < priority) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.priority >= priority) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public int extractMax() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int maxValue = head.value;
        head = head.next;
        return maxValue;
    }
}

