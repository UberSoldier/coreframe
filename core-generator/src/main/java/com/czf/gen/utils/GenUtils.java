package com.czf.gen.utils;

import com.czf.base.common.RRException;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器   工具类
 */
public class GenUtils {

    //配置信息
    private static final Configuration config = getConfig();
    private static Logger log = Logger.getLogger(GenUtils.class);

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Dao.java.vm");
        templates.add("template/Dao.xml.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/list.html.vm");
        templates.add("template/list.js.vm");
        templates.add("template/menu.sql.vm");
        return templates;
    }

    /**
     * 生成代码
     * @param table
     * @param columns
     * @param zip
     * @param genType
     */
    public static void generatorCode(Map<String, String> table, List<Map<String, String>> columns, ZipOutputStream zip, int genType) {
        //配置信息
        //Configuration config = getConfig();

        //表信息
        //TableEntity tableEntity = new TableEntity();

    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }
}
