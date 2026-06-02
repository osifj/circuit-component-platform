# 电路元件参数匹配与调试平台

## 项目简介

电路元件参数匹配与调试平台是一个用于电路元件参数匹配和调试的管理系统。该系统能够合理分析、监控和记录系统产生的相关数据，并实时记录和处理数据信息。系统界面美观大方，具有强大的自定义导入导出功能。

## 技术栈

### 后端
- **Java 8** + **Spring Boot 2.7**
- **MyBatis** — ORM 框架
- **MySQL** — 关系数据库
- **Swagger** — API 文档
- **Lombok** — 简化代码

### 前端
- **Vue 3** + **Vite**
- **Element Plus** — UI 组件库
- **ECharts** — 数据可视化
- **Axios** — HTTP 客户端

## 项目结构

```
circuit-platform/
├── backend/                     # Spring Boot 后端
│   ├── pom.xml                  # Maven 配置
│   └── src/main/
│       ├── java/com/dlyjcsppydspt/
│       │   ├── CircuitApplication.java        # 启动类
│       │   ├── api/
│       │   │   ├── controller/  # 控制器
│       │   │   ├── domain/      # 实体类
│       │   │   ├── mapper/      # MyBatis Mapper 接口
│       │   │   └── service/     # 服务接口与实现
│       │   ├── config/          # 配置类 (Swagger, CORS)
│       │   └── utils/           # 工具类
│       └── resources/
│           ├── application.yml  # 应用配置
│           └── mapper/          # MyBatis XML 映射文件
├── frontend/                    # Vue 3 前端
│   ├── package.json
│   ├── vite.config.js
│   └── src/
│       ├── App.vue              # 主布局
│       ├── main.js              # 入口
│       ├── router/              # 路由
│       ├── api/                 # API 请求
│       └── views/               # 页面
│           ├── Dashboard.vue    # 系统概览
│           ├── ComponentInfo.vue # 元件信息管理
│           ├── CircuitInfo.vue  # 电路信息管理
│           ├── ParamMatch.vue   # 参数匹配
│           ├── DebugInfo.vue    # 调试信息
│           ├── AlarmInfo.vue    # 报警信息
│           └── Statistics.vue   # 数据统计
├── .gitignore
└── README.md
```

## 功能模块

| 模块 | 说明 |
|------|------|
| 系统概览 | 仪表盘，展示关键指标和趋势图表 |
| 元件信息管理 | 管理电路元件的基本信息（规格、厂家等） |
| 电路信息管理 | 管理电路元件的电气参数（电压、电流、功率） |
| 参数匹配 | 元件参数匹配记录管理 |
| 调试信息 | 元件调试结果管理 |
| 报警信息 | 异常报警信息管理 |
| 数据统计 | 统计图表展示 |

## 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- Node.js 18+
- npm 9+

### 1. 数据库初始化
```sql
CREATE DATABASE IF NOT EXISTS circuit_platform DEFAULT CHARACTER SET utf8mb4;
```

启动应用后，MyBatis 会根据实体类自动映射到相应表。请根据 `application.yml` 配置数据库连接信息。

### 2. 启动后端
```bash
cd backend
mvn spring-boot:run
```

后端启动后访问 http://localhost:8080
Swagger API 文档：http://localhost:8080/swagger-ui.html

### 3. 启动前端
```bash
cd frontend
npm install
npm run dev
```

前端启动后访问 http://localhost:3000

## 配置说明

编辑 `backend/src/main/resources/application.yml`：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/circuit_platform?...
    username: root
    password: root
```

## License

本项目仅用于学习和研究目的。
