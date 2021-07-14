package excel;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.file.LineSeparator;

import java.util.List;

/**
 * @author Sc
 * @date 2020/12/31
 */
public class DemoDAO {

    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入

        FileWriter writer = new FileWriter("/Users/Sc/sc/Sc/practice/src/main/java/excel/text.sql");
        writer.write("test;");
        writer.write("test;");
        writer.writeLines(list, LineSeparator.MAC, true);
    }

}
