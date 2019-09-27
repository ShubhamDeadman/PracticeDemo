package testmeapp.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CompleteReport {
	
	

	 WebDriver driver = null;
	 WebDriverWait wait;
	ExtentReports extent;
	 ExtentTest logger;
	 Select sel;
	 Actions act = null;

	@BeforeTest
	public void startReportBeforeTest() {
			driver=Drivers.getDriver("chrome");
			driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
			driver.manage().window().maximize();
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Reports.html", true);
		extent.addSystemInfo("Host Name", "TestMe");
		extent.addSystemInfo("Environment", "Selenium Testing");
		extent.addSystemInfo("User Name", "Shubham Sharma");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		logger=extent.startTest("test registration");
		
		Assert.assertEquals(driver.getTitle(), "Home");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("SignUp")).click();
		//Assert.assertEquals(driver.getTitle(), "SignUp");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("shubham");
		driver.findElement(By.name("firstName")).sendKeys("Susane");
		//WebDriverWait wait1 = new WebDriverWait(driver,20);
		//boolean flag1 = wait1.until(ExpectedConditions.textToBe(By.id("err"),"Available"));
		//System.out.println(flag1);
		//Assert.assertTrue(flag1);
		//String flag2 = driver.findElement(By.id("err")).getText();
		//Assert.assertEquals(flag2, "Available");
		//logger.log(Status.INFO, MarkupHelper.createLabel("ID is Available", ExtentColor.GREEN));
		driver.findElement(By.name("lastName")).sendKeys("shaha");
		driver.findElement(By.name("password")).sendKeys("manu123");
		driver.findElement(By.name("confirmPassword")).sendKeys("manu123");
		driver.findElement(By.xpath("//input[@type='radio'and @value='Male']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("smsharma0708@gmail.com");
		driver.findElement(By.name("mobileNumber")).sendKeys("8377069673");
		driver.findElement(By.name("dob")).sendKeys("08/07/1995");
		driver.findElement(By.name("address")).sendKeys("h.no.202,ak dev road, guwahati, assam");
		WebElement search = driver.findElement(By.id("securityQuestion"));
		Select se = new Select(search);
		se.selectByVisibleText("What is your favour color?");
		driver.findElement(By.id("answer")).sendKeys("Blue");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.name("Submit")).click();
		driver.navigate().refresh();
		//System.out.println("Title is"+driver.getTitle());
		//String flag3 = driver.findElement(By.xpath("//div[@id='errormsg']/following-sibling: :div[3]")).getText();
		//Assert.assertEquals(flag3, "User registered Successfully!!! Please login");
//		Assert.assertEquals(driver.getTitle(), "Home");
//		logger.log(Status.INFO, MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
		
	}
	
	@Test(priority=2)
	public void testLogin() throws InterruptedException
	{
    		logger=extent.startTest("Login test");
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.findElement(By.linkText("SignIn")).click();
//		driver.findElement(By.name("userName")).sendKeys("lalitha");
//		Thread.sleep(3000);
//		driver.findElement(By.id("password")).sendKeys("Password123");
//		Thread.sleep(3000);
//		driver.findElement(By.name("Login")).click();
//		Assert.assertEquals(driver.getTitle(), "Home");
//		logger.log(Status.INFO, MarkupHelper.createLabel("Login is done", ExtentColor.BLUE));
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Assert.assertEquals(driver.getTitle(), "Home");
		
	}
	
	@Test(priority=3, dependsOnMethods="testLogin")
	public void testCart() throws InterruptedException
	{
		String len = null;
		int Value = -1;
//		logger=extent.createTest("test cart");
				//driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
				Actions act = new Actions(driver);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				act.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				act.moveToElement(driver.findElement(By.linkText("Electronics"))).click().build().perform();
				act.moveToElement(driver.findElement(By.linkText("Head Phone"))).click().build().perform();
				Assert.assertEquals(driver.getTitle(), "Search");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Add to cart")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.partialLinkText("Cart")).click();
     			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				for(int i=0; i<len.length();i++)
//				{
//					if(len.charAt(i)=='1')
//					{
//						Value = Character.getNumericValue(len.charAt(i));
//					}
//				}
//				if(Value>0)
//					Assert.assertEquals("Passed", "Passed");
//				else
//					Assert.assertEquals("Passed", "Failed");
	}
	
	
	@Test(priority=4)
	public void testPayment() throws InterruptedException
	{
//    	logger = extent.createTest("Payment Test");
//    	driver.findElement(By.partialLinkText("Checkout")).click();
		driver.findElement(By.partialLinkText("Checkout")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> r=driver.findElements(By.name("radio1"));
		System.out.println(r.size());
		driver.findElement(By.xpath("//label[contains(text(),'HDFC Bank')]")).click();
		driver.findElement(By.id("btn")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("123457");
		driver.findElement(By.name("password")).sendKeys("Pass@457");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@457");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("SignOut")).click();
		
	}
	
	@Test
	public void passTest() {
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}

	@Test
	public void failTest() {
		logger = extent.startTest("failTest");
		driver = Drivers.getDriver("firefox");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		String title = driver.getTitle();
		Assert.assertEquals(title, "NoTitle");
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}

	@Test
	public void skipTest() {
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = CompleteReport.getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		extent.close();
		driver.close();
	}

}
