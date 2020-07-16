package com.yjs.yujiangshe.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 封装一个统一返回的信息类
 * @Author ChenFei
 * @Date 2020/7/15 17:56
 */

@Data
public class Result<T> implements Serializable {
    //状态码
    private String code;
    //消息描述
    private String msg;
    //实体数据
    private T data;

    private Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }

    /**
     * 自定义一个构造器用于ResultUtil统一返回成功调用之后的值
     */
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 生成一个ApiResult对象, 并返回
     *
     * @param resultEnum 枚举类状态码
     * @return 统一返回Result对象
     */
    public static Result of(ResultEnum resultEnum) {
        return new Result(resultEnum);
    }

}
