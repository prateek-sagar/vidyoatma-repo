package vidyoatmav1.databaseconnection;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {
    private File secureBundleConnect;

    public File getSecureBundleConnect() {
        return secureBundleConnect;
    }

    public void setSecureBundleConnect(File secureBundleConnect) {
        this.secureBundleConnect = secureBundleConnect;
    }
}
