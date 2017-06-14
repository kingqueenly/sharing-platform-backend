package com.benz.usecase.adapter.web;

import com.benz.usecase.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paulliu on 2017/1/20.
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsQuery statisticsQuery;

    @Autowired
    private StatisticsMapper statisticsMapper;

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public TotalResult viewTotal() {
        return statisticsMapper.total();
    }

    @RequestMapping(value = "/total/value", method = RequestMethod.GET)
    public ComputedValue viewTotalByValue() {
        return statisticsQuery.dataWithlatest7Days();
    }
}
