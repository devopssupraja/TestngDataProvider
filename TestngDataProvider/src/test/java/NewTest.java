import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class NewTest {

	@Test(dataProvider = "cyclosDemo")
	@Parameters({ "username", "password" })
	public void loginToCyclone(String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.cyclos.org/#login");

		driver.findElement(By.name("principal")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath(".//div[@class=\"actionButtonText\"]")).click();

		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

	@DataProvider(name="cyclosDemo")
	public Object[][] getDataFromDataprovider() {
		Object[][] data = new Object[2][2];  // rows - col
		data[0][0] = "demo";
		data[0][1] = "1234";
		
		data[1][0] = "demo1";
		data[1][1] = "12342";
		return data;
	}
	
}


