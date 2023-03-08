function getTitle(bookTitle) {
    //alert(title);
    /*
    $.ajax({
        url: "/review",
        type: 'post',
        data: {
            title : bookTitle
        },
        success: function (data) {
            //alert(data);
            document.location.href = data;
        },
        error: function () {
            console.log("제목 전달 오류");
        }
    });
     */
    let f = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'title')
    obj.setAttribute('value', bookTitle);

    f.appendChild(obj);
    f.setAttribute('method', 'post');
    f.setAttribute('action', 'bookReview/write');
    document.body.appendChild(f);
    f.submit();
}