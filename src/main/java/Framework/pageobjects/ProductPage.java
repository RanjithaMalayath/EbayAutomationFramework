package Framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.abstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent {

	private WebDriver driver;

	// WebElements representing elements on the product page
	@FindBy(xpath="//h1[@class='b-pageheader']/span[@class='b-pageheader__text']")
	private WebElement filterPriceMessage;

	@FindBy(xpath="(//h3[@class='s-item__title'])[1]")
	private WebElement firstProduct;

	@FindBy(xpath="//span[@data-testid='ux-textual-display']")
	private WebElement conditionTag;

	@FindBy(xpath="//span[contains(text(),'Located in')]")
	private WebElement locationTag;

	@FindBy(css=".x-price-primary span")
	private WebElement priceTag;

	@FindBy(xpath="//*[@id='mainContent']//div[1]/div/h1")
	private WebElement resultText;

	// By locator for result text
	private final By result = By.xpath("//*[@id='mainContent']//div[1]/div/h1");

	@FindBy(xpath="(//div[@class='s-item__title'])[2]")
	private WebElement firstSearchResult;

	// Create constructor to initialize the ProductPage object
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// Method to get the price filter message
	public String getPriceText()
	{
		return filterPriceMessage.getText();

	}

	// Method to get the URL with applied filters
	public String getFilterAppliedUrl()
	{
		String filterTagUrl = driver.getCurrentUrl().toLowerCase();
		return filterTagUrl;
	}


	// Method to access the first product on the page
	public void accessFirstProduct()
	{
		firstProduct.click();
	}

	// Method to get the text of the applied condition filter
	public String getConditionTagApplied()
	{
		waitForWebElementToAppear(conditionTag);
		String conditionText = conditionTag.getText();
		return conditionText;

	}

	// Method to get the price value as a double of the applied filter
	public double getPriceTagApplied()
	{
		waitForWebElementToAppear(priceTag);
		String priceText = priceTag.getText().substring(4);
		return Double.parseDouble(priceText);

	}
	// Method to get the text of the applied location filter
	public String getLocationTagApplied()
	{
		waitForWebElementToAppear(locationTag);
		String locationText = locationTag.getText();
		return locationText;

	}

	// Method to verify that the page has loaded
	public void verifyPageLoaded()
	{
		waitForElementToAppear(result);

	}

	// Method to get the text of the first search result
	public String getFirstProduct()
	{
		return firstSearchResult.getText();

	}




}

