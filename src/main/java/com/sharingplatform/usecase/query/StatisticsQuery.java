package com.sharingplatform.usecase.query;

import com.sharingplatform.framework.query.BaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by paulliu on 2017/1/20.
 */
@Service
public class StatisticsQuery extends BaseQuery {
    @Autowired
    private StatisticsMapper statisticsMapper;

    @Autowired
    private ValueMapper valueMapper;

    public ComputedValue dataWithlatest7Days() {
        List<String> last7days = statisticsMapper.last7days();
        List<ValueResult> values = valueMapper.findAll();
        List<TotalByValueResult> totalByValueResults = statisticsMapper.totalByValue();
        ComputedValue computedValue = new ComputedValue(last7days);

        for (ValueResult vr : values) {
            ComputedValueData computedValueData = new ComputedValueData(vr.getText());
            for (String day : last7days) {
                TotalByValueResult filterResult = filter(totalByValueResults, vr.getText(), day);
                computedValueData.addData(filterResult.getAmount());
            }
            computedValue.addData(computedValueData);
        }
//        System.out.println("computedValue:"+computedValue);
        return computedValue;
    }

    private TotalByValueResult filter(List<TotalByValueResult> totalByValueResults, String value, String day) {
        for (TotalByValueResult totalByValueResult : totalByValueResults) {
            if (totalByValueResult.getValue().equals(value) && totalByValueResult.getCreateDay().equals(day)) {
                return totalByValueResult;
            }
        }
        return null;
    }
}
