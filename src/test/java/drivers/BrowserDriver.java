package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import owner.MobileDriverConfig;
import owner.UserConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserDriver implements WebDriverProvider {
    static MobileDriverConfig mobileDriver = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());
    static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities){
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", userConfig.getUserName());
        caps.setCapability("browserstack.key", userConfig.getAccessKey());
        caps.setCapability("app", mobileDriver.getApp());
        caps.setCapability("device", mobileDriver.getDevice());
        caps.setCapability("os_version", mobileDriver.getOS());
        caps.setCapability("project", userConfig.getProject());
        caps.setCapability("build", userConfig.getBuild());
        caps.setCapability("name", userConfig.getName());
        try {
            return new RemoteWebDriver(
                    new URL(mobileDriver.getUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
