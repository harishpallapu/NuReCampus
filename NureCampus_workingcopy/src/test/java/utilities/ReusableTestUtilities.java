package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ReusableTestUtilities {

	public WebDriver driver;
	static WebDriverWait wait;
	 Actions act;

	public ReusableTestUtilities(WebDriver driver) {

		this.driver = driver;

	}

	public void browserrefresh() {

		driver.navigate().refresh();

	}

	public void windowsscrollfordropdwown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void backgroundsearch(WebElement ele) {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", ele);
	}
	
	public static void explicitlywait(WebDriver driver,Duration timeOut)
	{
		wait=new WebDriverWait(driver,timeOut);
	}
	
	public static void waitUntilElementVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitUntilElementClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void initializesActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	
	public void mouseOverOnTheElement(WebElement maduleBox, WebDriver driver)
	{
		act.moveToElement(maduleBox).perform();
	}
	public void assertionThroughIfCondition(String expectedResult, String actualResult, String testCaseName)
	{
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			System.out.println(testCaseName+ "created successfully");
			System.out.println("Tc pass");
		}
	}
	

}
