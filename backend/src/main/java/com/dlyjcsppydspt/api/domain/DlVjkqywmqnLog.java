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
 * 操作日志实体类
 */
@ApiModel(value = "操作日志实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlVjkqywmqnLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "元件编号")
    private String dlyjcsppydsptComponentNumber;

    @ApiModelProperty(value = "元件类型")
    private String dlyjcsppydsptComponentType;

    @ApiModelProperty(value = "元件参数")
    private String dlyjcsppydsptComponentParameter;

    @ApiModelProperty(value = "调试编号")
    private String dlyjcsppydsptDebugNumber;

    @ApiModelProperty(value = "调试时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlyjcsppydsptDebuggingTime;

    @ApiModelProperty(value = "调试结果")
    private String dlyjcsppydsptDebuggingResults;
}
