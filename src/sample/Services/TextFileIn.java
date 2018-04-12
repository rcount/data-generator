package sample.Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Public service that reads in a text file, be it a {@code .txt}, {@code .rtf}, {@code .csv}, or any other TEXT FILE system
 * extends {@link InFileService}
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
public class TextFileIn extends InFileService{

    //MARK: - Private attributes for the TextFileIn class -

    /**
     * Private instance of {@code SJVLogger} for the {@code TextFileIn} class
     * This is used for all our {@code Logging}
     */
    private Logger LOG = Logger.getLogger(TextFileIn.class.getName());

    //MARK: - Constructors for the TextFileIn class -

    /**
     * Public constructor for the {@code TextFileIn} class. Takes one arg for the path of the file to be read in.
     *
     * @param filePath  A {@code String} containing the Path of the {@code file} to open and read from.
     */
    public TextFileIn(String filePath){
        super(filePath);
    }

    /**
     * Public constructor for the {@code TextFileIn} class. Takes one arg for the path of the file to be read in.
     *
     * @param filePath  A {@code Path} containing the Path of the {@code file} to open and read from.
     */
    public TextFileIn(Path filePath){
        super(filePath);
    }


    /**
     * Public method to get the contents of the {@code file}
     *
     * @return  A {@code String} representing the the contents of the {@code file}
     *
     * <p>This returns all the data as a string, so that we can later parse the data as needed,
     * i.e. for a .txt file, .rtf file, or .csv file</p>
     */
    @Override
    public String readFile(){


        StringBuilder builder = new StringBuilder();

        try (Scanner reader = new Scanner(
                new BufferedReader(new FileReader(this.getFile()))
        )){
            String line;

            while (reader.hasNext()){
                if((line = reader.nextLine()) != null){
                    builder.append(line).append(System.lineSeparator());
                }
            }

        }catch (FileNotFoundException ex){
            LOG.log(Level.SEVERE, ex.getMessage());
        }

        return builder.toString();

    }
}
