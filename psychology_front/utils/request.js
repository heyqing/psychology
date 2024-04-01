// request.js
// const baseUrl="http://localhost:8080";
const baseUrl="http://192.168.113.144:8080";
module.exports = {
    /*
     * url:请求的接口地址
     * methodType:请求方式
     * data: 要传递的参数
    */
    request: function (url, methodType, data) {
        let fullUrl = `${baseUrl}${url}`
        // 获取Token或Cookie 没有则为空字符串
        let Cookie = wx.getStorageSync('Cookie') ||  ''
        wx.showLoading({ title: "加载中" });
        return new Promise((resolve, reject) => {
            wx.request({
                url: fullUrl,
                method: methodType,
                data,
                header: {
                    'content-type': 'application/json', // 默认值
                    'Cookie':`${ Cookie }`,
                    // 'Cookie':`PHPSESSID=${ Cookie }`
                },
                success: (res) => {
                    console.log("请求结果",res.data);
                    resolve(res.data)
                },
                fail: (err) => {
                    console.log(err);
                    wx.showToast({
                        title: '接口请求错误',
                        icon: 'none'
                    })
                    reject('接口请求错误')
                },
                complete: () => {
                    wx.hideLoading()
                }
            })
        })
    }
}
