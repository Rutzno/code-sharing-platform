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
<#list codes>
    <div>
        <#items as code>
            <span id="load_date">${code.date}</span><br>
            <pre id="code_snippet">
                <code>${code.code}</code>
            </pre>
        </#items>
    </div>
</#list>
</body>
</html>
