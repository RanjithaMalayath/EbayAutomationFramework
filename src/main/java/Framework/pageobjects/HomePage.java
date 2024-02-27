package Framework.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Framework.abstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {
	
	
	// Declare WebDriver instance to interact with the browser
	private WebDriver driver;
	
	// WebElements representing elements on the HomePage
	@FindBy(id="gh-shop-a")
	private WebElement shopByCategory;
	
	@FindBy(partialLinkText="Cell phones")
	private WebElement cellPhonesAccesories;
	
	@FindBy(id="gh-ac")
	private WebElement searchBar;
	
	@FindBy(id="gh-cat")
	private WebElement allCategoriesDropDown;
	
	@FindBy(id="gh-btn")
	private WebElement searchButton;
	
	// Create constructor to initialize the PageFactory and set the WebDriver to instance WebDriver to use through out the class
    // The 'super(driver)' call is to invoke the constructor of the AbstractComponent class (Parent)
	// 'PageFactory.initElements(driver, this)' will construct WebElement in run time
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	 // Navigate to Electronics category
	public CategoryPage navigateToElectronicsCategory()
	{
		shopByCategory.click();
		cellPhonesAccesories.click();
		return new CategoryPage(driver);
	 
	}
	
	// Type in the search bar
	public void typeInTheSearchBar(String searchString)
	{
		searchBar.sendKeys(searchString);
			
	}
	
	  // Select a category from the dropdown
	public ProductPage selectCategory(String category)
	{
		new Select(allCategoriesDropDown).selectByVisibleText(category);
		searchButton.click();
		return new ProductPage(driver);
		
	}
	
	// Navigate to a specific URL
	public void goTo(String url)
	{
		driver.get(url);
	}	

}

