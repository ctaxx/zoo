function addAnimal() {

    var animalName = document.getElementById("animalName").value;
    var animalAge = document.getElementById("animalAge").value;
    var animalClass = document.getElementById("animalClass").value;
    $.ajax({
        type: "POST",
        url: "/addAnimal",  //servlet name
        dataType: "json",
        data: {animalName: animalName, animalAge: animalAge, animalClass: animalClass},
        success: function (data) {
            document.getElementById("result").innerText = data.result;
        }
    });
}

function showAnimals() {

    $.ajax({
        type: "GET",
        url:"/addAnimal",    //servlet name
        dataType: "json",
        success: function(data) {
            //        document.getElementById("result").innerText = data.result.id;
            var responce = data.result;
            var table = document.createElement("table");
//            table.setAttribute("border", 1);

            var rowHeader = table.insertRow();
            rowHeader.setAttribute("class", "tableheader");
            var cellHeader1 = rowHeader.insertCell(0);
            var cellHeader2 = rowHeader.insertCell(1);
            var cellHeader3 = rowHeader.insertCell(2);

            cellHeader1.innerText = "Name";
            cellHeader2.innerText = "Age";
            cellHeader3.innerText = "Class";

            for (var animalNum in responce) {

                var row = table.insertRow();
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);

                cell1.innerText = responce[animalNum].name;
                cell2.innerText = responce[animalNum].age;
                cell3.innerText = responce[animalNum].class;
            }
//            document.body.appendChild(table);
            document.getElementById("tablearea").appendChild(table);
        }
    })
}