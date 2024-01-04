package owner;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties"
})

public interface UserConfig extends Config {
    @Key("userName")
    String getUserName();

    @Key("accessKey")
    String getAccessKey();
    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
