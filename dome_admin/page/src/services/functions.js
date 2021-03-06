//货币的形式显示
export function showPayment(mon) {
  if (isNaN(mon) || mon == 0) {
    return '-';
  }
  let money = mon / 100;
  money = String(money);
  let left = money.split('.')[0], right = money.split('.')[1];
  right = right ? (right.length >= 2 ? '.' + right.substr(0, 2) : '.' + right + '0') : '.00';
  let temp = left.split('').reverse().join('').match(/(\d{1,3})/g);
  return (Number(money) < 0 ? "-" : "") + temp.join(',').split('').reverse().join('') + right;
}

//分转换为元，若为空则显示defaultStr
export function fenToYuan(money, defaultStr) {
  if (isNaN(money)) {
    return defaultStr;
  }
  return money / 100;
}
//百分比显示
export function Percentage(value) {
  if (isNaN(value)) {
    return '-';
  }
  if (value == 0) {
    return "-";
  }
  return parseFloat(value) * 100 + "%";
}
//百分比显示
export function Percentage2(value, defaultStr) {
  if (isNaN(value)) {
    return defaultStr;
  }
  if (value == 0) {
    return defaultStr;
  }
  return (value * 100).toFixed(2) + "%";
}
//时间格式转换
export function getYMD(time) {
  if (!time) {
    return "--";
  }
  time = time.replace(new RegExp("-", "gm"), "/"); //为了适配所有的浏览器
  var date = new Date(time);
  var y = date.getFullYear();
  var m = date.getMonth() + 1;
  var d = date.getDate();
  return y + '-' + add0(m) + '-' + add0(d);
}
//解析Josn
export function parseJSON(jsonStr){
  let jsonObj = null;
  try {
    jsonObj = JSON.parse(jsonStr);
  }catch(e){
    console.log('解析json格式失败，解析内容：',jsonStr);
  }
  return jsonObj;
}

function add0(m) {
  return m < 10 ? '0' + m : m;
}

//删除左右两端的空格
export function trim(str) {
  return str.replace(/(^\s*)|(\s*$)/g, "");
}

//判断是否是电话号码
export function isMobile(str) {
  let mobile = /^[1][3,4,5,7,8][0-9]{9}$/;
  return (mobile.test(str));
}






