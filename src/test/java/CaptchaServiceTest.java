import model.FileLogger;
import model.Logger;
import service.CaptchaService;
import model.Captcha;
import org.junit.Test;
import util.Randomizer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

/**
 * Created by cadet on 1/6/15 AD.
 */
public class CaptchaServiceTest {

    @Test
    public void resultShouldBe1PlusOneWhenInputIs1111() {
        CaptchaService captchaService = new CaptchaService();
        Logger captchaLogger = mock(FileLogger.class);

        captchaService.setRandomizer(getRandomizer());
        captchaService.setCaptchaLogger(captchaLogger);
        Captcha captcha = captchaService.randomCaptcha();

        assertEquals("1 + One", captcha.getLeft() + " " + captcha.getOperator() + " " + captcha.getRight());
    }

    @Test
    public void resultShouldBe2PlusOneWhenInputIs1211() {
        CaptchaService captchaService = new CaptchaService();
        Logger captchaLogger = mock(FileLogger.class);

        captchaService.setRandomizer(getRandomizer());
        captchaService.setCaptchaLogger(captchaLogger);
        Captcha captcha = captchaService.randomCaptcha();

        assertEquals("1 + One", captcha.getLeft() + " " + captcha.getOperator() + " " + captcha.getRight());
    }


    @Test
    public void verifyLoggerPersisShouldBeCalledOneTimeWhenRandomCaptcha(){
        CaptchaService captchaService = new CaptchaService();
        Logger captchaLogger = mock(FileLogger.class);

        captchaService.setRandomizer(new Randomizer());
        captchaService.setCaptchaLogger(captchaLogger);
        captchaService.randomCaptcha();

        verify(captchaLogger, times(1)).persist(anyString());
    }

    public static Randomizer getRandomizer() {
        Randomizer randomizer = mock(Randomizer.class);
        when(randomizer.getPattern()).thenReturn(1);
        when(randomizer.getOperator()).thenReturn(1);
        when(randomizer.getOperand()).thenReturn(1);

        return randomizer;
    }


}
