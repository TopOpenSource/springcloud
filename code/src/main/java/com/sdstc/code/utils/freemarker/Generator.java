package com.sdstc.code.utils.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import com.sdstc.code.model.Table;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public abstract class Generator {

	protected abstract void proccess(Table table);

	public void genarator(Object table, String outPath, String ftlPath) throws Exception {
		Configuration configuration = new Configuration(Configuration.getVersion());
		TemplateLoader ctl = new ClassTemplateLoader(GeDao.class, "/");
		configuration.setTemplateLoader(ctl);
		Template template = configuration.getTemplate(ftlPath);
		Writer out = new FileWriter(new File(outPath));
		template.process(table, out);
		out.close();
	}
}
