package com.bytesw.hubpagos.pasarela;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapMessage;

public final class ClientMessageCallBack 
implements WebServiceMessageCallback {

/**the soapAction to be appended to the soap message.*/
private String soapAction;

/**constructor.
 * @param action the soapAction to be set.*/
public ClientMessageCallBack(final String action) {
    this.soapAction = action;
}

@Override
public void doWithMessage(final WebServiceMessage message) 
        throws IOException, TransformerException {

    if (message instanceof SoapMessage) {
        SoapMessage soapMessage = (SoapMessage) message;
        soapMessage.setSoapAction(soapAction);
    }

}
}