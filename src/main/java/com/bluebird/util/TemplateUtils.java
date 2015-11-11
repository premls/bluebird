package com.bluebird.util;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateUtils {
	private Configuration cfg = null;

	private static TemplateUtils _instance;

	public static synchronized TemplateUtils getInstance() {
		if (null == _instance) {
			_instance = new TemplateUtils();
		}
		return _instance;
	}

	private TemplateUtils() {
		cfg = new Configuration();
	}


	public String processContent(String ftlName, Object dataModel) throws Exception {
//		cfg.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/templates/email"));
		Template template = cfg.getTemplate(ftlName + ".ftl");
		Writer writer = new StringWriter();
		template.process(dataModel, writer);
		String content = writer.toString();
		return content;
	}

	public String processSubject(String subject) throws Exception {
		Map<String, String> subjectMap = new HashMap<String, String>();
		return processSubject(subject, subjectMap);
	}
	
	public String processSubject(String subject,Map<String, String> subjectMap)throws Exception {
		cfg.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/templates/email"));
		subjectMap.put("subject", subject);
		Template template = cfg.getTemplate("subjects.ftl");
		Writer writer = new StringWriter();
		template.process(subjectMap, writer);
		return writer.toString();
	}
}
