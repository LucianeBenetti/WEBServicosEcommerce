/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.integracao;

import controle.VO.Item;
import controle.VO.RepositorioItemList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 80119050
 */
public class ItemDAOXML {

    public RepositorioItemList desserializa(String s) {
        RepositorioItemList obj = null;
        InputStream in = new ByteArrayInputStream(s.getBytes(Charset.forName("UTF-8")));
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(RepositorioItemList.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            obj = (RepositorioItemList) jaxbUnmarshaller.unmarshal(in);

        } catch (JAXBException ex) {
            Logger.getLogger(ItemDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public String serializa(ArrayList<Item> listaDeItens) {
        String xmlContent = "";        

        try {
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(RepositorioItemList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(listaDeItens, sw);
            xmlContent = sw.toString();
        } catch (Exception e) {

        }
        return xmlContent;

    }
}
