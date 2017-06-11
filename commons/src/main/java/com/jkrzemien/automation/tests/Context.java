package com.jkrzemien.automation.tests;

import com.jkrzemien.automation.languages.Language;

/**
 * @author Juan Krzemien
 */
public interface Context {

    void init();

    void destroy();

    Language getLanguage();

    String getToken();

    void setToken(String token);

}
