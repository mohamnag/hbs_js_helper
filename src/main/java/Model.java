/**
 * Created by mohamnag on 15/08/16.
 */
public class Model {

    public String goodProperty() {
        // this is ok to be called
        return "Some string";
    }

    public String badProperty() {
        // this shall not be called
        throw new RuntimeException("Why did you call me?");
    }

}
