## Configuring the applicationContext using xml
- xml configuration can specify the beans and their dependencies without using annotations

1. Create a **applicationContext.xml** file in /resources
2. Use the template

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

  <bean id="..." class="...">
    <!-- collaborators and configuration for this bean go here -->
  </bean>

  <bean id="..." class="...">
    <!-- collaborators and configuration for this bean go here -->
  </bean>

  <!-- more bean definitions go here -->

</beans>
```

- filled xml for current example:
	- <bean id="bean id="name of the bean **lower case begginning**" class = "qualified path of the class">
- to autowire xmlJdbcConnection to xmlPersonDao we do:
	- ``` <property name="xmlJdbcConnection" ref="xmlJdbcConnection"/>```
		- where name is the name of the dependency and ref is the bean id we declared 
	
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

  <bean id="xmlJdbcConnection" class="com.spring.xml.XmlJdbcConnection">
  </bean>

  <bean id="xmlPersonDao" class="com.spring.xml.XmlPersonDAO">
  	<property name="xmlJdbcConnection" ref="xmlJdbcConnection"/>
  </bean>


</beans>
```

### XML Context Application
- To get the application context we use : 
```
ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")
```
- where the parameter is the path of the xml file
- full code : 

```
package com.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.xml.XMLPersonDAO;

@Configuration
@ComponentScan("com.spring.scope")
public class SpringbasicsXMLContextApplication {

		public static void main(String[] args) {
		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			XMLPersonDAO personDao = applicationContext.getBean(XMLPersonDAO.class);
			System.out.println(personDao);
			System.out.println(personDao.getXMLJdbcConnection());
			
		}

	}

}

```