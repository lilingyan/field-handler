package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.ProcessorContext;

/**
 * @author lilingyan
 * @date 2019/11/24 下午5:22
 */
public class StringDuplexProcessor extends ObjectDuplexProcessor{

    public final static StringDuplexProcessor instance  = new StringDuplexProcessor();

    @Override
    public void channelRead(ProcessorContext ctx, String fieldName) throws Exception {
        ctx.setFieldObject(fieldName,null);
    }

    @Override
    public void write(ProcessorContext ctx, String fieldName) throws Exception {
        String fieldObject = (String) ctx.getFieldObject(fieldName);
        if(fieldObject != null){
            String result = "";
            for (int i = 0; i <fieldObject.length() ; i++) {
                result += "*";
            }
            ctx.setFieldObject(fieldName,result);
        }
    }

}
