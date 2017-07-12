package com.example.mayc.openmind;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by mayc on 7/12/17.
 */

/*taken from https://github.com/watson-developer-cloud/conversation-with-discovery/blob/master/src/main/java/com/ibm/watson/apis/conversation_with_discovery/utils/Messages.java*/


public class Messages {
    private static final String BUNDLE_NAME = "locale/messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    /**
     * Gets the string.
     *
     * @param key the key
     * @return the string
     */
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    private Messages() { }
}
