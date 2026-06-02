package com.dlyjcsppydspt.api.controller;

import com.dlyjcsppydspt.api.domain.DlPeyugrjzInformation;
import com.dlyjcsppydspt.api.service.DlPeyugrjzInformationService;
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
 * 用户信息管理 (电路元件信息)
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/api/peyugrjz-information")
public class DlPeyugrjzInformationController {

    @Autowired
    private DlPeyugrjzInformationService dlPeyugrjzInformationService;

    @ApiOperation("根据ID查询用户信息")
    @GetMapping("/{id}")
    public ResultVo getById(@PathVariable Long id) {
        DlPeyugrjzInformation info = dlPeyugrjzInformationService.selectByPrimaryKey(id);
        return info != null ? ResultVoUtil.success(info) : ResultVoUtil.error("未找到该记录");
    }

    @ApiOperation("查询所有用户信息")
    @GetMapping("/list")
    public ResultVo list(@RequestParam Map<String, Object> params) {
        List<DlPeyugrjzInformation> list = dlPeyugrjzInformationService.selectByAll(params);
        return ResultVoUtil.success(list);
    }

    @ApiOperation("添加用户信息")
    @PostMapping("/save")
    public ResultVo save(@RequestBody DlPeyugrjzInformation record) {
        int result = dlPeyugrjzInformationService.insert(record);
        return result > 0 ? ResultVoUtil.success("保存成功") : ResultVoUtil.error("保存失败");
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/update")
    public ResultVo update(@RequestBody DlPeyugrjzInformation record) {
        int result = dlPeyugrjzInformationService.updateByPrimaryKeySelective(record);
        return result > 0 ? ResultVoUtil.success("更新成功") : ResultVoUtil.error("更新失败");
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        int result = dlPeyugrjzInformationService.deleteByPrimaryKey(id);
        return result > 0 ? ResultVoUtil.success("删除成功") : ResultVoUtil.error("删除失败");
    }

    @ApiOperation("更新用户信息状态")
    @PutMapping("/status")
    public ResultVo updateStatus(@RequestParam Long id, @RequestParam Integer status) {
        int result = dlPeyugrjzInformationService.updateStatus(id, status);
        return result > 0 ? ResultVoUtil.success("状态更新成功") : ResultVoUtil.error("状态更新失败");
    }
}
