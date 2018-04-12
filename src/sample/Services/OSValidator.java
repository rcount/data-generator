package sample.Services;

/**
 * Public class to validate the Operating System that the software is running on. This class only has static attributes
 * to call so there is no constructors. The class also calls on <code>{@link System#getProperty(String)}</code> to
 * get the type of OS that the system is running.
 *
 * <p>Class is called as <code>OSValidator.X</code> where X is the attribute you wish to call.
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
 *
 */
public class OSValidator {

    /**
     * Public static final {@code boolean} representing  the current os is {@code macOS} / {@code OSX}.
     * {@code true} if it is {@code false} if it's not
     */
    public static final boolean IS_MAC = System.getProperty("os.name").toLowerCase().startsWith("mac");

    /**
     * Public static final {@code boolean} representing  the current os is {@code Windows}.
     * {@code true} if it is {@code false} if it's not
     */
    public static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().startsWith("win");

    /**
     * Public static final {@code boolean} representing  the current os is a {@code Unix} or {@code Linux} variety.
     * {@code true} if it is {@code false} if it's not
     */
    public static final boolean IS_UNIX_LINUX = System.getProperty("os.name").toLowerCase().startsWith("nix") ||
                                                System.getProperty("os.name").toLowerCase().startsWith("nux") ||
                                                System.getProperty("os.name").toLowerCase().startsWith("aix") ||
                                                System.getProperty("os.name").toLowerCase().startsWith("sunos");


    /**
     * Public static final {@code String} to get the name of the Operating System.
     */
    public static final String OS_NAME = System.getProperty("os.name");



}
