const { default: api } = require("../../utils/api")

// subpkg/tree_msg/tree_msg.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    wFlag:false,
    rFlag:false,
    sFlag:false,
    writeValue: '',
    msgList: null,
    replyList: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    wx.setNavigationBarTitle({
      title: options.type,
    })
    this.initPage(options.type)
  },
  initPage(type){
    switch(type){
      case '我要留言':
        this.writeMsg()
        break
      case '我的留言':
        this.showMsg()
        break
      case '我的回复':
        this.replyMsg()
        break
    }
  },
  writeMsg(){
    this.setData({
      wFlag: true
    })
  },
  async showMsg(){
    this.setData({
      sFlag: true
    })
    api.showTreeMsg().then(res => {
      if(res.data.length !== 0){
        this.setData({
          msgList: res.data
        })
      } 
    })
  },
  async replyMsg(){
    this.setData({
      rFlag: true
    })
    api.replyMsg().then(res => {
      if(res.code === 0){
        this.setData({
          replyList: res.data
        })
      }else{
        wx.showToast({
          title: '暂无回复',
          icon: 'success'
        })
      }
    })
  },
  async handleWSend(){
    let param = {
      token : wx.getStorageSync('token') | '',
      content: this.data.writeValue
    }
    api.writeTreeMsg(param).then(res => {
      if(res.code === 0){
        wx.showToast({
          title: '发送成功',
          icon: 'success'
        })
      }
      this.setData({
        writeValue: ''
      })
    })
  },
  bindinput(e){
    this.setData({
      writeValue: e.detail.value
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