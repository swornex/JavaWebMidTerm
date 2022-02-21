let numbers = document.querySelectorAll(".number");
let operators = document.querySelectorAll(".operators");
let clearAll = document.getElementById("clear-all");
let equal = document.getElementById("equal");
let clearOne = document.getElementById("clear-one");
let decimal= document.getElementById("decimal");
let textField = document.getElementsByTagName("input")[0];

let clickDecimal = false;

numbers.forEach((number) => {
    number.onclick = () => (textField.value += number.value);
});

operators.forEach((operator) => {
    operator.addEventListener("click", () => {

        if (!textField.value) {
            if (operator.value == "+" || operator.value == "-") {
                textField.value += " " + operator.value + " ";
            }
            return;
        } else {
            let lastValue = textField.value.charAt(textField.value.length - 1);

            if (isNaN(lastValue)) {
                return;
            }
        }

        textField.value += " " + operator.value + " ";
        clickDecimal = false;
    });

});

equal.onclick = () => {
    if(textField.value.length > 0) {
        fetch(`calculator?expression=${encodeURIComponent(textField.value)}`)
            .then(response =>
                response.json()
            ).then(jsonValue => {
            textField.value = jsonValue.output;
            clickDecimal = false;
        }).catch(e => {
            console.log({"error": e.message})
        });
    }
};

clearAll.addEventListener("click", () => {
    textField.value = "";
    clickDecimal = false;
});

clearOne.addEventListener("click", () => {
    textField.value = textField.value.substr(0,textField.value.length -1);
});

decimal.onclick = () =>{
    if (!clickDecimal) {
        textField.value += ".";
        clickDecimal= true;
    }
}


