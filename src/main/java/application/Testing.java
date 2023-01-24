package application;

public class Testing{
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int calculate(){
        return a+b;
    }

    public static void main(String args[]){
        Testing testing = new Testing();
        testing.setA(2);
        testing.setB(3);
        System.out.println(testing.calculate());
    }



}
