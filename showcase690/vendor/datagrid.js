
//  用于下拉框的数据映射，测试用的假数据
var products = [
	{productid:'FI-SW-01',name:'Koi'},
	{productid:'K9-DL-01',name:'Dalmation'},
	{productid:'RP-SN-01',name:'Rattlesnake'},
	{productid:'RP-LI-02',name:'Iguana'},
	{productid:'FL-DSH-01',name:'Manx'},
	{productid:'FL-DLH-02',name:'Persian'},
	{productid:'AV-CB-01',name:'Amazon Parrot'}
];

// 生成表格数据的一系列操作，先生成表格，设置表格事件，设置分页控件
/* 
*	<div id="datagrid">
*		<div class="container">
*			<table class='datatable'></table> // 生成表格的地方,这个table 可以不写，因为下面会清空这里的
*		</div>
*		<div class="pagination clearfix"></div> 
*	<div>
*/
var createDataGrid = function (selector,data){
		
		// 找到相关的DOM元素，
		var gird  = $(selector);
		var container = gird.find(".container");
		
		container.html("<table class='datatable'></table>");//清空并设置表格空间
	
		var table = gird.find("table");

		var  listrecord = '<div class="row clearfix" style="float:left;">'+
								'<div class="select-kit">'+
									'<div class="select-kit-value">'+
										'<span id="">10条/页</span>'+
										'<img src="images/selectIconWhite.png">'+
									'</div>'+
									'<ul>'+
										'<li>10条/页</li>'+
										'<li>20条/页</li>'+
										'<li>30条/页</li>'+
									'</ul>'+
								'</div>'+
							'</div>';
							
		// 根据数据生成表格
		table.datagrid({
			title:'<div style="float:left;margin-right: 20px;">共计<span class="records">'+(data.total||0)+'</span>条数据</div>'+listrecord,
			iconCls:'icon-edit',
			width:1000, // 设置表格宽度
			height:250, // 设置表格高度
			singleSelect:true, //单选
			idField:'itemid',
			//url:'js/libs/easyui/data/datagrid_data.json',
			data:data.rows,
			frozenColumns:[[
				{field:'ck',checkbox:true},
				{field:'itemid',title:'序号',align:'center',width:80},
			]],
			
			//fitColumns:true, 这个选项是设置自适应表格的宽度的，
			
			columns:[[
				{field:'productid',title:'客户编码',halign:"center",align:'center',width:200,
					formatter:function(value){
						for(var i=0; i<products.length; i++){
							if (products[i].productid == value) return products[i].name;
						}
						return value;
					},
					editor:{
						type:'combobox',
						options:{
							valueField:'productid',
							textField:'name',
							data:products,
							required:true
						}
					}
				},
				{field:'listprice',title:'客户名称',width:200,halign:"center",align:'center',editor:{type:'numberbox',options:{precision:1}}},
				{field:'unitcost',title:'客户状态',width:200,halign:"center",align:'center',editor:'numberbox'},
				{field:'attr1',title:'测试栏',width:200,halign:"center",align:'center',editor:'text'},
				{field:'action',title:'其它操作',width:200,halign:"center",align:'center',
					formatter:function(value,row,index){
						/*if (row.editing){
							var s = '<a href="#" onclick="saverow(this)">Save</a> ';
							var c = '<a href="#" onclick="cancelrow(this)">Cancel</a>';
							return s+c;
						} else {
							var e = '<a href="#" onclick="editrow(this)">Edit</a> ';
							var d = '<a href="#" onclick="deleterow(this)">Delete</a>';
							return e+d;
						}*/
						
						
						// 这里就是一个设置该列的显示元素
						
						// 如果是编辑状态，那么就直接设置这样html元素，举例，如果点击需要编辑状态，那么就直接使用一个状态来设置一下
						
						// 如果不想处于bool状态，那么直接返回想要的HTML结构即可
						/*	var e = '<a class="datagrid-save-btn">'+
									'<div class="btn-left-icon"><img src="images/saveIcon.png"></div>'+
									'<div class="btn-right-text">保存</div>'+
								'</a>'; */
						// return e;
						
						if (row.editing){
							var e = '<a class="datagrid-save-btn">'+
										'<div class="btn-left-icon"><img src="images/saveIcon.png"></div>'+
										'<div class="btn-right-text">保存</div>'+
									'</a>';
							var d = '<a class="datagrid-delete-btn">'+
										'<div class="btn-left-icon"><img src="images/freeIcon.png"></div>'+
										'<div class="btn-right-text">解冻</div>'+
									'</a>';
							return e+d;
						} else {

							var s = '<a class="datagrid-modify-btn">'+
										'<div class="btn-left-icon"><img src="images/editIcon.png"></div>'+
										'<div class="btn-right-text">修改</div>'+
									'</a>';
							var c = '<a class="datagrid-delete-btn">'+
										'<div class="btn-left-icon"><img src="images/freeIcon.png"></div>'+
										'<div class="btn-right-text">解冻</div>'+
									'</a>';
							return s+c;
						}
					}
				}
			]],
			onBeforeEdit:function(index,row){
				row.editing = true;
				updateActions(index);
			},
			onAfterEdit:function(index,row){
				row.editing = false;
				updateActions(index);
			},
			onCancelEdit:function(index,row){
				row.editing = false;
				updateActions(index);
			}
		}); 

		// 表格中的事件设置
		
		gird.off(".nsgrid");//解绑nsgrid下的所有事件
		
		gird.on("click.nsgrid",".datagrid-modify-btn",function(){
			editrow(this);  // 启动编辑状态
		}).on("click.nsgrid",".datagrid-delete-btn",function(){
			cancelrow(this);// 取消编辑
		}).on("click.nsgrid",".datagrid-save-btn",function(){
			saverow(this);	// 保存数据
		}).on("click.nsgrid",".cancelrow",function(){
			cancelrow(this);	
		}).on("click.nsgrid",".editrow",function(){
			editrow(this);		
		}).on("click.nsgrid",".deleterow",function(){
			deleterow(this);	// 删除该行，这个功能没有加上，加上需要把上面的类名改为要点击的按钮的名称即可	
		});
		
		function updateActions(index){
			table.datagrid('updateRow',{
				index: index,
				row:{}
			});
		}

		function getRowIndex(target){
			var tr = $(target).closest('tr.datagrid-row');
			return parseInt(tr.attr('datagrid-row-index'));
		}

		function editrow(target){
			table.datagrid('beginEdit', getRowIndex(target));
		}

		function deleterow(target){
			$.messager.confirm('Confirm','Are you sure?',function(r){
				if (r){
					table.datagrid('deleteRow', getRowIndex(target));
				}
			});
		}

		function saverow(target){
			table.datagrid('endEdit', getRowIndex(target));
		}

		function cancelrow(target){
			table.datagrid('cancelEdit', getRowIndex(target));
		}

		function insert(){
			var row = table.datagrid('getSelected');
			if (row){
				var index = table.datagrid('getRowIndex', row);
			} else {
				index = 0;
			}
			table.datagrid('insertRow', {
				index: index,
				row:{
					status:'P'
				}
			});
			table.datagrid('selectRow',index);
			table.datagrid('beginEdit',index);
		}
		
	};
	
var Pagination = function (selector,data){
		var me = this;
		// 找到相关的DOM元素，
		var gird = $(selector);
		var paginationEl = gird.find(".pagination");
		// 分页设置 点击对应的数字按钮时，重新生成表格
		var pageConfig = {
			prev_text: "|<", 
			next_text: ">|", 
			items_per_page:5,	//每页显示的列表数
			num_display_entries:10,	//分页链接显示数
			num_edge_entries:1	//起始与结束点的数目
		};
		
		// 缓存住当前的表格空间，与设置表格缓存数据对象
		this.selector = selector;
		this.cache = {};
		
		// 存在分页条数时候 显示分页控件
		if(data.total){
			paginationEl.pagination((data.total||0), {// 传入总条数
				prev_text: pageConfig.prev_text, 
				next_text: pageConfig.next_text, 
				items_per_page:pageConfig.items_per_page,	//每页显示的列表数
				num_display_entries:pageConfig.num_display_entries,	//分页链接显示数
				num_edge_entries:pageConfig.num_edge_entries,	//起始与结束点的数目
				//回调 
				callback: function(page) { // 点击相应的按钮，那么就会重新生成一个表格
					console.log(page);// 页签
					// 第一次生成分页控件时候，会触发该回调函数，因为已经生成表格，所以不需要继续请求数据
					// 仅仅把数据缓存住即可
					if(!me.isFirst){
						me.cache[page]=data;// 缓存住数据，以免下次还要去请求
						me.isFirst = true;
						return ;
					}
					// 如果有缓存数据，那么使用缓存数据即可
					if(me.cache[page]){
						createDataGrid(selector,data);
						return;
					}
					// 根据点击的page页面标识 进行获取数据，并生成表格
					$.ajax({
						url:'js/libs/easyui/data/datagrid_data.json',
						dataType:"JSON",
						data:{
							pageIndex:page
						},
						success:function(data){
							me.cache[page] = data;
							createDataGrid(selector,data);
						}
					});
				}  
			}); 	
		}else{
			paginationEl.hide();
		}

	};
