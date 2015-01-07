package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cadet on 1/7/15 AD.
 */
public class FileLogger implements Logger {
    private File logFile;

    public FileLogger(File file) {
        this.logFile = file;
    }

    @Override
    public void persist(String content) {
        try {
            validateExistFile();
            writeFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateExistFile() throws IOException {
        // if file doesnt exists, then create it
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
    }

    private void writeFile(String content) throws IOException {
        FileWriter fw = new FileWriter(logFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }
}
