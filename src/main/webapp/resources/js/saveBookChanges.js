$(document).ready(function(){
    $(".bookSaveButton").click(function(){
        const bookName = $(this).attr('id');
        saveChanges(bookName);
    });
})

function saveChanges(book){
    const bookEntity = "#book-"+book;
    let bookUser = $(bookEntity).find(".bookUser").val();
    let bookReturnDate = $(bookEntity).find(".bookReturnDate").val();
    if(bookUser==undefined || bookUser.trim()==""){
        bookUser="";
        bookReturnDate="";
    }
    if(bookReturnDate==undefined){
        bookReturnDate="";
    }

    $.getJSON("/api/saveBook",{
        bookName:book,
        bookOwner:bookUser,
        returnDate:bookReturnDate
    },()=>{
        location.reload();
    })
}