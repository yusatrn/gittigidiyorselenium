package base;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.idealized.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;
import org.apache.log4j.Logger;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    JavascriptExecutor executor;
    final static Logger logger= Logger.getLogger(BasePage.class.getName());
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public WebElement findElement(By path){
        wait=new WebDriverWait(webDriver,3);
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(path));
    }
    public void clickElementbyJs (By path) {
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].click()", findElement(path));
    }
    public void yonlen(){
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        By path = new By.ByXPath("//*[@class='logo_gg imglink logo-small']");
        String currentWindow = webDriver.getWindowHandle();
        webDriver.findElement(path).sendKeys(selectLinkOpeninNewTab);
        Set<String> windowsHandles = webDriver.getWindowHandles();
        for (String pencere : windowsHandles){
            if (!currentWindow.equals(pencere)){
                webDriver.switchTo().window(pencere);
            }
        }
    }
    public void clickElement(By path){
        try{
            findElement(path).click();
        }
        catch (Exception e){
            clickElementbyJs(path);
        }
    }
    public void actions(By path){
        Actions actions = new Actions(webDriver);
        //return actions.moveToElement(findElement(path));
        actions.moveToElement(findElement(path)).click().build().perform();
    }
    public JavascriptExecutor scroll(){
        executor=((JavascriptExecutor) webDriver);
        return executor;
    }
    public int count (By path){
        return webDriver.findElements(path).size();
    }
    public Select select (By path){
        Select select = new Select(findElement(path));
        return select;
    }
    public void clear(By path){
        findElement(path).clear();
    }
}
