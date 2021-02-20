$(document).ready( function (){
    $("#buyButton").click(function () {
        const login = $("#login").text().trim()
        $.getJSON("/api/buy", {userLogin: login}, (isSuccess) => {
        console.log(isSuccess)
          showToast(isSuccess)
        })
    })
})
function reloadCounter(userLogin) {
    $.getJSON("/api/getCountOfBooks", {login: userLogin}, (result) => {
        $("#counter").text(result)
    })
}

function addBookToCart(bookName) {
    const userLogin = $("#login").text().trim()
    $.getJSON("/api/addToCart", {name: bookName, login: userLogin}, (result) => {
        closeWindow();
        reloadCounter(userLogin);
    })
}

function deleteFromTheCart(name, login) {
    $.getJSON("/api/deleteBook", {bookName: name, userLogin: login}, (result) => {
        location.reload()
        if (result) {
            console.log("Success")
        } else {
            console.log("Fail")
        }
        closeWindow()
    })
}

function getTotalPrice() {
    let booksPrice = []
    $('.bookPrice').each(function () {
        booksPrice.push($(this).text());
    });
    let totalPrice = 0;
    for (let i = 0; i < booksPrice.length; i++) {
        totalPrice = Number(totalPrice) + Number(booksPrice[i]);
    }
    $('#totalPrice').text(totalPrice)
}

function showToast(isOperationSuccess) {
    const toast = $("#toast");
    if (isOperationSuccess) {
        toast.addClass("success");
        toast.text("Операция прошла успешно")
    } else {
        toast.addClass("fail")
        toast.text("Произошла ошибка")
    }
   toast.animate({bottom: "+40px", opacity: 0.8}, "normal");
    window.setTimeout(() =>{
        toast.css({"bottom":"20px","opacity":"0"})
        location.reload()
    },2000).then(()=>{
        toast.removeClass("fail")
        toast.removeClass("success")
    })

}