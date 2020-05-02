/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.web.xbcatalogweb.faces;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Language controller.
 *
 * @version 0.1.24 2015/01/30
 * @author ExBin Project (http://exbin.org)
 */
@Controller
@Scope("view")
@Qualifier("language")
public final class LanguageBacking implements Serializable {

    private static final long serialVersionUID = 1L;
    private String localeCode;
    private static Map<String, Object> countries;

    public LanguageBacking() {
        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH);
        countries.put("Česky", Locale.forLanguageTag("cs_CZ"));
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {

                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());

            }
        }
    }
}
