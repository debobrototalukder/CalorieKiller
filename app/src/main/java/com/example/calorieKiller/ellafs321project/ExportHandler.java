package com.example.calorieKiller.ellafs321project;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import android.widget.Toast;

public class ExportHandler implements Observer{
    private static ExportHandler export = new ExportHandler();

    private PrintStream ps;
    private File file;
    /** Time of the first data received */
    private long startTime;

    public void start(MainActivity mainActivity){
        String suffix = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        File dir = mainActivity.getBaseContext().getFilesDir();
        file = new File(dir,"polar"+suffix+".txt");
        try {
            ps = new PrintStream(file);
            ps.println("76");
            //ps.println("76");
            //ps.println("80");
            //ps.println("183");
            //ps.println("183");
            //ps.println(suffix);
            Toast.makeText(mainActivity.getBaseContext(),
                    "Save data to dir: "+dir.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            DataHandler.getInstance().addObserver(this);
        } catch (Exception e) {
            Toast.makeText(mainActivity.getBaseContext(),
                    "Can't write to file: "+file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public static ExportHandler getInstance(){
        return export;
    }

    @Override
    public void update(Observable observable, Object data) {
        receiveData();
    }

    private void receiveData() {
        String value = DataHandler.getInstance().getLastValue();
        if (startTime==0L){
            // there is small diff between time in the file header and this actual startTime
            startTime = System.currentTimeMillis();
        }
        long time = System.currentTimeMillis() - startTime;
        ps.println(value);
        //ps.println(value+";"+format(time));
    }
    /** Format time in millis to hh:mm:ss */
    private String format(long time) {
        long timeInSec = time / 1000;
        long hrs = timeInSec / 60 / 60;
        long mins = (timeInSec - hrs * 60 * 60 ) / 60;
        long sec = timeInSec - mins * 60;
        return hrs+":"+mins+":"+sec;
    }

    public void close() {
        if (ps!=null)
            ps.close();
        DataHandler.getInstance().deleteObserver(this);
    }

    public String getFileName() {
        return file.toString();

    }
}