function send() {
    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": document.getElementById("time_restriction").value,
        "views": document.getElementById("views_restriction").value
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status != 200) { // analyze HTTP status of the response
        alert("Error "+xhr.status+ ":" + xhr.statusText); // e.g. 404: Not Found
    } else { // show the result
        alert("Success!");
        window.location.replace("/code/"+ xhr.response.id);
    }
}
