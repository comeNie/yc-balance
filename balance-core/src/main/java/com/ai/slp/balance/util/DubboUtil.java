package com.ai.slp.balance.util;

import com.ai.yc.order.api.orderquery.interfaces.IOrderQuerySV;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.yc.common.api.subject.interfaces.IGnSubjectQuerySV;

public final class DubboUtil {

    private DubboUtil() {

    }

    /*
     * static { System.setProperty(CenterProductDef.CENTER_PRODUCT_SYS_PROPERTY,
     * CenterProductDef.CenterProductName.AM_CENTER); }
     */

    /**
     * 获取公共域科目查询服务
     * 
     * @return
     * @author lilg
     */
    public static IGnSubjectQuerySV getIGnSubjectQuerySV() {
        IGnSubjectQuerySV sv = null;
        try {
            sv = DubboConsumerFactory.getService("IGnSubjectQuerySV", IGnSubjectQuerySV.class);
        } catch (NoSuchBeanDefinitionException ex) {
            throw new SystemException("获取不到远程服务:[" + ex.getMessage() + "],请检查配置文件", ex);
        }
        if (sv == null) {
            throw new SystemException("获取不到远程服务:" + IGnSubjectQuerySV.class);
        }
        return sv;
    }

    public static IOrderQuerySV getIOrderQuerySV(){
        IOrderQuerySV sv = null;
        try {
            sv = DubboConsumerFactory.getService("IOrderQuerySV", IOrderQuerySV.class);
        } catch (NoSuchBeanDefinitionException ex) {
            throw new SystemException("获取不到远程服务:[" + ex.getMessage() + "],请检查配置文件", ex);
        }
        if (sv == null) {
            throw new SystemException("获取不到远程服务:" + IOrderQuerySV.class);
        }
        return sv;
    }

}
