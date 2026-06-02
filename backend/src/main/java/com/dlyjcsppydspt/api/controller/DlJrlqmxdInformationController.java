package com.dlyjcsppydspt.api.controller;

import com.dlyjcsppydspt.api.domain.DlJrlqmxdInformation;
import com.dlyjcsppydspt.api.service.DlJrlqmxdInformationService;
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
 * 元件信息管理
 */
@Api(tags = "元件信息管理")
@RestController
@RequestMapping("/api/jrlqmxd-information")
public class DlJrlqmxdInformationController {

    @Autowired
    private DlJrlqmxdInformationService dlJrlqmxdInformationService;

    @ApiOperation("查询所有元件信息")
    @GetMapping("/list")
    public ResultVo list(@RequestParam Map<String, Object> params) {
        List<DlJrlqmxdInformation> list = dlJrlqmxdInformationService.selectByMap(params);
        return ResultVoUtil.success(list);
    }

    @ApiOperation("添加元件信息")
    @PostMapping("/save")
    public ResultVo save(@RequestBody DlJrlqmxdInformation record) {
        int result = dlJrlqmxdInformationService.insert(record);
        return result > 0 ? ResultVoUtil.success("保存成功") : ResultVoUtil.error("保存失败");
    }

    @ApiOperation("更新元件信息")
    @PutMapping("/update")
    public ResultVo update(@RequestBody DlJrlqmxdInformation record) {
        int result = dlJrlqmxdInformationService.updateByPrimaryKeySelective(record);
        return result > 0 ? ResultVoUtil.success("更新成功") : ResultVoUtil.error("更新失败");
    }

    @ApiOperation("删除元件信息")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        int result = dlJrlqmxdInformationService.deleteByPrimaryKey(id);
        return result > 0 ? ResultVoUtil.success("删除成功") : ResultVoUtil.error("删除失败");
    }

    @ApiOperation("根据调试人员/安装位置添加元件信息")
    @PostMapping("/saveByDebug")
    public ResultVo saveByDebug(@RequestParam String debuggingPersonnel,
                                @RequestParam String installationPosition) {
        String err = dlJrlqmxdInformationService.saveByDebug(debuggingPersonnel, installationPosition);
        return err == null ? ResultVoUtil.success("保存成功") : ResultVoUtil.error(err);
    }

    @ApiOperation("根据规格/调试人员/生产厂家添加元件信息")
    @PostMapping("/saveBy")
    public ResultVo saveBy(@RequestParam String specifications,
                           @RequestParam String debuggingPersonnel,
                           @RequestParam String manufacturer) {
        String err = dlJrlqmxdInformationService.saveBy(specifications, debuggingPersonnel, manufacturer);
        return err == null ? ResultVoUtil.success("保存成功") : ResultVoUtil.error(err);
    }
}
