package com.e2e.helpers;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.e3e.log4g.LoggerHelper;
import com.github.javafaker.Faker;


public class JavaHelper {
	private static final Logger log = LoggerHelper.getLogger(JavaHelper.class);
	
	
	/**<p This method will generate random FirstName
	 * @author Shridhara
	 *
	 */
	public static String geFirstName() {
		Faker fac=new Faker();
		return fac.name().firstName();
				
	}
	
	/**<p This method will generate random LastName
	 * @author Shridhara
	 *
	 */
	public static String getLastName() {
		Faker fac=new Faker();
		return fac.name().lastName();			
	}
	
	/**<p This method will generate random FullName
	 * @author Shridhara
	 *
	 */
	public static String getFullName() {
		Faker fac=new Faker();
		return fac.name().fullName();
				
	}
	
	/**<p This method will generate random Username
	 * @author Shridhara
	 *
	 */
	public static String getUserName() {
		Faker fac=new Faker();
		return fac.name().username();		
	}
	
	/**<p This method will generate random FullAddress
	 * @author Shridhara
	 *
	 */
	public static String getAddress() {
		Faker fac=new Faker();
		return fac.address().fullAddress();
	}
	
	/**<p This method will generate random Age
	 * @author Shridhara MJ
	 *
	 */
		public static Integer getAge() {
		Faker fac=new Faker();
		return fac.random().nextInt(18, 70);
	}
	
		
	
	@Test(invocationCount = 10)
	public void testFaker() {
		System.out.println("DOB:   :   "+LocalDate.of(1950+(int)(Math.random()*(2000-1950)), Month.SEPTEMBER, (int)(1+Math.random()*(30-1))));	}
	
}
