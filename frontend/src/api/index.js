import request from './request'

// 元件信息 (Jrlqmxd) API
export const componentApi = {
  list: (params) => request.get('/jrlqmxd-information/list', { params }),
  save: (data) => request.post('/jrlqmxd-information/save', data),
  update: (data) => request.put('/jrlqmxd-information/update', data),
  delete: (id) => request.delete(`/jrlqmxd-information/${id}`),
  saveByDebug: (params) => request.post('/jrlqmxd-information/saveByDebug', null, { params }),
  saveBy: (params) => request.post('/jrlqmxd-information/saveBy', null, { params })
}

// 电路信息 (Peyugrjz) API
export const circuitApi = {
  list: (params) => request.get('/peyugrjz-information/list', { params }),
  getById: (id) => request.get(`/peyugrjz-information/${id}`),
  save: (data) => request.post('/peyugrjz-information/save', data),
  update: (data) => request.put('/peyugrjz-information/update', data),
  delete: (id) => request.delete(`/peyugrjz-information/${id}`),
  updateStatus: (params) => request.put('/peyugrjz-information/status', null, { params })
}

// 参数匹配 (Jpixc) API
export const matchApi = {
  list: (params) => request.get('/jpixc-match/list', { params }),
  save: (data) => request.post('/jpixc-match/save', data),
  update: (data) => request.put('/jpixc-match/update', data),
  delete: (id) => request.delete(`/jpixc-match/${id}`),
  updateMatchInfo: (params) => request.put('/jpixc-match/matchInfo', null, { params }),
  saveMatch: (params) => request.post('/jpixc-match/saveMatch', null, { params })
}

// 调试信息 (Ekjaud) API
export const debugApi = {
  list: (params) => request.get('/ekjaud-information/list', { params }),
  save: (data) => request.post('/ekjaud-information/save', data),
  update: (data) => request.put('/ekjaud-information/update', data),
  delete: (id) => request.delete(`/ekjaud-information/${id}`),
  queryByInstall: (params) => request.get('/ekjaud-information/queryByInstall', { params }),
  updateInfo: (params) => request.put('/ekjaud-information/updateInfo', null, { params }),
  saveDebugInfo: (params) => request.post('/ekjaud-information/saveDebugInfo', null, { params })
}

// 报警信息 (Cnonfbot) API
export const alarmApi = {
  list: (params) => request.get('/cnonfbot-information/list', { params }),
  save: (data) => request.post('/cnonfbot-information/save', data),
  update: (data) => request.put('/cnonfbot-information/update', data),
  delete: (id) => request.delete(`/cnonfbot-information/${id}`)
}

// 数据统计 API
export const statisticsApi = {
  summary: () => request.get('/statistics/summary')
}
