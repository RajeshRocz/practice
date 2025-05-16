package Java24;

public class Main {
    public static void main(String args[]){
        Object j=0;

        switch (j){
            case Integer i->System.out.println("Integer value");
            case String s->System.out.println("String value");

            default -> throw new IllegalStateException("Unexpected value: " + j);
        }
    }
}
