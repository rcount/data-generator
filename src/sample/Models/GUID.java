package sample.Models;

import sample.Services.RandomGenerator;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Public class to generate a random GUID/UUID. None of the data generated in this class will repeat
 *
 * <p>Class extends {@link Tablable} and by extension implements {@link sample.Models.Interfaces.Generatable}</p>
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
public class GUID extends Tablable{



    /**
     * Private static final int to hold the maximum number of GUIDs/UUIDs to produce.
     * Since this application only produces a maximum of 1,000,000 data points, that's what we use
     */
    private static final int MAX_GUIDS = 1_000_000;

    /**
     * Private {@link HashMap} to hold the GUIDs/UUIDs produced
     */
    private HashMap<Integer, String> guids = new HashMap<>();

    /**
     * Private {@code int} to hold the count of the GUIDs/UUIDs produced and returned.
     */
    private int count = 0;

    /**
     * Private {@link List} to hold the returned numbers for the {@link GUID#guids} keys.
     */
    private List<Integer> returnedNumbers = new ArrayList<>();

    //MARK: - Constructors for the class -

    /**
     * Public no args constructor for the class
     */
    public GUID(){
        this.generateGUIDS();
    }


    //MARK: - Private methods for the class -

    /**
     * Private method to generate the GUIDs/UUIDs for the class
     */
    private void generateGUIDS(){

        while (this.guids.size() < MAX_GUIDS){
            this.guids.put(this.count, UUID.randomUUID().toString());
            this.count++;

        }
    }

    //MARK: - Methods to make the class conform to Generatable -

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        int number = RandomGenerator.getInt(this.count);
        while (this.returnedNumbers.contains(number)){
            number = RandomGenerator.getInt(this.count);
        }
        this.count--;
        this.returnedNumbers.add(number);

        return DataType.valueOf(this.guids.remove(number));
    }
}
