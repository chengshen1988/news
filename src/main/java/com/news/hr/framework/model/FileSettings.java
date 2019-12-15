package com.news.hr.framework.model;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileSettings {
    //文件存储的名称
    private String fileStoreName;
    //是否按日期生成目录
    private boolean byDay;
    //是否按日期生成目录
    private FileDirEnum fileDir;

    //文件存储目录
    @Getter
    public enum FileDirEnum {
        //默认路径
        DEFAULT_DIRECOTRY("default/"),
        //组织绩效-专项奖管理
        ZZJX_ZXJGL("ZZJX/ZXJGL/");

        private String dir;
        FileDirEnum(String dir) {
            this.dir = dir;
        }
        public String getDir() {
            return dir;
        }
    }
}
