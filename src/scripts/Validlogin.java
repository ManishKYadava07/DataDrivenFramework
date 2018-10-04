package scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic.Auto_constant;
import generic.GenericClass;

public class Validlogin implements Auto_constant {
	static
	{
		System.setProperty(key, value);
	}
	public static void main(String[] args) throws InterruptedException, AWTException
	{
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		
		
		
		/*Test case1 Login with valid user name and then logout*/
		String uname=GenericClass.genericmethod(excelpath,"Sheet1",0,0);
		String pwd=GenericClass.genericmethod(excelpath,"Sheet1",1,0);
		methodLogin(driver,uname,pwd,act);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("crocks");
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
		WebElement ele1=driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconUser sprites-user']"));
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("(//div[.=' Logout '])[2]")).click();
		String actualtitle=driver.getTitle();
		if(actualtitle.equals("Crocs Shoes Online - Buy Crocs Flip Flops & Sandals Online in India - Myntra"))
			System.out.println("TEST CASE 1 PASSED");
		else
			System.out.println("TEST CASE 1 FAILED");
		
		//opens new tab
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		
		
		
		/*Test case2 try to login with invalid password*/
		String uname1=GenericClass.genericmethod(excelpath,"Sheet1",2,0);
		String pwd1=GenericClass.genericmethod(excelpath,"Sheet1",3,0);
		methodLogin(driver,uname1,pwd1,act);
		String actualtitle1=driver.getTitle();
		if(actualtitle1.equals("Login"))
			System.out.println("TEST CASE 2 PASSED");
		else
			System.out.println("TEST CASE 2 FAILED");
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	public static void methodLogin(WebDriver driver,String uname,String pwd,Actions act)
	{
		driver.get("https://www.myntra.com/");
		WebElement ele1=driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconUser sprites-user']"));
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("(//a[@class='desktop-linkButton'])[2]")).click();
		
		AppElements ele=new AppElements(driver);
		ele.methodUnamePwd(uname, pwd);
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(uname);
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@class='login-login-button']")).click();
		
	}
}
