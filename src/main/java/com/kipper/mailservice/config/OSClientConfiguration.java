package com.kipper.mailservice.config;

import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.Region;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class OSClientConfiguration {

    String configurationFilePath = "/.oci/config";
    String profile = "DEFAULT";

    public ObjectStorage getObjectStorage() throws IOException {
        Path currentRelativePath = Paths.get("");

        final ConfigFileReader.ConfigFile configFile = ConfigFileReader
                .parse(currentRelativePath.toAbsolutePath() + configurationFilePath, profile);

        final ConfigFileAuthenticationDetailsProvider provider = new ConfigFileAuthenticationDetailsProvider(configFile);

        return ObjectStorageClient
                .builder()
                .region(Region.SA_SAOPAULO_1)
                .build(provider);
    }
}
