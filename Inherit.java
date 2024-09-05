class Parent{

    public void display(){
        System.out.println("This is a parent's display method");
    }


}

class Child extends Parent {

        public void childmethod(){
            System.out.println("This is a child method");
        }

    }


public class Inherit{
    public static void main(String[] args){

        Child obj = new Child();
        obj.display();
        obj.childmethod();

    }
}