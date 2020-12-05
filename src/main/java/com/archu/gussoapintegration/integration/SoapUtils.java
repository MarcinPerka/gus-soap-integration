package com.archu.gussoapintegration.integration;

import com.archu.gussoapintegration.exception.UnmarshalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.StringReader;

import static com.archu.gussoapintegration.integration.SoapConstants.*;

@Slf4j
public class SoapUtils {

    public static <T> T unmarshal(String xml, Class<T> rootClass) {
        log.debug("Parsing xml to: {}", rootClass.toString());
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(rootClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            log.error("Error in unmarshalling string xml: {} to object of class: {}", xml, rootClass.getName());
            throw new UnmarshalException("Error in unmarshalling string xml: %s to object of class: %s".formatted(xml, rootClass.getName()));
        }
    }

    public static SoapActionCallback prepareSoapActionCallback(String apiEndpoint, String action, String sessionId) {
        return new SoapActionCallback(action) {
            public void doWithMessage(WebServiceMessage message) throws IOException {
                var soapMessage = (SaajSoapMessage) message;
                var soapHeader = soapMessage.getSoapHeader();
                setWsaTo(soapHeader, apiEndpoint);
                setWsaAction(soapHeader, action);
                setSid(sessionId);
            }
        };
    }

    private static void setSid(String sessionId) throws IOException {
        var context = TransportContextHolder.getTransportContext();
        var connection = (HttpUrlConnection) context.getConnection();
        log.info("Add sid http header to request: {}", sessionId);
        connection.addRequestHeader("sid", sessionId);
    }

    private static void setWsaAction(SoapHeader soapHeader, String action) {
        var wsaActionQName = new QName(WSA_ADDRESSING_NAMESPACE_URI, WSA_ACTION_HEADER, WSA_PREFIX);
        var wsaAction = soapHeader.addHeaderElement(wsaActionQName);
        wsaAction.setText(action);
    }

    private static void setWsaTo(SoapHeader soapHeader, String defaultUri) {
        var wsaToQName = new QName(WSA_ADDRESSING_NAMESPACE_URI, WSA_TO_HEADER, WSA_PREFIX);
        var wsaTo = soapHeader.addHeaderElement(wsaToQName);
        wsaTo.setText(defaultUri);
    }
}
