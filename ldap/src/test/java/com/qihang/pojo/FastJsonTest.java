package com.qihang.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class FastJsonTest {

    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    @Test
    public void testJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));

    }

    @Test
    public void testJsonObjectToJsonStr() {

        Object jsonObject = JSONObject.parse(JSON_OBJ_STR);
        String s = JSONObject.toJSONString(jsonObject);
        System.out.println(s);
    }

    //json数组转换成object对象
    // 1 一个json数组

    //2 调用方法转换

    @Test
    public void testJSONArrayStrToJSONArray() {

        JSONArray array = (JSONArray) JSONArray.parse(JSON_ARRAY_STR);
        System.out.println(array + "   size:" + array.size());
        for (Object obj : array) {
            JSONObject object = (JSONObject) obj;
            System.out.println(object.get("studentName"));
        }
    }

    @Test
    public void testJSONArrayToJSONStr() {
        JSONArray jsonArray = (JSONArray) JSONArray.parse(JSON_ARRAY_STR);
        String s = JSONArray.toJSONString(jsonArray);
        System.out.println(s);
    }

    @Test
    public void testComplexJSONStrToJSONObject(){
        // 1 将复杂json转换成复杂的json对象
        // 2 根据对象中的属性取出相应的类型
        JSONObject complexJSONStr = (JSONObject) JSONObject.parse(COMPLEX_JSON_STR);
        Object course = complexJSONStr.get("course");
        System.out.println(course);
//        JSONArray students = (JSONArray) complexJSONStr.get("students");
        JSONArray students = complexJSONStr.getJSONArray("students");
        for (Object obj : students) {
            JSONObject object = (JSONObject)obj;
            System.out.println(object.get("studentName"));
        }
    }
}