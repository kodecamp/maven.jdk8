package com.kodecamp.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

/**
 * This class demonstrates the use of various collectors.
 */
public class CollectorTest {

  public static void main(String args[]) {
    System.out.println("Begin : Main");
    List<Person> people = createPeople();
    /* allPersonNamesOfAge(people, 30); */
    /* partitionPeople(people, 30); */
    personNamesGroupedBycity(people);
  }

  private static void allPersonNamesOfAge(List<Person> people, int filterAge) {
    List<String> peopleOfAge30 = people.stream()
        .filter(p -> p.age == filterAge)
        .map(p -> p.name)
        .collect(toList());
    System.out.println(peopleOfAge30);
  }

  private static void partitionPeople(List<Person> people, int filterAge) {
    Map<Boolean, List<Person>> map = people.stream()
        .collect(partitioningBy(p -> p.age == 30));
    System.out.println(map);
  }

  private static void personGroupedBycity(List<Person> people) {
    Map<String, List<Person>> map = people.stream()
        .collect(groupingBy(Person::city));
    System.out.println(map);
  }

  private static void personNamesGroupedBycity(List<Person> people) {
    Map<String, List<String>> map = people.stream()
        .collect(groupingBy(Person::city, mapping(p -> p.name, toList())));
    System.out.println(map);
  }

  /**
   * Main method
   *
   * @return
   */
  private static List<Person> createPeople() {
    List<Person> people = new ArrayList<>();
    people.add(new Person("Chetan", "Chennai", 32));
    people.add(new Person("Chinmay Dd", "Chennai", 30));
    people.add(new Person("Dinesh D", "Delhi", 32));
    people.add(new Person("Durga P", "Delhi", 30));
    people.add(new Person("Lucky", "Lucknow", 32));
    people.add(new Person("Lakhan", "Lucknow", 30));
    return people;
  }

  private static class Person {
    private String name;
    private String city;
    private int age;

    Person(String name, String city, int age) {
      this.name = name;
      this.city = city;
      this.age = age;
    }

    @Override
    public String toString() {
      return String.format("[ Name = %s, city = %s, Age = %d ]", this.name,
          this.city, this.age);
    }

    public String city() {
      return this.city;
    }
  }
}
