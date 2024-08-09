package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");


        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(10000);
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("makemytrip.")){
            System.out.println("The URL of the Make My Trip homepage contains 'makemytrip.'");
        }
        else{
            System.out.println("The URL of the Make My Trip homepage does not contains 'makemytrip.'");
        }

        System.out.println("end Test case: testCase01");
    }
    
    /**
     * @throws InterruptedException
     */
    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(40000);
        // WebElement closePop = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
        // closePop.click();
        // Thread.sleep(5000);
        // WebElement closewid = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        // closewid.click();
        // Thread.sleep(5000);
        WebElement depCity =driver.findElement(By.xpath("//input[@id='fromCity']"));
        depCity.click();
        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        Thread.sleep(3000);
        fromInput.sendKeys("blr");
        Thread.sleep(3000);
        WebElement SelectDepCity = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
        SelectDepCity.click();

        Thread.sleep(3000);
        WebElement arrCity = driver.findElement(By.xpath("//input[@id='toCity']"));
        arrCity.click();
        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        Thread.sleep(3000);
        toInput.sendKeys("del");
        Thread.sleep(3000);
        WebElement SelectArrCity = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
        SelectArrCity.click();

        Thread.sleep(3000);
        WebElement reqDate = driver.findElement(By.xpath("//div[@aria-label='Wed May 29 2024']"));
        reqDate.click();

        WebElement searchBox = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
        searchBox.click();
        Thread.sleep(5000);
        WebElement price = driver.findElement(By.xpath("//div[@class='listingCard  appendBottom5']//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
        String flightPrice = price.getText();
        System.out.println("Flight Price:" + flightPrice);
        WebElement adultElement = driver.findElement(By.xpath("//div[@class='listingCard  appendBottom5']//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']/p"));
        String adult = adultElement.getText();
        System.out.println(adult);
        if(flightPrice.contains("6,516")){
        System.out.println("The correct flight details are obtained and the price per adult is stored.");}


        System.out.println("end Test case: testCase02");
    }

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(10000);
        //WebElement closewid = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        //closewid.click();
        Thread.sleep(5000);
        WebElement trainsSearch = driver.findElement(By.xpath("//li[@class='menu_Trains']/span/a"));
        trainsSearch.click();
        WebElement depCity = driver.findElement(By.id("fromCity"));
        depCity.click();
        Thread.sleep(5000);
        WebElement depText = driver.findElement(By.xpath("//input[@placeholder='From']"));
        depText.sendKeys("ypr");
        Thread.sleep(5000);
        WebElement selectDepCity = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
        selectDepCity.click();

        Thread.sleep(5000);
        WebElement arrText = driver.findElement(By.xpath("//input[@placeholder='To']"));
        arrText.sendKeys("ndls");
        Thread.sleep(5000);
        WebElement selectArrCity = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
        selectArrCity.click();

        //WebElement depDate = driver.findElement(By.xpath("//div[@class='rsw_inputBox dayPickerRailWrap dates']"));
        //depDate.click();
        WebElement reqDate = driver.findElement(By.xpath("//div[text()='29']"));
        reqDate.click();

        

        Thread.sleep(3000);
        WebElement reqClass = driver.findElement(By.xpath("//li[@data-cy='3A']"));
        reqClass.click();
      
        WebElement searchBox = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn']"));
        searchBox.click();

        WebElement price = driver.findElement(By.xpath("//div[@id='train_options_29-05-2024_0']/div/div[2]"));
        String ticketPrice = price.getText();
        System.out.println("Train Price:"+ticketPrice);

        System.out.println("end Test case: testCase03");
    }
    
    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(10000);
        //WebElement closewid = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        //closewid.click();
        Thread.sleep(5000);
        WebElement busSearch = driver.findElement(By.xpath("//li[@class='menu_Buses']"));
        busSearch.click();
        
        WebElement depCity = driver.findElement(By.id("fromCity"));
        depCity.click();
        Thread.sleep(5000);
        WebElement depText = driver.findElement(By.xpath("//input[@placeholder='From']"));
        depText.sendKeys("bangl");
        Thread.sleep(5000);
        WebElement selectDepCity = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
        selectDepCity.click();

        //WebElement arrCity = driver.findElement(By.id("toCity"));
        //arrCity.click();
        Thread.sleep(5000);
        WebElement 
        arrText = driver.findElement(By.xpath("//input[@placeholder='To']"));
        arrText.sendKeys("del");
        Thread.sleep(5000);
        WebElement selectArrCity = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
        selectArrCity.click();
    
        //WebElement date = driver.findElement(By.id("travelDate"));
        //date.click();
        WebElement nextMonth = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
        nextMonth.click();
        Thread.sleep(5000);
        WebElement reqDate = driver.findElement(By.xpath("//div[@aria-label='Sat Jun 29 2024']"));
        reqDate.click();

    
        WebElement searchBox = driver.findElement(By.id("search_button"));
        searchBox.click();

        WebElement result = driver.findElement(By.xpath("//span[@class='error-title']"));
        String message = result.getText();  
        System.out.println(message);  



        System.out.println("end Test case: testCase04");
    }


}
