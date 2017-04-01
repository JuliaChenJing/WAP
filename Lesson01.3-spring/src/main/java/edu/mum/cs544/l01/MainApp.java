package edu.mum.cs544.l01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.cs544.l01.greeting.HelloPerson;
//You don't need to new object in MainApp right now
public class MainApp {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("application-context.xml")) 
		{
			HelloPerson hp = (HelloPerson) context.getBean("helloPresidentBean");
			hp.sayHello();
		}
	}
}