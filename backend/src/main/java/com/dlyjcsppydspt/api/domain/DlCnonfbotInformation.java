package com.dlyjcsppydspt.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 电路元件参数匹配与调试平台
 * 报警信息实体类
 */
@ApiModel(value = "报警信息实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlCnonfbotInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "编号")
    private String dlyjcsppydsptNumber;

    @ApiModelProperty(value = "元件名称")
    private String dlyjcsppydsptComponentName;

    @ApiModelProperty(value = "参数值")
    private String dlyjcsppydsptParameterValue;

    @ApiModelProperty(value = "匹配方法")
    private String dlyjcsppydsptMatchingMethod;

    @ApiModelProperty(value = "调试结果")
    private String dlyjcsppydsptDebuggingResults;

    @ApiModelProperty(value = "备注")
    private String dlyjcsppydsptRemarks;
}
