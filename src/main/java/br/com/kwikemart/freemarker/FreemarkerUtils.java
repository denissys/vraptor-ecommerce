package br.com.kwikemart.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.properties.FileProperties;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class FreemarkerUtils {

    private static String DEFAULT_ENCODING = "UTF-8";
    private static String TEMPLATE_SUFIX = ".html";

	private String templateName;
	private HashMap<String, Object> data;
	private FileProperties fileProperties;
    private static Logger log = Logger.getLogger(FreemarkerUtils.class);

	public FreemarkerUtils() {
		this.fileProperties = new FileProperties(FileProperties.Type.SYSTEM);
		data = new HashMap<String, Object>();
	}

    public static String getTemplateAsString(String templateName) {

        Configuration cfg = new Configuration();
        ClassTemplateLoader loader = new ClassTemplateLoader(FreemarkerUtils.class, "templates");
        cfg.setTemplateLoader(loader);
        cfg.setDefaultEncoding(DEFAULT_ENCODING);

        Template template = null;
        try {
            template = cfg.getTemplate(templateName + TEMPLATE_SUFIX);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template.toString();

    }

    public static Template getTemplate(String templateName) {

        Configuration cfg = new Configuration();
        ClassTemplateLoader loader = new ClassTemplateLoader(FreemarkerUtils.class, "templates");
        cfg.setTemplateLoader(loader);
        cfg.setDefaultEncoding(DEFAULT_ENCODING);

        Template template = null;
        try {
            template = cfg.getTemplate(templateName + TEMPLATE_SUFIX);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return template;
    }

    public static HashMap<String, String> i18n(String propertiesFile) {

        HashMap<String, String> hash = new HashMap<String, String>();
        Set<String> keys;

        String path = FreemarkerUtils.class.getPackage().getName().replace(".", "/") + "/i18n/";

        try {
            keys = ResourceBundle.getBundle(path + propertiesFile, Locale.getDefault()).keySet();
        } catch (MissingResourceException exp) {
            log.debug(exp);
            return null;
        }

        for (String key : keys) {
            String value = ResourceBundle.getBundle(path + propertiesFile, Locale.getDefault()).getString(key);
            hash.put(key, value);
        }

        return hash;

    }

    public static String getPage(final String pagename) {
        return getPage(pagename, new HashMap<String, Object>());
    }

    public static String getPage(final String pagename, HashMap<String, Object> dataMap) {

        Template template = getTemplate(pagename);
        StringWriter out = new StringWriter();

        dataMap.put("i18n", i18n(pagename));
		dataMap.put("contextPath", new FileProperties(FileProperties.Type.SYSTEM).getString("contextPath"));

        try {
            template.process(dataMap, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();

        return out.toString();
    }

	public FreemarkerUtils createTemplate(final String templateName) {
		this.data = new HashMap<String, Object>();
		this.templateName = templateName;
		return this;
	}

	public FreemarkerUtils include(String key, Object value) {
		data.put(key, value);
		return this;
	}

	public String getPage() {

		Template template = getTemplate(templateName);
		StringWriter html = new StringWriter();

		data.put("i18n", i18n(templateName));
		data.put("contextPath", fileProperties.getString("contextPath"));

		try {
			template.process(data, html);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		html.flush();

		return html.toString();
	}

}