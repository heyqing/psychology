import api from '../../utils/api'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    articleList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    
  },
  async initArticle(){
    try {    
      const articleIds = wx.getStorageSync('articleId') || [];  
      api.getLikeArticle(articleIds).then(res => {
        this.setData({
          articleList: res.data
        })
      })
    } catch (error) {  
      console.error('读取或设置本地缓存时发生错误:', error);  
    }
    
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
    this.initArticle()
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