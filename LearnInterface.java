interface Parent{

    // define signature
    public void display();

}

class Child implements Parent {
    public void display(){
        System.out.println("This is clid class");
    }

}

public class LearnInterface {
    public static void main(String[] args){

        Parent obj = new Child();
        obj.display();


    }
}
