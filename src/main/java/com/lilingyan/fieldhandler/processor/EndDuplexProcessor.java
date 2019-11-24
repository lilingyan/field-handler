package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.ProcessorContext;

/**
 * @author lilingyan
 * @date 2019/11/24 下午5:22
 */
public class EndDuplexProcessor extends ObjectDuplexProcessor{

    public final static EndDuplexProcessor instance  = new EndDuplexProcessor();

    @Override
    public void channelRead(ProcessorContext ctx, String fieldName) throws Exception {
    }

    @Override
    public void write(ProcessorContext ctx, String fieldName) throws Exception {
    }

}
