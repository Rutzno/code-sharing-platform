<#--/**
* @author Mack_TB
* @version 1.0.7
* @since 12/20/2020
*/-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <span id="load_date">${code.date}</span><br>
    <#if code.time gt 0>
        The code will be available for
        <span id="time_restriction"><u>${code.time}</u></span> seconds<br>
    </#if>
    <#if code.viewsLimit>
        <span id="views_restriction"><u>${code.views}</u></span> more view(s) allowed<br>
    </#if>
    <pre id="code_snippet">
        <code>${code.code}</code>
    </pre>
</body>
</html>
