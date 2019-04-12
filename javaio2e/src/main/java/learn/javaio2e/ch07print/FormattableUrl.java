package learn.javaio2e.ch07print;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class FormattableUrl implements Formattable {
    private final URL delegate;

    public FormattableUrl(URL url) {
        delegate = url;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        if (precision < -1) {
            throw new IllegalFormatPrecisionException(precision);
        }
        if (width < -1) {
            throw new IllegalFormatWidthException(width);
        }
        if (precision > width) {
            throw new IllegalFormatPrecisionException(precision);
        }
        int recognizedFlags = FormattableFlags.UPPERCASE | FormattableFlags.LEFT_JUSTIFY;
        boolean unsupportedFlags = ((~recognizedFlags) & flags) != 0;
        if (unsupportedFlags) {
            throw new IllegalFormatFlagsException("#");
        }
        boolean upperCase = (flags & FormattableFlags.UPPERCASE) != 0;
        StringBuilder sb = new StringBuilder();
        String scheme = delegate.getProtocol();
        if (upperCase && scheme != null) {
            scheme = scheme.toUpperCase(Locale.ENGLISH);
        }
        String hostname = delegate.getHost();
        if (upperCase && hostname != null) {
            hostname = hostname.toUpperCase(Locale.ENGLISH);
        }
        String userInfo = delegate.getUserInfo();
        int port = delegate.getPort();
        String path = delegate.getPath();
        String query = delegate.getQuery();
        String fragment = delegate.getRef();
        appendBefore(sb, scheme, "://");
        appendBefore(sb, userInfo, "@");
        if (hostname != null) {
            sb.append(hostname);
        }
        if (port != -1) {
            sb.append(":").append(port);
        }
        if (path != null) {
            sb.append(path);
        }
        appendAfter(sb, '?', query);
        appendAfter(sb, '#', fragment);
        boolean leftJustify = (flags & FormattableFlags.LEFT_JUSTIFY) != 0;
        if (precision < sb.length()) {
            sb.setLength(precision);
        } else {
            while (sb.length() < width) {
                if (leftJustify) {
                    sb.append(' ');
                } else {
                    sb.insert(0, ' ');
                }
            }
        }
        formatter.format(sb.toString());
    }

    private void appendBefore(StringBuilder sb, String part, String suffix) {
        if (part != null) {
            sb.append(part).append(suffix);
        }
    }

    private void appendAfter(StringBuilder sb, char prefix, String part) {
        if (part != null) {
            sb.append(prefix).append(part);
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.example.org/index.html?name=value#Fred");
        System.out.printf("%60.40S%n", new FormattableUrl(url));
    }
}
