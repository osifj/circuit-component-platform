-- ============================================
-- 电路元件参数匹配与调试平台 - 数据库初始化脚本
-- 使用方法：mysql -u root -p < init.sql
-- ============================================

CREATE DATABASE IF NOT EXISTS circuit_platform
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

USE circuit_platform;

-- 1. 电路信息表 (用户信息 / 电路元件信息)
DROP TABLE IF EXISTS dl_peyugrjz_information;
CREATE TABLE dl_peyugrjz_information (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_sdsgks_rated_power VARCHAR(100) COMMENT '额定功率',
  dl_sdsgks_rated_current2 VARCHAR(100) COMMENT '额定电流范围',
  dl_sdsgks_number VARCHAR(100) COMMENT '编号',
  dl_sdsgks_rated_voltage VARCHAR(100) COMMENT '额定电压',
  dl_sdsgks_rated_voltage2 VARCHAR(100) COMMENT '额定电压范围',
  dl_sdsgks_debugging_results VARCHAR(500) COMMENT '调试结果',
  dl_sdsgks_rated_current VARCHAR(100) COMMENT '额定电流',
  dl_sdsgks_type VARCHAR(100) COMMENT '元件类型',
  dl_sdsgks_debugging_personnel VARCHAR(100) COMMENT '调试人员',
  dl_sdsgks_installation_position VARCHAR(200) COMMENT '安装位置',
  dl_sdsgks_rated_power2 VARCHAR(100) COMMENT '额定功率范围',
  dl_sdsgks_name VARCHAR(200) COMMENT '元件名称',
  dl_sdsgks_installation_time DATETIME COMMENT '安装时间',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='电路信息表';

-- 2. 元件信息表
DROP TABLE IF EXISTS dl_jrlqmxd_information;
CREATE TABLE dl_jrlqmxd_information (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_rbvlxtc_name VARCHAR(200) COMMENT '元件名称',
  dl_rbvlxtc_number VARCHAR(100) COMMENT '编号',
  dl_rbvlxtc_specifications VARCHAR(200) COMMENT '规格',
  dl_rbvlxtc_manufacturer VARCHAR(200) COMMENT '生产厂家',
  dl_rbvlxtc_installation_position VARCHAR(200) COMMENT '安装位置',
  dl_rbvlxtc_installation_time DATETIME COMMENT '安装时间',
  dl_rbvlxtc_debugging_personnel VARCHAR(100) COMMENT '调试人员',
  dl_rbvlxtc_debugging_results VARCHAR(500) COMMENT '调试结果',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='元件信息表';

-- 3. 参数匹配表
DROP TABLE IF EXISTS dl_jpixc_match;
CREATE TABLE dl_jpixc_match (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_tjpuksl_number VARCHAR(100) COMMENT '编号',
  dl_tjpuksl_component_name VARCHAR(200) COMMENT '元件名称',
  dl_tjpuksl_rated_voltage VARCHAR(100) COMMENT '额定电压',
  dl_tjpuksl_rated_current VARCHAR(100) COMMENT '额定电流',
  dl_tjpuksl_rated_power VARCHAR(100) COMMENT '额定功率',
  dl_tjpuksl_rated_voltage2 VARCHAR(100) COMMENT '额定电压范围',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='参数匹配表';

-- 4. 调试信息表
DROP TABLE IF EXISTS dl_ekjaud_information;
CREATE TABLE dl_ekjaud_information (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_nojsmbk_rated_power VARCHAR(100) COMMENT '额定功率',
  dl_nojsmbk_number VARCHAR(100) COMMENT '编号',
  dl_nojsmbk_component_type VARCHAR(100) COMMENT '元件类型',
  dl_nojsmbk_debugging_time DATETIME COMMENT '调试时间',
  dl_nojsmbk_rated_voltage VARCHAR(100) COMMENT '额定电压',
  dl_nojsmbk_rated_current VARCHAR(100) COMMENT '额定电流',
  dl_nojsmbk_installation_position VARCHAR(200) COMMENT '安装位置',
  dl_nojsmbk_component_name VARCHAR(200) COMMENT '元件名称',
  dl_nojsmbk_debugging_results VARCHAR(500) COMMENT '调试结果',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='调试信息表';

-- 5. 报警信息表
DROP TABLE IF EXISTS dl_cnonfbot_information;
CREATE TABLE dl_cnonfbot_information (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_yrvogtrq_number VARCHAR(100) COMMENT '编号',
  dl_yrvogtrq_component_name VARCHAR(200) COMMENT '元件名称',
  dl_yrvogtrq_parameter_value VARCHAR(200) COMMENT '参数值',
  dl_yrvogtrq_matching_method VARCHAR(200) COMMENT '匹配方法',
  dl_yrvogtrq_debugging_results VARCHAR(500) COMMENT '调试结果',
  dl_yrvogtrq_remarks VARCHAR(500) COMMENT '备注',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报警信息表';

-- 6. 数据备份表
DROP TABLE IF EXISTS dl_tshmdl_backup;
CREATE TABLE dl_tshmdl_backup (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_qlowknd_number VARCHAR(100) COMMENT '编号',
  dl_qlowknd_name VARCHAR(200) COMMENT '名称',
  dl_qlowknd_specifications VARCHAR(200) COMMENT '规格',
  dl_qlowknd_manufacturer VARCHAR(200) COMMENT '生产厂家',
  dl_qlowknd_purchase_date DATETIME COMMENT '采购日期',
  dl_qlowknd_date_of DATETIME COMMENT '有效期',
  dl_qlowknd_waste_status VARCHAR(50) COMMENT '报废状态',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据备份表';

-- 7. 操作日志表
DROP TABLE IF EXISTS dl_vjkqywmqn_log;
CREATE TABLE dl_vjkqywmqn_log (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_foerilg_component_number VARCHAR(100) COMMENT '元件编号',
  dl_foerilg_component_type VARCHAR(100) COMMENT '元件类型',
  dl_foerilg_component_parameter VARCHAR(200) COMMENT '元件参数',
  dl_foerilg_debug_number VARCHAR(100) COMMENT '调试编号',
  dl_foerilg_debugging_time DATETIME COMMENT '调试时间',
  dl_foerilg_debugging_results VARCHAR(500) COMMENT '调试结果',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志表';

-- 8. 数据统计表
DROP TABLE IF EXISTS dl_vrsbyluvz_statistics;
CREATE TABLE dl_vrsbyluvz_statistics (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
  dl_yfswnh_component_number VARCHAR(100) COMMENT '元件编号',
  dl_yfswnh_component_name VARCHAR(200) COMMENT '元件名称',
  dl_yfswnh_component_type VARCHAR(100) COMMENT '元件类型',
  dl_yfswnh_component_parameter VARCHAR(200) COMMENT '元件参数',
  dl_yfswnh_installation_position VARCHAR(200) COMMENT '安装位置',
  dl_yfswnh_installation_time DATETIME COMMENT '安装时间',
  dl_yfswnh_usage_status VARCHAR(50) COMMENT '使用状态',
  dl_yfswnh_supplier VARCHAR(200) COMMENT '供应商',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据统计表';

-- ============================================
-- 插入示例数据
-- ============================================

-- 电路信息示例数据
INSERT INTO dl_peyugrjz_information (dl_sdsgks_name, dl_sdsgks_number, dl_sdsgks_type, dl_sdsgks_rated_voltage, dl_sdsgks_rated_current, dl_sdsgks_rated_power, dl_sdsgks_installation_position, dl_sdsgks_debugging_personnel, dl_sdsgks_debugging_results)
VALUES
('电阻R1', 'CMP-001', '电阻', '220V', '2A', '440W', '机柜A-01', '张工', '调试通过'),
('电容C1', 'CMP-002', '电容', '380V', '5A', '1900W', '机柜A-02', '李工', '调试通过'),
('电感L1', 'CMP-003', '电感', '110V', '1A', '110W', '机柜B-01', '王工', '待复检'),
('二极管D1', 'CMP-004', '二极管', '12V', '0.5A', '6W', '机柜B-02', '赵工', '调试通过'),
('三极管Q1', 'CMP-005', '三极管', '24V', '3A', '72W', '机柜C-01', '张工', '调试中');

-- 元件信息示例数据
INSERT INTO dl_jrlqmxd_information (dl_rbvlxtc_name, dl_rbvlxtc_number, dl_rbvlxtc_specifications, dl_rbvlxtc_manufacturer, dl_rbvlxtc_installation_position, dl_rbvlxtc_debugging_personnel, dl_rbvlxtc_debugging_results)
VALUES
('精密电阻', 'ELM-001', '1kΩ ±1%', '深圳华强电子', '工位1-A', '张工', '合格'),
('电解电容', 'ELM-002', '100μF 50V', '东莞电子厂', '工位1-B', '李工', '合格'),
('功率电感', 'ELM-003', '10mH 2A', '苏州元件厂', '工位2-A', '王工', '待检测');

-- 调试信息示例数据
INSERT INTO dl_ekjaud_information (dl_nojsmbk_component_name, dl_nojsmbk_number, dl_nojsmbk_component_type, dl_nojsmbk_rated_voltage, dl_nojsmbk_rated_current, dl_nojsmbk_rated_power, dl_nojsmbk_installation_position, dl_nojsmbk_debugging_results)
VALUES
('电阻R1', 'DBG-001', '电阻', '220V', '2A', '440W', 'Lab-A', '参数正常，调试通过'),
('电容C1', 'DBG-002', '电容', '380V', '5A', '1900W', 'Lab-B', '容量偏差3%，建议更换'),
('电感L1', 'DBG-003', '电感', '110V', '1A', '110W', 'Lab-A', '电感值正常，调试通过');

SELECT '数据库初始化完成！' AS message;
