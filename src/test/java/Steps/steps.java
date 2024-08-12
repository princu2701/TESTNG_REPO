package Steps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {

	WebDriver driver;

	WebElement assert1;

	@Given("User Enters the Browser and Enter Ebay Url")
	public void user_enters_the_browser_and_enter_ebay_url() {

		driver = new FirefoxDriver();

		driver.get("https://www.ebay.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

	}

	@Given("Clicks on Advanced Search and Select the Options")
	public void clicks_on_advanced_search_and_select_the_options() throws InterruptedException {

		driver.findElement(By.linkText("Advanced")).click();

		driver.findElement(By.cssSelector("[id='_nkw']")).sendKeys("shoes adidas");

		WebElement opt = driver.findElement(By.cssSelector("[aria-label='Keyword options']"));

		Select s1 = new Select(opt);

		s1.selectByValue("3");

		driver.findElement(By.cssSelector("[name='_ex_kw']")).sendKeys("adidas,S,L,M");

		driver.findElement(By.cssSelector("[aria-label='In this category']")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("[text='Collectibles']")).click();

	}

	@When("User Clicks on Using Advanced Search options button and In new page verifies the Customer Service and Comeback to the main page")
	public void user_clicks_on_using_advanced_search_options_button() {

		driver.findElement(By.cssSelector("[href='/help/buying/search-tips/advanced-search?id=4049']")).click();

		Set<String> All = driver.getWindowHandles();

		String Parent = driver.getWindowHandle();

		for (String One : All) {

			if (!One.equals(Parent)) {

				driver.switchTo().window(One);

				assert1 = driver.findElement(By.xpath("//span[.='Contact us']"));

				Assert.assertEquals(assert1, "Contact us");
			}

		}

		driver.navigate().to("https://www.ebay.com/sch/ebayadvsearch?_sofindtype=5");

	}

	@When("Select the checkboxes and Clicks on Search button")
	public void select_the_checkboxes_and_clicks_on_search_button() {

		driver.findElement(By.cssSelector("[name='LH_TitleDesc']")).click();

		driver.findElement(By.cssSelector("[name='LH_Complete']")).click();

		driver.findElement(By.xpath("(//*[@class='checkbox__control'])[3]")).click();

		driver.findElement(By.cssSelector("[aria-label='Enter minimum price range value, $']")).sendKeys("1000");

		driver.findElement(By.cssSelector("[aria-label='Enter maximum price range value, $']")).sendKeys("2000");

		driver.findElement(By.cssSelector("[value='LH_BIN']")).click();

		driver.findElement(By.xpath("(//*[@data-radio='set-input'])[3]")).click();

		driver.findElement(By.xpath("(//*[@value='LH_ItemCondition'])[3]")).click();

		driver.findElement(By.cssSelector("[name='LH_FR']")).click();

		driver.findElement(By.cssSelector("name='LH_RPA']")).click();

		driver.findElement(By.cssSelector("[name='LH_AS']")).click();

		driver.findElement(By.cssSelector("[name='LH_Savings']")).click();

		driver.findElement(By.cssSelector("[name='LH_SaleItems']")).click();

		driver.findElement(By.cssSelector("[name='LH_Time']")).click();

		driver.findElement(By.cssSelector("[aria-label='Enter minimum number of bids']")).sendKeys("100");

		driver.findElement(By.cssSelector("[aria-label='Enter maximum number of bids']")).sendKeys("100");

		driver.findElement(By.cssSelector("aria-label='Enter minimum quantity']")).sendKeys("10");

		driver.findElement(By.cssSelector("aria-label=['Enter Maximum Quantity']")).sendKeys("20");

		driver.findElement(By.cssSelector("(//*[@value='LH_PrefLoc'])[2]")).click();

		driver.findElement(By.cssSelector("[aria-label='Seller ID']")).sendKeys("Ambani");

		WebElement sorted = driver.findElement(By.cssSelector("[aria-label='Sort By']"));

		Select sortbySelect = new Select(sorted);

		sortbySelect.selectByValue("10");

		WebElement results = driver.findElement(By.cssSelector("[aria-label='View Results']"));

		Select viewSelect = new Select(results);

		viewSelect.selectByValue("1");

		WebElement rpp = driver.findElement(By.cssSelector("aria-label='Results Per Page']"));

		Select pageSelect = new Select(rpp);

		pageSelect.selectByValue("120");

		driver.findElement(By.cssSelector("(//*[@class='btn btn--primary'])[2]")).click();

	}

	@Then("No Exact matches found Page should have been Appeared")
	public void no_exact_matches_found_page_should_have_been_appeared() {

		String finalassert = driver.findElement(By.cssSelector("[class='srp-save-null-search__heading']")).getText();

		Assert.assertEquals(finalassert, "No exact matches found");

	}

	@Then("Close the Browser")
	public void close_the_browser() {

		driver.close();

	}

}
