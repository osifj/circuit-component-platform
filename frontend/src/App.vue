<template>
  <div id="app">
    <el-container class="layout-container">
      <!-- Sidebar -->
      <el-aside width="220px" class="sidebar">
        <div class="logo">
          <el-icon :size="28"><Connection /></el-icon>
          <span>电路元件平台</span>
        </div>
        <el-menu
          :default-active="activeMenu"
          router
          background-color="#304156"
          text-color="#bfcbd9"
          active-text-color="#409EFF"
        >
          <el-menu-item index="/dashboard">
            <el-icon><DataBoard /></el-icon>
            <span>系统概览</span>
          </el-menu-item>
          <el-menu-item index="/component-info">
            <el-icon><Cpu /></el-icon>
            <span>元件信息管理</span>
          </el-menu-item>
          <el-menu-item index="/circuit-info">
            <el-icon><Monitor /></el-icon>
            <span>电路信息管理</span>
          </el-menu-item>
          <el-menu-item index="/param-match">
            <el-icon><SetUp /></el-icon>
            <span>参数匹配</span>
          </el-menu-item>
          <el-menu-item index="/debug-info">
            <el-icon><Tools /></el-icon>
            <span>调试信息</span>
          </el-menu-item>
          <el-menu-item index="/alarm-info">
            <el-icon><Bell /></el-icon>
            <span>报警信息</span>
          </el-menu-item>
          <el-menu-item index="/statistics">
            <el-icon><TrendCharts /></el-icon>
            <span>数据统计</span>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <!-- Main Content -->
      <el-container>
        <el-header class="header">
          <h2>电路元件参数匹配与调试平台</h2>
        </el-header>
        <el-main class="main-content">
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const activeMenu = computed(() => route.path)
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body, #app {
  height: 100%;
  font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;
}

.layout-container {
  height: 100%;
}

.sidebar {
  background-color: #304156;
  overflow-y: auto;
}

.logo {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  font-size: 18px;
  font-weight: bold;
  gap: 8px;
  border-bottom: 1px solid rgba(255,255,255,0.1);
}

.header {
  background: #fff;
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  align-items: center;
  padding: 0 24px;
}

.header h2 {
  font-size: 20px;
  color: #303133;
}

.main-content {
  background: #f0f2f5;
  min-height: calc(100vh - 60px);
  padding: 20px;
}
</style>
