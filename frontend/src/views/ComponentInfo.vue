<template>
  <div class="page">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>元件信息管理</span>
          <el-button type="primary" :icon="Plus" @click="handleAdd">添加元件</el-button>
        </div>
      </template>

      <!-- Search -->
      <el-form :inline="true" :model="searchForm">
        <el-form-item label="元件名称">
          <el-input v-model="searchForm.name" placeholder="请输入元件名称" clearable />
        </el-form-item>
        <el-form-item label="编号">
          <el-input v-model="searchForm.number" placeholder="请输入编号" clearable />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="fetchData">查询</el-button>
          <el-button @click="resetSearch">重置</el-button>
        </el-form-item>
      </el-form>

      <!-- Table -->
      <el-table :data="tableData" border stripe v-loading="loading">
        <el-table-column prop="id" label="ID" width="60" />
        <el-table-column prop="dlyjcsppydsptName" label="元件名称" />
        <el-table-column prop="dlyjcsppydsptNumber" label="编号" />
        <el-table-column prop="dlyjcsppydsptSpecifications" label="规格" />
        <el-table-column prop="dlyjcsppydsptManufacturer" label="生产厂家" />
        <el-table-column prop="dlyjcsppydsptInstallationPosition" label="安装位置" />
        <el-table-column prop="dlyjcsppydsptDebuggingPersonnel" label="调试人员" />
        <el-table-column prop="dlyjcsppydsptDebuggingResults" label="调试结果" />
        <el-table-column label="操作" width="180" fixed="right">
          <template #default="{ row }">
            <el-button type="primary" size="small" @click="handleEdit(row)">编辑</el-button>
            <el-button type="danger" size="small" @click="handleDelete(row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- Pagination -->
      <el-pagination
        style="margin-top: 16px"
        v-model:current-page="pageNum"
        v-model:page-size="pageSize"
        :total="total"
        layout="total, prev, pager, next"
        @current-change="fetchData"
      />
    </el-card>

    <!-- Dialog -->
    <el-dialog :title="dialogTitle" v-model="dialogVisible" width="600px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="元件名称">
          <el-input v-model="form.dlyjcsppydsptName" />
        </el-form-item>
        <el-form-item label="编号">
          <el-input v-model="form.dlyjcsppydsptNumber" />
        </el-form-item>
        <el-form-item label="规格">
          <el-input v-model="form.dlyjcsppydsptSpecifications" />
        </el-form-item>
        <el-form-item label="生产厂家">
          <el-input v-model="form.dlyjcsppydsptManufacturer" />
        </el-form-item>
        <el-form-item label="安装位置">
          <el-input v-model="form.dlyjcsppydsptInstallationPosition" />
        </el-form-item>
        <el-form-item label="调试人员">
          <el-input v-model="form.dlyjcsppydsptDebuggingPersonnel" />
        </el-form-item>
        <el-form-item label="调试结果">
          <el-input v-model="form.dlyjcsppydsptDebuggingResults" />
        </el-form-item>
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
import { componentApi } from '@/api'

const loading = ref(false)
const tableData = ref([])
const pageNum = ref(1)
const pageSize = ref(10)
const total = ref(0)
const dialogVisible = ref(false)
const dialogTitle = ref('添加元件')
const isEdit = ref(false)
const editId = ref(null)

const searchForm = reactive({ name: '', number: '' })
const form = reactive({
  dlyjcsppydsptName: '',
  dlyjcsppydsptNumber: '',
  dlyjcsppydsptSpecifications: '',
  dlyjcsppydsptManufacturer: '',
  dlyjcsppydsptInstallationPosition: '',
  dlyjcsppydsptDebuggingPersonnel: '',
  dlyjcsppydsptDebuggingResults: ''
})

const fetchData = async () => {
  loading.value = true
  try {
    const res = await componentApi.list({ ...searchForm, pageNum: pageNum.value, pageSize: pageSize.value })
    if (res.code === 200) {
      tableData.value = res.data || []
      total.value = res.data ? res.data.length : 0
    }
  } finally {
    loading.value = false
  }
}

const resetSearch = () => {
  searchForm.name = ''
  searchForm.number = ''
  fetchData()
}

const resetForm = () => {
  Object.keys(form).forEach(k => form[k] = '')
}

const handleAdd = () => {
  isEdit.value = false
  dialogTitle.value = '添加元件'
  resetForm()
  dialogVisible.value = true
}

const handleEdit = (row) => {
  isEdit.value = true
  editId.value = row.id
  dialogTitle.value = '编辑元件'
  Object.assign(form, row)
  dialogVisible.value = true
}

const handleSave = async () => {
  try {
    if (isEdit.value) {
      form.id = editId.value
      await componentApi.update(form)
      ElMessage.success('更新成功')
    } else {
      await componentApi.save(form)
      ElMessage.success('添加成功')
    }
    dialogVisible.value = false
    fetchData()
  } catch (e) {
    // handled by interceptor
  }
}

const handleDelete = async (row) => {
  await ElMessageBox.confirm('确认删除该元件信息？', '提示', { type: 'warning' })
  try {
    await componentApi.delete(row.id)
    ElMessage.success('删除成功')
    fetchData()
  } catch (e) {
    // handled
  }
}

onMounted(fetchData)
</script>

<style scoped>
.page { height: 100%; }
.card-header { display: flex; justify-content: space-between; align-items: center; }
</style>
