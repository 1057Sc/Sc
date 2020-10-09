package org.sc.gen;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;


import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class GeneratorUtil {
       public static void main(String[] args) throws Exception {
           List<String> warnings = new ArrayList<String>();
           boolean overwrite = true;
           ConfigurationParser cp = new ConfigurationParser(warnings);
           Configuration config =
                   cp.parseConfiguration(getResourceAsStream("generatorConfig.xml"));
           DefaultShellCallback callback = new DefaultShellCallback(overwrite);
           MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
           myBatisGenerator.generate(null);
           for (String warning : warnings) {
               System.out.println(warning);
           }
       }
/*    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(GeneratorUtil.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));
        // 解决IDEA下运行，多个模块路径冲突问题
        String cpath = GeneratorUtil.class.getClassLoader().getResource("generatorConfig.xml").toString();
        cpath = cpath.substring(0, cpath.indexOf("target")).replace("file:/", "");
        Context context = config.getContexts().get(0);
        context.getJavaModelGeneratorConfiguration().setTargetProject(cpath + context.getJavaModelGeneratorConfiguration().getTargetProject());
        context.getSqlMapGeneratorConfiguration().setTargetProject(cpath + context.getSqlMapGeneratorConfiguration().getTargetProject());
        context.getJavaClientGeneratorConfiguration().setTargetProject(cpath + context.getJavaClientGeneratorConfiguration().getTargetProject());
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }*/

}
