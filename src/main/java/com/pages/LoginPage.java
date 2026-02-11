package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By username = By.xpath("//*[@name='username']");
	private By password = By.xpath("//*[@name='password']");
	private By submit = By.xpath("//*[@type='submit']");
//	private By login = By.xpath("//*[@type='submit']");
	private By dashboardValidation = By.xpath("//h6[text()='Dashboard']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName(String un) {
		driver.findElement(username).sendKeys(un);
	}
	
	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public String getTitleAfterLogin() {
		return driver.findElement(dashboardValidation).getText();
	}
	
	
}
