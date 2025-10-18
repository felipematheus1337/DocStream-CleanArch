package org.docstream.infra.service;

import io.vertx.ext.web.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileInputStream;
import java.io.InputStream;

@ApplicationScoped
public class SerializadorDeArquivosXMLService {

    public <T> T serializar(FileUpload fileUpload, Class<T> clazz) throws JAXBException {
        try (InputStream inputStream = new FileInputStream(fileUpload.uploadedFileName())) {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(inputStream);
        } catch(Exception e) {
            throw new JAXBException("Erro ao deserializar o arquivo XML", e);
        }
    }

}
