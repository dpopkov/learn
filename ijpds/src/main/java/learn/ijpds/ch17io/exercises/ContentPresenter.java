package learn.ijpds.ch17io.exercises;

import java.io.IOException;
import java.io.InputStream;

public interface ContentPresenter {
    String getFromStream(InputStream input) throws IOException;

    byte[] toBytes(String content);
}
