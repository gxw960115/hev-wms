  /**
        Jquery easyui datagrid js导出excel
        修改自extgrid导出excel
        * allows for downloading of grid data (store) directly into excel
        * Method: extracts data of gridPanel store, uses columnModel to construct XML excel document,
        * converts to Base64, then loads everything into a data URL link.
        *
        * @author Animal <extjs support team>
        *
        */
        $.extend($.fn.datagrid.methods, {
            getExcelXml: function (jq, param) {
            	var tmp = "";
                var worksheet = this.createWorksheet(jq, param);
                //alert($(jq).datagrid('getColumnFields'));
                var totalWidth = 0;
//                var cfs = $(jq).datagrid('getColumnFields',true);
                var cfs = $.merge($(jq).datagrid('getColumnFields',true),$(jq).datagrid('getColumnFields'));
                for (var i = 0; i < cfs.length; i++) {
                    totalWidth += $(jq).datagrid('getColumnOption', cfs[i]).width;
                }
                return '<?xml version="1.0" encoding="gb2312"?><?mso-application progid="Excel.Sheet"?><Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"  xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:html="http://www.w3.org/TR/REC-html40">'
                +'<Styles>' +
            '<Style ss:ID="Default">' +
            '<Alignment ss:Vertical="Top"  />' +
            '<Font ss:FontName="arial" ss:Size="10" />' +
            '<Borders>' +
            '<Border  ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Top" />' +
            '<Border  ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Bottom" />' +
            '<Border  ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Left" />' +
            '<Border ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Right" />' +
            '</Borders>' +
            '<Interior />' +
            '<NumberFormat />' +
            '<Protection />' +
            '</Style>' +
            '<Style ss:ID="title">' +
            '<Borders />' +
            '<Font />' +
            '<Alignment  ss:Vertical="Center" ss:Horizontal="Center" />' +
            '<NumberFormat ss:Format="@" />' +
            '</Style>' +
            '<Style ss:ID="headercell">' +
            '<Font ss:Bold="1" ss:Size="10" />' +
            '<Alignment  ss:Horizontal="Center" />' +
            '<Interior ss:Pattern="Solid"  />' +
            '</Style>' +
            '<Style ss:ID="even">' +
            '<Interior ss:Pattern="Solid"  />' +
            '</Style>' +
            '<Style ss:Parent="even" ss:ID="evendate">' +
            '<NumberFormat ss:Format="yyyy-mm-dd" />' +
            '</Style>' +
            '<Style ss:Parent="even" ss:ID="evenint">' +
            '<NumberFormat ss:Format="0" />' +
            '</Style>' +
            '<Style ss:Parent="even" ss:ID="evenfloat">' +
            '<NumberFormat ss:Format="0.00" />' +
            '</Style>' +
            '<Style ss:ID="odd">' +
            '<Interior ss:Pattern="Solid"  />' +
            '</Style>' +
            '<Style ss:Parent="odd" ss:ID="odddate">' +
            '<NumberFormat ss:Format="yyyy-mm-dd" />' +
            '</Style>' +
            '<Style ss:Parent="odd" ss:ID="oddint">' +
            '<NumberFormat ss:Format="0" />' +
            '</Style>' +
            '<Style ss:Parent="odd" ss:ID="oddfloat">' +
            '<NumberFormat ss:Format="0.00" />' +
            '</Style>' +
            '</Styles>' +
            	worksheet.xml +
            '</Workbook>';
            },
            createWorksheet: function (jq, param) {
                // Calculate cell data types and extra class names which affect formatting
                var cellType = [];
                var cellTypeClass = [];
                //var cm = this.getColumnModel();
                var totalWidthInPixels = 0;
                var colXml = '';
                var headerXml = '';
                var visibleColumnCountReduction = 0;
                var _column = param._grid_column;
                var firstRow = "";
                var secondRow = "";
                if(typeof(_column) != "undefined"){
                	var firstColumn = _column[0];
                	var secondColumn = _column[1];
                	for(var i=0,j=firstColumn.length;i<j;i++){
                		var obj = firstColumn[i];
                		firstRow += '<Cell ss:MergeDown="'+obj["rowspan"]+'" ss:MergeAcross="'+obj["colspan"]+'" ss:StyleID="headercell"><Data ss:Type="String">'
                		+  obj["name"]
                		+ '</Data></Cell>';
                	}
                	for(var i=0,j=secondColumn.length;i<j;i++){
                		var obj = secondColumn[i];
                		if(i == 0){
                			secondRow += '<Cell ss:Index="'+obj["index"]+'" ss:StyleID="headercell"><Data ss:Type="String">'
	                		+  obj["name"]
	                		+ '</Data></Cell>';
                		}else{
                			secondRow += '<Cell ss:StyleID="headercell"><Data ss:Type="String">'
	                		+  obj["name"]
	                		+ '</Data></Cell>';
                		}
                	}
                }
                var cfs = $.merge($(jq).datagrid('getColumnFields',true),$(jq).datagrid('getColumnFields'));
                var colCount = cfs.length;
                for (var i = 0; i < colCount; i++) {
                    if (cfs[i] != '') {
                        var w = $(jq).datagrid('getColumnOption', cfs[i]).width;
                        if($(jq).datagrid('getColumnOption', cfs[i]).hidden==true)
                        {
                        	continue;
                        }
                        totalWidthInPixels += w;
                        if (cfs[i] === "") {
                            cellType.push("None");
                            cellTypeClass.push("");
                            ++visibleColumnCountReduction;
                        }
                        else {
                            colXml += '<ss:Column ss:AutoFitWidth="1" ss:Width="130" />';
                            headerXml += '<Cell ss:StyleID="headercell">' +
//                            headerXml += '<Cell>' +
//                             headerXml += '<Cell>' +
                             
                            
                        '<Data ss:Type="String">' + $(jq).datagrid('getColumnOption', cfs[i]).title.replace(/<br>/g,'') + '</Data></Cell>';
//                        +
//                        '<ss:NamedCell ss:Name="Print_Titles" /></Cell>';
                            cellType.push("String");
                            cellTypeClass.push("");
                        }
                    }
                }
                var visibleColumnCount = cellType.length - visibleColumnCountReduction;
                var result = {
                    height: 9000,
                    width: Math.floor(totalWidthInPixels * 30) + 50
                };
                var rows = $(jq).datagrid('getRows');
                // Generate worksheet header details.
                if(typeof(_column) != "undefined"){
                	headerXml =  '<Row ss:AutoFitHeight="1">' + firstRow + '</Row>'
                				+ '<Row ss:AutoFitHeight="1">' + secondRow + '</Row>';
                }else{
                	headerXml = '<Row ss:AutoFitHeight="1">' + headerXml + '</Row>';
                }
                var t = '<Worksheet ss:Name="' + param.title + '">' +
//            '<Names>' +
//            '<ss:NamedRange ss:Name="Print_Titles" ss:RefersTo="=\'' + param.title + '\'!R1:R2" />' +
//            '</ss:Names>' +
            '<Table x:FullRows="1" x:FullColumns="1"' +
            ' ss:ExpandedColumnCount="' + (visibleColumnCount + 2) +
            '" ss:ExpandedRowCount="' + (rows.length + 2) + '">' +
//            colXml +
            headerXml;
                // Generate the data rows from the data in the Store
                //for (var i = 0, it = this.store.data.items, l = it.length; i < l; i++) {
                for (var i = 0, it = rows, l = it.length; i < l; i++) {
                    t += '<Row>';
                    var cellClass = (i & 1) ? 'odd' : 'even';
                    r = it[i];
                    var k = 0;
                    for (var j = 0; j < colCount; j++) {
                        //if ((cm.getDataIndex(j) != '')
                        if (cfs[j] != '') {
                        	if($(jq).datagrid('getColumnOption', cfs[j]).hidden==true)
                        	{
                        		continue;
                        	}
                            //var v = r[cm.getDataIndex(j)];
                            var v = r[cfs[j]];
                            if (cellType[k] !== "None") {
//                                t += '<Cell ss:StyleID="' + cellClass + cellTypeClass[k] + '"><Data ss:Type="' + cellType[k] + '">';
                                 t += '<Cell ss:StyleID="' + cellClass + cellTypeClass[k] + '"><Data ss:Type="String">';
                                if (cellType[k] == 'DateTime') {
                                    t += v.format('Y-m-d');
                                } else {
                                	if(typeof(v)=="undefined" || v == "undefined "){
                                		v = "";
                                	}
                                	//console.log(v);
                                    t += v;
                                }
                                t += '</Data></Cell>';
                            }
                            k++;
                        }
                    }
                    t += '</Row>';
                }
                result.xml = t + '</Table>' +
//            '<x:WorksheetOptions>' +
//            '<x:PageSetup>' +
//            '<x:Layout x:CenterHorizontal="1" x:Orientation="Landscape" />' +
//            '<x:Footer x:Data="Page &amp;P of &amp;N" x:Margin="0.5" />' +
//            '<x:PageMargins x:Top="0.5" x:Right="0.5" x:Left="0.5" x:Bottom="0.8" />' +
//            '</x:PageSetup>' +
//            '<x:FitToPage />' +
//            '<x:Print>' +
//            '<x:PrintErrors>Blank</x:PrintErrors>' +
//            '<x:FitWidth>1</x:FitWidth>' +
//            '<x:FitHeight>32767</x:FitHeight>' +
//            '<x:ValidPrinterInfo />' +
//            '<x:VerticalResolution>600</x:VerticalResolution>' +
//            '</x:Print>' +
//            '<x:Selected />' +
//            '<x:DoNotDisplayGridlines />' +
//            '<x:ProtectObjects>False</x:ProtectObjects>' +
//            '<x:ProtectScenarios>False</x:ProtectScenarios>' +
//            '</x:WorksheetOptions>' +
            '</Worksheet>';
                return result;
            }
        });