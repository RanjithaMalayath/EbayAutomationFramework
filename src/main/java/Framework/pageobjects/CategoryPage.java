package Framework.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.abstractComponents.AbstractComponent;

public class CategoryPage extends AbstractComponent {


	// The WebDriver instance to interact with the browser
	private WebDriver driver;

	// WebElements of Category Page
	@FindBy(linkText="Cell Phones & Smartphones")
	private WebElement cellPhonesSmartphones;


	@FindBy(xpath="//button[@aria-label='All Filters']")
	private WebElement allFilters;

	// Constructor to initialize the PageFactory and set the WebDriver
	// The 'super(driver)' call is to invoke the constructor of the AbstractComponent class
	public CategoryPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Method to click on "Cell Phones & Smartphones" and navigate to FilterPage

	public FilterPage selectCellPhonesSmartphones()
	{
		cellPhonesSmartphones.click();
		return new FilterPage(driver);

	}

	// Method to click on "All Filters" and navigate to FilterPage
	public FilterPage clickAllFilters()
	{
		allFilters.click();
		return new FilterPage(driver);





	}	

}

