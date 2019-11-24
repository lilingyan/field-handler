package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.DefaultProcessorContext;
import com.lilingyan.fieldhandler.channel.ProcessorContext;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lilingyan
 * @date 2019/11/24 下午5:22
 */
public class MapDuplexProcessor extends ObjectDuplexProcessor{

    public static MapDuplexProcessor instance  = new MapDuplexProcessor();

    @Override
    public void channelRead(ProcessorContext ctx, String fieldName) throws Exception {
        Map map = (Map) ctx.getFieldObject(fieldName);
        if(map != null){
            Iterator iterator = map.values().iterator();
            while (iterator.hasNext()){
                Object o = iterator.next();
                if(o != null){
                    DefaultProcessorContext context = new DefaultProcessorContext(o);
                    ObjectInProcessor inProcessor = ProcessorConfig.getGlobalInstance().getObjectInProcessor(o.getClass());
                    inProcessor.channelRead(context,null);
                }
            }
        }
    }

    @Override
    public void write(ProcessorContext ctx, String fieldName) throws Exception {
        Map map = (Map) ctx.getFieldObject(fieldName);
        if(map != null){
            Iterator iterator = map.values().iterator();
            while (iterator.hasNext()){
                Object o = iterator.next();
                if(o != null){
                    DefaultProcessorContext context = new DefaultProcessorContext(o);
                    ObjectOutProcessor outProcessor = ProcessorConfig.getGlobalInstance().getObjectOutProcessor(o.getClass());
                    outProcessor.write(context,null);
                }
            }
        }
    }

}
