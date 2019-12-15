package com.news.hr.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.news.hr.framework.constant.DefaultField;

import java.io.File;
import java.util.*;

public class MpGenerator {
  //前端首页生成地址
  private static final String DISK_HTML = "D://test//html//";
  private static final String DISK_JAVA = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"java";

  private static final String PARENT = "com.news.hr";
  private static final String MODULE_NAME = "system";
  private static final String PARENT_PATH = "com/news/hr";
  //后端控制器以及服务生成地址
  private static final String AUTHOR = "Chen Seen";
  private static final String[] include = {"sys_access_log","sys_dict","sys_log_exception","sys_file","sys_group","sys_log_info","sys_menu","sys_message",
          "sys_message_user","sys_notice","sys_notice_user","sys_operation","sys_org","sys_permission","sys_post","sys_region","sys_role",
          "sys_sequence","sys_user_group"};
//  private static final String[] include = {"tbl_content","tbl_contribution","tbl_enterprise","tbl_level","tbl_link_manage","tbl_news_info","tbl_news_recommend","tbl_newsman"};

  /**
   * <p>
   * MySQL 生成演示
   * </p>
   */
  public static void main(String[] args) {
    final AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    final GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir(DISK_JAVA);
    gc.setFileOverride(true);
    // 不需要ActiveRecord特性的请改为false
    gc.setActiveRecord(true);
    // XML 二级缓存
    gc.setEnableCache(false);
    // XML ResultMap
    gc.setBaseResultMap(true);
    // XML columnList
    gc.setBaseColumnList(true);
    gc.setSwagger2(true);
    //是否生成 kotlin 代码
    //gc.setKotlin(true);
    gc.setAuthor(AUTHOR);
    gc.setIdType(IdType.UUID);

    // 自定义文件命名，注意 %s 会自动填充表实体属性！
     gc.setMapperName("%sMapper");
     gc.setXmlName("%sMapper");
     gc.setServiceName("%sService");
     gc.setServiceImplName("%sServiceImpl");
     gc.setControllerName("%sController");
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setTypeConvert(new MySqlTypeConvert() {
      // 自定义数据库表字段类型转换【可选】
      public IColumnType processTypeConvert(String fieldType) {
        System.out.println("转换类型：" + fieldType);
        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。

        return super.processTypeConvert(gc, fieldType);
      }
    });
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("ChengS#1988");
    dsc.setUrl("jdbc:mysql://localhost:3306/news_union?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai");
    mpg.setDataSource(dsc);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
    strategy.setTablePrefix(new String[] { "tbl", "sys", "examples" });// 此处可以修改为您的表前缀
    strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setInclude(include); // 需要生成的表
    strategy.setEntityColumnConstant(false);
    strategy.setEntityTableFieldAnnotationEnable(true);
    strategy.setLogicDeleteFieldName(DefaultField.delFlag);
    strategy.setTableFillList(getTableFills());

    mpg.setStrategy(strategy);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent(PARENT);
    pc.setModuleName(MODULE_NAME);
    pc.setController("controller");
    pc.setEntity("bean.po");
    mpg.setPackageInfo(pc);

    // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】  ${cfg.abc}
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("query", PARENT+"."+this.getConfig().getPackageInfo().get("ModuleName") + ".bean.query");
        map.put("vo", PARENT+"."+this.getConfig().getPackageInfo().get("ModuleName") + ".bean.vo");
        map.put("form", PARENT+"."+this.getConfig().getPackageInfo().get("ModuleName") + ".bean.form");
        map.put("dto", PARENT+"."+this.getConfig().getPackageInfo().get("ModuleName") + ".bean.dto");
        map.put("convert", PARENT+"."+this.getConfig().getPackageInfo().get("ModuleName") + ".bean.convert");
        this.setMap(map);
      }
    };

    // 自定义 xxListIndex.html 生成
    List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
    focList.add(new FileOutConfig("/templates/mybatisplus/list.html.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_HTML + tableInfo.getEntityName() + "ListIndex.html";
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 自定义  xxAdd.html 生成
    focList.add(new FileOutConfig("/templates/mybatisplus/add.html.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_HTML + tableInfo.getEntityName() + "Add.html";
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    //  自定义 xxUpdate.html生成
    focList.add(new FileOutConfig("/templates/mybatisplus/update.html.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_HTML + tableInfo.getEntityName() + "Update.html";
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    //  自定义 Vo.java生成
    focList.add(new FileOutConfig("/templates/mybatisplus/vo.java.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_JAVA +"/"+PARENT_PATH+"/"+MODULE_NAME+"/bean/vo/" + tableInfo.getEntityName() + "Vo.java";
      }
    });
    //  自定义 Form.java生成
    focList.add(new FileOutConfig("/templates/mybatisplus/form.java.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_JAVA +"/"+PARENT_PATH+"/"+MODULE_NAME+"/bean/form/" + tableInfo.getEntityName() + "Form.java";
      }
    });
    //  自定义 Query.java生成
    focList.add(new FileOutConfig("/templates/mybatisplus/query.java.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_JAVA +"/"+PARENT_PATH+"/"+MODULE_NAME+"/bean/query/" + tableInfo.getEntityName() + "Query.java";
      }
    });
    //  自定义 Convert.java生成
    focList.add(new FileOutConfig("/templates/mybatisplus/convert.java.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_JAVA +"/"+PARENT_PATH+"/"+MODULE_NAME+"/bean/convert/" + tableInfo.getEntityName() + "Convert.java";
      }
    });
    //  自定义 Import.java生成
    focList.add(new FileOutConfig("/templates/mybatisplus/import.java.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_JAVA +"/"+PARENT_PATH+"/"+MODULE_NAME+"/bean/dto/" + tableInfo.getEntityName() + "Import.java";
      }
    });
    //  自定义 Export.java生成
    focList.add(new FileOutConfig("/templates/mybatisplus/export.java.vm") {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
        return DISK_JAVA +"/"+PARENT_PATH+"/"+MODULE_NAME+"/bean/dto/" + tableInfo.getEntityName() + "Export.java";
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 关闭默认 xml 生成，调整生成 至 根目录
        /*TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);*/

    // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
    // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
    TemplateConfig tc = new TemplateConfig();
    tc.setController("/templates/mybatisplus/controller.java.vm");
    tc.setService("/templates/mybatisplus/service.java.vm");
    tc.setServiceImpl("/templates/mybatisplus/serviceImpl.java.vm");
    tc.setEntity("/templates/mybatisplus/entity.java.vm");
    tc.setMapper("/templates/mybatisplus/mapper.java.vm");
    tc.setXml("/templates/mybatisplus/mapper.xml.vm");


    // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
    mpg.setTemplate(tc);

    // 执行生成
    mpg.execute();

    // 打印注入设置【可无】
    System.err.println(mpg.getCfg().getMap().get("abc"));
  }

  public static List<TableFill> getTableFills(){
    TableFill cUserId = new TableFill(DefaultField.cUserId, FieldFill.INSERT);
    TableFill cUserName = new TableFill(DefaultField.cUserName, FieldFill.INSERT);
    TableFill cUnitId = new TableFill(DefaultField.cUnitId, FieldFill.INSERT);
    TableFill cPostId = new TableFill(DefaultField.cPostId, FieldFill.INSERT);
    TableFill ctime = new TableFill(DefaultField.ctime, FieldFill.INSERT);
    TableFill mUserId = new TableFill(DefaultField.mUserId, FieldFill.UPDATE);
    TableFill mUserName = new TableFill(DefaultField.mUserName, FieldFill.UPDATE);
    TableFill mtime = new TableFill(DefaultField.mtime, FieldFill.UPDATE);
    return Arrays.asList(cUserId,cUserName,cUnitId,cPostId,ctime,mUserId,mUserName,mtime);
  }

}
