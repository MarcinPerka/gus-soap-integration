package com.archu.gussoapintegration.config.locale;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {


    private final List<Locale> LOCALES = List.of(new Locale("en"), new Locale("pl"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (!StringUtils.hasText(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE))) {
            return Locale.getDefault();
        }
        var list = Locale.LanguageRange.parse(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
        return Locale.lookup(list, LOCALES);
    }

}