package sedpackagename.androidextra;

import android.annotation.SuppressLint;
import java.util.Locale;
import javax.net.ssl.SSLException;

public class AndroidLibHelper {

	public static String extractCN(final String subjectPrincipal) throws SSLException {
		return null;
	}
	
	@SuppressLint("NewApi") 
	public static Locale getRootLocale() {
		if ( android.os.Build.VERSION.SDK_INT < 9 ) {
			return Locale.ENGLISH;
		} else {
			return Locale.ROOT;
		}
	}
}
