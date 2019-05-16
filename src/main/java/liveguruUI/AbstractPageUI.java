package liveguruUI;

public class AbstractPageUI {
	public static final String DYNAMIC_LINK= "//a[text()='%s']";
	
	public static final String DYNAMIC_TEXTBOX= "//input[@class='%s']";
	//input[@class='input-text qty']
	
	public static final String DYNAMIC_BUTTON= "//button[@title='%s']";
	
	public static final String DYNAMIC_RADIO= "//input[@value='%s']";
	
	public static final String DYNAMIC_TEXT_EREA= "//textarea[@name='%s']";
	
	public static final String DYNAMIC_GET_TEXT= "//td[text()='%s']//following-sibling::td";
	
	public static final String DYNAMIC_TITEL_PAGE = "//p[text()='%s']";
	
	public static final String DYNAMIC_ALERT = "";
	
	public static final String DYNAMIC_PRICE = "//a[@title='%s']/parent::h2//following-sibling::div[@class='price-box']//span[@class='price']";
	
	public static final String DYNAMIC_DETAIL_PRICE = "//span[text()='%s']/parent::div//following-sibling::div[@class='price-info']//span[@class='price']";
	
	public static final String DYNAMIC_BUTTON_ADD_CARD = "//a[text()='%s']/parent::h2//following-sibling::div[@class='actions']//button[@title='Add to Cart']";
	
	public static final String DYNAMIC_BUTTON_ADD_LINK = "//a[@title='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='%s']";
	                                                     
	

}
