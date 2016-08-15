import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.FieldValueResolver;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.context.MethodValueResolver;
import com.github.jknack.handlebars.io.FileTemplateLoader;

import java.io.File;

/**
 * Created by mohamnag on 15/08/16.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Handlebars handlebars = new Handlebars(new FileTemplateLoader("."));
        handlebars.registerHelpers(new File("src/main/resources/js_helper.js"));

        Context context = Context
                .newBuilder(new Model())
                .resolver(
                        MethodValueResolver.INSTANCE,
                        MapValueResolver.INSTANCE,
                        FieldValueResolver.INSTANCE,
                        JavaBeanValueResolver.INSTANCE
                )
                .build();

        Template template = handlebars.compile("src/main/resources/template");
        template.apply(context);
    }

}
