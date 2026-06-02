package com.dlyjcsppydspt.api.controller;

import com.dlyjcsppydspt.api.domain.DlJpixcMatch;
import com.dlyjcsppydspt.api.service.DlJpixcMatchService;
import com.dlyjcsppydspt.utils.ResultVo;
import com.dlyjcsppydspt.utils.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 电路元件参数匹配与调试平台
 * 参数匹配管理
 */
@Api(tags = "参数匹配管理")
@RestController
@RequestMapping("/api/jpixc-match")
public class DlJpixcMatchController {

    @Autowired
    private DlJpixcMatchService dlJpixcMatchService;

    @ApiOperation("查询所有参数匹配记录")
    @GetMapping("/list")
    public ResultVo list(@RequestParam Map<String, Object> params) {
        List<DlJpixcMatch> list = dlJpixcMatchService.selectByMap(params);
        return ResultVoUtil.success(list);
    }

    @ApiOperation("添加参数匹配记录")
    @PostMapping("/save")
    public ResultVo save(@RequestBody DlJpixcMatch record) {
        int result = dlJpixcMatchService.insert(record);
        return result > 0 ? ResultVoUtil.success("保存成功") : ResultVoUtil.error("保存失败");
    }

    @ApiOperation("更新参数匹配记录")
    @PutMapping("/update")
    public ResultVo update(@RequestBody DlJpixcMatch record) {
        int result = dlJpixcMatchService.updateByPrimaryKeySelective(record);
        return result > 0 ? ResultVoUtil.success("更新成功") : ResultVoUtil.error("更新失败");
    }

    @ApiOperation("删除参数匹配记录")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        int result = dlJpixcMatchService.deleteByPrimaryKey(id);
        return result > 0 ? ResultVoUtil.success("删除成功") : ResultVoUtil.error("删除失败");
    }

    @ApiOperation("更新匹配信息（额定功率/电压/电流）")
    @PutMapping("/matchInfo")
    public ResultVo updateMatchInfo(@RequestParam String ratedPower,
                                    @RequestParam String ratedVoltage,
                                    @RequestParam String ratedCurrent) {
        int result = dlJpixcMatchService.updateMatchInfo(ratedPower, ratedVoltage, ratedCurrent);
        return result > 0 ? ResultVoUtil.success("匹配信息更新成功") : ResultVoUtil.error("匹配信息更新失败");
    }

    @ApiOperation("保存匹配记录")
    @PostMapping("/saveMatch")
    public ResultVo saveMatch(@RequestParam String ratedVoltage2,
                              @RequestParam String componentName,
                              @RequestParam String ratedCurrent) {
        String err = dlJpixcMatchService.saveMatch(ratedVoltage2, componentName, ratedCurrent);
        return err == null ? ResultVoUtil.success("保存成功") : ResultVoUtil.error(err);
    }
}
