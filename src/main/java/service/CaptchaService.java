package service;

import model.Captcha;
import model.Logger;
import util.Randomizer;

/**
 * Created by cadet on 1/6/15 AD.
 */
public class CaptchaService {

    private Randomizer randomizer;
    private Logger captchaLogger;

    public Captcha randomCaptcha() {
        captchaLogger.persist("Call");
        int pattern = randomizer.getPattern();
        int operator = randomizer.getOperator();
        int leftOperand = randomizer.getOperand();
        int rightOperand = randomizer.getOperand();
        Captcha captcha = new Captcha(pattern, leftOperand, operator, rightOperand);
        return captcha;
    }

    public void setRandomizer(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public void setCaptchaLogger(Logger captchaLogger){
        this.captchaLogger = captchaLogger;
    }
}
