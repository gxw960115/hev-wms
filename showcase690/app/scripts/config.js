this.require.define({"search/config":function(exports, require, module){(function() {
  var Properties;

  Properties = require("eevee/config/properties");

  module.exports = function() {
    var hotWordProperty, positionProperty, widthProperty;
    this.baseInfo.name = "搜索栏热词";
    this.baseInfo.description = "搜索栏热词推荐组件。";
    this.configs.ext = {
      name: "组件设置"
    };
    widthProperty = new Properties.Property(this, {
      name: "widthSize",
      label: "组件宽度",
      description: "为组件选择宽度",
      type: "radio",
      options: {
        "big-form": "530",
        "small-form": "400"
      },
      "default": "big",
      useData: true,
      reRender: true
    });
    hotWordProperty = new Properties.Property(this, {
      name: "hotwords",
      label: "热词",
      description: "可输入多个热词 中间用空格分隔 最多可输入7个",
      type: "text",
      useData: true,
      reRender: true,
      get: function() {
        var data;
        data = this._get();
        if (data === void 0) {
          return "";
        } else {
          return data.join(" ");
        }
      },
      set: function(value) {
        var hotwords;
        value = value.trim();
        if (value === "") {
          this._set(void 0);
        } else {
          hotwords = value.split(/\s+/);
          if (hotwords.length > 7) {
            Essage.show({
              message: "最多支持 7 个热词，超出部分将被忽略",
              status: "warning"
            }, 2000);
            hotwords = hotwords.slice(0, 7);
          }
        }
        return this._set(hotwords);
      }
    });
    positionProperty = new Properties.Property(this, {
      name: "position",
      label: "热词位置",
      description: "为热词选择展示位置",
      type: "radio",
      options: {
        "up": "搜索框上面",
        "down": "搜索框下面"
      },
      "default": "down",
      useData: true,
      reRender: true
    });
    return this.registerConfigProperty("ext", hotWordProperty, widthProperty, positionProperty);
  };

}).call(this);
;}});
