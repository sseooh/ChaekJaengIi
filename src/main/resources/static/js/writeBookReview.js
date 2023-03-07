function getTitle(title) {
    $.ajax({
        url: "writeBookReview",
        data: title,
        type: "POST",
        success: function (data) {

        },
        error: function () {
            console.log("제목 전달 오류");
        }
    });
}