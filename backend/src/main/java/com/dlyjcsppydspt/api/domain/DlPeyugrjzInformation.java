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
 * 用户信息实体类 (电路元件信息)
 */
@ApiModel(value = "用户信息实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlPeyugrjzInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "额定功率")
    private String dlyjcsppydsptRatedPower;

    @ApiModelProperty(value = "额定电流范围")
    private String dlyjcsppydsptRatedCurrent2;

    @ApiModelProperty(value = "编号")
    private String dlyjcsppydsptNumber;

    @ApiModelProperty(value = "额定电压")
    private String dlyjcsppydsptRatedVoltage;

    @ApiModelProperty(value = "额定电压范围")
    private String dlyjcsppydsptRatedVoltage2;

    @ApiModelProperty(value = "调试结果")
    private String dlyjcsppydsptDebuggingResults;

    @ApiModelProperty(value = "额定电流")
    private String dlyjcsppydsptRatedCurrent;

    @ApiModelProperty(value = "元件类型")
    private String dlyjcsppydsptType;

    @ApiModelProperty(value = "调试人员")
    private String dlyjcsppydsptDebuggingPersonnel;

    @ApiModelProperty(value = "安装位置")
    private String dlyjcsppydsptInstallationPosition;

    @ApiModelProperty(value = "额定功率范围")
    private String dlyjcsppydsptRatedPower2;

    @ApiModelProperty(value = "元件名称")
    private String dlyjcsppydsptName;

    @ApiModelProperty(value = "安装时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlyjcsppydsptInstallationTime;
}
