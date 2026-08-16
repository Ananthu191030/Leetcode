class LRUCache {
    private static class Node{
            int key;
            int value;
            Node prev;
            Node next;
            Node(int key,int value){
                this.key=key;
                this.value=value;
            }
    }
    private final Map<Integer,Node> cache;
    private final int capacity;
    private final Node head;
    private final Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node node=cache.get(key);
        if(node==null) return -1;
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.value=value;
            removeNode(node);
            addNode(node);
            return ;
        }
        Node newNode=new Node(key,value);
        cache.put(key,newNode);
        addNode(newNode);
        if(cache.size()>capacity){
            Node leastRecent=head.next;
            removeNode(leastRecent);
            cache.remove(leastRecent.key);
        }
    }
    private void removeNode(Node node){
        Node previous=node.prev;
        Node next=node.next;
        previous.next=next;
        next.prev=previous;
    }
    private void addNode(Node node){
        Node oldNode=tail.prev;
        oldNode.next=node;
        node.prev=oldNode;
        node.next=tail;
        tail.prev=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */