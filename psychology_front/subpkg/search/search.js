import api from '../../utils/api'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topicList: [],
    // 取消 按钮 是否显示
    isFocus:false,
    // 输入框的值
    inputValue:""
  },
  TimeId:-1,
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },
  handleInput(e){
    const {value}=e.detail;
    console.log(value)
    if(!value.trim()){
      this.setData({
        isFocus:false
      })
      return;
    }
    // 3 准备发送请求获取数据
    this.setData({
      isFocus:true
    })
    clearTimeout(this.TimeId);
    this.TimeId=setTimeout(() => {
      this.search(value);
    }, 1000);
  },
  async search(q){
    api.topicSearch(q).then(res=>{
      this.setData({
        topicList: res.data
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