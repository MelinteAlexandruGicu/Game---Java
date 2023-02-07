package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*! \class Utils
    \brief Clasa pentru functii statice utilitare.

 */
public class Utils {

    /*! \fn public static String loadFileAsString(String path)
       \brief Incarca o variabila de tip FileReader sub forma de String.
    */
    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line + "\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /*! \fn public static int parseInt(String number)
       \brief Converteste un String intr-un Integer.
    */
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
