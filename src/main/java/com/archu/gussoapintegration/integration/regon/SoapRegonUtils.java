package com.archu.gussoapintegration.integration.regon;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.namespace.QName;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.*;

class SoapRegonUtils {

    static SoapActionCallback prepareSoapActionCallback(WebServiceTemplate webServiceTemplate, String action) {

        return new SoapActionCallback(action) {
            public void doWithMessage(WebServiceMessage message) {
                var soapMessage = (SaajSoapMessage) message;
                var soapHeader = soapMessage.getSoapHeader();
                setWsaTo(soapHeader, webServiceTemplate.getDefaultUri());
                setWsaAction(soapHeader, action);
            }
        };
    }

    private static void setWsaAction(SoapHeader soapHeader, String action) {
        var wsaActionQName = new QName(WSA_ADDRESSING_NAMESPACE_URI, WSA_ACTION_HEADER, WSA_PREFIX);
        var wsaAction = soapHeader.addHeaderElement(wsaActionQName);
        wsaAction.setText(action);
    }

    private static void setWsaTo(SoapHeader soapHeader, String defaultUri) {
        var wsaToQName = new QName(WSA_ADDRESSING_NAMESPACE_URI, SoapRegonConstants.WSA_TO_HEADER, WSA_PREFIX);
        var wsaTo = soapHeader.addHeaderElement(wsaToQName);
        wsaTo.setText(defaultUri);
    }
}
