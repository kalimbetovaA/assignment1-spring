package kz.iitu.assihnment1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Scanner sc= new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		ATM atm = context.getBean("atm", ATM.class);
		Account account = atm.chooseAccount();

		System.out.println("Enter pin: ");
		int pin=sc.nextInt();

		boolean access = atm.identify(account, pin);

		if(access){
			System.out.println("Hello "+account.getFullName()+"!");
			atm.showMenu(account);
		}else{
			System.out.println("Error. Wrong credentials!");;
		}
	}

}
