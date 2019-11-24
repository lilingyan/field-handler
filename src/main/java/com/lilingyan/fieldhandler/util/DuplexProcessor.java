package com.lilingyan.fieldhandler.util;

import com.lilingyan.fieldhandler.processor.ObjectInProcessor;
import com.lilingyan.fieldhandler.processor.ObjectOutProcessor;
import lombok.Data;

/**
 * @author lilingyan
 * @date 2019/11/24 下午5:04
 */
@Data
public class DuplexProcessor {

    private ObjectInProcessor inProcessor;

    private ObjectOutProcessor outProcessor;

}
