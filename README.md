# CS5004Lab02
Repository for CS5004 Lab02 assignment submission

Name: Xuedinan(Dinan) Gao\
Semester: 2024 Spring

### My submission includes following directory/files

- Employee, Paychecks and test classes
   -  stored in src/employeesAndPaychecks package
   -  Include Driver Class
   -  Include Extension practices
     
In this program I have functions as below;

Employee --

	- constructors
	- setters for name, payRate, hours
	- getters for name, payRate, hours, ID, total employee number (Extension)
	- get weekly pay, get weekly pay(paycheck), get all paycheck (Extension)
	- payRaise, payDecrease (Extension)
	- addHours, resetHours (Extension)
	- toString

Paychecks --

	- constructors
	- load check
	- helpers for calculation totalPay, overtime
	- setters for name, payRate, hours, overtime
	- getters for name, payRate, hours, overtime, totalPay (Extension)
	- addHours (Extension)
	- toString

### My test case will be based on total pay; (In Driver Class)

1. Create test objective for each constructor
	- Employee: 2 arguments, invalid argument
	- Paychecks: 4 arguments, no argument, employee argument, invalid argument

2. Add hours
3. Check total pay
4. Increase payRate
5. Check total pay
6. Decrease payRate
7. Check total pay
8. Get weekly paycheck
9. Add overtime hours
10. Check total pay
11. Reset hours
12. Add hours < 40 and add overtime, check conflict
13. Check total employee numbers
14. Check total paychecks for this week by Array List
  
     
## Writing assignment

:star:  **ICE**
  - I followed the inClass video to build Fighter and it's test classes, below Screenshots are for Fighter, FighterTest Classes
  - ![image](https://github.com/Xuedinan/CS5004Lab02/assets/144306521/44c09641-a828-4790-a948-4974b0fc9ac4)
  - ![image](https://github.com/Xuedinan/CS5004Lab02/assets/144306521/3ddff86d-3eae-47b9-ad95-4723d84b0d6e)

  - I built test classes first for Employee and Paycheck classes
  - ![image](https://github.com/Xuedinan/CS5004Lab02/assets/144306521/6d41d9ee-fa19-47ba-8e2a-4e6fb73526da)

:star:  **Weekly report**

This week, I learned the three major topics, Override method (like toString()), how to use static variables when designing class, and what’s exception handling and the use case for it. 

For the override method, it’s more like we extend a class with certain method, and we are able to re-write the method based on our own application. For the static, it’s the scope of a variable or method that we could use it to make them be usable when calling the class by itself, not just calling it only by creating objective before. For the exception handling, it’s a smart way and option to make our program not crash, especially when there are uncertain cases we can’t 100% control, like opening a file or asking the user to input some content.

For the following extensions, I'm expecting to have more introduction videos for the concept of designing of a program. And I’d like to learn a strategic way to design classes with manipulation of using public, private, static, final, exception, etc.. Also I’m glad to have more practice along with code demo videos, that’s really helpful content for study. 

