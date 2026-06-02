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
 * 元件信息实体类
 */
@ApiModel(value = "元件信息实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlJrlqmxdInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "安装位置")
    private String dlyjcsppydsptInstallationPosition;

    @ApiModelProperty(value = "元件名称")
    private String dlyjcsppydsptName;

    @ApiModelProperty(value = "调试人员")
    private String dlyjcsppydsptDebuggingPersonnel;

    @ApiModelProperty(value = "编号")
    private String dlyjcsppydsptNumber;

    @ApiModelProperty(value = "安装时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlyjcsppydsptInstallationTime;

    @ApiModelProperty(value = "规格")
    private String dlyjcsppydsptSpecifications;

    @ApiModelProperty(value = "生产厂家")
    private String dlyjcsppydsptManufacturer;

    @ApiModelProperty(value = "调试结果")
    private String dlyjcsppydsptDebuggingResults;
}
