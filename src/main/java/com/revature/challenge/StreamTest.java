package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {
	
    public static void main(String[] args) {
    	
    	/*
    	 * ============== Don't alter the code between lines 24 - 42 ==============
    	 */
 
        Student student1 = new Student(
            "Bob",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
 
        Student student2 = new Student(
            "Alice",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
 
        Student student3 = new Student(
            "Wally",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
 
        List<Student> students = Arrays.asList(student1, student2, student3);
        
    	/*
    	 *========== Don't alter the code above (lines 24 - 42) ===============
    	 */
        
        /***************************************************************************
         (1) Get the student with the name "Bob" and print his name to the console.
         	 If "Bob" does not exist, print "No student found".
        ****************************************************************************/
        System.out.println("========= Problem 1 ==========");
        
        // Code your Solution here

        try {
        	Student bob = students.stream().filter((stu) -> stu.getName()=="Bob").collect(Collectors.toList()).get(0);
        	System.out.println(bob.getName());
        } catch(IndexOutOfBoundsException e) {
        	System.out.println("No student found");
        }

        
        System.out.println("");
        /***************************************************************************
         (2) Get the student with matching address "1235" and print their name to the console.
             If the address does not exist, print "No student found".
             HINT: Save students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/
        System.out.println("========= Problem 2 ==========");
        
        // Code your Solution here
//        students.stream().forEach((stu) -> System.out.println(stu.getAddress().getZipcode()=="1235"));
        Optional<Student> addressSearch = students.stream().filter((stu) -> stu.getAddress().getZipcode()=="1235").findFirst();

        try {
			System.out.println(addressSearch.get().getName());
		} catch (NoSuchElementException e) {
			System.out.println("No student found");
		}
        
        
        System.out.println("");
        /****************************************************************************
         (3) Get all the students that have the mobile number "3333" and print their
             names to the console.
        *****************************************************************************/
        System.out.println("========= Problem 3 ==========");
        
        // Code your Solution here
        List<Student> students3333 = students.stream()
        											.filter((stu) -> stu.getMobileNumbers().stream()
        													.filter((num) -> num.getNumber()=="3333")
        													.collect(Collectors.toList()).size()==1)
        											.collect(Collectors.toList());
        
        if(students3333.size()==0) {
        	System.out.println("No students with that number");
        }
        else {
        	for(Student student : students3333) {
        		System.out.println(student.getName());
        	}
        }
        
        
        
        System.out.println("");
        /***************************************************************************
         (4) Get all student having mobile number "1233" and "1234" and print their
             names to the console.
         ***************************************************************************/
        System.out.println("========= Problem 4 ==========");
        
        // Code your Solution here
        List<Student> students1233and1234 = students.stream()
													.filter((stu) -> stu.getMobileNumbers().stream()
															.filter((num) -> num.getNumber()=="1233" || num.getNumber()=="1234")
															.collect(Collectors.toList()).size()==2)
													.collect(Collectors.toList());
        
        for(Student student : students1233and1234) {
        	System.out.println(student.getName());
        }

        
        
        System.out.println("");
        /***************************************************************************
	     (5) Create a List<Student> from the List<TempStudent>. Call it studentList.
	         Hint: Use Collectors.toList(). Print it to the console. 
	         Resource: https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
        ****************************************************************************/
        System.out.println("========= Problem 5 ==========");
        TempStudent tmpStud1 = new TempStudent(
            "Bob1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
 
        TempStudent tmpStud2 = new TempStudent(
            "Alice1",
            202,
            new Address("12351"),
            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
 
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        
        // Code your Solution here, don't touch the code above
        List<Student> studentList = tmpStudents.stream()
        							.map((tstu) -> new Student(
        						            tstu.name,
        						            tstu.age,
        						            tstu.address,
        						            tstu.mobileNumbers) )
        							.collect(Collectors.toList());
 
        studentList.stream().forEach(System.out::println);
        
        
        
        System.out.println("");
        /***************************************************************************
         (6) Convert the List<Student> called studentList that you made in question (5) to 
             List<String> of just their names. Call this new list "studentNames". 
             Print it to the console.
        ****************************************************************************/
        System.out.println("========= Problem 6 ==========");
        
        // Code your Solution here
        List<String> studentNames = studentList.stream().map((stu) -> stu.getName()).collect(Collectors.toList());
        
        studentNames.forEach(System.out::println);
        
        
        
        System.out.println("");
        /***************************************************************************
          (7) Convert List<Students> to a single String called name with just their names.
          	  Print that String to the console.
        ****************************************************************************/
        System.out.println("========= Problem 7 ==========");
        
        // Code your Solution here
        
        StringBuilder name = new StringBuilder();
        students.forEach((stu) -> name.append(stu.getName()+" | "));  
        
        System.out.println(name);        
        
        System.out.println("");
        /****************************************************************************
         (8) Change all the Strings within the List<String> nameList to Upper Case.
             Print it to the screen.
        *****************************************************************************/
        System.out.println("========= Problem 8 ==========");
        List<String> nameList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Code your Solution here, don't touch the code above
        nameList = nameList.stream().map((n) -> n.toUpperCase()).collect(Collectors.toList());
        nameList.forEach(System.out::println);
        
        
        System.out.println("");
        /****************************************************************************
         (9) Sort List<String> namesList by natural order.
             Hint: Research .sorted() method https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
         *****************************************************************************/
        System.out.println("========= Problem 9 ==========");
        List<String> namesList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Code your Solution here, don't touch the code above
        List<String> sortedNamesList = namesList.stream().sorted((n1,n2) -> n1.compareTo(n2)).collect(Collectors.toList());

        sortedNamesList.forEach(System.out::println);
        
 
    }
    
    
}






