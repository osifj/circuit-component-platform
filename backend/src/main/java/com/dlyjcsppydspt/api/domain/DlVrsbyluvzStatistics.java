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
 * 数据统计实体类
 */
@ApiModel(value = "数据统计实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlVrsbyluvzStatistics implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "元件编号")
    private String dlyjcsppydsptComponentNumber;

    @ApiModelProperty(value = "元件名称")
    private String dlyjcsppydsptComponentName;

    @ApiModelProperty(value = "元件类型")
    private String dlyjcsppydsptComponentType;

    @ApiModelProperty(value = "元件参数")
    private String dlyjcsppydsptComponentParameter;

    @ApiModelProperty(value = "安装位置")
    private String dlyjcsppydsptInstallationPosition;

    @ApiModelProperty(value = "安装时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlyjcsppydsptInstallationTime;

    @ApiModelProperty(value = "使用状态")
    private String dlyjcsppydsptUsageStatus;

    @ApiModelProperty(value = "供应商")
    private String dlyjcsppydsptSupplier;
}
