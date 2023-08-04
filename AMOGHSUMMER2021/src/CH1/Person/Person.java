package CH1.Person;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private String gender;
    private double height;
    private ArrayList<String> hobbies;
    private Address address;

    public Person(String name, int age, String gender, double height, ArrayList<String> hobbies, Address address){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.hobbies = hobbies;
        this.address = address;
    }
    public String toString(){
        return "\nPrinting person details: \nName: " + name +
                "\nAge: "  + age +
                "\nGender: " + gender +
                "\nHeight: " + height +
                "\nHobbies: " + hobbies +
                "\nAddress: " + address + "\n";
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public Address getAddress(){
        return  this.address;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public int getAge() {
        return this.age;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setHeight(double newHeight) {
        this.height = newHeight;
    }

    public double getHeight() {
        return this.height;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void searchElement(String elementName){
        if (hobbies.contains(elementName)){
            System.out.print("This set of hobbies contains " + elementName + ".");
        }
        else{
            System.out.print(elementName + " is not located in this set of hobbies.");
        }
    }

    public void printDetails() {
        System.out.print("Printing User Details:\n" + "\tName: " + this.getName() +
                "\n\tAge: " + this.getAge() + "\n\tGender: " + this.getGender() +
                "\n\tHeight: " + this.getHeight() + "\n");

    }

}




