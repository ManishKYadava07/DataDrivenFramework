package scripts;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic.Auto_constant;
import generic.GenericClass;

public class Invalid_login implements Auto_constant{

	static
	{
		System.setProperty(key, value);
	}
	public static void main(String[] args) throws InterruptedException, AWTException
	{
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		String uname=GenericClass.genericmethod(excelpath,"Sheet1",0,0);
		String pwd=GenericClass.genericmethod(excelpath,"Sheet1",3,0);
		Actions act = new Actions(driver);
		Validlogin.methodLogin(driver,uname,pwd,act);
		driver.close();
		
		
	}
}
