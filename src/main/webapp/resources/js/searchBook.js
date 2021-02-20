$(document).ready(function () {
    $("#searchButton").click(() => searchBook())

})

function searchBook() {
    const bookName = $("#searchLine").val()
    const bookAuthor = $("#author").val()
    const bookMaxPrice = $("#price").val()
    const bookGenre = $("#genre").val()
    $(".book").css("display", "block")
    $.getJSON("/api/search", {
        name: bookName,
        author: bookAuthor,
        genre: bookGenre,
        maxPrice: bookMaxPrice
    }, (response) => {
        let validBooksNames = [];
        for (let i = 0; i < response.length; i++) {
            validBooksNames.push(response[i].name)
        }
        $(".book").filter((index, element) => {
            for (let j = 0; j < validBooksNames.length; j++) {
                if (validBooksNames[j].trim() === element.textContent.trim()) {
                    return false;
                }
            }
            return true;
        }).css("display", "none")
    })
}