package pl.itgolo.plugin.email.Services;

/**
 * Created by ITGolo on 10.12.2016.
 */
public class Extractor {

    /**
     * Get domain from email
     *
     * @param email email
     * @return domain email
     */
    public static String getDomain(String email) {
        if (email.contains("@")){
            return email.split("@")[1];
        } else {
            return email;
        }
    }
}
