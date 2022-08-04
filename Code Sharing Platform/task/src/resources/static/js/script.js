function send() {
    const codeObj = {
        code: document.getElementById("code_snippet").value
    };

    fetch('/api/code/new', {
        method: 'POST', headers: {
            'Content-Type': 'application/json'
        }, body: JSON.stringify(codeObj)
    })
        .then(response => {
            if (response.ok) {
                alert("Success!")
            }
        })
}