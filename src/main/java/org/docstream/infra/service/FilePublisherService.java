package org.docstream.infra.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@ApplicationScoped
public class FilePublisherService {

    @Inject
    @Channel("files-processed")
    Emitter<String> emitter;

    private static Logger logger = LoggerFactory.getLogger(FilePublisherService.class);

    public void publish(InputStream inputStream) throws IOException {
       byte[] bytes = inputStream.readAllBytes();
       String base64 = Base64.getEncoder().encodeToString(bytes);
       var stage = emitter.send(base64);

       stage.thenRun(() -> Log.info("Mensagem enviada com sucesso."))
               .exceptionally(ex -> {
                   Log.error("Falha ao enviar mensagem: {}", ex);
                   return null;
               });
    }
}
