package com.qihang.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName: AppLog
 * @Description:
 * @Author: HZ
 * @Date: 2019/6/19 15:22
 * @Version: 1.0
 */
@Entity
@Data
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class AppLog {
    @Id
    @GeneratedValue(generator="jpa-uuid")
    private String  id;
//    username,clientIp,operateModule,operateModuleName,operateType,operateTime,operateContent,operateResult
    private String username;

    private String clientIp;

    private String operateModule;

    private String operateType;

    private String operateTime;

    private String operateContent;

    private String operateResult;
}
