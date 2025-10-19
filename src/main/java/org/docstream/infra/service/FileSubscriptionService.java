package org.docstream.infra.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.docstream.infra.cloud.S3Service;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@ApplicationScoped
public class FileSubscriptionService {

    private final S3Service s3Service;

    @Inject
    public FileSubscriptionService(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Incoming("files-in")
    public void consumirPayload(String base64) {
        byte[] bytes = Base64.getDecoder().decode(base64);
        InputStream is = new ByteArrayInputStream(bytes);

        String key = UUID.randomUUID().toString() + LocalDateTime.now();

        s3Service.upload(is, key);
    }
}
