$(document).ready(function () {
    const userLogin = $("#login").text().trim()
    reloadCounter(userLogin);
    getTotalPrice()

    $(".bookEntity").click(function () {
        const win = $("#window");
        const wall = $("#windowBack");
        const bookName = $(this).attr('value');
        openPopup(bookName, wall, win);
    });

    $("#closeWindow").click(() => {
        closeWindow();
    });

    $("#addToCart").click(function () {
        const bookName = $(this).attr('value');
        addBookToCart(bookName);
    })
    $("#deleteFromTheCart").click(function () {
        const bookName = $(this).attr("value");
        const userLogin = $("#login").text().trim()
        deleteFromTheCart(bookName, userLogin);
    })
});



