package gov.noaa;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest {

    @Test
    void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)new NdfdXMLLocator().getndfdXMLPort();

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        String response = binding.latLonListZipCode("53714");

        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response)); //

        assertEquals("43.0798,-89.3875", dwml.getLatLonList());
    }

}