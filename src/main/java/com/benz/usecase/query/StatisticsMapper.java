package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by paulliu on 2016/12/24.
 */
@Mapper
public interface StatisticsMapper {

    TotalResult total();

    List<TotalByValueResult> totalByValue();

    List<String> last7days();
}