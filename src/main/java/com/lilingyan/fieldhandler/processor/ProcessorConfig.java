package com.lilingyan.fieldhandler.processor;

import com.lilingyan.fieldhandler.util.DuplexProcessor;
import lombok.Data;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lilingyan
 * @date 2019/11/24 下午3:45
 */
@Data
public class ProcessorConfig {

    public final static ProcessorConfig globalInstance  = new ProcessorConfig();

    private Map<Type, DuplexProcessor> duplexProcessorMap;

    public ProcessorConfig() {
        this(8192);
    }

    public ProcessorConfig(int tableSize) {
        duplexProcessorMap = new ConcurrentHashMap<>(tableSize);

        initProcessors();
    }

    private void initProcessors() {
        put(byte.class,EndDuplexProcessor.instance);
        put(Byte.class,EndDuplexProcessor.instance);
        put(short.class,EndDuplexProcessor.instance);
        put(Short.class,EndDuplexProcessor.instance);
        put(int.class,EndDuplexProcessor.instance);
        put(Integer.class,EndDuplexProcessor.instance);
        put(long.class,EndDuplexProcessor.instance);
        put(Long.class,EndDuplexProcessor.instance);
        put(float.class,EndDuplexProcessor.instance);
        put(Float.class,EndDuplexProcessor.instance);
        put(double.class,EndDuplexProcessor.instance);
        put(Double.class,EndDuplexProcessor.instance);
        put(char.class,EndDuplexProcessor.instance);
        put(Character.class,EndDuplexProcessor.instance);
        put(boolean.class,EndDuplexProcessor.instance);
        put(Boolean.class,EndDuplexProcessor.instance);

        put(Date.class,EndDuplexProcessor.instance);
        put(LocalDate.class,EndDuplexProcessor.instance);
        put(LocalTime.class,EndDuplexProcessor.instance);
        put(LocalDateTime.class,EndDuplexProcessor.instance);

        put(String.class,StringDuplexProcessor.instance);
        put(Collection.class,CollectionDuplexProcessor.instance);
        put(Map.class,MapDuplexProcessor.instance);
        put(Collection.class,CollectionDuplexProcessor.instance);
    }

    public final ObjectInProcessor getObjectInProcessor(Class<?> clazz) {
        ObjectInProcessor inProcessor = getInProcessor(clazz);
        if(inProcessor == null){
            if (byte.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Byte.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (short.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Short.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (int.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Integer.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (long.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Long.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (float.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Float.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (double.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Double.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (char.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Character.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (boolean.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Boolean.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (Date.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (LocalDate.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (LocalTime.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (LocalDateTime.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = EndDuplexProcessor.instance);
            }else if (String.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = StringDuplexProcessor.instance);
            }else if (Map.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = MapDuplexProcessor.instance);
            }else if (Collection.class.isAssignableFrom(clazz)) {
                put(clazz, inProcessor = CollectionDuplexProcessor.instance);
            }

        }
        if(inProcessor == null){
            inProcessor = new JavaBeanDuplexProcessor();
            put(clazz,inProcessor);
        }
        return inProcessor;
    }

    public final ObjectOutProcessor getObjectOutProcessor(Class<?> clazz) {
        ObjectOutProcessor outProcessor = getOutProcessor(clazz);
        if(outProcessor == null){
            if (byte.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Byte.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (short.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Short.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (int.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Integer.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (long.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Long.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (float.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Float.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (double.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Double.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (char.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Character.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (boolean.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Boolean.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (Date.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (LocalDate.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (LocalTime.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (LocalDateTime.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = EndDuplexProcessor.instance);
            }else if (String.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = StringDuplexProcessor.instance);
            }else if (Map.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = MapDuplexProcessor.instance);
            }else if (Collection.class.isAssignableFrom(clazz)) {
                put(clazz, outProcessor = CollectionDuplexProcessor.instance);
            }
        }
        if(outProcessor == null){
            outProcessor = new JavaBeanDuplexProcessor();
            put(clazz,outProcessor);
        }
        return outProcessor;
    }

    public final ObjectInProcessor getInProcessor(Type type) {
        DuplexProcessor duplexProcessor = get(type);
        return duplexProcessor==null?null:duplexProcessor.getInProcessor();
    }

    public final ObjectOutProcessor getOutProcessor(Type type) {
        DuplexProcessor duplexProcessor = get(type);
        return duplexProcessor==null?null:duplexProcessor.getOutProcessor();
    }

    public final DuplexProcessor get(Type type) {
        return duplexProcessorMap.get(type);
    }

    public void put(Type type, ObjectProcessor processor) {
        DuplexProcessor duplexProcessor = duplexProcessorMap.get(type);
        if(duplexProcessor == null){
            duplexProcessor = new DuplexProcessor();
            duplexProcessorMap.put(type,duplexProcessor);
        }
        if(processor instanceof ObjectInProcessor){
            duplexProcessor.setInProcessor((ObjectInProcessor) processor);
        }
        if(processor instanceof ObjectOutProcessor){
            duplexProcessor.setOutProcessor((ObjectOutProcessor) processor);
        }
    }

    public static ProcessorConfig getGlobalInstance() {
        return globalInstance;
    }


}
