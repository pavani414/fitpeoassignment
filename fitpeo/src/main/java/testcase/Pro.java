package testcase;



import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Pro {

	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// first point
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// second point
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
		Thread.sleep(2000);
		// third point
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);		
        //fourth
		WebElement slider =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]"));
		 Actions action = new Actions(driver);
	       action.clickAndHold(slider).moveByOffset(94, 0).build().perform();
			Thread.sleep(2000);
        // fifth point
		   WebElement text=driver.findElement(By.xpath("//input[@type='number']"));
			//text.clear();
	        Thread.sleep(2000);
	        js.executeScript("arguments[0].value='560';",text );
	        Thread.sleep(2000);
	        //sixth point 
	        String setvalue = text.getAttribute("value");
	        System.out.println(setvalue);
			SoftAssert sf=new SoftAssert();
	          sf.assertEquals(setvalue, 560);
	          Thread.sleep(2000);	
        //seventh point
        js.executeScript("window.scrollBy(0,500)");
                WebElement check1 = driver.findElement(By.xpath("//p[text()='CPT-99091']/parent::div/label/span/input"));
                check1.click();
                Thread.sleep(2000);
                WebElement check2 = driver.findElement(By.xpath("//p[text()='CPT-99453']/parent::div/label/span/input"));
                check2.click();
                Thread.sleep(2000);
                WebElement check3 = driver.findElement(By.xpath("//p[text()='CPT-99454']/parent::div/label/span/input"));
                check3.click();
                Thread.sleep(2000);
                WebElement check4 = driver.findElement(By.xpath("//p[text()='CPT-99474']/parent::div/label/span/input"));
                check4.click();
                Thread.sleep(2000);
                //eight
                WebElement total = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']/p"));
                String totalvalue = total.getText();
                System.out.println(totalvalue);
                sf.assertEquals(totalvalue, "$111105");	
                 
      Thread.sleep(2000);
		driver.quit();
		
	}

}
