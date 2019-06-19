package com.qihang.commons;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CommonResult
 * @Author: HZ
 * @Description: TODO:
 * @Date: 2019/5/14 10:24
 * @Version: 1.0
 */
@Data
@Component
public class CommonResult {

    private String status;
    private String code;
    private String resultMsg;
    private Object data;

    public CommonResult setSuccess(){
        this.code = "200";
        this.status = "success";
        this.resultMsg = "操作成功";
        return this;
    }

    public CommonResult setDefault(){
        this.status = "false";
        this.code = "500";
        this.resultMsg = "操作失败";
        return this;
    }

    public CommonResult userDefined(String status, String code, String resultMsg){
        this.status = status;
        this.code = code;
        this.code = resultMsg;
        return this;
    }
}
