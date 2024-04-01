import api from '../../utils/api'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isType: '',
    topicList: []
  },
  handleMsg(){
    this.setData({
      isType: 'msg'
    })
  },
  handleTopic(){
    this.setData({
      isType: 'topic'
    })
    api.getTreeTopic().then(res =>{
      this.setData({
        topicList: res.data
      })
    })
  },
  handleMsgItem(e){
    let title = ''
    switch(e.currentTarget.dataset.type){
      case '0' :
        title = '我要留言'
        break
        case '1' : 
        title = '我的留言'
        break
        case '2' : 
        title = '我的回复'
        break

    }
    wx.navigateTo({
      url: '/subpkg/tree_msg/tree_msg?type='+ title
    })
  },
  handleTopicItem(e){
    wx.navigateTo({
      url: '/subpkg/tree_topic/tree_topic?id='+ e.currentTarget.dataset.mid + '&title='+ e.currentTarget.dataset.title
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

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