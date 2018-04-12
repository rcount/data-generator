package sample.Services;

import sample.Models.Name;
import sample.Services.CSVService.CSVParsable;

import java.util.ArrayList;
import java.util.List;

/**
 * Public final class to get details about a NameService. This class conforms to {@link CSVParsable} because the data is read in
 * from a {@code .csv} file and needs to be parsed while doing it.
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
public final class NameService {


    //MARK: - Private attributes for the NameService class -

    /**
     * Private {@link Name} instance to hold a first name of a NameService
     */
    private List<Name> firstNames = new ArrayList<>();

    /**
     * Private {@link Name} instance to hold a middle name of a NameService
     */
    private List<Name> middleNames = new ArrayList<>();

    /**
     * Private {@link Name} instance to hold a last name of a person
     */
    private List<Name> lastNames = new ArrayList<>();



    //MARK: - Constructors for the NameService Class -

    /**
     * Public no args constructor for the {@code NameService} class
     */
    public NameService(){
        this.getNames();
    }


    //MARK: - Public methods for the NameService class -

    /**
     * Public mutator for the {@link NameService#firstNames} attribute
     *
     * @param firstName     A {@code String} containing the first name of a person
     */
    public void addFirstName(String firstName) {
        this.firstNames.add(Name.newInstance(firstName));
    }

    /**
     * Public mutator for the {@link NameService#middleNames} attribute
     *
     * @param middleName    A {@code String} containing the middle name of a person
     */
    public void addMiddleName(String middleName) {
        this.middleNames.add(Name.newInstance(middleName));
    }

    /**
     * Public mutator for the {@link NameService#lastNames} attribute
     *
     * @param lastName      A {@code String} containing the last name of a person
     */
    public void addLastName(String lastName) {
        this.lastNames.add(Name.newInstance(lastName));
    }


    /**
     * Public assessor for the {@link NameService#firstNames} attribute.
     *
     * @return  A {@link List<Name>} representing the first name of a person.
     */
    public List<Name> getFirstNames() {
        return this.firstNames;
    }

    /**
     * Public assessor for the {@link NameService#middleNames} attribute.
     *
     * @return  A {@link List<Name>} representing the middle name of a person.
     */
    public List<Name> getMiddleNames() {
        return this.middleNames;
    }

    /**
     * Public assessor for the {@link NameService#lastNames} attribute.
     * @return  A {@link List<Name>} representing the last name of a person.
     */
    public List<Name> getLastNames() {
        return this.lastNames;
    }

    /**
     * private method to get the {@code File} containing all the names.
     *
     * @return  A {@code String} with the name of the file from {@link FileNames#NAMES} attribute.
     */
    private String getFile() {
        return FileNames.NAMES;
    }

    /**
     * Private void method to get all the names from the Data Store.
     */
    private void getNames(){
        TextFileIn file = new TextFileIn(this.getFile());

        String[] content = file.readFile().split(System.lineSeparator());

        for(String line : content){
            String[] names = line.split(",");
            this.addFirstName(names[0]);
            this.addMiddleName(names[1]);
            this.addLastName(names[2]);
        }
    }
}
