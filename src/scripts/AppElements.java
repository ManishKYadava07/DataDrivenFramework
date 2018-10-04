package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppElements {
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	public AppElements(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void methodUnamePwd(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
	}
}
