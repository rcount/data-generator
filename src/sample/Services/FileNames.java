package sample.Services;

/**
 * Public class to access the names of the text files used in this program.
 *
 * <p>This class is called as {@code FileNames.X} where X is the name of the File you wish to open</p>
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
public final class FileNames {

    //MARK: - Public attributes for the FileNames class

    public static final String CURRENT = System.getProperty("user.dir");

    public static final String SRC = "src";

    public static final String SAMPLE = "sample";

    public static final String TEXT_FILES = "TextFiles";

    /**
     * Public static final {@code String} to access the name of the {@code NameService.csv} file
     */
    public static final String NAMES = "Names.csv";

    /**
     * Public static final {@code String} to access the name of the {@code CityCountries.csv} file.
     */
    public static final String CITY_STATES = "CityStates.csv";

    /**
     * Public static final {@code String} to access the name of the {@code AboutFile.txt} file
     */
    public static final String ABOUT = "AboutFile.txt";

    /**
     * Public static final {@code String} to access the name of the {@code License.txt} file.
     */
    public static final String LICENSE = "License.txt";

    public static final String GS1_NUMBERS = "GS1_Numbers.txt";

    public static final String ISBN10_GROUPS = "ISBN10_groups.txt";


    //MARK: - Constructors for the FileNames class -

    /**
     * Private no args constructor for the {@code FileNames} class.
     * This allows the class to be called as a static class`
     */
    private FileNames(){}
}
