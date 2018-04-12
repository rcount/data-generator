package sample.Services;

import java.io.File;
import java.nio.file.Path;

/**
 * Public abstract class that extends the  for reading data from a file.
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
public abstract class InFileService{

    /**
     * Private {@code String} variable to hold the name of the file
     */
    private String file = "";

    /**
     * Public {@code no args} constructor for the {@code InFileService}
     */
    public InFileService(){}

    /**
     * Public constructor for the {@code InFileService} class
     *
     * @param file  A {@code String} that holds the name or path for the file.
     */
    public InFileService(String file){
        this.setFile(file);
    }

    /**
     * Public constructor for the {@code InfileService} class
     *
     * @param path  A {@code Path} that contains the Path of the file we want to open
     */
    public InFileService(Path path){
        this(path.toString());
    }

    /**
     * Public mutator for the {@code file}
     *
     * @param file  A {@code String} that holds the name or path for the file.
     */
    public void setFile(String file) {
        this.file = this.constructPath(file);
    }


    /**
     * Public accessor for the {@code file}
     *
     * @return  A {@code String} that represents the name or path for the file.
     */
    public String getFile() {
        return this.file;
    }

    private String constructPath(String file){
        String path = FileNames.CURRENT;
        path = path.concat(File.separator + FileNames.SRC);
        path = path.concat(File.separator + FileNames.SAMPLE);
        path = path.concat(File.separator + FileNames.TEXT_FILES);

        path = path.concat(File.separator + file);

        return path;
    }

    /**
     * Method to read the contents of a file.
     *
     * @return  A {@code String} that contains all the data in the file
     *
     * <p>This returns all the data as a string, so that we can later parse the data as needed,
     * i.e. for a .txt file, .rtf file, or .csv file</p>
     */
    abstract public String readFile();
}
