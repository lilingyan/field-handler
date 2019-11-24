package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.ProcessorContext;

/**
 * @author lilingyan
 * @date 2019/11/24 下午3:59
 */
public class ObjectDuplexProcessor extends ObjectInAdapter implements ObjectOutProcessor{

    @Override
    public void write(ProcessorContext ctx, String fieldName) throws Exception {
        ctx.write(fieldName);
    }

}
