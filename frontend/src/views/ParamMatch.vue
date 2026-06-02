<template>
  <div class="page">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>参数匹配管理</span>
          <el-button type="primary" :icon="Plus" @click="handleAdd">添加匹配记录</el-button>
        </div>
      </template>

      <el-form :inline="true" :model="searchForm">
        <el-form-item label="元件名称">
          <el-input v-model="searchForm.componentName" placeholder="请输入元件名称" clearable />
        </el-form-item>
        <el-form-item label="编号">
          <el-input v-model="searchForm.number" placeholder="请输入编号" clearable />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="fetchData">查询</el-button>
          <el-button @click="resetSearch">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table :data="tableData" border stripe v-loading="loading">
        <el-table-column prop="id" label="ID" width="60" />
        <el-table-column prop="dlyjcsppydsptComponentName" label="元件名称" />
        <el-table-column prop="dlyjcsppydsptNumber" label="编号" />
        <el-table-column prop="dlyjcsppydsptRatedVoltage" label="额定电压" />
        <el-table-column prop="dlyjcsppydsptRatedCurrent" label="额定电流" />
        <el-table-column prop="dlyjcsppydsptRatedPower" label="额定功率" />
        <el-table-column prop="dlyjcsppydsptRatedVoltage2" label="额定电压范围" />
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
        <el-form-item label="元件名称"><el-input v-model="form.dlyjcsppydsptComponentName" /></el-form-item>
        <el-form-item label="编号"><el-input v-model="form.dlyjcsppydsptNumber" /></el-form-item>
        <el-form-item label="额定电压"><el-input v-model="form.dlyjcsppydsptRatedVoltage" /></el-form-item>
        <el-form-item label="额定电流"><el-input v-model="form.dlyjcsppydsptRatedCurrent" /></el-form-item>
        <el-form-item label="额定功率"><el-input v-model="form.dlyjcsppydsptRatedPower" /></el-form-item>
        <el-form-item label="额定电压范围"><el-input v-model="form.dlyjcsppydsptRatedVoltage2" /></el-form-item>
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
import { matchApi } from '@/api'

const loading = ref(false)
const tableData = ref([])
const pageNum = ref(1)
const total = ref(0)
const dialogVisible = ref(false)
const dialogTitle = ref('添加匹配记录')
const isEdit = ref(false)
const editId = ref(null)

const searchForm = reactive({ componentName: '', number: '' })
const form = reactive({
  dlyjcsppydsptComponentName: '', dlyjcsppydsptNumber: '',
  dlyjcsppydsptRatedVoltage: '', dlyjcsppydsptRatedCurrent: '',
  dlyjcsppydsptRatedPower: '', dlyjcsppydsptRatedVoltage2: ''
})

const fetchData = async () => {
  loading.value = true
  try { const res = await matchApi.list({ ...searchForm, pageNum: pageNum.value }); tableData.value = res.data || []; total.value = res.data ? res.data.length : 0 }
  finally { loading.value = false }
}

const resetSearch = () => { searchForm.componentName = ''; searchForm.number = ''; fetchData() }
const resetForm = () => Object.keys(form).forEach(k => form[k] = '')
const handleAdd = () => { isEdit.value = false; dialogTitle.value = '添加匹配记录'; resetForm(); dialogVisible.value = true }
const handleEdit = (row) => { isEdit.value = true; editId.value = row.id; dialogTitle.value = '编辑匹配记录'; Object.assign(form, row); dialogVisible.value = true }

const handleSave = async () => {
  try {
    if (isEdit.value) { form.id = editId.value; await matchApi.update(form); ElMessage.success('更新成功') }
    else { await matchApi.save(form); ElMessage.success('添加成功') }
    dialogVisible.value = false; fetchData()
  } catch (e) {}
}

const handleDelete = async (row) => {
  await ElMessageBox.confirm('确认删除？', '提示', { type: 'warning' })
  try { await matchApi.delete(row.id); ElMessage.success('删除成功'); fetchData() } catch (e) {}
}

onMounted(fetchData)
</script>

<style scoped>
.page { height: 100%; }
.card-header { display: flex; justify-content: space-between; align-items: center; }
</style>
