/**
 * 文件名：CodeGenerator
 * 作者：张喆
 * 时间：2020/10/30 16:05
 * 描述：
 */

package com.zz.one.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类名称:        CodeGenerator
 * 创建时间:      2020/10/30 16:05
 * 版本:          1.0
 * 说明:
 */
public class CodeGenerator {


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 生成文件的输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 开发人员
        gc.setAuthor("zz");
        // 是否打开输出的目录
        gc.setOpen(false);

        // 是否覆盖
        gc.setFileOverride(false);
        // service 命名方式。默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceName("%sService");
        //service impl 命名方式。默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setServiceImplName("%sServiceImpl");
        // 指定生成的主键的ID类型
        gc.setIdType(IdType.AUTO);
        // 时间类型对应策略
        gc.setDateType(DateType.ONLY_DATE);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);


        //2.设置数据源
        DataSourceConfig dsc=new DataSourceConfig();
        // url
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        // 数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 用户名
        dsc.setUsername("root");
        // 密码
        dsc.setPassword("y2yhsa");
        // 数据库类型
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);


        //3.设置包
        PackageConfig pc=new PackageConfig();
        //设置包名
        pc.setModuleName("generate");
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.yezhiyuan");
        //实体类包名
        pc.setEntity("domain");
        // mapper包名
        pc.setMapper("mapper");
        // service包名
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        // 自定义配置    主要是为了下面输出Mapper位置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        //4.配置策略
        StrategyConfig strategy=new StrategyConfig();
        // 要映射的表名，可以写多个
        strategy.setInclude("user","student");
        // 数据库表映射到实体的命名策略,这里用的是下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动使用lombok
        strategy.setEntityLombokModel(true);
        // 控制器类上加上@RestController
        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 给字段添加逻辑删除注解
        strategy.setLogicDeleteFieldName("deleted");

        //自动填充配置
        TableFill insert=new TableFill("create_time", FieldFill.INSERT);
        TableFill update=new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFillList=new ArrayList<>();
        tableFillList.add(insert);
        tableFillList.add(update);

        strategy.setTableFillList(tableFillList);
        // 设置乐观锁
        strategy.setVersionFieldName("version");
        // 生成RestController控制器
        strategy.setRestControllerStyle(true);
        // 开启驼峰转连接字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();
    }




}
