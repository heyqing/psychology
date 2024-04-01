import api from '../../utils/api'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: 0,
    answer: true,
    index: 0,
    tip: '下一题',
    isTopic: true,
    title: '',
    desc: '',
    topicList: [],
    optionList: [],
    selectedAnswer: null,
    currentRadioValue: null,
    total: 0,
    check:false,
    answerMap: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      id: options.id
    })
    this.initTitleAndDesc(options.id)
    this.getTopicAndOptionList(options.id)
  },
  radioChange: function(e) {  
    this.setData({  
      selectedAnswer: e.detail.value  
    });  
  },  
  handleStart(){
    this.setData({
      isTopic : false
    })
    wx.showToast({
      title: '开始答题',
      icon: 'success'
    })
  },
  handleTip(){
    if(this.data.selectedAnswer === null){
      wx.showToast({
        title: '请选择',
        icon: 'error'
      })
      return;
    }
    this.setData({
      total: Number(this.data.total) + Number(this.data.selectedAnswer)
    })
    if(this.data.index < this.data.topicList.length-1){
      this.setData({
        index: this.data.index + 1
      })
    }else{
      this.setData({
        tip: '提交'
      })
      this.submit()
    }
    this.setData({
      selectedAnswer: null,
      currentRadioValue: null,
      check:false
    })
  },
  async submit(){
    let param = {
      total:this.data.total,
      id: this.data.id
    }
    api.getAnswer(param).then(res => {
      this.setData({
        answer:false,
        answerMap: res.data
      })
    })
  },
  async getTopicAndOptionList(id){
    api.getTopic(id).then(res => {
      this.setData({
        topicList: res.data
      })
    })
    api.getOption(id).then(res => {
      this.setData({
        optionList: res.data
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
  initTitleAndDesc(id){
    console.log(id)
    switch(id){
      case '0':
        console.log("pstr")
        this.setData({
          title: 'PSTR',
          desc: '\tPSTR心理压力量表由瑞士心理学家爱德沃兹于1983年编制，以德国心理学家穆瑞在1968年提出的心理压力因素理论为基础。'
        })
        break;
      case '1':
        this.setData({
          title: '儿童抑郁量表CDI',
          desc: '\t此量表是Kovacs根据成人的贝克抑郁问卷(Beck\'s Depression Inventory.BDI)改编的用于测量儿童和青少年抑郁情绪的量表，足西方最早出现的儿童抑郁问卷\n该量表适用于儿童和青少年(7-17岁之间)抑郁心理症状的自评，主要评定依据是近两周内的自我感觉CDI共有27题，包含5个因子:负面情绪:人际问题、效率低下、火感缺乏和负性自尊'
        })
        break;
      case '2':
        this.setData({
          title: 'MSSMHS',
          desc: '中国中学生心理健康量表（MSSMHS）是由我国著名心理学家中科院心理所王极盛教授根据我国中学生的文化特性与行为习惯编制的心理健康量表。属于症状取向的心理诊断量表，旨在对中学生的心理问题或心理障碍进行检测。该测试共有60个必答题目，评价10个中学生常见的心理问题，它们分别为强迫症状、偏执、敌对、人际关系敏感、抑郁、焦虑、学习压力感、适应不良、情绪不稳定、心理不平衡。'
        })
        break;
      case '3':
        this.setData({
          title: '中学生情绪智力量表(EIS)',
          desc: '亲爱的同学，请你仔细阅读以下的每一个句子，然后根据你的实际情况进行选择'
        })
        break;
      case '4':
        this.setData({
          title: '中学生人际关系综合诊断量表',
          desc: '亲爱的同学，请你仔细阅读以下的每一个句子，然后根据你的实际情况进行选择'
        })
        break;
      case '5':
        this.setData({
          title: '中学生学习方面心理测试题',
          desc: '亲爱的同学，请你仔细阅读以下的每一个句子，然后根据你的实际情况进行选择'
        })
        break;
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})