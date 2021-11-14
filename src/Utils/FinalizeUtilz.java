package Utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FinalizeUtilz {

    public static void openTextFile(File file) throws IOException {


        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().edit(file);
        }

    }
}
