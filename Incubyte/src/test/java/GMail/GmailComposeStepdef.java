package GMail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailComposeStepdef {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Login to gmail
		driver.findElement(By.xpath("//input[@id ='identifierId']")).sendKeys("testautomation467@gmail.com"+"\n");
		driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("Test@123"+"\n");
		//click on compose and add the to mail id, and subject
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3' and text()='Compose']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//child::textarea[@name='to']")).sendKeys("karishma@incubyte.co");//To
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("FYI");
		//Attach file and send the mail
		driver.findElement(By.xpath("//div[@class='bAK' ]//child::div[@aria-label='Attach files']")).click();
		Runtime.getRuntime().exec( System.getProperty("user.dir")+ "\\src\\test\\resources\\FileUpload.exe");
		Thread.sleep(10000); 
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		//logout 
		driver.findElement(By.xpath("//a[@class='gb_D gb_Na gb_i']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		driver.close();
		
		
	}

}
