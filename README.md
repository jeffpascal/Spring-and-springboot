## Spring-and-springboot

Course to understand spring and spring boot. Here i will have my notes

### Dependency injection


```
public class ComplexBusinessService{
  SortAlgorithm sortAlgorithm;
```

- ComplexBusiness Class uses the sortAlgorithm. ComplexBusiness depends on sortAlgorithm

- SortAlgorithm class is a **dependency** of ComplexBusinessService because it needs to make use of it to sort something

- What are all the things it needs to perform the functionality

- Before (without Spring) we would need to instatiate SortAlgorithm to create a dependancy. This is called **Tight-coupling** which is not considered good.

- **Loose coupling** is considered good. We do this by removing the instantiation and creating a constructor


```
public class ComplexBusinessService{
  SortAlgorithm sortAlgorithm; // = new BubbleSortAlgorithm(); //tight coupling
  
  public ComplexBusnessService(SortAlgorithm sortAlgorithm){
    this.sortAlgorithm = sortAlgorithm;
    } //example of loose coupling
    
    
SortAlgorighm = new BubbleSortAlgorithm();
ComplexBusinessService businessService = new ComplexBusinessService(sortAlgorithm);
// example of loosely coupled code
```
- In the example above, ComplexBusinessService is not dependant on a specific sorting algorithm

- What spring does is **create** objects and **populates dependancies** however it is my job as a programmer to tell Srping which are the dependencies it needs.

- How does spring do this? I need to tell it which are the objects it needs to manage and which dependancies the class needs

- **@Component** tells spring it needs to manage instances of ComplexBusinessService and BubbleSortAlgorithm

```
@Component
public class ComplexBusinessService{
  SortAlgorithm sortAlgorithm;
  
@Component
public class BubbleSortAlgorithm implements SortAlgorithm{
```

- Now spring knows it needs to manage those 2 classes
- How to tell Spring that SortAlgorithm is a dependancy? using **@Autowired**

```
@Component
public class ComplexBusinessService{
  @Autowired
  SortAlgorithm sortAlgorithm;
```

- Internally, spring would instantiate SortAlgorithm and pass it to ComplexBusinessServic


### Terminology

- Beans   
---**The Instances that Spring manages are called Beans** Beans are the different objects that are managed by the Spring Framework
- Autowiring 
---The process where spring identifies the dependencies, identifies the matches for those identities, and populates them
```
@Component
public class ComplexBusinessService{
  SortAlgorithm sortAlgorithm;
  
@Component
public class BubbleSortAlgorithm implements SortAlgorithm{
```
- Dependancy Injection 
--- We are injecting the sortAlgorithm as a dependancy in the ComplexBusinessService bean
- Inversion of control
--- Who creates the SortAlgorithm? **The class that needs the dependency**. We are taking the control that the class has to the spring framework
- IOC Container
- Application context
--- most important IOC Container. The place where **all** the beans are created and managed. All the core logic of the Spring Framework happens here
