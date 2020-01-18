import java.util.Scanner;

public class CircularQuere {
    private static Scanner scan = new Scanner(System.in);
    private static final int MAX = 5;
    private static int[] cirQueue = new int[MAX];
    private static int FRONT , REAR ;
    static {
        FRONT = -1;
        REAR = -1;
        System.out.println("CIRCULAR QUEUE IMPLEMENTATION");
    }
    public static void main(String[] args){
        int choice;
        boolean flag = true;
        while(flag){
            System.out.println("\nOPTION AVAILABLE");
            System.out.println("1 : INSERT ");
            System.out.println("2 : READ");
            System.out.println("3 : DELETE");
            System.out.println("4 : EXIT");
            System.out.print("\nENTER OPTION : ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    insertElement();
                    break;
                case 2:
                    readQueue();
                    break;
                case 3:
                    deleteElement();
                    break;
                case 4:
                    System.out.println("** END OF CIRCULAR QUEUE **");
                    flag = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
    private static void insertElement(){
        if((REAR == (MAX-1) && FRONT==0) || FRONT == (REAR+1) ){
            System.out.println("\nOVER FLOW");
        }else if(REAR==(MAX-1)){
            REAR = 0;
            System.out.print("\nENTER THE ELEMENT : ");
            cirQueue[REAR] = scan.nextInt();
           // REAR+=1;
        }else if(REAR == -1){
                REAR+=1;
                FRONT+=1;
                System.out.print("\nENTER THE ELEMENT : ");
                cirQueue[REAR] = scan.nextInt();

        }else{
            REAR+=1;
            System.out.print("\nENTER THE ELEMENT : ");
            cirQueue[REAR] = scan.nextInt();
        }

    }

    private static void readQueue(){
        System.out.println("\n*** CIRCULAR QUEUE ***");
        if(FRONT==(REAR+1)){
            System.out.println(cirQueue[FRONT] + "\t");
            for(int i = (FRONT+1) ; i!=REAR+1 ; i++){
                if(i==MAX){
                    i = MAX - i;
                }
                System.out.println(cirQueue[i] + "\t");
            }
        }else{
            for(int i = FRONT ; i!=REAR+1 ; i++){
                if(i==MAX){
                    i = MAX - i;
                }
                System.out.println(cirQueue[i] + "\t");
            }
        }


    }
    private static void deleteElement(){
        if(FRONT==-1){
            System.out.println("UNDER FLOW");
        }else if(FRONT==REAR){
            System.out.println("\n" + cirQueue[FRONT] + " IS DELETED FROM THE CIRCULAR QUEUE");
            FRONT=-1;
            REAR=-1;
        } else {
            System.out.println("\n" + cirQueue[FRONT] + " IS DELETED FROM THE CIRCULAR QUEUE");
            if(FRONT==(MAX-1)){
                FRONT=0;
            }else{

                FRONT+=1;
            }
        }
    }
}
