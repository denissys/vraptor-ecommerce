package br.com.kwikemart.utils;

import static br.com.caelum.vraptor.resource.HttpMethod.GET;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.apache.commons.validator.GenericValidator.isBlankOrNull;

import java.net.HttpURLConnection;
import java.net.URL;

public abstract class UrlChecker {

    public static boolean isValid(final String url) {
        boolean isValid = false;
        try {
            if (!isBlankOrNull(url)) {
                URL urlTest = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlTest.openConnection();
                httpURLConnection.setRequestMethod(GET.toString());
				isValid = httpURLConnection.getResponseCode() == HTTP_OK;
            }
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
}
