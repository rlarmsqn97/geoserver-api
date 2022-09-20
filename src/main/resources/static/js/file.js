(function () {
    document.getElementById("shoot").onclick = function(){
        let formData = new FormData();
        for(let i=0; i<4; i++) {
            formData.append("file", document.getElementById("file").files[i])
        }
        fetch("/upload", {
            method : "POST",
            headers : {"Accept" : "multipart/form-data"},
            mode: 'cors',
            cache: 'no-cache',
            credentials: 'same-origin',
            redirect: 'follow',
            referrer: 'no-referrer',
            body : formData,
        }).then((res) => console.log(res))
    }
}());