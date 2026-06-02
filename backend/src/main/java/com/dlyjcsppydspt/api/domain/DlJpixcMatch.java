package com.dlyjcsppydspt.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电路元件参数匹配与调试平台
 * 参数匹配实体类
 */
@ApiModel(value = "参数匹配实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlJpixcMatch implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "额定电压范围")
    private String dlyjcsppydsptRatedVoltage2;

    @ApiModelProperty(value = "元件名称")
    private String dlyjcsppydsptComponentName;

    @ApiModelProperty(value = "额定电流")
    private String dlyjcsppydsptRatedCurrent;

    @ApiModelProperty(value = "额定电压")
    private String dlyjcsppydsptRatedVoltage;

    @ApiModelProperty(value = "额定功率")
    private String dlyjcsppydsptRatedPower;

    @ApiModelProperty(value = "编号")
    private String dlyjcsppydsptNumber;
}
