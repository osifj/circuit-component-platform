<template>
  <div class="dashboard">
    <el-row :gutter="20">
      <el-col :span="6" v-for="card in cards" :key="card.title">
        <el-card class="stat-card" shadow="hover">
          <div class="stat-content">
            <el-icon :size="40" :color="card.color"><component :is="card.icon" /></el-icon>
            <div class="stat-info">
              <div class="stat-value">{{ card.value }}</div>
              <div class="stat-title">{{ card.title }}</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="16">
        <el-card shadow="hover">
          <template #header>
            <span>电路元件调试趋势</span>
          </template>
          <div ref="chartRef" style="height: 350px"></div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card shadow="hover">
          <template #header>
            <span>元件类型分布</span>
          </template>
          <div ref="pieRef" style="height: 350px"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'

const chartRef = ref(null)
const pieRef = ref(null)

const cards = [
  { title: '电路元件总数', value: 128, icon: 'Cpu', color: '#409EFF' },
  { title: '已完成调试', value: 96, icon: 'CircleCheck', color: '#67C23A' },
  { title: '待调试元件', value: 32, icon: 'Clock', color: '#E6A23C' },
  { title: '报警信息', value: 5, icon: 'Bell', color: '#F56C6C' }
]

onMounted(() => {
  // Trend chart
  if (chartRef.value) {
    const chart = echarts.init(chartRef.value)
    chart.setOption({
      tooltip: { trigger: 'axis' },
      xAxis: {
        type: 'category',
        data: ['1月', '2月', '3月', '4月', '5月', '6月']
      },
      yAxis: { type: 'value' },
      series: [
        { name: '调试完成', type: 'line', data: [12, 18, 25, 22, 30, 28], smooth: true, color: '#67C23A' },
        { name: '新增元件', type: 'line', data: [15, 20, 22, 18, 25, 20], smooth: true, color: '#409EFF' }
      ]
    })
    window.addEventListener('resize', () => chart.resize())
  }

  // Pie chart
  if (pieRef.value) {
    const pie = echarts.init(pieRef.value)
    pie.setOption({
      tooltip: { trigger: 'item' },
      series: [{
        type: 'pie',
        radius: ['45%', '75%'],
        data: [
          { value: 40, name: '电阻' },
          { value: 30, name: '电容' },
          { value: 20, name: '电感' },
          { value: 10, name: '二极管' }
        ]
      }]
    })
    window.addEventListener('resize', () => pie.resize())
  }
})
</script>

<style scoped>
.stat-card {
  cursor: pointer;
}
.stat-content {
  display: flex;
  align-items: center;
  gap: 16px;
}
.stat-info {
  flex: 1;
}
.stat-value {
  font-size: 28px;
  font-weight: bold;
  color: #303133;
}
.stat-title {
  font-size: 14px;
  color: #909399;
  margin-top: 4px;
}
</style>
