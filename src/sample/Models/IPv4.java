package sample.Models;

import sample.Models.Interfaces.Generatable;
import sample.Services.RandomGenerator;

public class IPv4 extends Tablable {


    /**
     * Private static final {@code int} for the maximum a number that could be in
     * an IPv4 address.
     */
    private static final int IPV4_MAX = 256;


    public IPv4(){

    }

    /**
     * Public static method to get a pseudorandom IPv4 Internet address, that is a group of 4 numbers each
     * between 0 inclusive and 256 exclusive.
     *
     * <p>Example: {@code 127.0.0.1}</p>
     *
     * @return  A {@code String} representing a pseudorandom IPv4 internet address
     */
    private String getIPv4(){
        int firstNumber = RandomGenerator.getInt(IPV4_MAX);
        int secondNumber = RandomGenerator.getInt(IPV4_MAX);
        int thirdNumber = RandomGenerator.getInt(IPV4_MAX);
        int forthNumber = RandomGenerator.getInt(IPV4_MAX);

        return String.format("%d.%d.%d.%d", firstNumber, secondNumber, thirdNumber, forthNumber);
    }

    /**
     * Public method to generate an Data
     * @return  A new {@link DataType} instance with the data.
     */
    @Override
    public DataType generate() {
        return DataType.valueOf(this.getIPv4());
    }
}
