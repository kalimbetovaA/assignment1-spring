package kz.iitu.assihnment1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class DemoApplication {

	public static void main(String[] args){


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("kz.iitu.assihnment1.demo");
        context.refresh();
		Scanner sc= new Scanner(System.in);

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

		context.close();
	}

}
