package org.docstream.infra.cloud;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@ApplicationScoped
public class S3ClientProducer {

    @Inject
    @ConfigProperty(name = "aws.region")
    String region;

    @Inject
    @ConfigProperty(name = "aws.access-key-id")
    String accessKey;

    @Inject
    @ConfigProperty(name = "aws.secret-access-key")
    String secretKey;

    @Produces
    @ApplicationScoped
    public S3Client s3Client() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
