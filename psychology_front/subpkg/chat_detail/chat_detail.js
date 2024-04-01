import api from '../../utils/api'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    content: [], //聊天内容 id，text, date
    mineAvatar: '../../icons/my.png',
    himAvatar: '../../icons/him.png',
    inputValue: ''
  },
  sendParam : {
    id: 0,
    text: '',
    date: ''
  },
  listParam:{
    id: 999,
    pageNum: 1,
    pageSize: 10
  },
  handleInput: function(e){
    const {value}=e.detail
    if(!value.trim()){
      return;
    }
    this.sendParam.text = value
    this.sendParam.date = this.getCurrentTime()
  },
  handleSendMsg(){
    console.log(this.sendParam)
    api.saveMsg(this.sendParam).then(res => {
      if(res.code !== 0){
        wx.showToast({
          title: '发送失败',
          icon: 'error'
        })
        return
      }else{

        this.setData({
          content:[...this.data.content,...res.data],
          inputValue: ''
        })
        this.sendParam.date = ''
        this.sendParam.text = ''
      }
      
      
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.initPage();
    this.listParam = {
      id: 999,
      pageNum: 1,
      pageSize: 10
    }
  },

  initPage(){
    //初始化页面从后端数据库中获取内容
    api.getMsgList(this.listParam).then(res => {
      this.setData({
        content : res.data
      })
    })
    if(this.listParam.pageNum * this.listParam.pageSize >= this.data.total){
      this.listParam.pageNum++
    }
  },
  getCurrentTime(){
    // 创建一个新的Date对象，它会自动设置为当前日期和时间  
    var currentDate = new Date();  
    // 获取各个部分的时间  
    var year = currentDate.getFullYear();  
    var month = currentDate.getMonth() + 1; // 注意：月份是从0开始的，所以要加1  
    var day = currentDate.getDate();  
    var hours = currentDate.getHours();  
    var minutes = currentDate.getMinutes();  
    var seconds = currentDate.getSeconds();  
      
    // 如果月份、日期、小时、分钟或秒数小于10，则在前面添加'0'  
    month = (month < 10 ? '0' : '') + month;  
    day = (day < 10 ? '0' : '') + day;  
    hours = (hours < 10 ? '0' : '') + hours;  
    minutes = (minutes < 10 ? '0' : '') + minutes;  
    seconds = (seconds < 10 ? '0' : '') + seconds;  
      
    // 将各个部分组合成一个字符串  
    var currentTime = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;  
    return currentTime
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