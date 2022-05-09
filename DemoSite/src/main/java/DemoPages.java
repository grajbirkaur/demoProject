import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DemoPages extends TestBase {

    public DemoPages() {
        PageFactory.initElements(TestBase.driver, this);
    }

    @FindBy(xpath = "//input[@id='user-message']")
    WebElement singleMessageTextBox;

    @FindBy(id = "showInput")
    WebElement getCheckedValueButton;

    @FindBy(xpath = "//p[@id='message']")
    WebElement addedMessage;

    @FindBy(id = "sum1")
    WebElement textBoxForTwoInput1;

    @FindBy(id = "sum2")
    WebElement textBoxForTwoInput2;

    @FindBy(xpath = "//button[text()='Get values']")
    WebElement getValuesButtonForTwoInputFields;

    @FindBy(id = "addmessage")
    WebElement outputOfTwoInputFields;

    @FindBy(xpath = "//p[@class='inline-block' and text()='Progress Bar & Sliders']")
    WebElement progressBarAndSlidersTab;

    @FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
    WebElement dragAndDropSliders;

    @FindBy(xpath = "//div[@id='slider3']//input[@class='sp__range']")
    WebElement sliderElement;

    @FindBy(xpath = "//output[@id='rangeSuccess']")
    WebElement sliderActualRange;

    @FindBy(xpath = "//a[text()='Input Form Submit']")
    WebElement inputFromSubmitTab;

    @FindBy(id = "name")
    WebElement nameTextBox;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextBox;

    @FindBy(id = "company")
    WebElement companyTextBox;

    @FindBy(id = "websitename")
    WebElement websitenameTextBox;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityTextBox;

    @FindBy(xpath = "//input[@name='address_line1']")
    WebElement address_line1TextBox;

    @FindBy(xpath = "//input[@name='address_line2']")
    WebElement address_line2TextBox;

    @FindBy(xpath = "//input[@placeholder='State']")
    WebElement stateTextBox;

    @FindBy(id = "inputZip")
    WebElement zipTextBox;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//select[@name='country']")
    WebElement selectCountryDropdown;

    @FindBy(xpath = "//p[text()='Thanks for contacting us, we will get back to you shortly.']")
    WebElement successMessage;

    public void enterMessage(String value) {
        singleMessageTextBox.sendKeys(value);
    }

    public void clickOnCheckedValueButton() {
        getCheckedValueButton.click();
    }

    public String getAddedMessage() {
        return addedMessage.getText();
    }

    public void enterDataForTwoInputFields(int value1, int value2) {
        textBoxForTwoInput1.sendKeys(String.valueOf(value1));
        textBoxForTwoInput2.sendKeys(String.valueOf(value2));
        getValuesButtonForTwoInputFields.click();
    }

    public int getOutputForTwoInputFields() {
        String output = outputOfTwoInputFields.getText();
        return Integer.valueOf(output);
    }

    public void dragAndDropSlidersFunctionality() {
        progressBarAndSlidersTab.click();
        System.out.println("Click on progress bar and Sliders tab. ");
        dragAndDropSliders.click();
        System.out.println("Click on drag And Drop Sliders. ");
        slider(sliderElement);
        System.out.println("Sliding value to sliderRange.");
    }

    public void inputFromSubmitValidationFunctionality(Map<String, String> map) {
        inputFromSubmitTab.click();
        System.out.println("Click on input from submit tab.");
        nameTextBox.sendKeys(map.get("name"));
        System.out.println("Enter name.");
        emailTextBox.sendKeys(map.get("emailId"));
        System.out.println("Enter emailId.");
        passwordTextBox.sendKeys(map.get("password"));
        System.out.println("Enter password.");
        companyTextBox.sendKeys(map.get("company"));
        System.out.println("Enter company.");
        websitenameTextBox.sendKeys(map.get("website"));
        System.out.println("Enter website.");
        cityTextBox.sendKeys(map.get("city"));
        System.out.println("Enter city.");
        address_line1TextBox.sendKeys(map.get("address"));
        System.out.println("Enter address1.");
        address_line2TextBox.sendKeys(map.get("address"));
        System.out.println("Enter address2.");
        stateTextBox.sendKeys(map.get("state"));
        System.out.println("Enter state.");
        zipTextBox.sendKeys(map.get("zip"));
        System.out.println("Enter zip.");
        Select select = new Select(selectCountryDropdown);
        select.selectByVisibleText(map.get("country"));
        submitButton.click();
        System.out.println("Click on submit button.");
    }

    public boolean verifyInputFromWithValidation() {
        return successMessage.isDisplayed();
    }

    public int getSlidersRange() {
        String range = sliderActualRange.getText();
        return Integer.valueOf(range);
    }

    public void waitForElement() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public int getIntValue() {
        Random random = new Random();
        return random.nextInt();
    }

    public String getRandomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public void slider(WebElement sliderElement) {
        Actions move = new Actions(driver);
        move.dragAndDropBy(sliderElement, 120, 0).build().perform();
    }
}
