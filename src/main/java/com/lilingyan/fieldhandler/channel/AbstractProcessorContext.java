package com.lilingyan.fieldhandler.channel;

import com.lilingyan.fieldhandler.processor.ObjectInProcessor;
import com.lilingyan.fieldhandler.processor.ObjectOutProcessor;
import com.lilingyan.fieldhandler.processor.ProcessorConfig;
import lombok.Data;
import java.lang.reflect.Field;

/**
 * @author lilingyan
 * @date 2019/11/24 下午4:13
 */
@Data
abstract class AbstractProcessorContext implements ProcessorContext{

    /**
     * 当前的对象
     */
    private Object object;
    private ProcessorConfig config = ProcessorConfig.globalInstance;

    public AbstractProcessorContext() {
    }

    public AbstractProcessorContext(Object object) {
        this.object = object;
    }

    @Override
    public ProcessorContext fireChannelRead(String fieldName) {
        if(object == null){
            return null;
        }
        ProcessorContext ctx = null;
        try {
            /**
             * 找出对应字段
             * 为空就不需要递归下去了
             */
            Object fieldObject;
            if(fieldName == null){
                fieldObject = object;
            }else {
                fieldObject = getFieldObject(fieldName);
            }

            if(fieldObject == null){
                return null;
            }

            ctx = new DefaultProcessorContext(fieldObject);
            Field[] fields = fieldObject.getClass().getDeclaredFields();
            for (Field fieldObjectField : fields) {
                fieldObjectField.setAccessible(true);
                Object o = fieldObjectField.get(fieldObject);
                if(o != null){
                    ObjectInProcessor inProcessor = config.getObjectInProcessor(o.getClass());
                    inProcessor.channelRead(ctx,fieldObjectField.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctx;
    }

    @Override
    public ProcessorContext write(String fieldName) {
        if(object == null){
            return null;
        }
        ProcessorContext ctx = null;
        try {
            Object fieldObject;
            if(fieldName == null){
                fieldObject = object;
            }else {
                fieldObject = getFieldObject(fieldName);
            }

            if(fieldObject == null){
                return null;
            }

            ctx = new DefaultProcessorContext(fieldObject);
            Field[] fields = fieldObject.getClass().getDeclaredFields();
            for (Field fieldObjectField : fields) {
                fieldObjectField.setAccessible(true);
                Object o = fieldObjectField.get(fieldObject);
                if(o != null){
                    ObjectOutProcessor outProcessor = config.getObjectOutProcessor(o.getClass());
                    outProcessor.write(ctx,fieldObjectField.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctx;
    }

    @Override
    public Object getFieldObject(String fieldName) {
        try {
            if(fieldName != null){
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(object);
            }else {
                return object;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setFieldObject(String fieldName, Object value) {
        try {
            if(fieldName != null){
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
