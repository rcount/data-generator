package sample.Services;

import sample.Models.Tablable;

import java.io.File;
import java.util.List;

/**
 * Public {@code Factory} class to create a subclass of {@link OutFileService} for the file that we want to write to.
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

public class OutFileFactory {

    /**
     * Public static final {@code int} for creating a {@link CSVFileOut} instance
     */
    public static final int CSV_FILE = 0;

    /**
     * Public static final {@code int} for creating a {@link TextFileOut} instance
     */
    public static final int TEXT_FILE = 1;

    /**
     * Public static final {@code int} for creating a {@link JSONFileOut} instance
     */
    public static final int JSON_FILE = 2;

    /**
     * Public static final {@code int} for creating a {@link XMLFileOut} instance
     */
    public static final int XML_FILE = 3;

    private static final String COMMA = ",";

    /**
     * Public static method to return a subclass of {@link OutFileService}
     *
     * @param service   An {@code int} representing the {@link OutFileService} we want to create.
     * @param file      A {@link File} that we want to save the data to.
     * @param amount    An {@code int} with the amount of data we want to create.
     * @param separator A {@code String} containing the character that we want to separate the data with.
     * @param quote     A {@code String} containing the character we want to surround the data with.
     * @param tablables A {@link List} of {@link Tablable} elements that we create the data from.
     * @return          A new subclass instance of a {@link OutFileService} subclass.
     */
    public static OutFileService getOutFileService(int service, File file, int amount, String separator, String quote, List<Tablable> tablables){
        switch (service){
            case 0:
                return new CSVFileOut(file, amount, separator, quote, tablables);
            case 1:
                return new TextFileOut(file);
            case 2:
                return new JSONFileOut(file, amount, separator, quote, tablables);
            case 3:
                return new XMLFileOut(file, amount, separator, quote, tablables);
        }

        //this is just a catch all if the switch doesn't work. if the separator is a comma we assume a .csv file,
        //else we just return a TextFile. This should never run, but it's just an assurance.
        if(separator.equals(COMMA)){
            return new CSVFileOut(file, amount, separator, quote, tablables);
        } else {
            return new TextFileOut(file, amount, separator, quote, tablables);
        }
    }
}
