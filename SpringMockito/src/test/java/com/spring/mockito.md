
## Mockito

- we created a complete class for the mock of DataService
```java
package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessTest {
	
	@Test
	public void findTheGreatestFromAllData() {
		SomeBusinessImpl bus= new SomeBusinessImpl(new DataServiceStub());
		int result = bus.findTheGreatestFromAllData();
		assertEquals(3,result);
	}
}

class DataServiceStub implements DataService{
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {3,1,2};
	}
}
```

- We want to test the code above, and to do this we need to create a stub
	- the problem with stubs is that they take a lot of effort to maintain
	- everytime i add a method to DataService, the stub needs to change too.
	
	
### Mocking with mockito

- **mock()** method
	- it is used to mock an interface or class

```java
DataService dataServiceMock = mock(DataService.class);
```

- **when()** method
	- when is used to set an output for a method of the mocked class
```java
when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{3});
```
- this way we can easily change what the method returns in different tests
- we use the contructor to pass the mock

```java
SomeBusinessimpl bussinessImpl = new SomeBusinessImpl(dataServiceMock);
```

### Mockito Annotations
- In order to use mochito annotations, a **runner** is needed.
```java
@RunWith(MockitoJUnitRunner.class)
```

- Annotations:
	- **@Mock**
		- used to mock a class or interface outside of the method
		- ex: 
		```
		@Mock 
		DataService dataServiceMock;
		```
	- **@InjectMocks**
		- automatically injects using constructor of the Mocked classes.
- full code example:
		
```java
package com.spring;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@Mock
	DataService dataServiceMock;
	//dataServiceMock is injected in businessImpl using the constructor.
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Test
	public void findTheGreatestFromAllData() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,14,2});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24,result);
	}
}
```

	
