import java.util.Scanner;
public class practice {
    public static void main(String args[]){
        Student s1=new Student();
        Student s2=new Student("Paras",20);
        s1.name="Jaiveer";
        s1.age=19;
        s1.study();
        s2.study();
        Car c=new Car(1990);
        c.setModel();
        System.out.println(c.year);
        System.out.println(c.getModel());
        // Interfaces 
        Animal a=new Dog();
        a.speak();
        a.eat();
        Engine e=new Engine();
        e.sleeping();
        e.working();
        // Static member in a class
        College col=new College();
        col.getUniversity();
        System.out.println(College.university);
    }
}
class Student{
    String name;
    int age;
    Student(){
        this.name="";
        this.age=0;
    }
    Student(String name, int age){
        this.name=name;
        this.age=age;
    }
    void study(){
        System.out.println(this.name+" is studying!");
    }
}
class Car{
    private String model;
    public int year;
    Car(int year){
        this.year=year;
    }
    String getModel(){
        return this.model;
    }
    void setModel(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter car name: ");
        this.model=sc.nextLine();
    }
}
class College{
    static String university="TIET";
    void getUniversity(){
        System.out.println(university);
    }
}
abstract class Machine{
    abstract void working();
    void sleeping(){
        System.out.println("The machine is sleeping!");
    }
}
class Engine extends Machine{
    void working(){
        System.out.println("The engine is working!");
    }
}
// Use of protected class is primarly defined in the concept of Inheritance
interface Animal{
    void speak();
    void eat();
}
class Dog implements Animal{
    public void speak(){
        System.out.println("Woof Woof");
    }
    public void eat(){
        System.out.println("Eating..");
    }
}