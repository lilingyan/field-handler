package com.lilingyan.fieldhandler;

import com.lilingyan.fieldhandler.channel.DefaultProcessorContext;
import com.lilingyan.fieldhandler.processor.ObjectInProcessor;
import com.lilingyan.fieldhandler.processor.ObjectOutProcessor;
import com.lilingyan.fieldhandler.processor.ProcessorConfig;

/**
 * @author lilingyan
 * @date 2019/11/24 下午10:19
 */
public class FieldHandler {

    private static ProcessorConfig config = ProcessorConfig.globalInstance;

    public static void inProcess(Object o){
        try {
            DefaultProcessorContext ctx = new DefaultProcessorContext(o);
            ObjectInProcessor inProcessor = config.getObjectInProcessor(o.getClass());
            inProcessor.channelRead(ctx,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void outProcess(Object o){
        try {
            DefaultProcessorContext ctx = new DefaultProcessorContext(o);
            ObjectOutProcessor outProcessor = config.getObjectOutProcessor(o.getClass());
            outProcessor.write(ctx,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
