import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest extends TestBase {
    DemoPages demoPages;

    public DemoTest() {
        super();
    }

    @BeforeMethod
    public void launchBrowser() {
        TestBase.Launch(map.get("baseURL"));
    }

    @Test
    public void singleInputFieldTest() {
        demoPages = new DemoPages();
        String data = demoPages.getRandomString();
        Assert.assertTrue(demoPages.getURL().contains(map.get("expectedTextInURL")));
        demoPages.enterMessage(data);
        System.out.println("Enter message for Single Input Field.");
        demoPages.clickOnCheckedValueButton();
        System.out.println("Click on get checked value button.");
        Assert.assertEquals(demoPages.getAddedMessage(), data);
        System.out.printf("verify Added message is showing as expected.");
    }

    @Test
    public void twoInputFieldTest() {
        demoPages = new DemoPages();
        int value1 = demoPages.getIntValue();
        int value2 = demoPages.getIntValue();
        Assert.assertTrue(demoPages.getURL().contains(map.get("expectedTextInURL")));
        System.out.println("Enter values " + value1 + " and " + value2);
        demoPages.enterDataForTwoInputFields(value1, value2);
        Assert.assertEquals(demoPages.getOutputForTwoInputFields(), value1 + value2);
        System.out.printf("Sum is showing as expected");
    }

    @Test
    public void dragAndDropSliders_Test() {
        int sliderRange = Integer.valueOf(map.get("slidingRange"));
        demoPages = new DemoPages();
        Assert.assertTrue(demoPages.getURL().contains(map.get("expectedTextInURL")));
        demoPages.dragAndDropSlidersFunctionality();
        Assert.assertEquals(demoPages.getSlidersRange(), sliderRange);
        System.out.printf("Verified the slider range is" + sliderRange);
    }

    @Test
    public void inputFromSubmit_Test() {
        demoPages = new DemoPages();
        Assert.assertTrue(demoPages.getURL().contains(map.get("expectedTextInURL")));
        demoPages.inputFromSubmitValidationFunctionality(map);
        Assert.assertTrue(demoPages.verifyInputFromWithValidation());
    }
}
