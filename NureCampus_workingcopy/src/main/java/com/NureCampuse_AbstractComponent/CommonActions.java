package com.NureCampuse_AbstractComponent;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	public WebDriver driver;
	public WebDriverWait wait;

	
	public static Logger logger = LogManager.getLogger(CommonActions.class.getName());
	public CommonActions(WebDriver driver) {
		this.driver = driver;
	}

	public void waitTillCompleteAction(String n) {

		try {
			Thread.sleep(Integer.parseInt(n));
		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
		}
	}

	public void waitTillElementVisible(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(160));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void scrollToSpecifiedElement(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		try {
			exe.executeScript("arguments[0].scrollIntoView()", element);
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
		}
	}

	
	public void  clickAddNewGroupButton() {
		driver.findElement(By.xpath("//campus-label[@key='addNewGroupButton']")).click();
	}
	
	
	public void clickAddNewCancelButton() {
		driver.findElement(By.xpath("//campus-label[@key='cancel']")).click();
		
	}
	
	public void clickCampusHierarchyDeleteButton() {
		driver.findElement(By.xpath("//campus-label[@key='campusHierarchyDeleteButton']")).click();
		
	}

	public void clickDeteleGroupYesIAmSureDeleteTheRecordButton() {
		driver.findElement(By.xpath("//button[text()='Yes, I Am Sure. Delete The Records']")).click();
	}
	
	
	public void clickDeleteGroupCancelButton() {
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
	}
	
	

	public void clickElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
	}
}
