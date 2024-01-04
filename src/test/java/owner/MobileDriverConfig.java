package owner;
import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${launch}.properties"
})
public interface MobileDriverConfig extends Config {
    @Key("url")
    String getUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOS();

    @Key("app")
    String getApp();
}
