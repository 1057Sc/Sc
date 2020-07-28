package generate;

import cn.hutool.core.util.StrUtil;
import generate.scan.PackageScan;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据实体生成sql文件
 */
public class GenerateMySQl {


    public static Map<String, String> property2SqlColumnMap = new HashMap<>();

    public static String path = "/Users/sc/Code/java/Sc/practice/src/main/java/generate/sql/";

    static {
        property2SqlColumnMap.put("integer", "INT");
        property2SqlColumnMap.put("int", "INT");
        property2SqlColumnMap.put("short", "tinyint");
        property2SqlColumnMap.put("long", "bigint");
        property2SqlColumnMap.put("bigdecimal", "decimal(19,2)");
        property2SqlColumnMap.put("double", "double precision not null");
        property2SqlColumnMap.put("float", "float");
        property2SqlColumnMap.put("boolean", "bit");
        property2SqlColumnMap.put("timestamp", "datetime");
        property2SqlColumnMap.put("date", "datetime");
        property2SqlColumnMap.put("string", "VARCHAR(20)");
    }


    public static String generateSql(String className, String primaryKey) {
        try {
            Class<?> clz = Class.forName(className);
            className = clz.getSimpleName();
            String tableName = StrUtil.toUnderlineCase(className);
            Field[] fields = clz.getDeclaredFields();
            StringBuffer column = new StringBuffer();
            for (Field f : fields) {
                if (f.getName().equals(primaryKey)) {
                    continue;
                }
                //column.append(" \n `"+f.getName()+"`").append(varchar);
                column.append(getColumnSql(f));
            }

            // 去除多余的 逗号
            // column = column.replace(column.length() - 1, column.length(), "");
            // String sqlPrimaryKey = StringUtils.camelToUnderline(primaryKey).toUpperCase();
            String sqlPrimaryKey = (primaryKey);
            StringBuffer sql = new StringBuffer();
            sql.append("\n DROP TABLE IF EXISTS `" + tableName + "`; ")
                    .append(" \n CREATE TABLE `" + tableName + "`  (")
                    // .append(" \n `" + sqlPrimaryKey + "` bigint(20) NOT NULL AUTO_INCREMENT,")
                    .append(" \n `" + sqlPrimaryKey + "` varchar(20) NOT NULL AUTO_INCREMENT,")
                    .append(" \n " + column)
                    .append(" \n PRIMARY KEY (`" + sqlPrimaryKey + "`)")
                    .append(" \n ) ENGINE = InnoDB ;");
            // AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci
            String sqlText = sql.toString();
            StringToSql(sqlText, path + tableName);
            return sqlText;
        } catch (ClassNotFoundException e) {
            // log.debug("SQL生成异常：", e);
            return null;
        }
    }

    private static String getColumnSql(Field field) {
        String tpl = "\n `%s` %s DEFAULT NULL,";
        String typeName = field.getType().getSimpleName().toLowerCase();
        String sqlType = property2SqlColumnMap.get(typeName);

        if ("serialVersionUID".toLowerCase().equals(typeName)) {
            return null;
        }

        if (sqlType == null || sqlType.isEmpty()) {
            // log.info(field.getName() + ":"+field.getType().getName()+" 需要单独创建表");
            return "";
        }
        // String column = StringUtils.camelToUnderline(field.getName()).toUpperCase();
        String column = field.getName();
        String sql = String.format(tpl, column, sqlType.toUpperCase());
        return sql;
    }

    private static void StringToSql(String str, String path) {
        byte[] sourceByte = str.getBytes();
        if (null != sourceByte) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);
                outStream.write(sourceByte);
                outStream.flush();
                outStream.close();
                System.out.println("生成成功");
            } catch (Exception e) {
                // log.debug("保存SQL文件异常：", e);
                e.printStackTrace();
            }
        }
    }

    private static void testFileDirOrName(String path) {
        File dirFile = new File(path);
        if (dirFile.exists()) {
            File[] files = dirFile.listFiles();
            if (files != null) {
                for (File fileChildDir : files) {
                    //输出文件名或者文件夹名
                    System.out.print(fileChildDir.getName());
                    if (fileChildDir.isDirectory()) {
                        System.out.println(" :  此为目录名");
                        //通过递归的方式,可以把目录中的所有文件全部遍历出来
                        testFileDirOrName(fileChildDir.getAbsolutePath());
                    }
                    if (fileChildDir.isFile()) {
                        System.out.println(" :  此为文件名");
                    }
                }
            }
        } else {
            System.out.println("你想查找的文件不存在");
        }
    }

    public static void main(String[] args) {
        List<String> classNames = PackageScan.getClassName("generate.entity");
        for (String clazzName : classNames) {
            generateSql(clazzName, "id");
        }
    }

}
