// pages/home/home.js
import api from "../../utils/api"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [],
    floorList: [],
    videoList: [],
    choiceType: true,
    paramArticle: {
      pageNum: 5,
      pageSize: 1,
    },
    paramVideo:{
      pageNum: 5,
      pageSize: 1,
    },
    flag: true
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.getSwiperList()
    this.getFloorList()
    this.getVideoList()
  },

  async getSwiperList(){
    api.getSwiper().then(res => {
      this.setData({
        swiperList: res.data
      })
    })
  },
  async getFloorList(){
    this.data.flag = false
     api.getFloor(this.data.paramArticle).then(res => {
        this.setData({
          floorList: res.data
        })
      })
      this.data.flag = true
  },
  async getVideoList(){
    this.data.flag = false
     api.getVideo(this.data.paramVideo).then(res =>{
       this.setData({
         videoList: res.data
       })
     })
    this.data.flag = true
  },
  handleChoiceArticle(){
    this.setData({
      choiceType: true
    })
  },
  handleChoiceVideo(){
    this.setData({
      choiceType: false
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
    if(this.data.flag){
      if(this.data.choiceType){
        this.data.paramArticle.pageNum += 1
        this.getFloorList()
      }else{
        this.data.paramVideo.pageNum += 1
        this.getVideoList()
      }
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})