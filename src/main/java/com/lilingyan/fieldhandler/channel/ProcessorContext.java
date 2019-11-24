package com.lilingyan.fieldhandler.channel;

/**
 * @author lilingyan
 * @date 2019/11/24 下午4:13
 */
public interface ProcessorContext extends ProcessorInInvoker , ProcessorOutInvoker{

    ProcessorContext fireChannelRead(String fieldName);

    ProcessorContext write(String fieldName);

    Object getFieldObject(String fieldName);

    void setFieldObject(String fieldName,Object value);

}
