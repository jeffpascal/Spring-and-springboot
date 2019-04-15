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

## Constructor and setter injection - means we aren't using constructors to inject the dependancies like we did above

- Works without setter and consturctor (if you create a setter or not, spring does the autowiring the same way)

- When do you use setter or constructor injection? Well, setter is most used, Constructor injection is obsolete because if we have many dependencies, the constructor declaration will be too long


## Spring projects

- **Spring Boot** most popular for microservices (dev applications quickly)
- **Spring Cloud** develop cloud-native applications. You can use Spring Cloud to move a Spring Boot microservice to the cloud
- **Spring Data** Consistent data access. 
- **Spring Integration** Solves problems with Integration. Helps us with connecting enterprise applications easily
- **Spring Batch** 
- **Spring Security** provides solutions to make applications secure
- **Sprint HATEOS** return related links for the user to know where to go next, like links to related actions

#### Why is spring popular? 
- Writing testable code easily
- No Plumbing Code (Spring makes all exceptions unchecked, so no need to handle exceptions)
- Flexible Architecture spring is very modular

### in-depth Autowiring
- Turns out, autowiring can be done by type and name :

```
	@Autowired
	private SortAlgorithm quickSortAlgorithm;
```

- This means, even though @Primary wasn't used, Spring knows i want QuickSortAlgorithm class;
- @Primary has **higher precendence** over the name of the variable(name autowiring)

- **@Qualifier**

   @Qualifier can be used in conflicts where multiple candidates are present for autowiring. It is used to select one using a name

```
@Component
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm {
	@Override
	public int[] sort(int[] numbers) {
		return numbers;
	}
}


@Autowired
@Qualifier("quick")
private SortAlgorithm quickSortAlgorithm;
```

- Usage : you use **@Primary** when you know there is a definite favourite (faster, more efficient). You use **@Qualifier** when you need different beans for different tasks.
- Autowiring by name can be used over both of those.

#### Example

```
@Component
@Qualifier("bubble")
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{
	public int[] sort(int[] numbers) {
		return numbers;
	}
}
```
- Will use the Qualifier here over name autowiring

```
@Autowired
@Qualifier("bubble")
private SortAlgorithm quickSortAlgorithm;
```
- will use bubbleSortAlgorithm because of name autowiring

```
@Autowired
private SortAlgorithm bubbleSortAlgorithm;
```

- will use bubbleSortAlgorithm because @Primary

```
@Autowired
private SortAlgorithm sortAlgorithm;
```

### Bean Scope
  ###### Default: singleton
- Singleton - One instance per Spring Context
- Prototype - New bean whenever requested
- Request - One bean per HTTP request
- Session - One bean per HTTP session

##### The following commands will both get the same bean instance because the default scope of a bean is singleton
```
BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
```

- To get different instances of beans we need to change the bean type to prototype. We do this with **Scope("prototype")**
   Now when we run the above two commands we get 2 different instances of BinarySearchImpl.
   
 ```
@Scope("prototype") // makes the bean prototype(which means every time it is created, it gives a new instance instead of the same one
@Component // tells spring this is a bean
public class BinarySearchImpl {
```

- Hardcoding @Scope("prototype") is not very good instead we can use
```
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
```

- If you have a singleton class that uses a Prototype autowired bean, the bean will have the same values because it uses the instance of the singleton to get the prototype. 
To fix this, if we want different instances of the autowired bean we use a proxy.

```
@Component
public class PersonDAO {
	
	@Autowired
	JdbcConnection jdbcConnection;
}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {
	
}
```
- Now every instance of PersonDAO will have a different instance of JdbcConnection

- If we remove the proxy, the JdbcConnection will always have the same insstance

- Even the same instances of PersonDAO will have different JdbcConnections

#### Component Scanning

- If your Application that starts spring is in another package when you try to run you get the following exception:
```
java.lang.TypeNotPresentException: Type org.springframework.jdbc.CannotGetJdbcConnectionException not present
```

To fix this we use **@ComponentScan("com.spring.componentscan")** where we specify the package we want Spring to do the **component scan**

- Turns out i'm incapabable to recreate the most basic of learnt functionality -- working on itasdasdasd
### Lifecycle of a bean @PostConstruct @PreDestroy

- you can use **@PostConstruct** to make operations on a bean before it gets created as seen below

```
postConstruct
Creating shared instance of singleton bean 'componentJdbcConnection'
Creating shared instance of singleton bean 'componentPersonDAO'
```

- you can use **@PreDestroy** to make operations on a bean before it gets destroyed (after you do all operations you wanted)

```
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
		LOGGER.info("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("PREdESTROY");
		LOGGER.info("PREdESTROY");
	}
```

### Moving from Spring Boot to plain Spring Framework

- Removed the dependency in pom.xml to just have spring and not spring boot

#### Changes made to migrate from Spring Boot to Spring

```
@Configuration
@ComponentScan
public class SpringbasicsApplication {
	
	
	//What are the beans that spring needs to manage
	//What are the dependencies for a bean?
	//Where to search for beans
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringbasicsApplication.class);
				//SpringApplication.run(SpringbasicsApplication.class, args);

```

- **@Configuration** tells Spring that this class is a configuration class
- **@ComponentScan** tells spring to do the component scan in the package we are in (can also specify another package with ())
- We need to create a new ApplicationConext with new AnnotationConfigApplicationContext(SpringbasicsApplication.class);
