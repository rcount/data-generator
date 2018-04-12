package sample.Services;



import com.google.gson.annotations.Expose;
import sample.Models.Tablable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class OutFileService{

    //TODO: Comment File

    @Expose(serialize = false)
    private File file;

    @Expose(serialize = false)
    private int generateAmount = 0;

    @Expose(serialize = false)
    private String separator = "";

    @Expose(serialize = false)
    private String quote = "";

    @Expose(serialize = false)
    private List<Tablable> tablableList = new ArrayList<>();


    public OutFileService(File file){
        this.setFile(file);
    }

    public OutFileService(File file, int generateAmount, String separator, String quote, List<Tablable> tablables){
        this.setFile(file);
        this.setGenerateAmount(generateAmount);
        this.setSeparator(separator);
        this.setQuote(quote);
        this.setTablableList(tablables);
    }

    protected void setFile(File file){
        this.file = file;
    }

    protected void setGenerateAmount(int generateAmount) {
        this.generateAmount = generateAmount;
    }

    protected void setSeparator(String separator) {
        this.separator = separator;
    }

    protected void setQuote(String quote) {
        this.quote = quote;
    }

    protected void setTablableList(List<Tablable> tablableList) {
        this.tablableList = tablableList;
    }

    protected File getFile(){
        return this.file;
    }

    protected int getGenerateAmount() {
        return this.generateAmount;
    }

    protected String getSeparator() {
        return this.separator;
    }

    protected String getQuote() {
        return this.quote;
    }

    protected List<Tablable> getTablableList() {
        return this.tablableList;
    }

    public abstract  void writeFile();

}
