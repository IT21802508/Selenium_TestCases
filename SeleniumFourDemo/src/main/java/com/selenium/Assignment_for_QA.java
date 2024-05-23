package com.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Assesment {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		
		  WebDriver driver = new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.get("https://cog-stg.incubatelabs.com");
		
		  try {
			  
			  clickSignUpButton(driver);
			  
	            clickSignUpWithEmailButton(driver);
	            fillSignUpForm(driver, "Amal", "Fernando", "amal1@example.com", "0760045777", "newPassword123!");
	            validateEmailFormat(driver);
	            validatePhoneNumberFormat(driver);
	            validatePasswordStrength(driver);
	            submitButton(driver);
	           
	            
	           
	            
	        } catch (Exception e) {
	        	
	        	System.err.println("Error during test execution: " + e.getMessage());
	            
	        }
		  finally {
	            quitBrowser(driver);
	        }
	    }
	
	  private static void clickSignUpButton(WebDriver driver) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 WebElement signUpButton = driver.findElement(By.xpath("/html/body/dynamicheader/header/div[2]/div[2]/ul/li[3]/a\r\n"+ ""));
	      signUpButton.click();
	    }
	  
	  private static void clickSignUpWithEmailButton(WebDriver driver) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
		  WebElement signUpWithEmailButton = driver.findElement(By.xpath("\r\n"
		      		+ "//*[@id=\"continue_with_email_signup\"]\r\n"
		      		+ ""));
		      signUpWithEmailButton.click();
	    }
	  
	  private static void fillSignUpForm(WebDriver driver, String firstName, String lastName, String email, String phoneNumber, String password) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
	        WebElement firstNameInput = driver.findElement(By.id("fname"));
	        firstNameInput.sendKeys(firstName);

	        WebElement lastNameInput = driver.findElement(By.id("lanme"));
	        lastNameInput.sendKeys(lastName);

	        WebElement emailInput = driver.findElement(By.id("email"));
	        emailInput.sendKeys(email);

	        WebElement phoneNumberInput = driver.findElement(By.id("mobileNum"));
	        phoneNumberInput.sendKeys(phoneNumber);

	        WebElement passwordInput = driver.findElement(By.id("pw"));
	        passwordInput.sendKeys(password);
	    }
	  
	  private static void validateEmailFormat(WebDriver driver) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
	        WebElement emailInput = driver.findElement(By.id("email"));
	        String email = emailInput.getAttribute("value");
	        boolean isEmailValid = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

	        if (!isEmailValid) {
	            System.out.println("Email is not in the correct format.");
	        } else {
	            System.out.println("Email is in the correct format.");
	        }
	    }
	  
	  private static void validatePhoneNumberFormat(WebDriver driver) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
	        WebElement phoneNumberInput = driver.findElement(By.id("mobileNum"));
	        String phoneNumber = phoneNumberInput.getAttribute("value");
	        boolean isPhoneNumberValid = phoneNumber.matches("\\d{10}");

	        if (!isPhoneNumberValid) {
	            System.out.println("Phone number is not in the correct format.");
	        } else {
	            System.out.println("Phone number is in the correct format.");
	        }
	    }

	  
	  private static void validatePasswordStrength(WebDriver driver) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
	        WebElement passwordInput = driver.findElement(By.id("pw"));
	        String password = passwordInput.getAttribute("value");
	        boolean isPasswordStrong = password.length() >= 8 && password.matches(".*[!@#$%^&*()].*");

	        if (!isPasswordStrong) {
	            System.out.println("Password does not meet the required criteria (minimum 8 characters, including a special character).");
	        } else {
	            System.out.println("Password meets the minimum strength criteria.");
	        }
	    }
	  
	  private static void submitButton(WebDriver driver) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
		  WebElement loginButton = driver.findElement(By.id("submit"));
	      loginButton.click();
          
		    }
		  
	  private static void quitBrowser(WebDriver driver) {
		    if (driver != null) {
		        driver.quit();
		    }
		}

	  
	  
	  

	
	
	
		
		
		
		
		

	}


