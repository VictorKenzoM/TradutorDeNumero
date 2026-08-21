package br.com.fiap;
import br.com.fiap.stubclasses.NumberConversionSoapType;
import jakarta.xml.ws.Service;

import java.math.BigInteger;
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        final String WSDL = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL";
        final String TARGET = "http://www.dataaccess.com/webservicesserver/";
        final String NAME = "NumberConversion";

        URL url = new URL(WSDL);
        QName qName = new QName(TARGET,NAME);
        Service service = Service.create(url,qName);

        NumberConversionSoapType numberConversion = service.getPort(NumberConversionSoapType.class);
        String convertedNumber = numberConversion.numberToWords(BigInteger.valueOf(67));
        System.out.println(convertedNumber);
    }
}
