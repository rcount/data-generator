package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * Public Class to get the a pseudorandomly generated Latitude
 *
 * Copyright 2018 Stephen Vickers, Shane May
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public final class Latitude extends Tablable {

    //MARK: - Private members for the class -

    /**
     * Private static {@code double}  representing the minimum {@code Latitude}
     */
    private static final double LAT_MIN = -90.d;

    /**
     * Private static {@code Double} representing the maximum {@code Latitude}
     */
    private static final double LAT_MAX = 90.1d;

    /**
     * Private static final {@code String} to hold the format for the {@link DecimalFormat} of the Output.
     */
    private static final String OUTPUT_FORMAT = "#.######";

    //MARK: - Constructors for the class -

    /**
     * Private no args constructor for the {@link Latitude} class
     */
    public Latitude(){}


    /**
     * Private to get the a random {@link Latitude}. Returns a random {@code double} between  {@code Latitude.LAT_MIN} inclusive
     * and {@code Latitude.LAT_MAX} exclusive
     *
     * @return      A {@code String} that represents a random {@link Latitude} generated.
     */
    private String getLat(){
        DecimalFormat decimalFormat = new DecimalFormat(OUTPUT_FORMAT);
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        return decimalFormat.format(RandomGenerator.getDouble(LAT_MIN, LAT_MAX));
    }

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return DataType.valueOf(this.getLat());
    }
}
