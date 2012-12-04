package com.rcs.common.service;

import java.util.Locale;

public interface LocaleService {

    Locale[] getAvailableLocales();

    Locale[] getSortedLocales();

    Locale[] getAvailableLocales(Long companyID);

}
