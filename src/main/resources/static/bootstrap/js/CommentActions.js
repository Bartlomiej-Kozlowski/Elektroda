function addComment(postId){
    let commentContent = document.getElementById("addText");
    let bodyMessage = JSON.stringify({
        // postId: sessionStorage.getItem("postId"),
        postId: postId,
        // content: commentContent.textContent
        content: commentContent.getInnerHTML()
    })
    if (commentContent){
        fetch("/api/forumComment/create", {
            method: "post",
            body: bodyMessage,
            headers: {
                "Content-type": "application/json",
                "Authorization": getCookie("authenticationToken")
            }
        }).then(() => {
            window.location.reload()
        }).catch((error) => {
            console.log(error);
        })
    }
}
function likeComment(commentId){
}
function likePost(){
}
function deleteComment(commentId){
}
function deletePost(){
}
function edit(elementType, elementId){
    let content;
    if (elementType == "post"){
        content = document.getElementById("postContent");
    }else{
        content = document.getElementById("commentContent" + elementId);
    }
    content.setAttribute("contenteditable", "true");
    let confirmButton = document.createElement("button");
    confirmButton.setHTML("Confirm");
    confirmButton.addEventListener("click", () => {editConfirm(elementType, elementId)});
    let cancelButton = document.createElement("button");
    cancelButton.setHTML("Cancel");
    cancelButton.addEventListener("click", () => {editCancel(elementType, elementId)});
    content.parentElement.append(confirmButton);
    content.parentElement.append(cancelButton);
}
function editConfirm(elementType, elementId){
    let bodyMessage, fetchLocation;
    let content;
    if (elementType == "post"){
        content = document.getElementById("postContent");
        bodyMessage = JSON.stringify({
            postId: sessionStorage.getItem("postId"),
            // content: content.textContent
            content: content.getInnerHTML()
        });
        fetchLocation = "/api/forumPost/edit";
    }else{
        content = document.getElementById("commentContent" + elementId);
        content.setAttribute("contenteditable", "false");
        bodyMessage = JSON.stringify({
            commentId: parseInt(elementId),
            // content: content.textContent
            content: content.getInnerHTML()
        })
        fetchLocation = "/api/forumComment/edit";
    }
    if (content){
        fetch(fetchLocation, {
            method: "put",
            body: bodyMessage,
            headers: {
                "Content-type": "application/json",
                "Authorization": getCookie("authenticationToken")
            }
        }).then(() => {
            window.location.reload();
        }).catch((error) => {
            console.log(error);
        })
    }else{
        console.log("no content");
    }
}
function editCancel(elementType, elementId){
    let content;
    if (elementType == "post") {
        content = document.getElementById("postContent");
    }else{
        content = document.getElementById("commentContent" + elementId);
    }
    content.setAttribute("contenteditable", "false");
    window.location.reload();
}