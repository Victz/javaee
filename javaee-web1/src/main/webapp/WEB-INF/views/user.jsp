<!--
The MIT License

Copyright 2016 Victz.com.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1"/>        
        <meta name="author" content="Victz" />
        <Link rel="icon" type="image/x-icon"  href="${mvc.contextPath}/resources/img/victz.ico" />
        <link rel="apple-touch-icon" href="${mvc.contextPath}/resources/img/victz-300x300-bg.png" />
        <link rel="apple-touch-icon" sizes="76x76" href="${mvc.contextPath}/resources/img/victz-76x76-bg.png" />
        <link rel="apple-touch-icon" sizes="120x120" href="${mvc.contextPath}/resources/img/victz-120x120-bg.png" />
        <link rel="apple-touch-icon" sizes="152x152" href="${mvc.contextPath}/resources/img/victz-152x152-bg.png" />
        <link rel="apple-touch-icon" sizes="167x167" href="${mvc.contextPath}/resources/img/victz-167x167-bg.png" />
        <link rel="apple-touch-icon" sizes="180x180" href="${mvc.contextPath}/resources/img/victz-180x180-bg.png" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
        <meta name="keywords" content="victz, java, javaee, mvc"/>
        <meta name="description" content="Java EE 8 MVC (JSR-371) Demo"/>
        <title>Victz MVC</title>
    </head>
    <body>    
        <div class="container">
            <h1 class="text-primary">Java EE - web 1 User !</h1>
            <hr/>
            <form role="form" method="post" action="${mvc.basePath}/user/save" class="form-inline">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Please input name" autofocus>
                </div>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
            <hr/>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <tr>
                        <td></td>
                        <td>Name</td>
                        <td></td>
                    </tr>
                    <c:forEach items="${userModel.users}" var="model" varStatus="status" >
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${model.name}</td>
                            <td><a href="${mvc.basePath}/user/delete/${model.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>


