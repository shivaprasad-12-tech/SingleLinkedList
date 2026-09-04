public class SingleLL {
    private Node head;
    private Node tail;
    private int size;

    void insertAtBeginning(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;

        if(tail==null){
            tail=newNode;
        }
        size++;
    }

    void inserAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            insertAtBeginning(data);
            return;
        }
        //with tail variable
//         tail.next=newNode;
//        tail=newNode;
//        size++;

        //with out tail
        Node temp;
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        size++;
    }

    void insertAtPosition(int data,int pos){
        Node newNode=new Node(data);
        if(pos<=0 || pos>size+1){
            System.out.println("position is not valid");
        }
        if(head==null){
            if(pos==1){
                insertAtBeginning(data);
            return;
            }
        }
        if(pos==1){
            newNode.next=head;
            head=newNode;
            size++;
            return;
        }
        int currentPosition=1;
        Node temp;
        temp=head;
        while(currentPosition<pos-1){
            temp=temp.next;
            currentPosition++;
        }

        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }

    void insertAfterValue(int data,int value){
        Node newNode=new Node(data);
        Node temp;
        temp=head;
        while(temp!=null && temp.data!=value){
            temp=temp.next;
        }
        if(temp!=null) {
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
            else{
                System.out.println("no such value exists");

        }
    }

    void deleteFromBeginning(){
        if(head==null){
            System.out.println("can not delete list is empty");
            return;
        }
        System.out.println("deleted node is: "+head.data);
        head=head.next;
        size--;
        if(head==null){
            tail=null;
        }
    }

    void deleteFromEnd(){
        if(head==null){
            System.out.println("can not delete because list is empty ");
            return;
        }
        if(head.next==null){
            head=head.next;
            tail=null;
            size--;
            return;
        }
        Node temp;
        temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        System.out.println("deleted node is:" +temp.next.data);
        temp.next=temp.next.next;
        size--;
    }

    void deleteFromPosition(int pos){
        if(head==null){
            System.out.println("can not delete beacause list is empty");
            return;
        }
        if(pos==1){
            deleteFromBeginning();
        }
        if(pos<=0 || pos>size){
            System.out.println("given position is not valid so can not delete any node.");
            return;
        }
        int currentPos=1;
        Node temp,preNode;
        preNode=null;
        temp=head;
        while(temp!=null){
            if(currentPos==pos){
                System.out.println("deleted node is: "+temp.data);
               preNode.next=temp.next;
               size--;
               return;
            }
            preNode=temp;
            temp=temp.next;
            currentPos++;
        }
//        System.out.println("deleted node is "+temp.next.data);
//        temp.next=temp.next.next;
//        size--;
    }

    void deleteValue(int value){
        if(head==null){
            System.out.println("can not delete because list is empty");
            return;
        }
        if(head.data==value){
            System.out.println("deleted node is:"+head.data);
            head=head.next;
            size--;
        }
        Node temp,prevNode;
        prevNode=null;
        temp=head;
        while ((temp!=null) && (temp.data!=value)){
            prevNode=temp;
            temp=temp.next;
        }
        if(temp!=null){
            System.out.println("deleted node is "+temp.data);
            prevNode.next=temp.next;
            size--;
        }
        else{
            System.out.println("mo such node exist in the lsit");
        }
    }


    void traverseLL(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }

        Node temp;
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " -->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    void findLength(){
        Node temp;
        temp=head;
        int count=0;
        while(temp!=null){
            count++;
         temp=temp.next;
        }
        System.out.println("Length of linked is "+count);

    }

    boolean searchElement(int value){
        Node temp;
        temp=head;
        while(temp!=null){
            if(temp.data==value){
                return true;
            }
            temp=temp.next;
        }
        return false;

    }



    static void main(String[] args) {
        SingleLL obj=new SingleLL();
       obj.insertAtBeginning(10);
        obj.insertAtBeginning(20);
        obj.insertAtBeginning(30);
        obj.insertAtBeginning(1);
        obj.inserAtEnd(100);
        obj.inserAtEnd(101);
        obj.inserAtEnd(134);
        obj.insertAtPosition(25,2);
        obj.traverseLL();
        obj.insertAtPosition(45,4);
        obj.insertAfterValue(189,10);
        obj.traverseLL();
//        obj.deleteFromBeginning();
//        obj.traverseLL();
        obj.deleteFromEnd();
        obj.traverseLL();
        obj.deleteFromEnd();
        obj.traverseLL();
        obj.deleteFromPosition(3);
        obj.traverseLL();
        obj.deleteValue(45);
        obj.traverseLL();
        obj.findLength();
        System.out.println(obj.searchElement(10));

    }


}
