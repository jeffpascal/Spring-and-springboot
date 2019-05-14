## Testing with spring

- First we need to specify the Context of the test. We do that using @ContextConfiguration and we specify the class that has the defined context in our case that class is out Springbasicapplication class. We do that using the annotation like this:
```java
@ContextConfiguration(classes=SpringbasicsApplication.class)
```
- Secondly, we need to specify a runner for the test to initialise it as a spring application. We do that with the annotation **@RunWith(SpringRunner.class)**
```java
@RunWith(SpringRunner.class)
```

```java
//load context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringbasicsApplication.class)
public class BinarySearchTest {

	//get this bean from context
	@Autowired
	BinarySearchImpl binarySearch;
	
	@Test
	public void testBasicScenario() {
		int actualResult = binarySearch.binarySearch(new int[] {}, 4);
		assertEquals(3, actualResult);
		//call method on binarySearch
		//check if value is correct
	}
}
```