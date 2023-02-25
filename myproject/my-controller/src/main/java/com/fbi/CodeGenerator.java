package com.fbi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取当前的路径
        gc.setOutputDir(projectPath + "/src/main/java");//在当前路径上加上这个路径
        gc.setAuthor("name");//添加作者信息
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);//是否覆盖文件
        gc.setServiceName("%sService");//去除服务接口service前缀
        gc.setIdType(IdType.ID_WORKER);//使用默认主键
        gc.setDateType(DateType.ONLY_DATE);//设置默认的时间格式
        gc.setSwagger2(false); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);//把全局配置放入代码生成器中

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //在这里需要改成你自己的数据库
        dsc.setUrl("jdbc:mysql://192.168.2.199:3306/myproject?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");//用户名
        dsc.setPassword("123456");//密码
        dsc.setDbType(DbType.MYSQL);//设置默认类型
        mpg.setDataSource(dsc);//将数据源配置放入代码生成器中

        // 包配置
        PackageConfig pc = new PackageConfig();
        //这里需要设置自己的包路径名
        pc.setModuleName("generate");//设置模块名
        pc.setParent("com");//设置包名，这样com.zjh.mybatis
        pc.setEntity("entity");//设置实体类的包名
        pc.setMapper("mapper");//设置持久层的包名
        pc.setService("service");//设置业务层的包名
        pc.setController("controller");//设置表现层（控制层）的包名
        mpg.setPackageInfo(pc);//将包的配置放入到自动代码生成器中

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("leader_schedule_main");//设置要包含生成的表,生成多个表以逗号相隔,例如strategy.setInclude("表1","表2");
        strategy.setNaming(NamingStrategy.underline_to_camel);//设置驼峰命名的自动映射
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//设置列名的驼峰命名自动映射
        strategy.setEntityLombokModel(true);//设置是否支持lombok
        strategy.setRestControllerStyle(true);

        strategy.setLogicDeleteFieldName("deleted");//自动配置逻辑删除字段
        //自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT);
        //创建一个list集合,把两个自动填充策略加入到这个集合
        ArrayList<TableFill> tableFill = new ArrayList<>();
        tableFill.add(gmtCreate);
        tableFill.add(gmtModified);
        strategy.setTableFillList(tableFill);//把自动填充放入到配置策略
        strategy.setVersionFieldName("version");//开启乐观锁
        strategy.setRestControllerStyle(true);//配置restful的风格的驼峰命名
        strategy.setControllerMappingHyphenStyle(true);//url多字段的/变成_下划线
        mpg.setStrategy(strategy);//把所有策略放入自动代码生成器中
        mpg.execute();//执行
    }
}
