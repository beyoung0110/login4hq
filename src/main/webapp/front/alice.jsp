<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% response.setStatus(200); %>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Alice 的简单例子</title>
    <link media="all" href="https://a.alipayobjects.com/alice/one/1.1.0/one.css" rel="stylesheet">
    <style>
        .wrapper {
            width: 990px;
            margin: 0 auto;
        }
        h1 {
            font-size: 26px;
        }
        .ui-grid-row {
            margin-bottom: 15px;
        }
    </style>
    </head>

    <body>
    <div class="wrapper">
        <div class="ui-grid-row">
            <div class="ui-grid-25">
                <h1>这是一个简陋的页面</h1>
            </div>
        </div>
        <div class="ui-grid-row">
            <div class="ui-grid-25">
                <div class="ui-nav">
                    <ul class="ui-nav-main">
                        <li class="ui-nav-item">
                        <a href="#">一级导航 1</a>
                        <ul class="ui-nav-submain">
                            <li class="ui-nav-subitem ui-nav-subitem-current"><a href="#">二级导航 1-1</a></li>
                            <li class="ui-nav-subitem"><a href="#">二级导航 1-2</a></li>
                            <li class="ui-nav-subitem"><a href="#">二级导航 1-3</a></li>
                        </ul>
                        </li>
                        <li class="ui-nav-item ui-nav-item-current">
                        <a href="#">一级导航 2</a>
                        <ul class="ui-nav-submain">
                            <li class="ui-nav-subitem"><a href="#">二级导航 2-1</a></li>
                            <li class="ui-nav-subitem ui-nav-subitem-current"><a href="#">二级导航 2-2</a></li>
                            <li class="ui-nav-subitem"><a href="#">二级导航 2-3</a></li>
                        </ul>
                        </li>
                        <li class="ui-nav-item">
                        <a href="#">一级导航 3</a>
                        <ul class="ui-nav-submain">
                            <li class="ui-nav-subitem"><a href="#">二级导航 3-1</a></li>
                            <li class="ui-nav-subitem"><a href="#">二级导航 3-2</a></li>
                            <li class="ui-nav-subitem ui-nav-subitem-current"><a href="#">二级导航 3-3</a></li>
                        </ul>
                        </li>
                        <li class="ui-nav-item"><a href="/upload/upload.jsp">演示上传附件功能</a></li>
                    </ul>
                    <div class="ui-nav-subcontainer"></div>
                </div>
            </div>
        </div>
        <div class="ui-grid-row">
            <div class="ui-grid-6">
                <div class="ui-box">
                    <div class="ui-box-head">
                        <div class="ui-box-head-border">
                            <h3 class="ui-box-head-title">区块标题</h3>
                            <span class="ui-box-head-text">其他文字</span>
                            <a href="#" class="ui-box-head-more">更多</a>
                        </div>
                    </div>
                    <div class="ui-box-container">
                        <div class="ui-box-content">
                            <ul class="ui-list">
                                <li class="ui-list-item"><a href="#">如何申请认证？</a></li>
                                <li class="ui-list-item"><a href="#">如何提现？</a></li>
                                <li class="ui-list-item"><a href="#">支付宝数字证书有什么作用？</a></li>
                                <li class="ui-list-item"><a href="#">如何申请认证？</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui-grid-19">
                <div class="ui-tipbox ui-tipbox-success">
                    <div class="ui-tipbox-icon">
                        <i class="iconfont" title="成功">&#xF046;</i>
                    </div>
                    <div class="ui-tipbox-content">
                        <h3 class="ui-tipbox-title">成功标题</h3>
                        <p class="ui-tipbox-explain">完成的说明完成的说明。</p>
                        <p class="ui-tipbox-explain"><a href="#">查询缴费记录</a> | <a href="#">我的支付宝</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>