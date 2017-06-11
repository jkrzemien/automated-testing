package com.jkrzemien.automation.texts;

import static com.jkrzemien.automation.texts.Dictionary.DICTIONARY;

public class Texts {

    private Texts() {
    }

    public static String Sample_Multi_Locale_Text() {
        return DICTIONARY.get("search.text");
    }

}
