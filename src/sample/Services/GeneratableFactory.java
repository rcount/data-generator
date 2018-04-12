package sample.Services;

import org.omg.CORBA.PUBLIC_MEMBER;
import sample.Models.*;
import sample.Models.Interfaces.Generatable;

/**
 * Public factory class for classes that conform to {@link Generatable}.
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
public class GeneratableFactory {


    /**
     * Public static final int representing the total number of types that conform to Generatable.
     */
    public static final int GENERATABLE_COUNT = 19;

    /**
     * Public static final int representing the number to get a Binary for the Factory.
     */
    public static final int BINARY = 0;

    /**
     * Public static final int representing the number to get a Hexadecimal for the Factory.
     */
    public static final int HEXADECIMAL = 1;

    /**
     * Public static final int representing the number to get a Octal for the Factory.
     */
    public static final int OCTAL = 2;

    /**
     * Public static final int representing the number to get a NumberData for the Factory.
     */
    public static final int NUMBER_DATA = 3;

    /**
     * Public static final int representing the number to get a IPv4 for the Factory.
     */
    public static final int IPV4 = 4;

    /**
     * Public static final int representing the number to get a IPv6 for the Factory.
     */
    public static final int IPV6 = 5;

    /**
     * Public static final int representing the number to get a MacAddress for the Factory.
     */
    public static final int MAC_ADDRESS = 6;

    /**
     * Public static final int representing the number to get a ISBN10 for the Factory.
     */
    public static final int ISBN_10 = 7;

    /**
     * Public static final int representing the number to get a ISBN13 for the Factory.
     */
    public static final int ISBN_13 = 8;

    /**
     * Public static final int representing the number to get a UPC for the Factory.
     */
    public static final int UPC = 9;

    /**
     * Public static final int representing the number to get a Latitude for the Factory.
     */
    public static final int LATITUDE = 10;

    /**
     * Public static final int representing the number to get a Longitude for the Factory.
     */
    public static final int LONGITUDE = 11;

    /**
     * Public static final int representing the number to get a FirstName for the Factory.
     */
    public static final int FIRST_NAME = 12;

    /**
     * Public static final int representing the number to get a MiddleName for the Factory.
     */
    public static final int MIDDLE_NAME = 13;

    /**
     * Public static final int representing the number to get a LastName for the Factory.
     */
    public static final int LAST_NAME = 14;

    /**
     * Public static final int representing the number to get a Gender for the Factory.
     */
    public static final int GENDER = 15;


    /**
     * Public static final int representing the number to get a Currency for the Factory.
     */
    public static final int CURRENCY = 16;

    /**
     * Public static final int representing the number to get a GUID for the Factory.
     */
    public static final int GUID = 17;

    /**
     * Public static final int representing the number to get a Boolean for the Factor.
     */
    public static final int BOOLEAN = 18;

    /**
     * Public static final int representing the number to get a HexString for the Factory.
     */
    public static final int HEX_STRING = 19;

    /**
     * Public method to get a class instance that conforms to {@link Generatable}.
     *
     * @param index An {@code int} representing the number corresponding to the class we want.
     * @return      A new instance of a class conforming to {@link Generatable}.
     */
    public Generatable getGeneratable(int index){
        switch (index){
            case 0:
                return new Binary();
            case 1:
                return new Hexadecimal();
            case 2:
                return new Octal();
            case 3:
                return new NumberData();
            case 4:
                return new IPv4();
            case 5:
                return new IPv6();
            case 6:
                return new MacAddress();
            case 7:
                return new ISBN10();
            case 8:
                return new ISBN13();
            case 9:
                return new UPC();
            case 10:
                return new Latitude();
            case 11:
                return new Longitude();
            case 12:
                return new FirstName();
            case 13:
                return new MiddleName();
            case 14:
                return new LastName();
            case 15:
                return new Gender();
            case 16:
                return new Currency();
            case 17:
                return new GUID();
            case 18:
                return new DataBool();
            case 19:
                return new HexString();
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Public method to get a class instance that conforms to {@link Generatable}. This method
     * takes an {@code int} for the maximum bound for types that accept that in the constructor,
     * if they don't take an {@code int} arg then it just passes it onto {@link GeneratableFactory#getGeneratable(int)}
     *
     * @param index An {@code int} representing the number corresponding to the class we want.
     * @param max   An {@code int} representing the upper bound for the type we want.
     * @return      A new instance of a class conforming to {@link Generatable}.
     */
    public Generatable getGeneratable(int index, int max){
        switch (index){
            case 0:
                return new Binary(max);
            case 1:
                return new Hexadecimal(max);
            case 2:
                return new Octal(max);
            case 3:
                return new NumberData(max);
            case 19:
                return new HexString(max);
            case 16:
                return new Currency(max);
        }
        return this.getGeneratable(index);
    }

    /**
     * Public method to get a class instance that conforms to {@link Generatable}. This method
     * takes an {@code double} for the maximum bound for types that accept that in the constructor,
     * if they don't take an {@code int} arg then it just passes it onto {
     * @link GeneratableFactory#getGeneratable(int, int)}
     *
     * @param index An {@code int} representing the number corresponding to the class we want.
     * @param max   An {@code double} representing the upper bound for the type we want.
     * @return      A new instance of a class conforming to {@link Generatable}.
     */
    public Generatable getGeneratable(int index, double max){
        switch (index){
            case 16:
                return new Currency(max);
        }

        return this.getGeneratable(index, (int) max);
    }

    /**
     * Public method to get a class instance that conforms to {@link Generatable}. This method
     * takes an {@code int} for the minimum bound and an {@code int} for the maximum bound for types that
     * accept that in the constructor, if they don't take an two {@code int} arg then it just passes it onto
     * {@link GeneratableFactory#getGeneratable(int)}
     *
     * @param index An {@code int} representing the number corresponding to the class we want.
     * @param min   An {@code int} representing the lower bound for the type we want.
     * @param max   An {@code int} representing the upper bound for the type we want.
     * @return      A new instance of a class conforming to {@link Generatable}.
     */
    public Generatable getGeneratable(int index, int min, int max){
        switch (index){
            case 0:
                return new Binary(min, max);
            case 1:
                return new Hexadecimal(min, max);
            case 2:
                return new Octal(min, max);
            case 3:
                return new NumberData(min, max);
            case 19:
                return new HexString(min, max);
            case 16:
                return new Currency(min, max);
        }
        return this.getGeneratable(index);
    }

    /**
     * Public method to get a class instance that conforms to {@link Generatable}. This method
     * takes an {@code double} for the minimum bound and an {@code double} for the maximum bound for types that
     * accept that in the constructor, if they don't take an two {@code double} arg then it just passes it onto
     * {@link GeneratableFactory#getGeneratable(int, int, int)}
     *
     * @param index An {@code int} representing the number corresponding to the class we want.
     * @param min   An {@code double} representing the lower bound for the type we want.
     * @param max   An {@code double} representing the upper bound for the type we want.
     * @return      A new instance of a class conforming to {@link Generatable}.
     */
    public Generatable getGeneratable(int index, double min, double max){
        switch (index){
            case 16:
                return new Currency(min, max);
        }

        return this.getGeneratable(index, (int) min, (int) max);
    }
}
