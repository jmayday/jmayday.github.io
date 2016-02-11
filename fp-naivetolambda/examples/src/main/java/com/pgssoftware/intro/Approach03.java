/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.intro;



import java.util.List;

/**
 *
 * @author kuba
 */
public class Approach03 {
      
   
    // Approach 3: Specify Search Criteria Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression

    public static void printPersons(
        List<Person> roster, RosterTest.CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    public static void main(String... args) {
        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }

        // Approach 3: Specify Search Criteria Code in a Local Class

        System.out.println("Persons who are eligible for Selective Service:");

        class CheckPersonEligibleForSelectiveService implements RosterTest.CheckPerson {
           public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
            }
        }

        printPersons(
            roster, new CheckPersonEligibleForSelectiveService());
    }
}
