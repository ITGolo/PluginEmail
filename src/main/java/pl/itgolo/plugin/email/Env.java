package pl.itgolo.plugin.email;

import pl.itgolo.plugin.email.Exceptions.PropertyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by ITGolo on 10.12.2016.
 */
public class Env {

    /**
     * Get property from .ENV file
     * @param propertyName property name
     * @return property value
     * @throws PropertyException failed get property from file
     */
    public static String getProperty(String propertyName) throws PropertyException {
        String propertyResult = null;
        String propertyFile = "ENV.properties";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(propertyFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyResult = properties.getProperty(propertyName);
        } catch (IOException e) {
            // exceptions get property is defined below for null variable propertyResult
        } finally {
            if (Objects.nonNull(inputStream)){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // exception close input stream is not require
                }
            }
        }
        if (Objects.isNull(propertyResult)){
            throw new PropertyException(String.format("Failed get property from file %1$s.", propertyFile));
        }
        return propertyResult;
    }
}
