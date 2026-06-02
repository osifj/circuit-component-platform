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
 * 数据备份实体类
 */
@ApiModel(value = "数据备份实体类")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DlTshmdlBackup implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "编号")
    private String dlyjcsppydsptNumber;

    @ApiModelProperty(value = "名称")
    private String dlyjcsppydsptName;

    @ApiModelProperty(value = "规格")
    private String dlyjcsppydsptSpecifications;

    @ApiModelProperty(value = "生产厂家")
    private String dlyjcsppydsptManufacturer;

    @ApiModelProperty(value = "采购日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlyjcsppydsptPurchaseDate;

    @ApiModelProperty(value = "有效期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlyjcsppydsptDateOf;

    @ApiModelProperty(value = "报废状态")
    private String dlyjcsppydsptWasteStatus;
}
