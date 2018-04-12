package sample.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sample.Models.JsonXmlType;
import sample.Models.Tablable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONFileOut extends OutFileService {

    private List<JsonXmlType> mJsonXmlTypes = new ArrayList<>();

    private Logger LOG = Logger.getLogger(getClass().getName());

    public JSONFileOut(File file, int generateAmount, String separator, String quote , List<Tablable> tablable) {
        super(file, generateAmount, separator, quote, tablable);
    }

    @Override
    public void writeFile() {

        for(Tablable tablable: this.getTablableList()){
            JsonXmlType type = new JsonXmlType(tablable, this.getGenerateAmount());
            this.mJsonXmlTypes.add(type);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(this.getFile())){
            gson.toJson(this.mJsonXmlTypes, writer);

        }catch (IOException ex){
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        ;
    }
}
