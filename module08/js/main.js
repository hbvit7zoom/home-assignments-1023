function myAlert() {
  alert("Hello, World")
}

function handleOnChange(input) {
  console.log(input)
  console.log(input.value)

  var aInput = document.getElementById("text-123")
  alert(`I was changed, value is ${aInput.value}`)
}