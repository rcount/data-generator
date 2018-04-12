package sample.Services.CSVService;

import sample.Services.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Public class to parse a {@code .csv} file that is read in.
 * all Types that use this class must conform to {@link CSVParsable}
 *
 * @param <T>   Type parameter that conforms to {@link CSVParsable}
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
public class CSVFileParser<T extends CSVParsable>{

    //MARK: - Private attributes for the CSVFileParser class -

    /**
     * Private instance of {@code Logger} to log things to the console.
     */
    private Logger LOG = Logger.getLogger(CSVFileParser.class.getName());


    /**
     * Private {@code String} to hold the {@code Path} of the {@code File}
     */
    private String file;

    /**
     * Private {@code Class<T>} instance to get the class of the {@code CSVFileParser#T} type
     */
    private Class<T> clazz;

    //MARK: - Constructors for the CSVFileParser class -

    /**
     * Public constructor for the {@code CSVFileParser} class
     * @param clazz         The {@code Type} for the {@link CSVFileParser#clazz} parameter
     * @param filePath      A {@code Path} containing the path to the file to read.
     */
    public CSVFileParser(Class<T> clazz, Path filePath){
        this(clazz, filePath.toString());
    }


//    public CSVFileParser(Class<T> clazz, FileNames... fileParts){
//        String path = fileParts[0].toString();
//
//        for(int index = 1; index < fileParts.length; index++){
//            path = path.concat(File.separator + fileParts[index].toString());
//        }
//
//        path = path.concat(FileNames.CSV);
//
//        this.setClazz(clazz);
//        this.setFile(path);
//    }

    /**
     * Public constructor for the {@code CSVFileParser} class
     * @param clazz         The {@code Type} for the {@link CSVFileParser#clazz} parameter
     * @param filePath      A {@code String} containing the path to the file to read.
     */
    public CSVFileParser(Class<T> clazz, String filePath){

        this.setClazz(clazz);
    }

    //MARK: - Public assessors and mutators for the CSVFileParser class -

    /**
     * Public mutator to set the {@link CSVFileParser#clazz} attribute
     *
     * @param clazz     The {@code Class} for the {@code clazz} attribute
     */
    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Public mutator to set the {@link CSVFileParser#file} attribute
     *
     * @param file  A {@code String} for the {@code path} of the file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Public assessor for the {@link CSVFileParser#clazz} attribute
     *
     * @return  The {@code Class} contained in the {@link CSVFileParser#clazz} attribute.
     */
    public Class<T> getClazz() {
        return this.clazz;
    }

    /**
     * Public assessor for the {@link CSVFileParser#file} attribute
     *
     * @return  A {@code String} contained in the {@link CSVFileParser#file} attribute.
     */
    public String getFile() {
        return this.file;
    }

    /**
     * Public method to get all the data contained in the {@link CSVFileParser#file}
     *
     * @return  A {@code List<T>} containing all the data from the file
     */
    public List<T> getData(){
       return this.parseData();
    }

    /**
     * Public method to get a certain number of of items from the {@link CSVFileParser#file}
     *
     * @param number    An {@code int} containing the number of items we want to get.
     * @return          A {@code List<T>} containing the number of items we want to get.
     */
    public List<T> getData(int number){
        List<T> temp = this.parseData();

        int start = RandomGenerator.getInt(temp.size() - number);

        return temp.subList(start, start + number);
    }

    /**
     * Private method to parse the data from a {@code .csv} file contained in {@link CSVFileParser#file}
     *
     * @return  A {@code List<T>} containing the data from the {@link CSVFileParser#file}
     */
    private List<T> parseData(){

        //open a new TextFile. Since a {@code .csv} file is nothing more than a text file this will not fail,
        //assuming the path to the file is correct
        TextFileIn file = new TextFileIn(this.getFile());

        //get the content of the file in a String array, split on a new line.
        String[] content = file.readFile().split("\n");

        //create a list of items to parse
        List<T> parsableList = new ArrayList<>();

        //for every line in the content array iterate over them and parse the data
        for (String line : content){
            try{
                //Try to create a new instance of T and parse the current line
                //into it. Since every type that uses the {@code CSVFileParser}
                //has to conform to {@code CSVParsable} we know that they have a .parse(String) method
                T temp = this.newInstance();
                temp.parse(line);

                //add the new item to the parsableList
                parsableList.add(temp);

            }catch (Exception ex){
                //catch an Exception thrown from this.newInstance() and log it
                LOG.log(Level.SEVERE, ex.getMessage());
            }
        }

        //return the new list of items.
        return  parsableList;
    }



    /**
     * Private instance to get a new instance of the class contained in {@link CSVFileParser#clazz} attribute
     * This is used as a Class Factory to create new instances
     *
     * @return              A new instance of the Class contained in {@link CSVFileParser#clazz}
     * @throws Exception    An exception thrown if a new instance can't be created.
     */
    private T newInstance() throws Exception{
        return this.getClazz().newInstance();
    }

}
