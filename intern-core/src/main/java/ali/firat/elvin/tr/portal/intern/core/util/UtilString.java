package ali.firat.elvin.tr.portal.intern.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ocekmez on 4/20/2016.
 */
public class UtilString {

    public static String getKeyValueFromXmlString(String tag, String text) {
        Matcher matcher = Pattern.compile(tag + ".*>(.*)<").matcher(text);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }

        return null;
    }
}
