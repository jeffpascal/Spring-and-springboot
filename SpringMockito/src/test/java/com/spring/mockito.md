
## Mockito

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