const { default: api } = require("../../utils/api")

// subpkg/article_detail/article_detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    articleId: 0,
    like: '../../icons/like.png',
    articleEntity: {},
    articleTitle:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.initIcon(options.id)
    this.setData({
      articleId: options.id,
      articleTitle: options.title
    })
    wx.setNavigationBarTitle({
      title: options.title || '文章详情',
    })
    this.getArticleDetail(options.id)
  },
  initIcon(id){
      const articleIds = wx.getStorageSync('articleId') || [];
    console.log(articleIds)
    try {    
       const isLisk = articleIds.includes(id)
      if (isLisk) {  
        this.setData({
          like: '../../icons/_like.png'
        })  
      } else {  
        console.log('未找到要删除的值');  
      }  
    } catch (error) {  
      console.error('读取或设置本地缓存时发生错误:', error);  
    }
  },
  handleIcon(){
    const articleIds = wx.getStorageSync('articleId') || [];
    this.setData({
      like: this.data.like === '../../icons/like.png' ? '../../icons/_like.png' : '../../icons/like.png'
    })
    if(this.data.like === '../../icons/_like.png'){
      articleIds.push(this.data.articleId)
      const list =  this.removeDuplicates(articleIds)
      wx.setStorageSync('articleId', list)
    }else{
    try {    
      const indexToDelete = articleIds.indexOf(this.data.articleId);  
      if (indexToDelete !== -1) {  
        articleIds.splice(indexToDelete, 1); 
        const list =  this.removeDuplicates(articleIds) 
        wx.setStorageSync('articleId', list);  
      } else {  
        console.log('未找到要删除的值');  
      }  
    } catch (error) {  
      console.error('读取或设置本地缓存时发生错误:', error);  
    }
        }
  },

  async getArticleDetail(id){
    api.getArticleDetail(id).then(res => {
      this.setData({
        articleEntity : res.data
      })
    })
  } ,
  removeDuplicates(list) {  
    const seen = {};  
    return list.filter(item => {  
      if (!seen[item]) {  
        seen[item] = true;  
        return true;  
      }  
      return false;  
    });  
  }  ,
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