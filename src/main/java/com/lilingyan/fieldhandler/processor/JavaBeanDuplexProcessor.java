package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.ProcessorContext;

/**
 * @author lilingyan
 * @date 2019/11/24 下午5:22
 */
public class JavaBeanDuplexProcessor extends ObjectDuplexProcessor{

    @Override
    public void channelRead(ProcessorContext ctx, String fieldName) throws Exception {
        super.channelRead(ctx, fieldName);
    }

    @Override
    public void write(ProcessorContext ctx, String fieldName) throws Exception {
        ctx.write(fieldName);
    }

}
