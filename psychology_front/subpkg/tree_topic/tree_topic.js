const { default: api } = require("../../utils/api")

// subpkg/tree_topic/tree_topic.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topicEntity: {},
    userInfo: {
      avatarUrl: '',
      nickname: '匿名'
    },
    title: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      title: options.title
    })
    wx.setNavigationBarTitle({
      title: options.title,
    })
    this.initTreeTopic(options.id)
  },
  async initTreeTopic(id){
    api.getTopicEntity(id).then(res =>{
      this.setData({
        topicEntity: res.data
      })
      if(res.data.type === '0' | res.data.type === 0){
        this.getUesrInfo(res.data.userId)
      }
    })
  },
  async getUesrInfo(userId){
    console.log(userId)
    api.getUserName(this.data.topicEntity.userId).then(res => {
      this.setData({
        userInfo: res.data
      })
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})