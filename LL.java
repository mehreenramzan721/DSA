
public class LL {

    Node head;
    int size;
    LL(){
        this.size=0;
    }
    //add
    public void addFirst(String data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;

    }

    //add last
    public void addLast(String data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next= newNode;
    }

    //delete
    //deletefirst
    public void deleteFirst(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        head=head.next;
    }
    //delete last
    public void deleteLast(){
        if( head==null)
        {
            System.out.println("List is empty");
            return;
        }
        size--;
        Node current=head;
        while(current.next.next!=null){
            current=current.next;
        }
        current.next=null;
    }
    //display
    public void printList(){
        if(head==null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode=head;
        while(currentNode!= null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.print("NUll");
        System.out.println();
    }
    public int getsize(){
        return size;
    }


    //to reverse a linked list
    public void reverseIterate(){
        if(head==null){
            return;
        }
        Node temp=head.next;
        if(temp==null){
            return;
        }
        Node prevNode=head;
        Node currNode=head.next;
        while(currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;

            //update
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
        System.out.println();
    }
    //second method to reverse linked list:
    public Node reverseRecursive(Node temp){
        if(temp==null || temp.next==null){
            return temp;
        }
        Node newTemp=reverseRecursive(temp.next);
        temp.next.next=temp;
        temp.next=null;
        return newTemp;

    }
    public static void main(String[] args) {
        LL list=new LL();
        list.addFirst("s");
        list.addFirst("45");
        list.addFirst("45");
        list.addLast("Hello World");
        list.addFirst("60");
        list.addFirst("Bye");
        list.addLast("Err");
        list.printList();
        System.out.println("Normal list");
        list.reverseIterate();
        list.printList();
        System.out.println("Reverse list");
        list.head=list.reverseRecursive(list.head);
        list.printList();
        System.out.println(list.getsize());
        list.deleteFirst();
        //bye should be deleted
        list.printList();
        list.deleteLast();
        list.printList();
        list.reverseIterate();
        System.out.println(list.getsize());

    }

    public static class Node {
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
}