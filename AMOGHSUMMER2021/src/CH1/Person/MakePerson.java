package CH1.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MakePerson {
    public static void main(String[] args) {
        List<Person> listOfPeople = new ArrayList<>();

        ArrayList<String> amoghHobbies = new ArrayList<>();
        amoghHobbies.add("Soccer");
        amoghHobbies.add("Coding");
        Address amoghsAddress = new Address("Carmelita", "Belmont", 94002);
        Person Amogh = new Person("Amogh", 16, "Male", 51.0, amoghHobbies, amoghsAddress);
        System.out.println(Amogh);
        Amogh.searchElement("Swimming");

        System.out.print("\n");

        ArrayList<String> atharvaHobbies = new ArrayList<>();
        atharvaHobbies.add("Basketball");
        atharvaHobbies.add("Swimming");
        Address atharvasAddress = new Address("Carmelita", "Belmont", 94002);
        Person Atharva = new Person("Atharva", 7, "Male", 32.0, atharvaHobbies, atharvasAddress);
        System.out.println(Atharva);

        listOfPeople.add(Amogh);
        listOfPeople.add(Atharva);
        for (int i = 0; i < 100; i++) {
            Person newPerson = new Person("Person " + i, i + 1, "Male", i + i, amoghHobbies, amoghsAddress);
            listOfPeople.add(newPerson);
        }


        List<Person> peopleThatHaveHobbies = getListOfPeopleWithThisHobby(listOfPeople, "Swimming");
        System.out.print("Here are the people that contain the same hobbies:\n" + peopleThatHaveHobbies);

    }
    public static List<Person> getListOfPeopleWithThisHobby(List<Person> peopleList, String hobbyName){
        List<Person> personListThatMatchesHobby = new ArrayList<>();
            for (Person person: peopleList){
                List<String> personHobbies = new ArrayList<>();
                personHobbies =  person.getHobbies();
                if (personHobbies.contains(hobbyName)){
                    personListThatMatchesHobby.add(person);
                }
            }
            return personListThatMatchesHobby;
        }
    }



