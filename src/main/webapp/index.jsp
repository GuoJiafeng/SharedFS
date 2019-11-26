<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: G
  Date: 2018/1/23
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>所有文件|FileList</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>


<div class="container">


    <div class="modal fade" id="modal-container-499906" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        当前文件内容为空，请选择文件！
                    </h4>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>

        </div>

    </div>


    <div class="row clearfix">
        <div class="col-md-12 column">

            <div class="list-group" id="filelist">

                <a href="#" class="list-group-item active">所有文件</a>
                <div class="list-group-item">
                    <label for="exampleInputFile">文件上传</label>
                    <form id="uploadForm" action='FileController/upload' method='post' enctype='multipart/form-data'>
                        <input type="file" id="exampleInputFile" name="file"/>
                        </br>
                        <button type="button" class="btn btn-default btn-success" id="uploadButton">上传</button>
                    </form>
                </div>

                <%--                <div class="list-group-item">--%>
                <%--                    <h4 class="list-group-item-heading">--%>
                <%--                        List group item heading--%>
                <%--                    </h4>--%>
                <%--                </div>--%>
                <%--                <div class="list-group-item">--%>
                <%--                    <h4 class="list-group-item-heading">--%>
                <%--                        List group item heading--%>
                <%--                    </h4>--%>
                <%--                </div>--%>
                <%--
                                <div class="list-group-item">
                                    <h4 class="list-group-item-heading">
                                        <a href="" >List group item heading</a>
                                    </h4>
                                </div>--%>

                <%--                <a class="list-group-item active"> <span class="badge">14</span> Help</a>--%>
            </div>
        </div>
    </div>
</div>

<!-- 文件上传模态框 -->
<div id="progressModal" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static"
     data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">文件上传进度</h4>
            </div>
            <div class="modal-body">
                <div id="progress" class="progress">
                    <div id="progress_rate" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
                         class="progress-bar progress-bar-success progress-bar-striped active"
                         role="progressbar" style="width: 0%">
                        <span id="percent">0%</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    var process;// 定时对象

    $(function () {

        list();

        listenUploadButton()

        beginUploadProgress();
    });

    function beginUploadProgress() {

        var time = "${time}";
        if (time != null && time != "") {
            $("#msg").css("display", "block");
        }


    }

    function dimissprogressModal() {


        $("#progressModal").modal("show");// 打开模态框
    }

    function listenUploadButton() {

        $("#uploadButton").click(function () {

            if ($("#exampleInputFile").val() == "") {
                alert("请选择文件！")
                // window.location.reload()
            } else {

                $("#progressModal").modal("show");// 打开模态框

                $("#uploadForm").submit()


            }

        });
    }

    function list() {


        $.ajax({
            url: "FileController/list",
            type: "post",
            data: {},
            dataType: "json",
            success: function (result) {
                html = '';
                for (var i = 0; i < result.length; i++) {
                    html += ' <div class="list-group-item">\n' +
                        '                    <h4 class="list-group-item-heading">\n' +
                        '                         <a href="FileController/download/?uuid=' + result[i].uuid + '&&name=' + result[i].originalName + '" >' + result[i].originalName + '</a>  <a href="FileController/del/?uuid=' + result[i].uuid + '">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;删除</a>\n'
                   +
                    '                    </h4>\n' +
                    '                </div>';

                }

                $("#filelist").append(html);


            }
        });
    }
</script>
</body>
</html>