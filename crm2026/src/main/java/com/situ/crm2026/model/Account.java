package com.situ.crm2026.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String username;
    private String password;
    private String captcha;//验证码
    private String captchaId;//验证码Id
}
