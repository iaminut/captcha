package controller;

import model.Captcha;
import service.CaptchaService;
import util.Randomizer;

/**
 * Created by cadet on 1/7/15 AD.
 */
public class CaptchaController {


    private CaptchaService captchaService;

    public String getCaptcha(){
        Captcha captcha = captchaService.randomCaptcha();
        return  captcha.getLeft() + " " + captcha.getOperator() + " " + captcha.getRight();
    }

    public CaptchaService getCaptchaService(){
        return captchaService;
    }

    public void setCaptchaService(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }



}


