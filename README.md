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


# Terminology

- Beans   

   **The Instances that Spring manages are called Beans** Beans are the different objects that are managed by the Spring Framework

- Autowiring 

    The process where spring identifies the dependencies, identifies the matches for those identities, and populates them
```
@Component
public class ComplexBusinessService{
  SortAlgorithm sortAlgorithm;
  
@Component
public class BubbleSortAlgorithm implements SortAlgorithm{
```
- Dependancy Injection 

    We are injecting the sortAlgorithm as a dependancy in the ComplexBusinessService bean
    
- Inversion of control

    Who creates the SortAlgorithm? **The class that needs the dependency**. We are taking the control that the class has to the spring framework
- IOC Container
- Application context

    most important IOC Container. The place where **all** the beans are created and managed. All the core logic of the Spring Framework happens here

### Important questions when setting up Spring
- What are the beans that spring needs to manage?

   We do this by writing **@Component** to specify it as a bean
   
- What are the dependencies for a bean?

   We do this by writing **@Autowired** on the dependencies of the bean
   
- Where to search for beans

   We need a component scan in the package where the beans and dependancies are
   
   
   
```
ApplicationContext applicationContext = SpringApplication.run(SpringbasicsApplication.class, args);
		
//Because we use beans we don't need this anymore
//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
//We get the bean from the application context
BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
// then invoke the method from the bean
int result = binarySearch.binarySearch(new int[] {1, 2,3,4,5}, 2);
System.out.println(result);
```

## Understanding what happens in the background [Console]

#### Here we see the **component scan** (searches for classes with @Component)

   It identifies the bean classes
   
```
Identified candidate component class: file [C:\Users\JeanPascal\git\Spring-and-springboot\Springbasics\target\classes\com\spring\BinarySearchImpl.class]
Identified candidate component class: file [C:\Users\JeanPascal\git\Spring-and-springboot\Springbasics\target\classes\com\spring\BubbleSortAlgorithm.class]
```

#### Here we see the beans being added to the application context

```
Creating shared instance of singleton bean 'springbasicsApplication'
Creating shared instance of singleton bean 'binarySearchImpl'
Creating shared instance of singleton bean 'bubbleSortAlgorithm'
```

#### Here we see **autowiring** happening via the **constructor**
   
- Spring uses this constructor to do the autowiring
   
```
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
	
Autowiring by type from bean name 'binarySearchImpl' via constructor to bean named 'bubbleSortAlgorithm'
```
- Seems like beans are written with lowercase first letter. Which means binarySearchImpl = instance of BinarySearchImpl


#### Dynamic autowiring

- What if BinarySearchImpl has two sort algorithms with @Component?
   
   The application fails to start
   
```
org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.spring.SortAlgorithm' available: expected single matching bean but found 2: bubbleSortAlgorithm,quickSortAlgorithm

Parameter 0 of constructor in com.spring.BinarySearchImpl required a single bean, but 2 were found:
	- bubbleSortAlgorithm: defined in file [C:\Users\JeanPascal\git\Spring-and-springboot\Springbasics\target\classes\com\spring\BubbleSortAlgorithm.class]
	- quickSortAlgorithm: defined in file [C:\Users\JeanPascal\git\Spring-and-springboot\Springbasics\target\classes\com\spring\QuickSortAlgorithm.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

```

#### Solution
- Adding the @Primary annotation to the algorithm i want to use (giving more importance to one of the components)

## Constructor and setter injection

   