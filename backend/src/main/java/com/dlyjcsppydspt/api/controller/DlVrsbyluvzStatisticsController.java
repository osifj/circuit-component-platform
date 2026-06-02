package com.dlyjcsppydspt.api.controller;

import com.dlyjcsppydspt.api.service.DlVrsbyluvzStatisticsService;
import com.dlyjcsppydspt.utils.ResultVo;
import com.dlyjcsppydspt.utils.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 电路元件参数匹配与调试平台
 * 数据统计管理
 */
@Api(tags = "数据统计管理")
@RestController
@RequestMapping("/api/statistics")
public class DlVrsbyluvzStatisticsController {

    @Autowired
    private DlVrsbyluvzStatisticsService dlVrsbyluvzStatisticsService;

    @ApiOperation("获取统计概览")
    @GetMapping("/summary")
    public ResultVo summary() {
        Map<String, Object> summary = dlVrsbyluvzStatisticsService.getStatisticsSummary();
        return ResultVoUtil.success(summary);
    }
}
