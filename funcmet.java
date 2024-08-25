public class funcmet {

    public int addNumbers(int num1, int num2){
        return num1 + num2;
    }

    public void display(){
        System.out.println("This is a void method.");
    }

    public static int MultiplyNumbers(int num1, int num2){
        return num1*num2;
    }

    public static void main(String[] args){

        funcmet met = new funcmet();
        int result = met.addNumbers(10, 20);

        System.out.println("The Sum is " + result);

        int multiply = MultiplyNumbers(10, 20);

        System.out.println("The multiplication id " + multiply);

        met.display();
    }
}
