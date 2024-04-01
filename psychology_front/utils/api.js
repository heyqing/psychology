// 引入文件
import { request } from './request'

export default  {
  getSwiper: () => request('/article/swiper','GET'),
  getFloor: (data) => request('/article/floor','POST',data),
  getVideo: (data) => request('/video/list','POST',data),
  getArticleDetail: (data) => request('/article/detail/' + data,'GET'),
  login: (data) => request('/user/login','POST',data),
  getMsgList: (data) => request('/chat/list','POST',data),
  saveMsg: (data) => request('/chat/save','POST',data),
  getTopic: (data) => request('/topic/'+data,'GET'),
  getOption: (data) => request('/topic/option/'+data,'GET'),
  getAnswer: (data) => request('/topic/answer','POST',data),
  getLikeArticle: (data) => request('/user/like',"POST",data),
  getTreeTopic: () => request('/tree/topic','GET'),
  topicSearch: (data) => request('/tree/search',"POST",data),
  getTopicEntity: (data) => request('/tree/topic/detail/'+data,'GET'),
  getUserName: (data) => request('/tree/topic/detail/getUser/'+data,'GET'),
  writeTreeMsg: (data) => request('/tree/msg/write','POST',data),
  showTreeMsg: () => request('/tree/msg/show','GET'),
  replyMsg: () => request('/tree/msg/reply','GET')
}
