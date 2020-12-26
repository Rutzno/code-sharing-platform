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
    <script src="/js/codeSharing.js"></script>
</head>
<body>
    <form>
        <textarea id="code_snippet" required placeholder="Write your code" rows=5 cols=60></textarea><br><br>

        <label for="time_restriction">Time restriction</label>
        <input id="time_restriction" type="text" value="0"/><br>
        <br>
        <label for="views_restriction">Views restriction</label>
        <input id="views_restriction" type="text" value="0"/><br><br>

        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </form>
</body>
</html>
