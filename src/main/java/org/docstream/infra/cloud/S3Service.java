package org.docstream.infra.cloud;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;

@ApplicationScoped
public class S3Service {

    @Inject
    S3Client s3Client;

    @Inject
    @ConfigProperty(name = "aws.s3.bucket-name")
    String bucketName;


    public void upload(InputStream inputStream, String key) {

        try {
            s3Client
                    .putObject(
                            PutObjectRequest.builder()
                                    .bucket(bucketName)
                                    .key(key)
                                    .build(),
                            RequestBody.fromInputStream(inputStream, inputStream.available())
                    );
        } catch (Exception e) {
            throw new RuntimeException("Falha ao enviar pro bucketS3", e);
        }

    }
}
