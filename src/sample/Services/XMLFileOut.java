package sample.Services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import sample.Models.JsonXmlType;
import sample.Models.Tablable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Public method to write data to an {@code .xml} file.
 *
 * <p>This class extends {@link OutFileService} for an {@code .xml} file.
 *
 * <p>Copyright 2018 Stephen Vickers, Shane May
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author Stephen Vickers
 */
public class XMLFileOut extends OutFileService {


    //MARK: - Private attributes for he class -

    /**
     * Private {@link List} of {@link JsonXmlType} for the data to generate
     */
    private List<JsonXmlType> xmlTypes = new ArrayList<>();

    /**
     * Private instance of {@link Logger} for the class
     */
    private Logger LOG = Logger.getLogger(getClass().getName());

    //MARK: - Constructors for the class -

    /**
     * Public constructor for the class
     *
     * @param file              A {@link File} that we want to save to.
     * @param generateAmount    A {@link int} that contains the amount of data points we want to generate
     * @param separator         A {@link String} for the separator for the data.
     * @param quote             A {@link String} for the quote that we surround the data with.
     * @param tablableList      A {@link List} of {@link Tablable} types that we want to generate the data for
     */
    public XMLFileOut(File file, int generateAmount, String separator, String quote, List<Tablable> tablableList){
        super(file, generateAmount, separator, quote, tablableList);
        this.loadArray();
    }

    //MARK: - Public methods for the class -

    //MARK: - Override methods from OutFileService

    /**
     * Override of the {@link OutFileService#writeFile()} method. Used to write the data out to an
     * {@code .xml} file.
     */
    @Override
    public void writeFile() {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;

        try {
            docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement( "DataTypes");
            doc.appendChild(rootElement);

            for(JsonXmlType type: this.xmlTypes){
                rootElement.appendChild(this.getXmlFormat(doc, type));
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(this.getFile());

            transformer.transform(source, result);

        }catch (Exception ex){
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    //MARK: - Private methods for the class -

    /**
     * Private helper method to convert a {@link Tablable} type to an {@link JsonXmlType}
     */
    private void loadArray(){
        for(Tablable tablable: this.getTablableList()){
            JsonXmlType type = new JsonXmlType(tablable, this.getGenerateAmount());
            this.xmlTypes.add(type);
        }
    }

    /**
     * Private method to get the data from a {@link JsonXmlType} in an {@code .xml} format
     *
     * @param doc   A {@link Document} that we want to add the element to
     * @param type  A {@link JsonXmlType} that we want to format
     * @return      A {@link Node} containing the data for the file.
     */
    private Node getXmlFormat(Document doc, JsonXmlType type){
        Element element = doc.createElement(type.getColumnName());
        element.appendChild(doc.createTextNode(type.getData().toString()));

        return element;
    }

}
