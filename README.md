# data-generator

#Data Generator

This program is used to generate pseudo random data and store it in a file for later processing.

The available file types currently are:
- .csv
- .txt
- .json
- .xml

[Gson](https://github.com/google/gson) is used for the JSON formatting.

#Notes

If you want to add a type to the generatable types you must provide the POJO, that class
must extend the Tablable class, which through inheritance will have to implement the
Generatable interface. You need to provide a name inside the resource.properties files
then add a public static final String for that to be called to ResourceNames.DataTypes inside
the ResourceNames file.

After that you must add a public static final int for that type to the GeneratableFactory
class and update the methods to return a Generatable from there. If you do not do these
steps then the application will not work.

#Licence 

Licenced under the [MIT License](https://opensource.org/licenses/MIT) except for the Gson, which is under [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).

Copyright 2018 Stephen Vickers, Shane May

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
