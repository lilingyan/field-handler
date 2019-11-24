package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.channel.DefaultProcessorContext;
import com.lilingyan.fieldhandler.channel.ProcessorContext;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author lilingyan
 * @date 2019/11/24 下午5:22
 */
public class CollectionDuplexProcessor extends ObjectDuplexProcessor{

    public static CollectionDuplexProcessor instance  = new CollectionDuplexProcessor();

    @Override
    public void channelRead(ProcessorContext ctx, String fieldName) throws Exception {
        Collection collection = (Collection) ctx.getFieldObject(fieldName);
        if(collection != null){
            Iterator iterator = collection.iterator();
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
        Collection collection = (Collection) ctx.getFieldObject(fieldName);
        if(collection != null){
            Iterator iterator = collection.iterator();
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
