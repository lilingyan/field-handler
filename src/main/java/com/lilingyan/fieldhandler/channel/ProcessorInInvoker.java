package com.lilingyan.fieldhandler.channel;

/**
 * @author lilingyan
 * @date 2019/11/24 下午4:16
 */
public interface ProcessorInInvoker {

    ProcessorInInvoker fireChannelRead(String fieldName);

}
