package com.ldx.springboot_thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocaleResolve implements LocaleResolver {
    //自定义区域解析方式
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = null;
        if(!StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
        }else {
            String header = httpServletRequest.getHeader("Accept-Language");
            String[] split = header.split(",");
            String[] split1 = split[0].split("-");
            locale = new Locale(split1[0], split1[1]);
        }



        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolve();
    }

}
