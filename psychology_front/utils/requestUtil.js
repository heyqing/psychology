
/**
 * wx getUserProfile封装
 * @param {*} param0 
 */
export const getUserProfile=()=>{
  return new Promise((resolve,reject)=>{
    wx.getUserProfile({
      desc: '获取用户信息',
      success: (res)=>{
        resolve(res);
      },
      fail:(err)=>{
        reject(err);
      }
    })
  })
}
/**
 * wx login封装
 * @param {*} param0 
 */
export const getLogin=()=>{
  return new Promise((resolve,reject)=>{
    // 获取小程序登录成功后的code
    wx.login({
      timeout: 5000,
      success:(res)=>{
        resolve(res);
      },
      fail:(err)=>{
        reject(err);
      }
    })
  })
}
