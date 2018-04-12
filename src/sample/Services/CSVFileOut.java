package sample.Services;

import sample.Models.Tablable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Public class to write data to a {@code .csv} file or a Tab delineated file.
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

/*
    As of right now this file breaks out inheritance of OutfileService, but that can be changed in the future.
 */
public class CSVFileOut extends OutFileService{

    //TODO: Comment File.

    //MARK: - Private attributes for the file -


    /**
     * Private {@link List} to hold a list of Tablable elements. This allows us to access what
     * the user wants to call the column for that type and then Generate data with the {@link sample.Models.Interfaces.Generatable}
     * methods
     */
    private List<Tablable> tablableList = new ArrayList<>();

    private Logger LOG = Logger.getLogger(getClass().getName());

    //MARK: - Constructor for the class -

    /**
     * Public 4 args constructor for the class.
     *
     * @param file              A {@link File} that is the File we want to write to
     * @param generateAmount    An {@code int} containing the number for the data points we want to create
     * @param separator         A {@code String} containing the separator for the data in the file
     * @param quote             A {@code String} containing the quote for the data to write.
     * @param tablable          A {@link List} containing the instance of Data we want to generate.
     */
    public CSVFileOut(File file, int generateAmount, String separator, String quote , List<Tablable> tablable){
        super(file, generateAmount, separator, quote, tablable);

    }

    //MARK: - Public method for the class -


    /**
     * Public method to write the data to the supplied {@link File}
     */
    public void writeFile(){
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(this.getFile()));

            for(Tablable tablable: this.tablableList){
                writer.write(tablable.getColumnName());
                writer.write(this.getSeparator());
            }

            writer.newLine();

            for(int index = 0; index < this.getGenerateAmount(); index++){
                for(Tablable tablable: this.tablableList){
                    writer.write(tablable.generate().toString());
                    writer.write(this.getSeparator());
                }
                writer.newLine();
            }

            writer.flush();
        }catch (IOException ex){
            LOG.log(Level.SEVERE, ex.getMessage());
        } finally {
            if (writer != null) {
                try{
                    writer.close();
                }catch (IOException ex){
                    LOG.log(Level.INFO, ex.getMessage());
                }
            }
        }
    }
}
