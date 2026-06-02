package com.dlyjcsppydspt.api.controller;

import com.dlyjcsppydspt.api.domain.DlCnonfbotInformation;
import com.dlyjcsppydspt.api.service.DlCnonfbotInformationService;
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
 * 报警信息管理
 */
@Api(tags = "报警信息管理")
@RestController
@RequestMapping("/api/cnonfbot-information")
public class DlCnonfbotInformationController {

    @Autowired
    private DlCnonfbotInformationService dlCnonfbotInformationService;

    @ApiOperation("查询所有报警信息")
    @GetMapping("/list")
    public ResultVo list(@RequestParam Map<String, Object> params) {
        List<DlCnonfbotInformation> list = dlCnonfbotInformationService.selectByMap(params);
        return ResultVoUtil.success(list);
    }

    @ApiOperation("添加报警信息")
    @PostMapping("/save")
    public ResultVo save(@RequestBody DlCnonfbotInformation record) {
        int result = dlCnonfbotInformationService.insert(record);
        return result > 0 ? ResultVoUtil.success("保存成功") : ResultVoUtil.error("保存失败");
    }

    @ApiOperation("更新报警信息")
    @PutMapping("/update")
    public ResultVo update(@RequestBody DlCnonfbotInformation record) {
        int result = dlCnonfbotInformationService.updateByPrimaryKeySelective(record);
        return result > 0 ? ResultVoUtil.success("更新成功") : ResultVoUtil.error("更新失败");
    }

    @ApiOperation("删除报警信息")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        int result = dlCnonfbotInformationService.deleteByPrimaryKey(id);
        return result > 0 ? ResultVoUtil.success("删除成功") : ResultVoUtil.error("删除失败");
    }
}
