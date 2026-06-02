# 电路元件参数匹配与调试平台

> **Circuit Component Parameter Matching & Debugging Platform**  
> 一个基于 Spring Boot + Vue 3 的全栈管理系统，用于电路元件的参数匹配、调试记录和数据统计分析。

---

## 📖 目录

- [项目简介](#项目简介)
- [功能概览](#功能概览)
- [技术架构](#技术架构)
- [项目结构](#项目结构)
- [环境要求](#环境要求)
- [⚡ 快速开始（小白友好）](#-快速开始小白友好)
  - [第一步：安装必备软件](#第一步安装必备软件)
  - [第二步：初始化数据库](#第二步初始化数据库)
  - [第三步：启动后端](#第三步启动后端)
  - [第四步：启动前端](#第四步启动前端)
  - [第五步：打开浏览器](#第五步打开浏览器)
- [📋 页面功能详解](#-页面功能详解)
- [🔧 常见问题排查](#-常见问题排查)
- [📡 API 接口文档](#-api-接口文档)

---

## 项目简介

本平台面向电路元件参数匹配与调试场景，提供以下核心能力：

- 📊 **系统概览仪表盘** — 实时展示元件总数、调试进度、报警情况
- 📦 **元件信息管理** — 管理元件规格、生产厂家、安装位置等基本信息
- ⚡ **电路信息管理** — 管理元件的电气参数（额定电压、电流、功率）
- 🔗 **参数匹配** — 记录元件参数的匹配关系
- 🔍 **调试信息** — 记录和管理每次调试的结果
- 🚨 **报警信息** — 异常参数报警记录
- 📈 **数据统计** — 可视化图表展示统计数据

---

## 功能概览

| 页面 | 路由 | 功能 |
|------|------|------|
| 🏠 系统概览 | `/dashboard` | 4 个统计卡片 + 趋势折线图 + 元件类型饼图 |
| 📦 元件信息管理 | `/component-info` | 增删改查、按名称/编号搜索 |
| ⚡ 电路信息管理 | `/circuit-info` | 增删改查、电气参数管理 |
| 🔗 参数匹配 | `/param-match` | 增删改查、匹配关系管理 |
| 🔍 调试信息 | `/debug-info` | 增删改查、按安装位置查询 |
| 🚨 报警信息 | `/alarm-info` | 增删改查、异常记录管理 |
| 📈 数据统计 | `/statistics` | 统计卡片 + 柱状图 + 折线图 |

---

## 技术架构

```
┌─────────────────────────────────────────┐
│              浏览器 (Vue 3)              │
│    Element Plus + ECharts + Axios       │
└──────────────┬──────────────────────────┘
               │ HTTP/REST (端口 3000→8080)
┌──────────────▼──────────────────────────┐
│         Spring Boot 2.7 (Java)          │
│    Controller → Service → Mapper        │
└──────────────┬──────────────────────────┘
               │ JDBC
┌──────────────▼──────────────────────────┐
│              MySQL 5.7+                 │
│          circuit_platform 库            │
└─────────────────────────────────────────┘
```

| 层级 | 技术 | 说明 |
|------|------|------|
| 前端框架 | Vue 3 + Vite | 响应式 SPA 应用 |
| UI 组件库 | Element Plus | 饿了么出品的企业级 UI 组件 |
| 图表库 | ECharts 5 | 百度出品的可视化图表库 |
| HTTP 客户端 | Axios | 前端请求后端接口 |
| 后端框架 | Spring Boot 2.7.18 | Java 生态最流行的微服务框架 |
| ORM | MyBatis 2.3 | 灵活的 SQL 映射框架 |
| 数据库 | MySQL | 关系型数据库 |
| API 文档 | Swagger 2 (Springfox) | 自动生成接口文档 |
| 代码简化 | Lombok | 减少样板代码 |

---

## 项目结构

```
circuit-platform/
├── backend/                          # 🔧 Spring Boot 后端
│   ├── pom.xml                       # Maven 依赖配置
│   └── src/main/
│       ├── java/com/dlyjcsppydspt/
│       │   ├── CircuitApplication.java    # 🚀 启动类 (运行这个文件)
│       │   ├── api/
│       │   │   ├── controller/       # 🌐 控制器 (接收前端请求)
│       │   │   │   ├── DlPeyugrjzInformationController.java  # 电路信息
│       │   │   │   ├── DlJrlqmxdInformationController.java  # 元件信息
│       │   │   │   ├── DlJpixcMatchController.java          # 参数匹配
│       │   │   │   ├── DlEkjaudInformationController.java   # 调试信息
│       │   │   │   ├── DlCnonfbotInformationController.java # 报警信息
│       │   │   │   └── DlVrsbyluvzStatisticsController.java # 数据统计
│       │   │   ├── domain/           # 📦 实体类 (对应数据库表)
│       │   │   ├── mapper/           # 🗺️  Mapper 接口 (Java)
│       │   │   └── service/          # ⚙️  服务层 (业务逻辑)
│       │   │       └── impl/         #     服务实现
│       │   ├── config/               # 🔩 配置类
│       │   │   ├── SwaggerConfig.java # Swagger API 文档配置
│       │   │   └── CorsConfig.java    # 跨域配置
│       │   └── utils/                # 🧰 工具类
│       │       ├── ResultVo.java      # 统一返回格式
│       │       ├── ResultVoUtil.java  # 返回工具方法
│       │       ├── StringUtils.java   # 字符串工具
│       │       └── UUID.java          # ID 生成器
│       └── resources/
│           ├── application.yml       # ⚙️ 应用配置 (数据库连接等)
│           ├── init.sql              # 🗄️ 数据库初始化脚本
│           └── mapper/               # 📄 MyBatis XML 映射文件
│
├── frontend/                         # 🎨 Vue 3 前端
│   ├── index.html                    # HTML 入口
│   ├── package.json                  # npm 依赖配置
│   ├── vite.config.js                # Vite 构建配置
│   └── src/
│       ├── main.js                   # 🚀 前端入口
│       ├── App.vue                   # 🏗️ 主布局 (侧边栏+顶栏+内容区)
│       ├── router/index.js           # 🧭 路由配置
│       ├── api/
│       │   ├── request.js            # Axios 请求封装
│       │   └── index.js              # 各模块 API 方法
│       └── views/                    # 📄 页面组件
│           ├── Dashboard.vue         # 系统概览
│           ├── ComponentInfo.vue      # 元件信息管理
│           ├── CircuitInfo.vue        # 电路信息管理
│           ├── ParamMatch.vue         # 参数匹配
│           ├── DebugInfo.vue          # 调试信息
│           ├── AlarmInfo.vue          # 报警信息
│           └── Statistics.vue         # 数据统计
│
├── .gitignore
└── README.md
```

---

## 环境要求

| 软件 | 最低版本 | 检查命令 | 下载地址 |
|------|----------|----------|----------|
| ☕ JDK | 1.8 / 8 | `java -version` | [Adoptium](https://adoptium.net/) |
| 📦 Maven | 3.6 | `mvn -v` | [Maven](https://maven.apache.org/download.cgi) |
| 🗄️ MySQL | 5.7 | `mysql --version` | [MySQL](https://dev.mysql.com/downloads/mysql/) |
| 🟢 Node.js | 18 | `node -v` | [Node.js](https://nodejs.org/) |
| 📋 npm | 9 | `npm -v` | (随 Node.js 附带) |

> **💡 提示**：如果你还没有安装这些软件，可以跳到下面 [第一步](#第一步安装必备软件) 查看安装指引。

---

## ⚡ 快速开始（小白友好）

### 第一步：安装必备软件

<details>
<summary><b>☕ 安装 JDK（点击展开）</b></summary>

1. 打开 [Adoptium 下载页](https://adoptium.net/download/)
2. 选择 **JDK 8**，下载对应操作系统的安装包
3. 安装后打开终端（Mac）/ 命令提示符（Windows），运行：
   ```bash
   java -version
   ```
   看到版本号即安装成功。
</details>

<details>
<summary><b>📦 安装 Maven（点击展开）</b></summary>

**Mac：**
```bash
brew install maven
```
**Windows：**
1. 下载 [Maven 二进制包](https://maven.apache.org/download.cgi)
2. 解压到 `C:\Program Files\Maven`
3. 添加 `C:\Program Files\Maven\bin` 到系统 PATH
4. 验证：`mvn -v`
</details>

<details>
<summary><b>🗄️ 安装 MySQL（点击展开）</b></summary>

**Mac：**
```bash
brew install mysql@5.7
brew services start mysql@5.7
```
**Windows：**
1. 下载 [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
2. 安装时记住 root 密码（建议设为 `root`）
</details>

<details>
<summary><b>🟢 安装 Node.js（点击展开）</b></summary>

1. 打开 [Node.js 官网](https://nodejs.org/)
2. 下载 **LTS 版本**（18.x 或 20.x）
3. 安装后验证：
   ```bash
   node -v   # 应显示 v18.x.x 或 v20.x.x
   npm -v    # 应显示 9.x.x 或 10.x.x
   ```
</details>

---

### 第二步：初始化数据库

1. **登录 MySQL：**
   ```bash
   mysql -u root -p
   ```
   输入你的 MySQL root 密码。

2. **执行初始化脚本：**
   ```sql
   source /完整路径/backend/src/main/resources/init.sql;
   ```
   > 将 `/完整路径/` 替换为项目在你电脑上的实际路径。  
   > 例如 Mac：`source /Users/你的用户名/Downloads/电路元件参数匹配与调试平台/circuit-platform/backend/src/main/resources/init.sql;`

   或者用 GUI 工具（如 Navicat、DBeaver）打开 `init.sql` 执行。

3. **验证：**
   ```sql
   USE circuit_platform;
   SHOW TABLES;
   ```
   应该看到 8 张表。

---

### 第三步：配置数据库连接

打开 `backend/src/main/resources/application.yml`，确认数据库连接信息与你的环境一致：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/circuit_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root      # 👈 改成你的 MySQL 用户名
    password: root      # 👈 改成你的 MySQL 密码
```

---

### 第四步：启动后端

```bash
# 进入后端目录
cd backend

# 下载依赖并启动（首次启动会自动下载 Maven 依赖，需要几分钟）
mvn spring-boot:run
```

看到以下输出表示启动成功：
```
电路元件参数匹配与调试平台 启动成功！
Tomcat started on port(s): 8080
```

> **💡 提示**：后端启动后不要关闭这个终端窗口。

---

### 第五步：启动前端

**新开一个终端窗口**：

```bash
# 进入前端目录
cd frontend

# 安装依赖（首次需要）
npm install

# 启动开发服务器
npm run dev
```

看到以下输出表示启动成功：
```
VITE v5.x.x  ready in xxx ms
➜  Local:   http://localhost:3000/
```

---

### 第六步：打开浏览器

在浏览器访问：**http://localhost:3000**

你会看到：
- 左侧：功能导航菜单
- 右侧：系统概览仪表盘（默认页面）
- 点击菜单项可以切换到不同功能页面

---

## 📋 页面功能详解

### 🏠 系统概览 (`/dashboard`)

![Dashboard 示意]

- **4 个统计卡片**：电路元件总数、已完成调试、待调试元件、报警信息
- **调试趋势折线图**：展示近 6 个月调试完成和新增元件的趋势
- **元件类型饼图**：展示电阻/电容/电感/二极管等类型占比

### 📦 元件信息管理 (`/component-info`)

管理电路元件的**物理属性**（规格、厂家、安装位置）。

| 操作 | 说明 |
|------|------|
| 🔍 查询 | 按元件名称、编号模糊搜索 |
| ➕ 添加 | 点击"添加元件"按钮，填写信息后保存 |
| ✏️ 编辑 | 点击表格中的"编辑"按钮，修改后保存 |
| 🗑️ 删除 | 点击"删除"按钮，确认后删除 |

### ⚡ 电路信息管理 (`/circuit-info`)

管理电路元件的**电气参数**（电压、电流、功率）。

| 字段 | 说明 | 示例 |
|------|------|------|
| 元件名称 | 元件标识名 | 电阻R1 |
| 编号 | 唯一编号 | CMP-001 |
| 元件类型 | 电阻/电容/电感/二极管/三极管 | 电阻 |
| 额定电压 | 额定工作电压 | 220V |
| 额定电流 | 额定工作电流 | 2A |
| 额定功率 | 额定功率 | 440W |
| 安装位置 | 物理安装位置 | 机柜A-01 |
| 调试人员 | 负责调试的人员 | 张工 |
| 调试结果 | 调试结论 | 调试通过 |

### 🔗 参数匹配 (`/param-match`)

记录电路元件参数的**匹配关系**，用于核对元件参数是否满足设计要求。

### 🔍 调试信息 (`/debug-info`)

记录每次调试的**详细结果**，支持按安装位置查询。

### 🚨 报警信息 (`/alarm-info`)

记录参数异常、调试失败的**报警信息**，包含参数值、匹配方法、备注等。

### 📈 数据统计 (`/statistics`)

- 统计卡片展示关键指标
- 元件调试状态柱状图（已完成 vs 待调试）
- 月度调试趋势折线图

---

## 📡 API 接口文档

后端启动后，访问 Swagger UI 查看所有接口：

👉 **http://localhost:8080/swagger-ui.html**

你可以直接在 Swagger 页面上测试接口，无需 Postman！

主要的 API 端点：

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/peyugrjz-information/list` | 查询电路信息列表 |
| POST | `/api/peyugrjz-information/save` | 添加电路信息 |
| PUT | `/api/peyugrjz-information/update` | 更新电路信息 |
| DELETE | `/api/peyugrjz-information/{id}` | 删除电路信息 |
| GET | `/api/jrlqmxd-information/list` | 查询元件信息列表 |
| POST | `/api/jrlqmxd-information/save` | 添加元件信息 |
| GET | `/api/jpixc-match/list` | 查询参数匹配列表 |
| GET | `/api/ekjaud-information/list` | 查询调试信息列表 |
| GET | `/api/cnonfbot-information/list` | 查询报警信息列表 |
| GET | `/api/statistics/summary` | 获取统计概览 |

---

## 🔧 常见问题排查

### ❌ 后端启动报错 "Access denied for user"

**原因**：MySQL 用户名或密码配置错误。

**解决**：
1. 确认 MySQL 能正常登录：`mysql -u root -p`
2. 修改 `backend/src/main/resources/application.yml` 中的 `username` 和 `password`
3. 重新启动后端

### ❌ 后端启动报错 "Unknown database 'circuit_platform'"

**原因**：数据库还未创建。

**解决**：执行 [第二步：初始化数据库](#第二步初始化数据库)

### ❌ 前端页面空白 / 数据加载不出来

**原因**：后端未启动或端口被占用。

**解决**：
1. 确认后端已启动（看到 "启动成功" 日志）
2. 检查 8080 端口是否被占用：
   ```bash
   # Mac
   lsof -i :8080
   # Windows
   netstat -ano | findstr :8080
   ```

### ❌ `npm install` 报错

**原因**：Node.js 版本太低或网络问题。

**解决**：
1. 升级 Node.js 到 18+：`node -v`
2. 尝试使用淘宝镜像：
   ```bash
   npm config set registry https://registry.npmmirror.com
   npm install
   ```

### ❌ `mvn` 命令找不到

**原因**：Maven 未安装或未配置到 PATH。

**解决**：参考 [安装 Maven](#第一步安装必备软件)

### ❌ 端口 8080 被占用

**解决**：修改 `backend/src/main/resources/application.yml`：
```yaml
server:
  port: 8081   # 改成其他端口
```
同时修改 `frontend/vite.config.js` 中的代理目标：
```js
proxy: {
  '/api': {
    target: 'http://localhost:8081',  // 改为对应端口
    changeOrigin: true
  }
}
```

---

## 🛠️ 开发相关

### 打包部署

**后端打包：**
```bash
cd backend
mvn clean package -DskipTests
java -jar target/circuit-component-platform-1.0.0.jar
```

**前端打包：**
```bash
cd frontend
npm run build
# 产物在 dist/ 目录，可部署到 Nginx 等静态服务器
```

### 修改数据库表结构

1. 修改 `backend/src/main/java/com/dlyjcsppydspt/api/domain/` 下的实体类
2. 修改 `backend/src/main/resources/mapper/` 下的 XML 映射文件
3. 修改 `backend/src/main/java/com/dlyjcsppydspt/api/mapper/` 下的 Mapper 接口
4. 修改对应的 Service 和 Controller
5. 同步修改数据库表结构

---

## 📄 License

本项目仅用于学习和研究目的。

---

> **🤝 获取帮助**：如果你在运行过程中遇到任何问题，欢迎提 [GitHub Issue](https://github.com/osifj/circuit-component-platform/issues)。
