/*
 * autor : 蔡仲瑞 date : 2014-4-24 实现jquery中仿extcard布局效果
 */
(function($) {
	var _cards = [];
	$.fn.cardLayout = function(_items,_parent) {
		if (typeof(_items) == "undefined" || _items == "" || _items.items == "" || _items.items.length == 0) {
			$(".cardLayout").each(function(index) {
						var _card = $(this).panel({
									title : $(this).context.attributes[0].nodeValue,
									width : $(_parent).width,
									height : $(_parent).height,
									fit : true,
									top : 0,
									left : 0,
									closed : true
								});
						_cards.push(_card);
					});
		} else {
			_items = _items.items;
			for(var _i=0;_i<_items.length;_i++){
				_cards.push(_items[_i].panel({
					fit : true,
					closed : true
				}));
			}
		}
		_cards[0].panel({
					closed : false
				});
		return _cards;
	}
})(jQuery);
jQuery.setActiveCard = function(_c, _n) {
	_cards = $.each(_c, function() {
				$(this).panel({
							closed : true
						});
			});
	try {
		_cards[_n].panel({
					closed : false
				});
				_cards[_n].layout();
		$.parser.parse(_cards[_n]);
	} catch (_e) {

	}
	return _cards;
};
