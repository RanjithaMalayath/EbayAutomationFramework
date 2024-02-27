package Framework.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.abstractComponents.AbstractComponent;

public class FilterPage extends AbstractComponent {
	
	
	private WebDriver driver;
	
	// WebElements representing various filters on the page
	@FindBy(id="c3-mainPanel-condition")
	private WebElement conditionFilter;
	
	@FindBy(id="c3-subPanel-LH_ItemCondition_Excellent%20-%20Refurbished_cbx")
	private WebElement conditionItem;
	
	@FindBy(id="c3-mainPanel-price")
	private WebElement priceFilter;

	@FindBy(css=".x-textrange__input.x-textrange__input--from")
	private WebElement minPrice;
	
	@FindBy(css="input[aria-label*='Maximum']")
	private WebElement maxPrice;

	@FindBy(xpath="//span[text()='Item Location']")
	private WebElement location;
	
	@FindBy(xpath="//input[@aria-label='US Only']")
	private WebElement locationCheckBox;
	
	@FindBy(xpath="//button[@aria-label='Apply']")
	private WebElement applyButton;
	
	// Create constructor to initialize the FilterPage object
	public FilterPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Method to add filters with specified minimum and maximum prices, condition and itemLocation
	public ProductPage addFilters(int minprice, int maxprice)
	{
		conditionFilter.click();
		conditionItem.click();
		priceFilter.click();
		minPrice.sendKeys(String.valueOf(minprice));
		maxPrice.sendKeys(String.valueOf(maxprice));
		location.click();
		locationCheckBox.click();
		applyButton.click();
		return new ProductPage(driver);
		
	}
	

	
	
	
	
	
	

}

