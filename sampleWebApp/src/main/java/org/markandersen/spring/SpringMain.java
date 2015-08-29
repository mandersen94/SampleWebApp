package org.markandersen.spring;

import org.markandersen.bean.Statistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringMain main = new SpringMain();
		main.doStuff();

	}

	private void doStuff() {

		try {
			System.out.println("Getting application context.");
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			System.out.println("Got application context.");
			Statistics stats = (Statistics) context.getBean("stats");

			System.out.printf("stats.getCount = %d\n", stats.getCount());
			
			Thread.sleep(600 * 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
