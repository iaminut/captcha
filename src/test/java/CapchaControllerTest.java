import model.FileLogger;
import model.Logger;
import org.junit.Rule;
import org.junit.Test;
import controller.CaptchaController;
import org.junit.rules.ExpectedException;
import service.CaptchaService;
import util.Randomizer;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by cadet on 1/7/15 AD.
 */
public class CapchaControllerTest {
    @Test
    public void whenGetCaptchaShouldBeReturnCaptchaString() {
        CaptchaController captchaController = new CaptchaController();
        CaptchaService captchaService = new CaptchaService();
        Logger captchaLogger = mock(FileLogger.class);
        captchaService.setCaptchaLogger(captchaLogger);
        captchaService.setRandomizer(getRandomizer());


        captchaController.setCaptchaService(captchaService);
        assertEquals("1 + One", captchaController.getCaptcha());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void captchaServiceShouldNotBeNullWhenGetCaptchaIsCalled() {
        CaptchaController captchaController = new CaptchaController();
        expectedException.expect(NullPointerException.class);
        captchaController.getCaptcha();
    }

    public static Randomizer getRandomizer() {
        Randomizer randomizer = mock(Randomizer.class);
        when(randomizer.getPattern()).thenReturn(1);
        when(randomizer.getOperator()).thenReturn(1);
        when(randomizer.getOperand()).thenReturn(1);
        return randomizer;
    }

}
