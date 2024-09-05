public class Hello {
    // those are access modifiers

    public void display(){
        System.out.println("This is a display method");
    }

    public void shoecase(){
        System.out.println("Chill pill");
    }

    public static void method1(){
        System.out.println("This is a static method1");
    }

    public int sum(){
        int a = 5;
        int b = 4;
        int c = a + b ;
        return c;
    }

    public static void main(String args[]){
        Hello obj = new Hello();
        obj.display();
        obj.shoecase();
        int result = obj.sum();
        System.out.println("The sum of two numbers is " + result);
        System.out.println("Hello World");
    }
}
