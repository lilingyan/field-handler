package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.ProcessorContext;

/**
 * @author lilingyan
 * @date 2019/11/24 下午3:59
 */
public class ObjectInAdapter implements ObjectInProcessor{

    @Override
    public void channelRead(ProcessorContext ctx, String fieldName) throws Exception {
        ctx.fireChannelRead(fieldName);
    }

}
