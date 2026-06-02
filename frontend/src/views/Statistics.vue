<template>
  <div class="page">
    <el-row :gutter="20">
      <el-col :span="8" v-for="card in statCards" :key="card.title">
        <el-card class="stat-card" shadow="hover">
          <div class="stat-content">
            <el-icon :size="36" :color="card.color"><component :is="card.icon" /></el-icon>
            <div class="stat-info">
              <div class="stat-value">{{ card.value }}</div>
              <div class="stat-title">{{ card.title }}</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="20" style="margin-top:20px">
      <el-col :span="12">
        <el-card shadow="hover">
          <template #header><span>元件调试状态分布</span></template>
          <div ref="barRef" style="height: 350px"></div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card shadow="hover">
          <template #header><span>月度调试统计</span></template>
          <div ref="lineRef" style="height: 350px"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref, onMounted, reactive } from 'vue'
import * as echarts from 'echarts'
import { statisticsApi } from '@/api'

const barRef = ref(null)
const lineRef = ref(null)

const statCards = reactive([
  { title: '总元件数', value: 0, icon: 'Cpu', color: '#409EFF' }
])

onMounted(async () => {
  try {
    const res = await statisticsApi.summary()
    if (res.code === 200 && res.data) {
      statCards[0].value = res.data.totalComponents || 0
    }
  } catch (e) {}

  if (barRef.value) {
    const bar = echarts.init(barRef.value)
    bar.setOption({
      tooltip: { trigger: 'axis' },
      xAxis: { type: 'category', data: ['电阻', '电容', '电感', '二极管', '三极管'] },
      yAxis: { type: 'value' },
      series: [
        { name: '已完成', type: 'bar', data: [35, 28, 18, 8, 7], color: '#67C23A' },
        { name: '待调试', type: 'bar', data: [5, 2, 2, 2, 3], color: '#E6A23C' }
      ]
    })
  }

  if (lineRef.value) {
    const line = echarts.init(lineRef.value)
    line.setOption({
      tooltip: { trigger: 'axis' },
      xAxis: { type: 'category', data: ['1月','2月','3月','4月','5月','6月'] },
      yAxis: { type: 'value' },
      series: [{ type: 'line', data: [10, 15, 20, 18, 22, 25], smooth: true, color: '#409EFF' }]
    })
  }
})
</script>

<style scoped>
.stat-card { cursor: pointer; }
.stat-content { display: flex; align-items: center; gap: 16px; }
.stat-value { font-size: 28px; font-weight: bold; color: #303133; }
.stat-title { font-size: 14px; color: #909399; margin-top: 4px; }
</style>
