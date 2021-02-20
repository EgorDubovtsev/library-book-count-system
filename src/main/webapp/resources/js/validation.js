$(document).ready(function () {
    $("#name-createBook").change(() => checkValueLengthText("name-createBook", 50))
    $("#author-createBook").change(() => checkValueLengthText("author-createBook", 100))
    $("#bookDescription-createBook").change(() => checkValueLengthText("bookDescription-createBook", 100))
    $("#publishYear-createBook").change(() => checkValuePublishYear("publishYear-createBook"))
    $("#price-createBook").change(() => checkValuePrice("price-createBook"))
})


function checkValueLengthText(id, maxLength) {
    const value = $("#" + id).val()
    if (value.length > maxLength) {
        $("#" + id).val(value.substring(0, maxLength - 1))
    }
}

function checkValuePublishYear(id) {
    const inputValue = $("#" + id).val();
    if (/\D/.test(inputValue) || inputValue.length > 4 || inputValue[0] == "0") {
        $("#" + id).val(0)
    }
}

function checkValuePrice(id) {
    const priceValue = $("#" + id).val().trim()
    if (/\D/.test(priceValue) || priceValue > 100000 || priceValue[0] == "0") {
        $("#" + id).val("0")
    }
}