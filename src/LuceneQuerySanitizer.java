import org.apache.commons.lang.StringEscapeUtils;

import java.util.regex.Pattern;

/**
 * Created by stefanwasserbauer (https://github.com/wassx) on 01.10.16.
 * Based on http://lucene.apache.org/core/2_9_4/queryparsersyntax.html#Escaping%20Special%20Characters
 *
 * Please re-test to verify security.
 */
public class LuceneQuerySanitizer {

	private final static Pattern SPECIAL_REGEX_CHARS = Pattern.compile("[\\{\\}\\(\\)\\[\\]\\+\\&\\|\\-\\~\\*\\?\\!\\:\\^\\$]");

	public static String sanitize(String query) {
		String escaped = SPECIAL_REGEX_CHARS.matcher(query).replaceAll("\\\\$0");
		escaped = escaped.replaceAll("AND", "\\A\\N\\D");
		escaped = escaped.replaceAll("OR", "\\O\\R");
		escaped = escaped.replaceAll("NOT", "\\N\\O\\T");
		return escaped;
	}
}
