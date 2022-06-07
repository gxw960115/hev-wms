(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
  templates["account_column/templates/hello"] = template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); data = data || {};
  var buffer = "", stack1, functionType="function", escapeExpression=this.escapeExpression, self=this;

function program1(depth0,data) {
  
  var buffer = "", stack1, helper;
  buffer += "\r\n                <tr>\r\n                    <td>1</td>\r\n                    <td>";
  if (helper = helpers.missionId) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.missionId); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.interfaceTable) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.interfaceTable); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.interfaceTable) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.interfaceTable); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.interfaceTable) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.interfaceTable); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.remark) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.remark); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.remark) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.remark); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.remark) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.remark); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.remark) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.remark); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.remark) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.remark); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td>";
  if (helper = helpers.remark) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.remark); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                    <td ><a href=\"details_qd.html\" class=\"fa-long-arrow-right\"></a></td>\r\n                </tr>\r\n ";
  return buffer;
  }

  buffer += "<tr class=\"fors\">\r\n                    <td>序号</td>\r\n                    <td>公司</td>\r\n                    <td>业务类型</td>\r\n                    <td>创建人</td>\r\n                    <td>创建时间</td>\r\n                    <td>字段1</td>\r\n                    <td>字段2</td>\r\n                    <td>字段3</td>\r\n                    <td>字段4</td>\r\n                    <td>字段5</td>\r\n                    <td>字段6</td>\r\n                    <td class=\"cz_s\">操作</td>\r\n                </tr>\r\n  ";
  stack1 = helpers.each.call(depth0, (depth0 && depth0.records), {hash:{},inverse:self.noop,fn:self.program(1, program1, data),data:data});
  if(stack1 || stack1 === 0) { buffer += stack1; }
  buffer += "\r\n                \r\n                   ";
  return buffer;
  });
templates["account_qdInfo/templates/tankuang"] = template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); data = data || {};
  var buffer = "", stack1, helper, functionType="function", escapeExpression=this.escapeExpression, self=this;

function program1(depth0,data) {
  
  var buffer = "", stack1, helper;
  buffer += "\r\n              <tr>\r\n                  <td id='postCode' >";
  if (helper = helpers.postCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.postCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='accountCode'>";
  if (helper = helpers.accountCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.accountCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='sglFlag'>";
  if (helper = helpers.sglFlag) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.sglFlag); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='missionType'>";
  if (helper = helpers.missionType) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.missionType); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='amount'>";
  if (helper = helpers.amount) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.amount); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='currencyAmount'>";
  if (helper = helpers.currencyAmount) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.currencyAmount); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='costCentre'>";
  if (helper = helpers.costCentre) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.costCentre); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='profitCentre'>";
  if (helper = helpers.profitCentre) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.profitCentre); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='orderNo'>";
  if (helper = helpers.orderNo) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.orderNo); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='businessScope'>";
  if (helper = helpers.businessScope) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.businessScope); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='wbsElement'>";
  if (helper = helpers.wbsElement) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.wbsElement); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='interestDate'>";
  if (helper = helpers.interestDate) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.interestDate); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='text'>";
  if (helper = helpers.text) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.text); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='quantity'>";
  if (helper = helpers.quantity) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.quantity); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='unit'>";
  if (helper = helpers.unit) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.unit); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='referenceCode'>";
  if (helper = helpers.referenceCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.referenceCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='tilte'>";
  if (helper = helpers.tilte) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.tilte); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='address'>";
  if (helper = helpers.address) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.address); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='payDate'>";
  if (helper = helpers.payDate) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.payDate); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='materialCode'>";
  if (helper = helpers.materialCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.materialCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td id='reasonCode'>";
  if (helper = helpers.reasonCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.reasonCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</td>\r\n                  <td class=\"i bianjis\"  ><i class=\"fa-pencil bianjis\"></i></td>\r\n              </tr> \r\n               ";
  return buffer;
  }

  buffer += " <div class=\"chacha\">\r\n        <input type=\"hidden\" value=\"2\" name=\"editType\" id=\"editType\">\r\n        <input type=\"hidden\" value=\"";
  if (helper = helpers.missionId) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.missionId); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" name=\"missionId\" id=\"missionId\">\r\n        \r\n          <img src=\"/assets/images/chacha.png\"/>\r\n        </div>\r\n        <p>任务单号：BK20159123132</p>\r\n        <p>公司代码：1100998973</p>\r\n        <ul class=\"ov\">\r\n          <li><span class=\"boders\">凭证日期：</span><input type=\"text\"  name=\"voucherDate\" id=\"voucherDate\" value=\"";
  if (helper = helpers.voucherDate) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.voucherDate); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">过账日期：</span><input type=\"text\" name=\"postDate\" id=\"postDate\" \r\n          value=\"";
  if (helper = helpers.postDate) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.postDate); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">凭证类型：</span><input type=\"text\" id='voucherType' name='voucherType' \r\n          value=\"";
  if (helper = helpers.voucherType) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.voucherType); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">货币：</span><input type=\"text\" id='currency' name='currency' \r\n          value=\"";
  if (helper = helpers.currency) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.currency); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">汇率：</span><input type=\"text\" id='exchangeRate' name='exchangeRate' \r\n          value=\"";
  if (helper = helpers.exchangeRate) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.exchangeRate); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">凭证编号：</span><input type=\"text\" id='voucherCode'  name='voucherCode' value=\"";
  if (helper = helpers.voucherCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.voucherCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">换算日期：</span><input type=\"text\" id='exchangeDate'  name='exchangeDate' value=\"";
  if (helper = helpers.exchangeDate) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.exchangeDate); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">参照：</span><input type=\"text\" id='refer' name='refer' \r\n            value=\"";
  if (helper = helpers.refer) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.refer); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">公司往来凭证号：</span><input type=\"text\" id='companyVoucherCode' name='companyVoucherCode' value=\"";
  if (helper = helpers.companyVoucherCode) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.companyVoucherCode); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">凭证抬头文本：</span><input type=\"text\" id='voucherHeadText' name='voucherHeadText' value=\"";
  if (helper = helpers.voucherHeadText) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.voucherHeadText); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"boders\">伙伴业务范围：</span><input type=\"text\" id='partnerBusinessScope' name='partnerBusinessScope' value=\"";
  if (helper = helpers.partnerBusinessScope) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.partnerBusinessScope); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\" /></li>\r\n          <li><span class=\"mob boders\">业务类型：</span>\r\n            <select name=\"\" class=\"selee\">\r\n              <option value=\"\">类型1</option>\r\n              <option value=\"\">类型2</option>\r\n              <option value=\"\">类型3</option>\r\n            </select>\r\n          </li>\r\n        </ul>\r\n        <div class=\"btn_xiao\">\r\n          <span class='fa fa-plus' id=\"showAdd\" ></span>\r\n\r\n        </div>\r\n        <div class=\"my_div\">\r\n     <div class=\"my_div_1\">\r\n        <div id=\"tableDiv_y\" onmousewheel=\"onwheel(event);\" onwheel=\"onwheel(event);\">\r\n           <div id=\"tableDiv_body\">\r\n            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_2\" >\r\n              <tr class=\"fors\">\r\n                  <td>记账码</td>\r\n                  <td>账目编码</td>\r\n                  <td>SGL标识</td>\r\n                  <td>事务类型</td>\r\n                  <td>金额</td>\r\n                  <td>本位币金额</td>\r\n                  <td>成本中心</td>\r\n                  <td>利润中心</td>\r\n                  <td>订单</td>\r\n                  <td>业务范围</td>\r\n                  <td>WBS元素</td>\r\n                  <td>起息日 </td>\r\n                  <td>文本 </td>\r\n                  <td>数量 </td>\r\n                  <td>单位 </td>\r\n                  <td>参考代码2</td>\r\n                  <td>标题   </td>\r\n                  <td>地址  </td>\r\n                  <td>付款基准日期 </td>\r\n                  <td>物料编码 </td>\r\n                  <td>原因代码 </td>\r\n                <td class=\"cz_s\">操作</td>\r\n              </tr>\r\n                ";
  stack1 = helpers.each.call(depth0, (depth0 && depth0.listDdtail), {hash:{},inverse:self.noop,fn:self.program(1, program1, data),data:data});
  if(stack1 || stack1 === 0) { buffer += stack1; }
  buffer += "\r\n            </table>\r\n          </div>          \r\n        </div> \r\n        </div>\r\n        </div>\r\n        <div class=\"btn_xiao\">\r\n          <span onclick=\"save();\" >保存</span>\r\n          <span class=\"qx\" onclick=\"qx()\">取消</span>\r\n        </div>";
  return buffer;
  });

})();
