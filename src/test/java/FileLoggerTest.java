import model.Logger;
import org.junit.Ignore;
import org.junit.Test;
import model.FileLogger;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


import java.io.File;

/**
 * Created by cadet on 1/7/15 AD.
 */
public class FileLoggerTest {

    @Test
    @Ignore
    public void testWriteLog() throws Exception {
        File logFile = getLogFile();
        Logger captchaLogger = new FileLogger(logFile);

        captchaLogger.persist("Write Log");


        verify(logFile, times(1)).createNewFile();
    }


    public static File getLogFile(){
        File logfile = mock(File.class);
        when(logfile.exists()).thenReturn(false);

        return logfile;
    }
}
