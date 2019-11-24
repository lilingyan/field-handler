package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.ProcessorContext;

/**
 * @author lilingyan
 * @date 2019/11/24 下午3:59
 */
public interface ObjectOutProcessor extends ObjectProcessor{

    void write(ProcessorContext ctx, String fieldName) throws Exception;

}
