import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebDriver driver ;
FirefoxProfile profile = new FirefoxProfile();
profile.setPreference("permissions.default.desktop-notification", 1);
profile.setPreference("dom.disable_beforeunload", true)
profile.setPreference("dom.disable_open_during_load", false)
DesiredCapabilities capabilities=DesiredCapabilities.firefox();
capabilities.setCapability(FirefoxDriver.PROFILE, profile);
driver = new FirefoxDriver(capabilities);
driver.get("http://google.com");
//driver.get("http://demoaut.katalon.com/");
WebUI.delay(3)
driver.quit()

FirefoxProfile geoDisabled = new FirefoxProfile();
geoDisabled.setPreference("geo.enabled", false);
geoDisabled.setPreference("geo.provider.use_corelocation", false);
geoDisabled.setPreference("geo.prompt.testing", false);
geoDisabled.setPreference("geo.prompt.testing.allow", false);
capabilities = DesiredCapabilities.firefox();
capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
driver = new FirefoxDriver(capabilities);
driver.get("http://demoaut.katalon.com/");
WebUI.delay(3)
driver.quit()