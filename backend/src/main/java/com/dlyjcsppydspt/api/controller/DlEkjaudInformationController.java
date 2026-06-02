package com.dlyjcsppydspt.api.controller;

import com.dlyjcsppydspt.api.domain.DlEkjaudInformation;
import com.dlyjcsppydspt.api.service.DlEkjaudInformationService;
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
 * 调试信息管理
 */
@Api(tags = "调试信息管理")
@RestController
@RequestMapping("/api/ekjaud-information")
public class DlEkjaudInformationController {

    @Autowired
    private DlEkjaudInformationService dlEkjaudInformationService;

    @ApiOperation("查询所有调试信息")
    @GetMapping("/list")
    public ResultVo list(@RequestParam Map<String, Object> params) {
        List<DlEkjaudInformation> list = dlEkjaudInformationService.selectByMap(params);
        return ResultVoUtil.success(list);
    }

    @ApiOperation("添加调试信息")
    @PostMapping("/save")
    public ResultVo save(@RequestBody DlEkjaudInformation record) {
        int result = dlEkjaudInformationService.insert(record);
        return result > 0 ? ResultVoUtil.success("保存成功") : ResultVoUtil.error("保存失败");
    }

    @ApiOperation("更新调试信息")
    @PutMapping("/update")
    public ResultVo update(@RequestBody DlEkjaudInformation record) {
        int result = dlEkjaudInformationService.updateByPrimaryKeySelective(record);
        return result > 0 ? ResultVoUtil.success("更新成功") : ResultVoUtil.error("更新失败");
    }

    @ApiOperation("删除调试信息")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        int result = dlEkjaudInformationService.deleteByPrimaryKey(id);
        return result > 0 ? ResultVoUtil.success("删除成功") : ResultVoUtil.error("删除失败");
    }

    @ApiOperation("根据安装位置查询调试信息")
    @GetMapping("/queryByInstall")
    public ResultVo queryByInstallationPosition(@RequestParam String installationPosition) {
        List<DlEkjaudInformation> list = dlEkjaudInformationService.queryByInstallationPosition(installationPosition);
        return ResultVoUtil.success(list);
    }

    @ApiOperation("更新调试信息（额定电流/元件类型）")
    @PutMapping("/updateInfo")
    public ResultVo updateInfo(@RequestParam String ratedCurrent,
                               @RequestParam String componentType) {
        int result = dlEkjaudInformationService.updateInfo(ratedCurrent, componentType);
        return result > 0 ? ResultVoUtil.success("更新成功") : ResultVoUtil.error("更新失败");
    }

    @ApiOperation("保存调试信息")
    @PostMapping("/saveDebugInfo")
    public ResultVo saveDebugInfo(@RequestParam String debuggingResults,
                                  @RequestParam String installationPosition,
                                  @RequestParam String ratedCurrent) {
        String err = dlEkjaudInformationService.saveDebugInfo(debuggingResults, installationPosition, ratedCurrent);
        return err == null ? ResultVoUtil.success("保存成功") : ResultVoUtil.error(err);
    }
}
