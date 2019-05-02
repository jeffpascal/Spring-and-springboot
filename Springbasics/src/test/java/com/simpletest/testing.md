### Unit Testing with jUnit

## Different available assert methods:
```java
boolean trueCondition = true;
assertEquals(1,1);
assertTrue(trueCondition);
assertFalse(!trueCondition);
assertNull(null);
assertNotNull(trueCondition);
assertArrayEquals(new int[] {1,2}, new int[] {1,2});
```

### Important annotations
- @Before
	- runs the code in the method annotated with @Before before each test
- @After
	- runs the code in the method annotated with @After after each test
- @BeforeClass
	- method needs to be static
	- it runs the code in the method before all tests are run (even @Before)
	- ex: establishing connection to database
- @AfterClass
	- method needs to be static
	- it runs the code in the method after all tests are run (even @After)
