package sample.Models;

import sample.Services.TextFileIn;

import java.util.Arrays;
import java.util.List;

public abstract class ISBN extends Tablable {

    public ISBN(){}

    /**
     * Private method to get the groups of the ISBN10 numbers.
     *
     * @param path  A {@code String} containing the name of the file we need to open for the
     *              correct groups, i.e. ISBN10 groups or ISBN13 groups
     * @return      A {@code List<String>} containing all the group numbers for the correct type.
     */
    protected List<String> getISBNGroups(String path){
        TextFileIn file = new TextFileIn(path);

        return Arrays.asList(file.readFile().split("\n"));
    }

    /**
     * Private static method that formats the ISBN10 number as it would appear on a bar code on a book.
     *
     * <p>An ISBN10 number of 6197499541 will appear as 6-197-49954-1.
     * An ISBN13 number of 3676144424131 will appear as 3-676144-424131.
     *
     * @param isbn  A {@code String} containing the ISBN10 number to format.
     * @return      A {@code String} containing the ISBN10 number in the correct format.
     */
    protected String isbnFormatter(String isbn, String regex, String pattern){
        return isbn.replaceAll(regex, pattern);
    }

    abstract String getISBN();
}
