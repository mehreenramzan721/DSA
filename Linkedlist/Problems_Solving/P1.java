package Problems_Solving;


//find nth node from last and delete it
public class P1 {
    public static void main(String[] args) {
        P1 q1=new P1();
        listNode head=new listNode(10);
        head.next=new listNode(20);
        head.next.next=new listNode(67);
        head.next.next.next=new listNode(21);
        head.next.next.next.next=new listNode(33);
        printList(head);
        head=q1.removeNthFromEnd(head,3);
        printList(head);


    }

    public static void printList(listNode head) {
        listNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public listNode removeNthFromEnd(listNode head, int n) {
        listNode temp = head;
        if (temp.next == null) {
            return null;
        }
        //to calculate size
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        System.out.println(size);
        // if n is given equal to size for size-n will be head
        if(n==size){
            return head.next;
        }
        //to find nth node
        int num = size - n;
        temp = head;
        for (int i = 1; i < num; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }



public static class listNode{
    int val;
    listNode next;
    listNode(int val){
        this.val=val;
        this.next=null;
    }
    listNode(int val, listNode next){
        this.val=val;
        this.next=next;
    }
}
}
