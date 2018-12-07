<%@ page import="com.fasterxml.jackson.annotation.JsonInclude" %>
<%--
  Created by IntelliJ IDEA.
  User: dylumian
  Date: 2018/12/6
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <%@ include file="/common/mystyle.jsp" %>
</head>
<body>
<form class="form-inline" >
    <div class="form-group">
        <label for="adName">广告名称</label>
        <input type="text" class="form-control" id="adName" placeholder="广告名称">
    </div>
    <br>
    <div class="form-group">
        <label for="adTime">有效时间</label>
        <input type="text" class="form-control date" id="minTime" placeholder="最早时间">
        <i class="form-group-addon glyphicon glyphicon-calendar"></i>
        <input type="text" class="form-control date" id="maxTime" placeholder="最晚时间">
    </div>
    <br>
    <button type="button" class="btn btn-success" onclick="search()">搜索</button>
    <button type="button" class="btn btn-primary" onclick="reset()">重置</button>
    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-primary" onclick="addBook()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-info" onclick="addMany()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>批量新增
        </button>
        <button id="btn_delete" type="button" class="btn btn-danger">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>
</form>
<table id="advertisementTable"></table>
</body>
<script>
    $(function(){
        search();
    })
    function search(){
        $('#advertisementTable').bootstrapTable('destroy');
        $("#advertisementTable").bootstrapTable({
            url:"http:localhost:8887/adv/queryAdvertisement",
            dataType:"jsonp",
            method:"post",			    //请求方式（*）
            striped: true,  	        //斑马线效果  默认false
            singleSelect:true,          //只允许选中一行
            showToggle:true,            //是否显示详细视图和列表视图的切换按钮
            cardView: false,            //是否显示详细视图
            uniqueId: "aid",            //每一行的唯一标识，一般为主键列
            showColumns: true,          //是否显示所有的列
            showRefresh: true,          //是否显示刷新按钮
            showPaginationSwitch:false, //是否显示 数据条数选择框
            detailView:false,           //设置为 true 可以显示详细页面模式。
            showFooter:false,           //是否显示列脚
            clickToSelect:true,         //是否启用点击选中行
            minimumCountColumns: 2,     //最少留两列
            sortName:'aid', 	        //排序字段
            sortOrder:'desc',           //排序方式
            search:true,                //前台--搜索框
            searchText:'请输入搜索内容', //初始化搜索文字
            searchOnEnterKey:true,      //启动回车键做搜索功能
            sidePagination:'server',    //后台请求的分页方式
            pagination: true,           //是否显示分页（*）
            paginationShowPageGo:true,  //显示跳转页码按钮
            pageNum: 1,                 //每页的记录行数（*）
            pageSize: 3,                //每页的记录行数（*）
            pageList: [3, 6, 9,12],     //可供选择的每页的行数（*）
            toolbar:'#tabToolBar',      //工具定义位置
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',  //发送到服务器的数据编码类型
            columns:[
                {field:'aid',title:'多选',width:50,
                    formatter:function(value,row,index){
                        return "<input type='checkbox' value="+value+" name='chk'/>";
                    }
                },
                {field:'aid',title:'广告ID',width:100,sortable:true},
                {field:'adName',title:'广告名称',width:100},
                {field:'adUrl',title:'广告链接',width:100},
                {field:'adPlaceId',title:'广告位',width:100,
                    formatter:function(value,row,index){
                        return '<a href="">value</a>';
                    }
                },
                {field:'adTime',title:'有效时间',width:100
                    /* formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
                        var simfomat = new Date();
                        simfomat.setTime(value);   //转换时间
                        return  simfomat.toLocaleDateString();
                    } */
                },

                {field:'adClicks',title:'点击数',width:100,
                    formatter:function(value,row,index){
                        return "<video width='200px' height='150px' src='<%=request.getContextPath()%>/book/getImg.do?id="+value+"' controls='controls'></video><button type='button' class='btn btn-danger' onclick='getVideo(\""+row.videoId+"\",\""+row.imgId+"\")'>查看视频详情</button>";
                    }
                },
                {field:'adImage',title:'广告图片',width:100,
                    formatter:function(value,row,index){
                        /* img-circle */
                        return "<img class='img-responsive img-rounded' width='150px' heigth='150px' src='<%=request.getContextPath()%>/book/getImg.do?id="+value+"'>";
                    }
                },
            ],
            queryParams: function(params) {
                var whereParams = {
                    /*分页自定义的参数:默认传 limit（展示几条) offset（从第几条开始 ,起始条数）*/
                    pageSize:params.limit,
                    start:params.offset,
                    /*bookName:$("#bookName").val(),
                    minTime:$("#minTime").val(),
                    maxTime:$("#maxTime").val(),*/
                    //"pro_name":params.search,//精确搜索产品名称
                }
                return whereParams;
            },

        })
    }
    function getJspHtml(urlStr){
        var  jspHtml = "";
//	 async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
//注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
        $.ajax({
            url:urlStr,
            type:'post',
            //同步的ajax
            async:false,
            success:function(data){
                //alert(data);//data--addProduct.jsp页面内容
                jspHtml = data;
            },
            error:function(){
                bootbox.alert("ajax失败");
            }
        });
        return jspHtml;
    }

    function  dialog(HTMLurl,submitUrl,title){

        var dialog = bootbox.dialog({
            title: title,
            message: getJspHtml(HTMLurl),   //调用方法
            buttons:{
                "save":{
                    label: '保存',
                    animate: true,
                    className: "btn-success",
                    callback: function() {
                        $.ajax({
                            url:submitUrl,
                            type:'post',
                            data:$("#bookForm").serialize(),
                            success:function(data){
                                bootbox.alert("保存成功");
                                $("#advertisementTable").bootstrapTable('refresh');
                            },
                            error:function(){
                                bootbox.alert("ajax失败");
                            }
                        });
                    }
                },
                "unSave":{
                    label: '取消',
                    //自定义样式
                    className: "btn-info",
                    callback: function() {
                        // return false;  //dialog不关闭
                    }
                }
            }
        });
    }


    function getVideo(vid,id){
        dialog("<%=request.getContextPath()%>/book/getVideo.do?videoId="+vid+"&&imgId="+id,"<%=request.getContextPath()%>/book/editBook.do","ckplayer");
    }

    function addMany(){
        dialog("<%=request.getContextPath()%>/book/toAddMany.do","<%=request.getContextPath()%>/book/addMany.do","批量新增")
    }

    function addBook(){
        dialog("<%=request.getContextPath()%>/book/toAddBook.do","<%=request.getContextPath()%>/book/editBook.do","单个新增")
    }

    function updBook(id){
        dialog("<%=request.getContextPath()%>/book/toUpdBook.do?bookId="+id,"<%=request.getContextPath()%>/book/editBook.do","修改")
    }

    function delBook(id){
        if (confirm("您确定要删除吗")) {
            $.ajax({
                url:'<%=request.getContextPath()%>/book/delBook.do',
                type:'post',
                data:{bookId:id},
                dataType:'json',
                success:function(data){
                    $('#advertisementTable').bootstrapTable('refresh');
                }
            });
        }

    }

    $('.date').datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式hh:ii:ss
        minView: "month",//设置只显示到月份
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true//显示今日按钮
    })
</script>

</html>
