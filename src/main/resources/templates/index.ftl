<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <p>我的springboot第一天</p>
    <#if sex==1>男<#elseif sex==0>女<#else>其他</#if>
    <#list userlist as user>
        ${user}
    </#list>
</body>
</html>