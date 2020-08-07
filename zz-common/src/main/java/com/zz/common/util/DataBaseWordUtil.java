/**
 * 文件名：DataBaseWordUtil
 * 作者：张喆
 * 时间：2020/8/7 14:17
 * 描述：
 */

package com.zz.common.util;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称:     zz-client-two
 * 类名称:       DataBaseWordUtil
 * 创建时间:     2020/8/7 14:17
 * 版本:         1.0
 */
@Component
public class DataBaseWordUtil {

    @Autowired
    ApplicationContext applicationContext;


    public  void main() {
        DataSource dataSourceMysql = applicationContext.getBean(DataSource.class);

        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
                .fileOutputDir("/Users/90555/Desktop")
                // 打开目录
                .openOutputDir(false)
                // 文件类型
                .fileType(EngineFileType.HTML)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker).build();

        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
        Configuration config = Configuration.builder()
                .version("1.0.3")
                .description("生成文档信息描述")
                .dataSource(dataSourceMysql)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig())
                .build();

        // 执行生成
        new DocumentationExecute(config).execute();
    }


    /**
     * 配置想要生成的表+ 配置想要忽略的表
     * @return 生成表配置
     */
    public static ProcessConfig getProcessConfig(){
        // 忽略表名
        List<String> ignoreTableName = Arrays.asList("aa","test_group");
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList("a","t");
        // 忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("_test","czb_");

        return ProcessConfig.builder()
                //根据名称指定表生成
                //.designatedTableName(new ArrayList<>())
                //根据表前缀生成
                //.designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                //.designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }
}
