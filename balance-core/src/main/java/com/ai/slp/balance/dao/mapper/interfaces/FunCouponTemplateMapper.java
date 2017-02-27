package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplate;
import com.ai.slp.balance.dao.mapper.bo.FunCouponTemplateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunCouponTemplateMapper {
    int countByExample(FunCouponTemplateCriteria example);

    int deleteByExample(FunCouponTemplateCriteria example);

    int deleteByPrimaryKey(Integer templateId);

    int insert(FunCouponTemplate record);

    int insertSelective(FunCouponTemplate record);

    List<FunCouponTemplate> selectByExample(FunCouponTemplateCriteria example);

    FunCouponTemplate selectByPrimaryKey(Integer templateId);

    int updateByExampleSelective(@Param("record") FunCouponTemplate record, @Param("example") FunCouponTemplateCriteria example);

    int updateByExample(@Param("record") FunCouponTemplate record, @Param("example") FunCouponTemplateCriteria example);

    int updateByPrimaryKeySelective(FunCouponTemplate record);

    int updateByPrimaryKey(FunCouponTemplate record);
}