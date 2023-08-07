package com.db.grad.javaapi;

import com.db.grad.javaapi.controller.BookUsersController;
import com.db.grad.javaapi.controller.BooksController;
import com.db.grad.javaapi.controller.TradeController;
import com.db.grad.javaapi.controller.UserController;
import com.db.grad.javaapi.repository.BooksUsersRepository;
import com.db.grad.javaapi.service.BooksHandler;
import com.db.grad.javaapi.service.BooksUsersService;
import com.db.grad.javaapi.service.TradeHandler;
import com.db.grad.javaapi.service.UsersHandler;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SpringBootTest
class JavaApiApplicationTests {


	// credentials, test email and password work (front-end)
	// the controller is injected before the test methods are run, using paths?
	//service?
	//repositories?

	//	Common steps in front-end testing are as follows:
	//	load the page in the web browser.
	//	check that all expected elements are present.
	//	check that all links work.
	//	check that the page layout is as expected.
	//	check for broken images.
	//	test the forms to ensure they are working correctly.

	@Autowired
	BooksController booksController;
	@Autowired
	BookUsersController bookUsersController;
	@Autowired
	UserController userController;
	@Autowired
	TradeController tradesController;
	private BooksHandler booksService =
			Mockito.mock(BooksHandler.class);
	//@Mock
	//BooksHandler booksService;
	@MockBean
	BooksUsersRepository booksUsersRepository;
	@Mock
	UsersHandler usersHandler;
	@Mock
	TradeHandler tradeHandler;
	ChromeDriver  driver;
	WebElement element;

	@Before
	public void init()
	{
		booksService = Mockito.mock(BooksHandler.class);
		//booksUsersService = Mockito.mock(BooksUsersService.class);
		usersHandler = Mockito.mock(UsersHandler.class);
		tradeHandler = Mockito.mock(TradeHandler.class);
	}
	@Test
	void contextLoads() throws Exception{
		assertThat(booksController).isNotNull();
		assertThat(bookUsersController).isNotNull();
		assertThat(userController).isNotNull();
		assertThat(tradesController).isNotNull();
	}

	@Test
	void services(){

		//arrange
		List<String> expectedList =new ArrayList<String>();
		expectedList.add("trading_borading Ltd,active,Airbus 3.15%  USD,,123456780,900,30-07-21,USD,3.15,105.775");
		expectedList.add("b");
		expectedList.add("c");

		String bondholder = "Astra Trading Ltd";
		String bondholderToFind = "Astra Trading Ltd";

		List<String> actualList =new ArrayList<String>();


		//act
		//assert
		//Mockito.when(booksService.getBondsPlusMinusPosId(1)).thenReturn();
		//Mockito.when(booksUsersService.getAllBooksUserS("")).thenReturn(Collections.singletonList());
		assertEquals(expectedList.get(0),booksService.getBondsPlusMinusPosId(1));
	}


	

	//To test successful login
	@Test
	public void validUserCredentials(){
		System.out.println("This is the test code " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver = new ChromeDriver();
		driver.get("http://localhost:3000/");
		driver.findElement(By.id("email")).sendKeys("gs@ak.de"); //Sending ID
		driver.findElement(By.id("password")).sendKeys("password"); // Sending PWD
		driver.findElement(By.id("btn btn-primary")).click();
		try{
			element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
		}catch (Exception e){
		}
		assertNotNull(element); //Checking the element presence
		System.out.println("Test End " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

}
