<template>
  <div class="page">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>报警信息管理</span>
          <el-button type="primary" :icon="Plus" @click="handleAdd">添加报警信息</el-button>
        </div>
      </template>

      <el-table :data="tableData" border stripe v-loading="loading">
        <el-table-column prop="id" label="ID" width="60" />
        <el-table-column prop="dlyjcsppydsptNumber" label="编号" />
        <el-table-column prop="dlyjcsppydsptComponentName" label="元件名称" />
        <el-table-column prop="dlyjcsppydsptParameterValue" label="参数值" />
        <el-table-column prop="dlyjcsppydsptMatchingMethod" label="匹配方法" />
        <el-table-column prop="dlyjcsppydsptDebuggingResults" label="调试结果" />
        <el-table-column prop="dlyjcsppydsptRemarks" label="备注" />
        <el-table-column label="操作" width="180" fixed="right">
          <template #default="{ row }">
            <el-button type="primary" size="small" @click="handleEdit(row)">编辑</el-button>
            <el-button type="danger" size="small" @click="handleDelete(row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination style="margin-top:16px" v-model:current-page="pageNum" :total="total" layout="total,prev,pager,next" @current-change="fetchData" />
    </el-card>

    <el-dialog :title="dialogTitle" v-model="dialogVisible" width="500px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="编号"><el-input v-model="form.dlyjcsppydsptNumber" /></el-form-item>
        <el-form-item label="元件名称"><el-input v-model="form.dlyjcsppydsptComponentName" /></el-form-item>
        <el-form-item label="参数值"><el-input v-model="form.dlyjcsppydsptParameterValue" /></el-form-item>
        <el-form-item label="匹配方法"><el-input v-model="form.dlyjcsppydsptMatchingMethod" /></el-form-item>
        <el-form-item label="调试结果"><el-input v-model="form.dlyjcsppydsptDebuggingResults" /></el-form-item>
        <el-form-item label="备注"><el-input v-model="form.dlyjcsppydsptRemarks" /></el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSave">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import { alarmApi } from '@/api'

const loading = ref(false)
const tableData = ref([])
const pageNum = ref(1)
const total = ref(0)
const dialogVisible = ref(false)
const dialogTitle = ref('添加报警信息')
const isEdit = ref(false)
const editId = ref(null)

const form = reactive({
  dlyjcsppydsptNumber: '', dlyjcsppydsptComponentName: '', dlyjcsppydsptParameterValue: '',
  dlyjcsppydsptMatchingMethod: '', dlyjcsppydsptDebuggingResults: '', dlyjcsppydsptRemarks: ''
})

const fetchData = async () => {
  loading.value = true
  try { const res = await alarmApi.list({ pageNum: pageNum.value }); tableData.value = res.data || []; total.value = res.data ? res.data.length : 0 }
  finally { loading.value = false }
}

const resetForm = () => Object.keys(form).forEach(k => form[k] = '')
const handleAdd = () => { isEdit.value = false; dialogTitle.value = '添加报警信息'; resetForm(); dialogVisible.value = true }
const handleEdit = (row) => { isEdit.value = true; editId.value = row.id; dialogTitle.value = '编辑报警信息'; Object.assign(form, row); dialogVisible.value = true }

const handleSave = async () => {
  try {
    if (isEdit.value) { form.id = editId.value; await alarmApi.update(form); ElMessage.success('更新成功') }
    else { await alarmApi.save(form); ElMessage.success('添加成功') }
    dialogVisible.value = false; fetchData()
  } catch (e) {}
}

const handleDelete = async (row) => {
  await ElMessageBox.confirm('确认删除？', '提示', { type: 'warning' })
  try { await alarmApi.delete(row.id); ElMessage.success('删除成功'); fetchData() } catch (e) {}
}

onMounted(fetchData)
</script>

<style scoped>
.page { height: 100%; }
.card-header { display: flex; justify-content: space-between; align-items: center; }
</style>
