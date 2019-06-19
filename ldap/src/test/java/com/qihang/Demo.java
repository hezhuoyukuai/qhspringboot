package com.qihang;

import org.junit.Test;

import java.io.File;

/**
 * @ClassName: Demo
 * @Description:
 * @Author: HZ
 * @Date: 2019/6/17 11:32
 * @Version: 1.0
 */
public class Demo {

    @Test
    public void testFile(){
        try {
            File file = null;
            boolean b = file.canWrite();
            System.out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
