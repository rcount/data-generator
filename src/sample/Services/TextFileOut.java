package sample.Services;



import sample.Models.Tablable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Public service to write out to a TextFile. The File will end with a {@code .txt} suffix This class extends the
 * abstract class of {@link OutFileService} to only deal with txt files.
 *
 * <p>Copyright 2018 Stephen Vickers, Shane May</p>
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:</p>
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>
 *
 * @author Stephen Vickers
 */
public class TextFileOut extends OutFileService {

    //MARK: - Private attributes for the class -

    /**
     * Private {@link Logger} for Logging of in case there is a failure.
     */
    private Logger LOG = Logger.getLogger(TextFileOut.class.getName());

    /**
     * Private static final {@code String} for the suffix of a TextFile
     */
    private static final String TEXT_FILE_SUFFIX = ".txt";

    //MARK: - Constructors for the class -

    /**
     * Public Constructor for the {@code TextFileOut} class. This is the only way to construct an instance as we
     * need to have the path to get the
     *
     * @param file     A {@link File} for the file path
     */
    public TextFileOut(File file){
        super(file);
    }

    public TextFileOut(File file, int amount, String separator, String quote, List<Tablable> tablables){
        super(file, amount, separator, quote, tablables);
    }

    //MARK: - Public methods for the class -

    /**
     * Public method to write to a text file
     */
    @Override
    public void writeFile(){


        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(this.getFile(), true));

            for(Tablable tablable: this.getTablableList()){
                writer.write(tablable.getColumnName());
                writer.write(this.getSeparator());
            }

            writer.newLine();

            for(int index = 0; index < this.getGenerateAmount(); index++){
                for(int index2 = 0; index2 < this.getTablableList().size(); index2++){
                    writer.write(this.getTablableList().get(index2).generate().toString());
                    if(index2 != this.getTablableList().size() - 1){
                        writer.write(this.getSeparator());
                    }else{
                        writer.newLine();
                    }
                }
            }

            writer.flush();
        }catch (IOException ex){
            LOG.log(Level.SEVERE, ex.getMessage());
        } finally {
            if (writer != null) {
                try{
                    writer.close();
                }catch (IOException ex){
                    //ignore exception
                }
            }
        }
    }





}
