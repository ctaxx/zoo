function addAnimal() {
 //   alert("addAnimal button has been clicked");


    var div = document.createElement('div');
    div.className = "alert alert-success";
    div.innerHTML = "<strong>Ура!</strong> Вы прочитали это важное сообщение.";

    document.body.appendChild(div);

    var mm = document.createElement("label");
    mm.className = "Label";
    mm.innerText = "mm label";
    document.body.appendChild(mm);

    var table = document.createElement("table");
    var row = table.insertRow();
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);

    cell1.innerHTML = "new cell1";
    cell2.innerHTML = "new cell2";

    document.body.appendChild(table);

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
            for (var animalNum in responce) {

                var row = table.insertRow();
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);

                cell1.innerText = responce[animalNum].id;
                cell2.innerText = responce[animalNum].date;
                cell3.innerText = responce[animalNum].text;
                cell4.innerText = responce[animalNum].user;
            }

            document.body.appendChild(table);
        }
    })
}