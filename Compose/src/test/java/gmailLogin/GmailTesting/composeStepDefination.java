package gmailLogin.GmailTesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class composeStepDefination {

	public static WebDriver driver=null;
		

@Given ("open URL")
public void OpenURL() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
	driver = new ChromeDriver();
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

@Then ("Enter email-id and password")
public void enterCredentials() {
		//Login to gmail
		driver.findElement(By.xpath("//input[@id ='identifierId']")).sendKeys("testautomation467@gmail.com"+"\n");
		driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("Test@123"+"\n");
}

@Then ("click on compose button")
public void composeMail()
{
		//click on compose and add the to mail id, and subject
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3' and text()='Compose']")).click();
}
@Then("Enter To,Subject fields")
public void SenderAddress() {
		driver.findElement(By.xpath("//div[@class='wO nr l1']//child::textarea[@name='to']")).sendKeys("nehaks.1449@gmail.com");//To
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("FYI");
		
}

@And("Select Attach File Button")
	public void AttachFile() throws IOException, InterruptedException {
		//Attach file and send the mail
		driver.findElement(By.xpath("//div[@class='bAK' ]//child::div[@aria-label='Attach files']")).click();
		Runtime.getRuntime().exec( System.getProperty("user.dir")+ "\\src\\test\\resources\\FileUpload.exe");
		Thread.sleep(10000); 
		}
@Then("click on Send button")
	public void SendMail() {
		driver.findElement(By.xpath("//div[text()='Send']")).click();
}

@Then("Logout account and close browser")
		public void logoutaccount()
		{
		//logout 
		driver.findElement(By.xpath("//a[@class='gb_D gb_Na gb_i']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		driver.quit();
		}
		
		
	}




